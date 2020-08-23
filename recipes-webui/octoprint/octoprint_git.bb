SUMMARY = "OctoPrint provides a responsive web interface for controlling a 3D printer (RepRap, Ultimaker, ...)."
HOMEPAGE = "http://octoprint.org"

SECTION = "devel/python"

LICENSE = "AGPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=73f1eb20517c55bf9493b7dd6e480788"

SRCREV = "45d3e7c8646c2cf8c2341616830fb492d73874f6"

PV = "1.4.2+git${SRCPV}"

PATCHTOOL = "git"
SRC_URI = "git://github.com/OctoPrint/OctoPrint.git;protocol=https;branch=maintenance \
           file://config.yaml \
           file://octoprint.service \
           file://octoprint \
           file://pip-sudo \
"
S = "${WORKDIR}/git"

inherit setuptools3 systemd useradd


export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"

do_configure_prepend() {
    # 'post0' only exist as tarball, no matching commit/version in the git repo :/
    sed -i -e s:post0::g ${S}/setup.py
}

do_install_append() {
    # We explicitly call distutils_do_install
    distutils3_do_install
    
    sed -i -e s:/etc:${sysconfdir}:g ${WORKDIR}/octoprint.service
    sed -i -e s:/etc:${sysconfdir}:g ${WORKDIR}/config.yaml
    sed -i -e 's: /sbin: ${base_sbindir}:g' ${WORKDIR}/octoprint
    sed -i -e 's: /bin: ${base_bindir}:g' ${WORKDIR}/octoprint
    sed -i -e s:/usr/bin:${bindir}:g ${WORKDIR}/octoprint

    install -d ${D}${sysconfdir}/octoprint
    install -m 0644 ${WORKDIR}/config.yaml ${D}${sysconfdir}/octoprint/config.yaml
    chmod 600 ${D}${sysconfdir}/octoprint/config.yaml

    install -d ${D}/lib/systemd/system
    install -m 0644 ${WORKDIR}/octoprint.service ${D}${systemd_unitdir}/system

    install -d ${D}${localstatedir}/lib/octoprint
    chmod 700 ${D}${localstatedir}/lib/octoprint

    install -d ${D}${sysconfdir}/sudoers.d
    install -m 0644 ${WORKDIR}/octoprint ${D}${sysconfdir}/sudoers.d/

    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/pip-sudo ${D}${bindir}
}

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "--system --home ${localstatedir}/lib/octoprint/ -M -g nogroup -G dialout octoprint"

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "octoprint.service"

FILES_${PN} += "${sysconfdir} ${localstatedir}"
CONFFILES_${PN} += "${sysconfdir}/octoprint/config.yaml"

do_install_append () {
        chown -R octoprint ${D}${sysconfdir}/octoprint
}

DEPENDS_append = " python3-markdown-native "

RDEPENDS_${PN} = "python3-awesome-slugify \
                  python3-backports-abc \
                  python3-backports-ssl \
                  python3-blinker \
                  python3-feedparser \
                  python3-flask \
                  python3-flask-assets \
                  python3-flask-babel \
                  python3-flask-login \
                  python3-flask-principal \
                  python3-frozendict \
                  python3-html \
                  python3-itsdangerous \
                  python3-jinja2 \
                  python3-json \
                  python3-markdown \
                  python3-netaddr \
                  python3-netifaces \
                  python3-netserver \
                  python3-numpy \
                  python3-pathtools \
                  python3-pip \
                  python3-pkginfo \
                  python3-psutil \
                  python3-pylru \
                  python3-pyserial \
                  python3-pyyaml \
                  python3-requests \
                  python3-rsa \
                  python3-sarge \
                  python3-semantic-version \
                  python3-singledispatch \
                  python3-sphinx-rtd-theme \
                  python3-sphinxcontrib-httpdomain \
                  python3-tornado \
                  python3-watchdog \
                  python3-werkzeug \
                  python3-werkzeug-tests \
                  python3-click \
                  python3-chainmap \
                  python3-future \
                  python3-scandir \
                  python3-websocket-client \
                  python3-dateutil \
                  python3-wrapt \
                  python3-emoji \
                  python3-monotonic \
                  python3-unidecode \
                  python3-filetype \
                  python3-sentry-sdk \
                  python3-cachelib \
                  python3-octoprint-filecheck \
                  python3-octoprint-firmwarecheck \
                  python3-typing \
                  sudo \
                  curaengine \ 
"

RRECOMMENDS_${PN} = "ffmpeg \
                     mjpg-streamer \
                     octoprint-nginx \
                    "
