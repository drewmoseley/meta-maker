SUMMARY = "The File Check plugin tries to detect common issues in uploaded files that are known to cause issues while printing and which in the past have caused support requests on OctoPrint's Community Forums"
SECTION = "devel/python"

HOMEPAGE = "https://github.com/OctoPrint/OctoPrint-FileCheck"

LICENSE = "AGPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=73f1eb20517c55bf9493b7dd6e480788"

SRC_URI = "git://github.com/OctoPrint/OctoPrint-FileCheck.git;protocol=https;branch=master"
SRCREV = "76619fd2c6b96f5894df85d0db10930438b03be3"
S = "${WORKDIR}/git"

inherit setuptools3
