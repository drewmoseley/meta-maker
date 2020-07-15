SUMMARY = "Flask webassets integration."
SECTION = "devel/python"

HOMEPAGE = "http://flask-assets.readthedocs.org/en/latest/"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c0c455026ee819a9365678bea8b2c82"

DEPENDS = "python3-webassets"

SRC_URI = "git://github.com/miracle2k/flask-assets.git;protocol=https"
SRCREV = "2.0"

PV = "2.0+git${SRCPV}"

S = "${WORKDIR}/git"

inherit setuptools3

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

RDEPENDS_${PN} = "python3-webassets"

BBCLASSEXTEND = "native"
