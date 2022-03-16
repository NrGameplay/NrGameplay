DESCRIPTION = "Simple hello friend application from git"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

#SRC_URI = "git://github.com/linuxtrainer-lwl/git_recipe.git;protocol=https"
SRC_URI = "git:///home/stormy/workspace/git/git_recipe;protocol=file \
	   file://0001-my-first-pacth.patch"
S = "${WORKDIR}/git"
SRCREV = "${AUTOREV}"


do_compile() {
        ${CC} userprog.c ${LDFLAGS} -o userprog
}

do_install() {
        install -d ${D}${bindir}
        install -m 0755 userprog ${D}${bindir}
}

