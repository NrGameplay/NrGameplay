DESCRIPTION = "Simple helloworld application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://userprog.c \
	   file://Readme.txt"

S = "${WORKDIR}"

do_compile() {
	${CC} -DUSE_SYSCALL userprog.c ${LDFLAGS} -o userprog
}	

do_install() {
	install -d ${D}${bindir}
	install -m 0755 userprog ${D}${bindir}
	install -d ${D}${docdir}
	install -m 0644 Readme.txt ${D}${docdir}
}
