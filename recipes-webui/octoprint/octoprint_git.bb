SUMMARY = "OctoPrint provides a responsive web interface for controlling a 3D printer (RepRap, Ultimaker, ...)."
HOMEPAGE = "http://octoprint.org"

SECTION = "devel/python"

LICENSE = "AGPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=73f1eb20517c55bf9493b7dd6e480788"

# Latest master
SRCREV = "9a6099ffc2982455d631c9d68a3273d9eb55885c"

PV = "1.2.4"


SRC_URI = "git://github.com/foosel/OctoPrint.git;protocol=https;branch=maintenance \ 
           file://config.yaml \
           file://octoprint.service \
           file://octoprint \
           file://pip-sudo \
"
S = "${WORKDIR}/git"

inherit setuptools systemd useradd


export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"

do_install_append(){

    sed -i -e s:/etc:${sysconfdir}:g ${WORKDIR}/octoprint.service
    sed -i -e s:/etc:${sysconfdir}:g ${WORKDIR}/config.yaml
    sed -i -e 's: /sbin: ${base_sbindir}:g' ${WORKDIR}/octoprint
    sed -i -e 's: /bin: ${base_bindir}:g' ${WORKDIR}/octoprint
    sed -i -e s:/usr/bin:${bindir}:g ${WORKDIR}/octoprint

    install -d ${D}${sysconfdir}/octoprint
    install -m 0644 ${WORKDIR}/config.yaml ${D}${sysconfdir}/octoprint/config.yaml
    chmod a+rw ${D}${sysconfdir}/octoprint/config.yaml

    install -d ${D}/lib/systemd/system
    install -m 0644 ${WORKDIR}/octoprint.service ${D}${systemd_unitdir}/system

    install -d ${D}${localstatedir}/lib/octoprint
    chmod a+rw ${D}${localstatedir}/lib/octoprint

    install -d ${D}${sysconfdir}/sudoers.d
    install -m 0644 ${WORKDIR}/octoprint ${D}${sysconfdir}/sudoers.d/

    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/pip-sudo ${D}${bindir}
}

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "--system --home ${localstatedir}/lib/octoprint/ -M -g nogroup octoprint"

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "octoprint.service"

FILES_${PN} += "${sysconfdir} ${localstatedir}"
CONFFILES_${PN} += "${sysconfdir}/octoprint/config.yaml"

RDEPENDS_${PN} = "python-tornado \
                  python-pyyaml \
                  python-numpy \
                  python-pyserial \
                  python-werkzeug \
                  python-html \
                  python-sockjs-tornado \
                  python-tornado \
                  python-json \
                  python-backports-ssl-match-hostname \
                  python-flask \
                  python-flask-login \
                  python-flask-principal \
                  python-netserver \
                  python-itsdangerous \
                  python-markupsafe \
                  python-blinker \
                  python-netaddr \
                  python-jinja2 \
                  python-watchdog \
                  python-pathtools \
                  python-sarge \
                  python-sphinxcontrib-httpdomain \
                  python-sphinx-rtd-theme \
                  python-pip \
                  python-semantic-version \
                  python-requests \
                  python-pkginfo \
                  python-rsa \
                  python-pylru \
                  python-netifaces \
                  python-flask-assets \
                  python-flask-babel \
                  sudo \
                  curaengine \ 
"

RRECOMMENDS_${PN} = "libav \
                     mjpg-streamer \
                    "