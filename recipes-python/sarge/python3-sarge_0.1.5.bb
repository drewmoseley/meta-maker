SUMMARY = "A wrapper for subprocess which provides command pipeline functionality."
SECTION = "devel/python"

HOMEPAGE = "https://pypi.python.org/pypi/sarge"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a5b7bcb59dada77822aa4d479a96cc6d"

SRCREV = "0.1.5"
SRC_URI = "git://github.com/vsajip/sarge.git;protocol=https;nobranch=1"

S = "${WORKDIR}/git"

inherit setuptools3

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"
