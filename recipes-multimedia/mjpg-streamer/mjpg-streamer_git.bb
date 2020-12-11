SUMMARY = "MJPG-streamer takes JPGs from Linux-UVC compatible webcams, filesystem or other input plugins and streams them as M-JPEG via HTTP to webbrowsers, VLC and other software. It is the successor of uvc-streamer, a Linux-UVC streaming application with Pan/Tilt"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"

PV = "0.4+git${SRCPV}"
SRCREV = "f387bb44e6c087271b763b27da998bf2e06c4f5d"
SRC_URI = "git://github.com/jacksonliam/mjpg-streamer.git;protocol=https \
           file://0001-slightly-unbreak-raspi-cmake.patch;striplevel=2 \
           file://d0dcc2e0bbe84ef0937def2d7d226eee88150739.patch \
           file://6970dcfb886477683558fd6caaefa990f7fbed75.patch \
           file://${BPN}.service \
          "

PATCHTOOL = "git"

DEPENDS = "libgphoto2 v4l-utils"

# Add support for raspicam on rpi platforms
DEPENDS_append_rpi = " ${@bb.utils.contains("MACHINE_FEATURES", "vc4graphics", "", "userland", d)}"
# https://lists.yoctoproject.org/pipermail/yocto/2014-June/019933.html
ASNEEDED_rpi = ""


S = "${WORKDIR}/git/mjpg-streamer-experimental"

inherit cmake systemd
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "${BPN}.service"

OECMAKE_GENERATOR="Unix Makefiles"
EXTRA_OECMAKE = "-DENABLE_HTTP_MANAGEMENT=ON"

EXTRA_OECMAKE_append_rpi = " ${@bb.utils.contains("MACHINE_FEATURES", "vc4graphics", "-DHAS_RASPI=OFF", "-DHAS_RASPI=ON", d)}"

do_install() {
    oe_runmake install DESTDIR=${D}

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/${BPN}.service ${D}${systemd_unitdir}/system
}

FILES_${PN} += "${libdir}/*.so \
                ${systemd_unitdir/system/${BPN}.service"

# And make it rpi specific due to depending on rpi binaries
PACKAGE_ARCH_rpi = "${MACHINE_ARCH}"
