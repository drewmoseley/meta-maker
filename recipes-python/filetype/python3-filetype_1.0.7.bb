SUMMARY = "Infer file type and MIME type of any file/buffer. No external dependencies."
SECTION = "devel/python"

HOMEPAGE = "https://pypi.python.org/pypi/filetype/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cc0e8af5f14a75ce53b7b9db0f4bd91e"

SRC_URI = "git://github.com/h2non/filetype.py;protocol=https;branch=master"
SRCREV = "3c643cb20b1620e0e5a264bdeb69926ca68ee4c1"
S = "${WORKDIR}/git"

inherit setuptools3
