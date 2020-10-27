SUMMARY = "Checks for unsafe or broken printer firmwares"
SECTION = "devel/python"

HOMEPAGE = "https://github.com/OctoPrint/OctoPrint-FirmwareCheck"

LICENSE = "AGPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=73f1eb20517c55bf9493b7dd6e480788"

SRC_URI = "git://github.com/OctoPrint/OctoPrint-FirmwareCheck.git;protocol=https;tag=${PV}"
S = "${WORKDIR}/git"

inherit setuptools3
