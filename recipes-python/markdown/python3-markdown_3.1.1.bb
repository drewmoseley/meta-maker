SUMMARY = "A Python implementation of John Gruber's Markdown."
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=745aaad0c69c60039e638bff9ffc59ed"

inherit pypi setuptools3

PYPI_PACKAGE = "Markdown"
SRC_URI[md5sum] = "d84732ecc65b3a1bff693d9d4c24277f"
SRC_URI[sha256sum] = "2e50876bcdd74517e7b71f3e7a76102050edec255b3983403f1a63e7c8a41e7a"

BBCLASSEXTEND = "native"

RDEPENDS_${PN} += "${PYTHON_PN}-logging ${PYTHON_PN}-setuptools"
