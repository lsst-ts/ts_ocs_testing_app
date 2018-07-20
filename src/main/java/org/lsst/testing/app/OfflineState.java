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

import org.lsst.testing.app.salconnect.SalConnect;
import org.lsst.testing.app.salservice.SalCmd;
import org.lsst.testing.app.salservice.SalEvent;

import static java.lang.System.out;

/**
 * <h2>Offline Entity State</h2>
 *
 * {@code OfflineState} is a Concrete State class implementation.
 * <p>
 * Transitions to: {@code StandbyState}
 */
public class OfflineState implements EntityState {

    @Override
    public String getName() { return "OfflineState"; }

    @Override
    public void enterControl( Entity entity ) {

        String salactor = entity.getClass()
                                .getSimpleName() + "." 
                                                 + entity.getCSC().getClass().getSimpleName()
                                                 + "."
                                                 + this.getName()
                                                 + ".enterControl";
        
        out.println( salactor + ": " + Thread.currentThread().getId() );

        /* Cmd Sequencer, TCS, CCS or DMCS via SAL */
        
        /*  
                    * 1. Command Pattern: SalComponent (Rcvr) reference is entity data member
                    * 2. Command Pattern: Define Concrete SalService (Concrete Cmd) for specific SalComponent (Rcvr)
                    */
        SalCmd salCmd = new SalCmd( entity._salComponent );

        /* 3. Also, assign topic & topic arguments */
        salCmd.setTopic( "enterControl" );

        /* 4. Command Pattern: Define Invoker & set up command request */
        SalConnect salConnect = new SalConnect( 1 );
        salConnect.setSalService( salCmd );

        /* 5. Command Pattern: Invoker.executeCommand() */
        salConnect.connect(); //  indirectly calls: commandIF.execute() [salService.execute()]

        if ( EntityType.OCS.toString().equalsIgnoreCase( salactor ) ) {

            /* 1. Publish SummaryState if not previously pub'd */
            SalEvent salEvent = new SalEvent( entity._salComponent );
            salEvent.setTopic( "summaryState" );

            salConnect.setSalService( salEvent );
            salConnect.connect();

            /* 2. Check settings match (or differ) from start values
                             *    a. Publish Topic->AppliedSettingsMatchStart (or they differ??)
                             * 3. Full control features are allowed
                             *    a. Entity reads/loads & applies control settings
                             */
        }

        /* 
                    * Cmd local entity state from OfflineState[AvailableState] to StandbyState
                    * State Pattern: Context.request()
                    */
        waitForSummaryState( salactor, entity, new StandbyState() );
    }
}
