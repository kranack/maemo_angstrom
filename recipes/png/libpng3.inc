DESCRIPTION = "PNG Library"
HOMEPAGE = "http://www.libpng.org/"
SECTION = "libs"
PRIORITY = "required"
LICENSE = "libpng"
DEPENDS = "zlib"

inherit autotools pkgconfig binconfig

do_install() {
        install -d ${D}${bindir} ${D}${mandir} \
                   ${D}${libdir} ${D}${includedir}
        unset LDFLAGS
        oe_runmake 'prefix=${prefix}' 'DESTDIR=${D}' \
                   'DB=${D}${bindir}' 'DI=${D}${includedir}' \
                   'DL=${D}${libdir}' 'DM=${D}${mandir}' \
                   install
}
do_stage() {
        cp libpng.pc libpng12.pc
        install -m 644 png.h ${STAGING_INCDIR}/png.h
        install -m 644 pngconf.h ${STAGING_INCDIR}/pngconf.h
        oe_libinstall -so libpng12 ${STAGING_LIBDIR}/
        ln -sf libpng12.so ${STAGING_LIBDIR}/libpng.so
}

PACKAGES =+ "libpng12-dbg libpng12 libpng12-dev"

FILES_libpng12-dbg += "${libdir}/libpng12*.dbg"
FILES_libpng12 = "${libdir}/libpng12.so.*"
FILES_libpng12-dev = "${libdir}/libpng12.* ${includedir}/libpng12 ${libdir}/pkgconfig/libpng12.pc"
FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev = "${includedir} ${libdir}/lib*.so ${libdir}/*.la \
                ${libdir}/*.a ${libdir}/pkgconfig \
                ${datadir}/aclocal ${bindir} ${sbindir}"

python do_package() {
        if bb.data.getVar('DEBIAN_NAMES', d, 1):
            bb.data.setVar('PKG_${PN}', 'libpng12', d)
        bb.build.exec_func('package_do_package', d)
}
