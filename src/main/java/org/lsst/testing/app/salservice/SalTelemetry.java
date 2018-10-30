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

package org.lsst.testing.app.salservice;

import org.lsst.testing.app.DomainObject;
import org.lsst.testing.app.salcomponent.CommandableSalComponent;

import static java.lang.System.out;

/**
 * <h2>SAL Telemetry</h2>
 * <p>
 * {@code SalTelemetry} is a Concrete Command class in the command pattern
 */
public class SalTelemetry extends SalService implements DomainObject {

  @Override
  public String getName() {

    return "SalTelemetry" + "::" + super._topic + "::" + this._salComponent;
  }

  /*
   * Command Pattern: Receiver IF (e.g. concrete receiver => CSCCcs)
   */
  CommandableSalComponent _salComponent;

  public SalTelemetry( CommandableSalComponent salComponent ) {

    this._salComponent = salComponent;
  }

  @Override
  public void execute() {

    out.println( this.getName() + "::"
                 + Thread.currentThread().getStackTrace()[1].getMethodName()
                 + "::"
                 + "Threadid: "
                 + Thread.currentThread().getId() );

    try {
      /*
       * Command Pattern: receiverIF.action() [e.g. concrete rcvr => cscMTcs.heartBeat()]
       */
      _salComponent.getClass()
          /*
           * specify method & that it takes no (i.e. null) args
           */
          .getMethod( this._topic, new Class<?>[]{} )
          /*
           * invoke w/ specific arg
           */
          .invoke( _salComponent, super._topicArgs );
    } catch ( Exception e ) {
      e.printStackTrace(
          out.printf( this.getName() + "interrupted from SalTelemetry.execute()" ) );
    }
  }
}
