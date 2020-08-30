SUMMARY = "A small OctoPrint plugin to change the looks of OctoPrint! "
SECTION = "devel/python"

HOMEPAGE = "https://github.com/birkbjo/OctoPrint-Themeify"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/birkbjo/OctoPrint-Themeify;protocol=https;branch=master"
SRCREV = "9a85f727e0855ac4ec6d64868e9a772fab0e233e"
S = "${WORKDIR}/git"

DEPENDS = "octoprint"

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
