SUMMARY = "Memory efficient way of reading files line-by-line from the end of file"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=91853fc3cff572c2912cad57e33b97a3"

PYPI_PACKAGE = "file_read_backwards"

inherit pypi setuptools3

SRC_URI[sha256sum] = "fd50d9089b412147ea3c6027e2ad905f977002db2918cf315d64eed23d6d6eb8"

BBCLASSEXTEND = "native nativesdk"
