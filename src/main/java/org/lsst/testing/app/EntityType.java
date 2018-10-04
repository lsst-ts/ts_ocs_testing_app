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
 *
 * {@code EntityType} is an {@code enum} type to specifically identify subsystems
 */
public enum EntityType {
    
    ARCHIVER         ( "ARCHIVER"        , "arc"  ),
    CATCHUPARCHIVER  ( "CATCHUPARCHIVER" , "cat"  ),
    CCS              ( "CCS"             , "ccs"  ),
    HEADERSERVICE    ( "HEADERSERVICE"   , "hdr"  ),
    MTCS             ( "MTCS"            , "mtcs" ),
    PROMPTPROCESSING ( "PROMPTPROCESSING", "pro"  ),
    OCS              ( "OCS"             , "ocs"  ),
    SCHEDULER        ( "SCHEDULER"       , "sch"  ),
    SEQUENCER        ( "SEQUENCER"       , "seq"  ),

    AARCHIVER        ( "AARCHIVER"       , "aarc" ),
    ACCS             ( "ACCS"            , "accs" ),
    AHEADERSERVICE   ( "AHEADERSERVICE"  , "ahdr" ),
    ASCHEDULER       ( "ASCHEDULER"      , "asch" ),
    ATCS             ( "ATCS"            , "atcs" ),
    
    ELECTROMETER     ( "ELECTROMETER"    , "ele"  ),
    MONOCHROMATOR    ( "MONOCHROMATOR"   , "mon"  ),
    SEDSPECTROGRAPH  ( "SEDSPECTROGRAPH" , "sed"  );
    
    private final String _etype;
    private final String _etypeShort;
    
    /* private constructor */
    private EntityType( String etype, String etypeShort ) { 
    
        this._etype = etype; 
        this._etypeShort = etype; 
    }
    
    @Override public String toString() { return this._etype; }
    public String toStringShort() { return this._etypeShort; }
}