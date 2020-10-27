SUMMARY = "This plugin visualises the output from various firmware that support bed mesh leveling, noteably the Prusa G81 mesh leveling report and the Marlin G29 T bed topography report. The plugin utilizes Plotly js library to render a 3D surface of the bed's reported mesh on a tab within OctoPrint."
SECTION = "devel/python"

HOMEPAGE = "https://github.com/jneilliii/OctoPrint-BedLevelVisualizer"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c25dca6f05d3d0d952c7fe9373c8b429"

SRC_URI = "git://github.com/jneilliii/OctoPrint-BedLevelVisualizer;protocol=https;branch=${PV};tag=${PV}"
S = "${WORKDIR}/git"

DEPENDS = "octoprint python3-numpy python3-flask"

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
