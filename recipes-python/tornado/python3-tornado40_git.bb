DESCRIPTION = "Tornado is an open source version of the scalable, non-blocking web server and tools that power FriendFeed."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PV = "4.0.2"

SRCREV = "b18b12b532790f40edf431625d184bf8e479956b"
SRC_URI = "git://github.com/tornadoweb/tornado.git;branch=branch4.0"

S = "${WORKDIR}/git"

inherit setuptools

DEPENDS = "python3-certifi"

RDEPENDS_${PN} = "python3-certifi"
RCONFLICTS_${PN} = "python3-tornado"
RCONFLICTS_${PN} = "python3-tornado45"
RCONFLICTS_${PN} = "python3-tornado50"

