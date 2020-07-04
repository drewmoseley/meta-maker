SUMMARY = "A wrapper for subprocess which provides command pipeline functionality."
SECTION = "devel/python"

HOMEPAGE = "https://pypi.python.org/pypi/sarge"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=854cf22854e806e5cdcce52c1a8ed020"

SRCREV = "c5aff8be9ec1c992f8902c7456777109d17834bf"
SRC_URI = "git://github.com/vsajip/sarge.git;protocol=https;nobranch=1"

S = "${WORKDIR}/git"

inherit setuptools

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"
