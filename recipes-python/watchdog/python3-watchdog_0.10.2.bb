SUMMARY = "Filesystem events monitoring"
SECTION = "devel/python"

HOMEPAGE = "http://http://werkzeug.pocoo.org/"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "python3-argh"

SRC_URI = "https://pypi.python.org/packages/source/w/watchdog/watchdog-${PV}.tar.gz"
SRC_URI[md5sum] = "2477fb59dcb110b8562eb4eb973cda23"
SRC_URI[sha256sum] = "c560efb643faed5ef28784b2245cf8874f939569717a4a12826a173ac644456b"

S = "${WORKDIR}/watchdog-${PV}"

inherit setuptools3

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

RDEPENDS_${PN} = "python3-argh"

BBCLASSEXTEND = "native"
