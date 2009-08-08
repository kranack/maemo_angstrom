# Copyright (C) 2009 Kirtika Ruchandani <kirtibr@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Sapwood: pixbuf based theming for gtk+ 2.x"
HOMEPAGE = "http://maemo.org"
LICENSE = "GNU Lesser General Public License-version 2.0"
SECTION = "x11/base"
DEPENDS = "gtk+ upstart"

PR = "r2"

SRC_URI = "http://repository.maemo.org/pool/maemo5.0beta/free/s/${PN}/${PN}_${PV}-2+0m5.tar.gz \
           file://sapwood/mer-changes.patch;patch=1 \
           file://sapwood/socket.patch;patch=1;pnum=0 "

inherit autotools pkgconfig

EXTRA_OECONF += "--enable-abstract-sockets=no"


FILES_${PN} += "${libdir}/gtk-2.0/2.10.0/engines/"

do_stage(){
    autotools_stage_all
}


do_install_append () {
	install -d ${D}${sysconfdir}/osso-af-init ${D}${sysconfdir}/X11/replace/Xsession.d/
	install -m 755 ${S}/debian/sapwood-server.sh  ${D}${sysconfdir}/osso-af-init/sapwood-server.sh
    install -m 755 ${S}/debian/gtk2-engines-sapwood.xsession ${D}${sysconfdir}/X11/replace/Xsession.d/gtk2-engines-sapwood

}

