SUMMARY = "Cross-platform network interface and IP address enumeration library"
SECTION = "devel/python"

HOMEPAGE = "https://github.com/pydron/ifaddr"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=8debe8d42320ec0ff24665319b625a5e"

inherit pypi setuptools3
SRC_URI[sha256sum] = "1f9e8a6ca6f16db5a37d3356f07b6e52344f6f9f7e806d618537731669eb1a94"

BBCLASSEXTEND = "native"
