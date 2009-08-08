# Copyright (C) 2009 Kirtika Ruchandani <kirtibr@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Control Panel to configure the Hildon desktop"
HOMEPAGE = "http://maemo.org"
LICENSE = "GNU Lesser General Public License-version 2.1"
SECTION = "base"
DEPENDS = "osso-gnome-vfs2 libhildon libosso osso-af-settings libhildonhelp maemo-launcher"
PR = "r1"

SRC_URI = "http://repository.maemo.org/pool/maemo5.0beta/free/h/${PN}/${PN}_${PV}-1+0m5.tar.gz \
           file://${PN}-${PV}/mer-changes.patch;patch=1"

EXTRA_OECONF = "--with-maemo-gtk=yes"

inherit autotools pkgconfig 

do_stage(){
    autotools_stage_all
}
