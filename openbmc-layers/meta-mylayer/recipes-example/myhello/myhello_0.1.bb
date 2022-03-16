DESCRIPTION = "Simple helloworld application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
DEPENDS = "systemd"
SRC_URI = "file://userprog.c \
           file://bmc_client_bus.c"

S = "${WORKDIR}"

do_compile() {
	${CC} -DUSE_SYSCALL userprog.c ${LDFLAGS} -o userprog
        ${CC} bmc_client_bus.c ${LDFLAGS} -o bmc_client_bus -lsystemd 
}	

do_install() {
	install -d ${D}${bindir}
	install -m 0755 userprog ${D}${bindir}
	install -m 0755 bmc_client_bus ${D}${bindir}
}
