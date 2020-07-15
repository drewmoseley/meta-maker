SUMMARY = "i18n and l10n support for Flask based on Babel and pytz"
SECTION = "devel/python"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=51917f3e8e858f5ae295a7d0e2eb3cc9"

DEPENDS = "python3-speaklater python3-babel"

SRC_URI = "git://github.com/mitsuhiko/flask-babel.git;protocol=https"
SRCREV = "v1.0.0"

PV = "1.0.0+git${SRCPV}"

S = "${WORKDIR}/git"

inherit setuptools3

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

RDEPENDS_${PN} = "python3-speaklater python3-babel"

BBCLASSEXTEND = "native"
