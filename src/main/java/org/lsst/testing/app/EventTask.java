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

import org.lsst.testing.app.salcomponent.CommandableSalComponent;

import static java.lang.System.out;

import javafx.concurrent.Task;

/**
 * <h2>Event Task</h2>
 *
 * The {@code EventTask} class implements the {@link Task} interface and
 * overrides the {@code call()} method defined in it. The {@code EventTask}
 * class wraps a SAL event topic and is intended to be run in a separate
 * {@link Thread}.
 * <p>
 * NOTE: The {@code EventTask} class does not create a {@link Thread} object, it
 * only defines an entry point for threads. It allows you to pass the object to
 * the {@link Thread}.
 */
public class EventTask extends Task<Integer> {

    /* Command Pattern: Receiver (e.g. SalCamera) */
    private final CommandableSalComponent _csc;
    
    private final String _event;

    public EventTask( CommandableSalComponent csc, String event ) {

        this._csc = csc;
        this._event = event;
    }

    public String getName() {
        
        return "EventTask" + "::" + this._csc.getName() + "::" + this._event;
    }

    @Override
    public Integer call() throws Exception {

        Thread.currentThread().setName( getName() );
        out.println( this.getName() + "::"
                                    + Thread.currentThread().getStackTrace()[1].getMethodName()
                                    + "::"
                                    + "Threadid: "
                                    + Thread.currentThread().getId() );

        Integer status = CommandableSalComponent.CSC_STATUS.SAL__NO_UPDATES.getValue();

        try {
            /* Command Pattern: receiver.action() [e.g. _cscMTCS.enterControl()] */
            status = (Integer) _csc.getClass()
                                   /* specify method & that it takes no (i.e. null) args */
                                   .getMethod( this._event, new Class<?>[]{} )
                                   /* invoke w/ null args */
                                   .invoke( _csc, new Object[]{} );
        } catch ( Exception e ) {
            e.printStackTrace( 
                out.printf( this.getName() + "interrupted from EventTask.call()" ));
        }

        return status;
    }
}
