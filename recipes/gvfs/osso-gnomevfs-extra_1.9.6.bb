# Copyright (C) 2009 Kirtika Ruchandani <kirtibr@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "Extra support for osso-gnome-vfs in form of an OBEX GnomeVFS module & small library to retrieve the capabilities object from a remote devices."
HOMEPAGE = "http://maemo.org"
SECTION = "base"
LICENSE = "GPL"
DEPENDS = "glib-2.0 openobex osso-gwobex osso-gnome-vfs2 dbus-glib osso-gwconnect expat"
PR = "r3"

SRC_URI = "http://repository.maemo.org/pool/maemo5.0alpha/free/o/${PN}/${PN}_${PV}-3.tar.gz \
           file://osso-gnomevfs-extra/mer-changes.patch;patch=1 "

FILES_${PN} += "${libdir}/gnome-vfs-2.0/modules/*"

require  osso-gnome-vfs2.inc
