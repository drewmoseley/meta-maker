SUMMARY = "The Swiss Army knife of Python web development"
DESCRIPTION = "\
Werkzeug started as simple collection of various utilities for WSGI \
applications and has become one of the most advanced WSGI utility modules. \
It includes a powerful debugger, full featured request and response objects, \
HTTP utilities to handle entity tags, cache control headers, HTTP dates, \
cookie handling, file uploads, a powerful URL routing system and a bunch \
of community contributed addon modules."
HOMEPAGE = "http://werkzeug.pocoo.org/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=5dc88300786f1c214c1e9827a5229462"

SRC_URI[md5sum] = "5d499cfdd30de5d9c946994783772efd"
SRC_URI[sha256sum] = "6c80b1e5ad3665290ea39320b91e1be1e0d5f60652b964a3070216de83d2e47c"

PYPI_PACKAGE = "Werkzeug"

CLEANBROKEN = "1"

PACKAGES =+ "${PN}-tests"
FILES_${PN}-tests+= " \
    ${PYTHON_SITEPACKAGES_DIR}/werkzeug/test* \
    ${PYTHON_SITEPACKAGES_DIR}/werkzeug/__pycache__/test* \
    ${PYTHON_SITEPACKAGES_DIR}/werkzeug/contrib/test* \
    ${PYTHON_SITEPACKAGES_DIR}/werkzeug/contrib/__pycache__/test* \
"

RDEPENDS_${PN} += " \
    ${PYTHON_PN}-datetime \
    ${PYTHON_PN}-difflib \
    ${PYTHON_PN}-email \
    ${PYTHON_PN}-html \
    ${PYTHON_PN}-io \
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-netclient \
    ${PYTHON_PN}-netserver \
    ${PYTHON_PN}-numbers \
    ${PYTHON_PN}-pkgutil \
    ${PYTHON_PN}-pprint \
    ${PYTHON_PN}-threading \
    ${PYTHON_PN}-unixadmin \
"

RDEPENDS_${PN}-tests = " \
    ${PN} \
    ${PYTHON_PN}-unittest \
"
