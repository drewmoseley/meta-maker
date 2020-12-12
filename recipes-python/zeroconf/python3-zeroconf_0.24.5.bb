SUMMARY = "Multicast DNS Service Discovery for Python"
SECTION = "devel/python"

HOMEPAGE = "https://github.com/jstasiak/python-zeroconf"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=27818cd7fd83877a8e3ef82b82798ef4"

inherit pypi setuptools3
SRC_URI[sha256sum] = "893a841445663e0c4c20d1111ce41484bd62d58f59d653d0485187343368ef4a"

BBCLASSEXTEND = "native"
