SUMMARY = "Semantic version comparison for Python (see http://semver.org/)"
SECTION = "devel/python"

HOMEPAGE = "https://github.com/rbarrois/python-semanticversion"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4fb31e3c1c7eeb8b5e8c07657cdd54e2"

SRC_URI = "git://github.com/rbarrois/python-semanticversion.git;protocol=git"
SRCREV = "9e968aef1a8aee4039b3052acc6f439b03bc315c"

# Exact version, no need for +git...
PV = "2.8.5"

S = "${WORKDIR}/git"

inherit setuptools3

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR


BBCLASSEXTEND = "native"
