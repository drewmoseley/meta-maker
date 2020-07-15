SUMMARY = "Media asset management for Python, with glue code for various web frameworks"
SECTION = "devel/python"

HOMEPAGE = "https://pypi.python.org/pypi/webassets/"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=01c7e9175fd063ebb0a6304af80e9874"

SRC_URI = "git://github.com/miracle2k/webassets.git;proctol=https \
          "
SRCREV = "2.0"
PV = "2.0+git${SRCPV}"

S = "${WORKDIR}/git"

inherit setuptools3

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"
