/*
 * LSST Observatory Control System (OCS) Software
 * Copyright 2008-2017 AURA/LSST.
 *
 * This product includes software developed by the
 * LSST Project (http://www.lsst.org/) with contributions made at LSST partner
 * institutions.  The list of partner institutions is found at:
 * http://www.lsst.org/lsst/about/contributors .
 *
 * Use and redistribution of this software is covered by the GNU Public License
 * Version 3 (GPLv3) or later, as detailed below.  A copy of the GPLv3 is also
 * available at <http://www.gnu.org/licenses/>.
 */

package org.lsst.testing.app;

/**
 * <h2>Entity Type</h2>
 * <p>
 * {@code EntityType} is an {@code enum} type to specifically identify subsystems
 */
public enum EntityType {

  ELECTROMETER( "ELECTROMETER", "elec" ),
  ATMONOCHROMATOR( "MONOCHROMATOR", "amon" ),
  FIBERSPECTROGRAPH( "SEDSPECTROGRAPH", "fspc" );

  private final String _etype;
  private final String _etypeSub;

  /*
   * private constructor
   */
  private EntityType( String etype, String etypeSub ) {

    this._etype = etype;
    this._etypeSub = etypeSub;
  }

  @Override
  public String toString() {
    return this._etype;
  }

  public String toSubString() {
    return this._etypeSub;
  }
}
