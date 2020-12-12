SUMMARY = "sgmllib was dropped in Python 3. For those depending on it, that’s somewhat unfortunate. This is a quick and dirty port of this old module."
SECTION = "devel/python"

HOMEPAGE = "http://hg.hardcoded.net/sgmllib"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://README;md5=4438afa480bb11441c89054e43d484c7"

inherit pypi setuptools3
SRC_URI[sha256sum] = "7868fb1c8bfa764c1ac563d3cf369c381d1325d36124933a726f29fcdaa812e9"

BBCLASSEXTEND = "native"
