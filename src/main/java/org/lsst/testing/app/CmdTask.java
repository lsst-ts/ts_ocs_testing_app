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
 * <h2>Command Task</h2>
 *
 * The {@code CmdTask} class implements the {@link Task} interface and overrides
 * the {@code call()} method defined in it. The {@code CmdTask} class wraps a
 * SAL command topic and is intended to be run in a separate {@link Thread}.
 * <p>
 * NOTE: The {@code CmdTask} class does not create a {@link Thread} object, it
 * only defines an entry point for threads. It allows you to pass the object to
 * the {@link Thread}.
 */
public class CmdTask extends Task<Void> {

    /* State Pattern: Context (e.g. Entity entityMTCS) */
    private final Entity _entity;

    private final CommandableSalComponent _csc;
    private final String _cmd;

    public CmdTask( CommandableSalComponent csc, String cmd ) {

        this._csc = csc;
        this._cmd = cmd;
        this._entity = null;
    }

    public CmdTask( Entity entity, String cmd ) {

        this._entity = entity;
        this._cmd = cmd;
        this._csc = entity.getCSC();
    }

    public String getName() {
        
        return "CmdTask" + "::" + this._csc.getName() + "::" + this._cmd;
    }

    @Override
    public Void call () {

        Thread.currentThread().setName( getName() );
        out.println( this.getName() + "::"
                                    + Thread.currentThread().getStackTrace()[1].getMethodName()
                                    + "::"
                                    + "Threadid: "
                                    + Thread.currentThread().getId() );

        try {
            /* State Pattern: Context.request() [e.g. entityMTCS.enterControl()] */
            _entity.getClass()
                   /* specify method & that it takes no (i.e. null) args */
                   .getMethod( this._cmd, new Class<?>[]{} )
                   /* invoke w/ null args */
                   .invoke( this._entity, new Object[]{} );
        } catch ( Exception e ) {
            e.printStackTrace( 
                out.printf( this.getName() + "interrupted from CmdTask.call()" ) );
        }

        return null;
    }
}
