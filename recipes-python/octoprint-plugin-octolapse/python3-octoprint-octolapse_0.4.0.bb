SUMMARY = "Create a stabilized timelapse of your 3D prints."
SECTION = "devel/python"

HOMEPAGE = "https://github.com/FormerLurker/Octolapse"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/FormerLurker/Octolapse;protocol=https;tag=v0.4.0"
S = "${WORKDIR}/git"

DEPENDS = "octoprint python3-tornado python3-future python3-flask python3-jinja2 python3-markupsafe python3-werkzeug python3-itsdangerous python3-click python3-flask-login python3-flask-babel python3-pytz python3-flask-assets python3-watchdog python3-pathtools python3-frozendict python3-netaddr python3-netifaces-native python3-requests python3-urllib3 python3-chardet python3-certifi python3-idna python3-pyyaml python3-pkginfo python3-sarge python3-wrapt python3-cachelib python3-pylru python3-emoji python3-unidecode python3-regex-native python3-blinker python3-pyserial"
RDEPENDS_${PN} += "python3-netifaces python3-regex"

inherit setuptools3

distutils3_do_configure_prepend() {
    export PYTHONPATH=${STAGING_DIR_HOST}${PYTHON_SITEPACKAGES_DIR}
}

distutils3_do_compile_prepend() {
    export PYTHONPATH=${STAGING_DIR_HOST}${PYTHON_SITEPACKAGES_DIR}
}

#
# This feels kinda dirty; I wonder if there is a better way to handle this.
# Essentially the plugin setup.py expects to find the octoprint py files
# in ${D}${PYTHON_SITEPACKAGES_DIR} but they aren't there since we are
# cross-building.  We'll copy them there for the install function so
# that it can find them and then remove them after so they don't get
# installed as part of this package.
#
do_install_prepend() {
    install -d ${D}${PYTHON_SITEPACKAGES_DIR}
    cp -R ${STAGING_DIR_HOST}${PYTHON_SITEPACKAGES_DIR}/* ${D}${PYTHON_SITEPACKAGES_DIR}/
}

do_install_append() {
    for i in $(cd ${STAGING_DIR_HOST}${PYTHON_SITEPACKAGES_DIR}; echo *); do
       rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/$i
   done
}
