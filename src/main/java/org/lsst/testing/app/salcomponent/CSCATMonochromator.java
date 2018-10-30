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

package org.lsst.testing.app.salcomponent;

import org.lsst.sal.SAL_ATMonochromator;
import org.lsst.testing.app.AppModel;
import org.lsst.testing.app.EntityType;

import static java.lang.System.out;
import java.util.HashMap;
import java.util.Map;

/**
 * <h2>Calibration Monochromator CSC</h2>
 * <p>
 * {@code CSCATMonochromator} is a (Concrete) Receiver class in the command pattern
 */
public class CSCATMonochromator implements CommandableSalComponent {

  @Override
  public String getName() {
    return "CSCATMonochrometer";
  }

  /////////////////////////////////////////////////////
  // SAL middle-ware Commands
  /////////////////////////////////////////////////////
  
  @Override
  public void start( Object[] args ) {

    SAL_ATMonochromator publisher = new SAL_ATMonochromator();
    publisher.salCommand( "ATMonochromator_command_start" );

    publisher.setDebugLevel( 1 );

    ATMonochromator.command_start command = new ATMonochromator.command_start();
    command.private_revCode = "LSST ATMonochromator start COMMAND";
    command.device = "ATMonochromator";
    command.property = "state";
    command.action = "start";

    int cmdId = publisher.issueCommand_start( command );

    try {
      Thread.sleep( 200 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

    int timeout = 4;
    publisher.waitForCompletion_start( cmdId, timeout );

    /*
          * cleanup
          */
    publisher.salShutdown();
  }

  @Override
  public void enable( Object[] args ) {

    SAL_ATMonochromator publisher = new SAL_ATMonochromator();
    publisher.salCommand( "ATMonochromator_command_enable" );

    publisher.setDebugLevel( 1 );

    ATMonochromator.command_enable command = new ATMonochromator.command_enable();
    command.private_revCode = "LSST ATMonochromator enable COMMAND";
    command.device = "ATMonochromator";
    command.property = "state";
    command.action = "enable";

    int cmdId = publisher.issueCommand_enable( command );

    try {
      Thread.sleep( 200 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

    int timeout = 4;
    publisher.waitForCompletion_enable( cmdId, timeout );

    /*
          * cleanup
          */
    publisher.salShutdown();
  }

  @Override
  public void disable( Object[] args ) {

    SAL_ATMonochromator publisher = new SAL_ATMonochromator();
    publisher.salCommand( "ATMonochromator_command_disable" );

    publisher.setDebugLevel( 1 );

    ATMonochromator.command_disable command = new ATMonochromator.command_disable();
    command.private_revCode = "LSST ATMonochromator disable COMMAND";
    command.device = "ATMonochromator";
    command.property = "state";
    command.action = "disable";

    int cmdId = publisher.issueCommand_disable( command );

    try {
      Thread.sleep( 200 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

    int timeout = 4;
    publisher.waitForCompletion_disable( cmdId, timeout );

    /*
          * cleanup
          */
    publisher.salShutdown();
  }

  @Override
  public void standby( Object[] args ) {

    SAL_ATMonochromator publisher = new SAL_ATMonochromator();
    publisher.salCommand( "ATMonochromator_command_standby" );

    publisher.setDebugLevel( 1 );

    ATMonochromator.command_standby command = new ATMonochromator.command_standby();
    command.private_revCode = "LSST ATMonochromator standby COMMAND";
    command.device = "ATMonochromator";
    command.property = "state";
    command.action = "standby";

    int cmdId = publisher.issueCommand_standby( command );

    try {
      Thread.sleep( 200 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

    int timeout = 4;
    publisher.waitForCompletion_standby( cmdId, timeout );

    /*
          * cleanup
          */
    publisher.salShutdown();
  }

  @Override
  public void exitControl( Object[] args ) {

    SAL_ATMonochromator publisher = new SAL_ATMonochromator();
    publisher.salCommand( "ATMonochromator_command_exitControl" );

    publisher.setDebugLevel( 1 );

    ATMonochromator.command_exitControl command = new ATMonochromator.command_exitControl();
    command.private_revCode = "LSST ATMonochromator exitControl COMMAND";
    command.device = "ATMonochromator";
    command.property = "state";
    command.action = "exitControl";

    int cmdId = publisher.issueCommand_exitControl( command );

    try {
      Thread.sleep( 200 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

    int timeout = 4;
    publisher.waitForCompletion_exitControl( cmdId, timeout );

    /*
          * cleanup
          */
    publisher.salShutdown();
  }

  public void updateMonochromatorSetup( Object[] args ) {

    SAL_ATMonochromator publisher = new SAL_ATMonochromator();
    publisher.salCommand( "ATMonochromator_command_updateMonochromatorSetup" );

    publisher.setDebugLevel( 1 );

    ATMonochromator.command_updateMonochromatorSetup command = new ATMonochromator.command_updateMonochromatorSetup();
    command.private_revCode = "LSST ATMonochromator updateMonochromatorSetup COMMAND";
    command.device = "ATMonochromator";
    command.property = "calibration";
    command.action = "updateMonochromatorSetup";
    command.gratingType = (int) args[0];
    command.fontEntranceSlitWidth = (double) args[1];
    command.fontExitSlitWidth = (double) args[2];
    command.wavelength = (double) args[3];

    int cmdId = publisher.issueCommand_updateMonochromatorSetup( command );

    try {
      Thread.sleep( 200 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

    int timeout = 4;
    publisher.waitForCompletion_updateMonochromatorSetup( cmdId, timeout );

    /*
          * cleanup
          */
    publisher.salShutdown();
  }

  public void calibrateWavelength( float wavelength ) {

    SAL_ATMonochromator publisher = new SAL_ATMonochromator();
    publisher.salCommand( "ATMonochromator_command_calibrateWavelength" );

    publisher.setDebugLevel( 1 );

    ATMonochromator.command_calibrateWavelength command = new ATMonochromator.command_calibrateWavelength();
    command.private_revCode = "LSST ATMonochromator calibrateWavelength COMMAND";
    command.device = "ATMonochromator";
    command.property = "calibration";
    command.action = "calibrateWavelength";
    command.wavelength = wavelength;

    int cmdId = publisher.issueCommand_calibrateWavelength( command );

    try {
      Thread.sleep( 200 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

    int timeout = 4;
    publisher.waitForCompletion_calibrateWavelength( cmdId, timeout );

    /*
          * cleanup
          */
    publisher.salShutdown();
  }

  public void changeSlitWidth( int slit, float slitWidth ) {

    SAL_ATMonochromator publisher = new SAL_ATMonochromator();
    publisher.salCommand( "ATMonochromator_command_changeSlitWidth" );

    publisher.setDebugLevel( 1 );

    ATMonochromator.command_changeSlitWidth command = new ATMonochromator.command_changeSlitWidth();
    command.private_revCode = "LSST ATMonochromator changeSlitWidth COMMAND";
    command.device = "ATMonochromator";
    command.property = "calibration";
    command.action = "changeSlitWidth";
    command.slit = slit;
    command.slitWidth = slitWidth;

    int cmdId = publisher.issueCommand_changeSlitWidth( command );

    try {
      Thread.sleep( 200 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

    int timeout = 4;
    publisher.waitForCompletion_changeSlitWidth( cmdId, timeout );

    /*
          * cleanup
          */
    publisher.salShutdown();
  }

  public void changeWavelength( float wavelength ) {

    SAL_ATMonochromator publisher = new SAL_ATMonochromator();
    publisher.salCommand( "ATMonochromator_command_changeWavelength" );

    publisher.setDebugLevel( 1 );

    ATMonochromator.command_changeWavelength command = new ATMonochromator.command_changeWavelength();
    command.private_revCode = "LSST ATMonochromator ChangeWavelength COMMAND";
    command.device = "ATMonochromator";
    command.property = "calibration";
    command.action = "changeWavelength";
    command.wavelength = wavelength;

    int cmdId = publisher.issueCommand_changeWavelength( command );

    try {
      Thread.sleep( 200 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

    int timeout = 4;
    publisher.waitForCompletion_changeWavelength( cmdId, timeout );

    /*
          * cleanup
          */
    publisher.salShutdown();
  }

  public void power( boolean power ) {

    SAL_ATMonochromator publisher = new SAL_ATMonochromator();
    publisher.salCommand( "ATMonochromator_command_power" );

    publisher.setDebugLevel( 1 );

    ATMonochromator.command_power command = new ATMonochromator.command_power();
    command.private_revCode = "LSST ATMonochromator power COMMAND";
    command.device = "ATMonochromator";
    command.property = "calibration";
    command.action = "power";
    command.power = power;

    int cmdId = publisher.issueCommand_power( command );

    try {
      Thread.sleep( 200 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

    int timeout = 4;
    publisher.waitForCompletion_power( cmdId, timeout );

    /*
          * cleanup
          */
    publisher.salShutdown();
  }

  public void selectGrating( int gratingType ) {

    SAL_ATMonochromator publisher = new SAL_ATMonochromator();
    publisher.salCommand( "ATMonochromator_command_selectGrating" );

    publisher.setDebugLevel( 1 );

    ATMonochromator.command_selectGrating command = new ATMonochromator.command_selectGrating();
    command.private_revCode = "LSST ATMonochromator selectGrating COMMAND";
    command.device = "ATMonochromator";
    command.property = "calibration";
    command.action = "selectGrating";
    command.gratingType = gratingType;

    int cmdId = publisher.issueCommand_selectGrating( command );

    try {
      Thread.sleep( 200 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

    int timeout = 4;
    publisher.waitForCompletion_selectGrating( cmdId, timeout );

    /*
          * cleanup
          */
    publisher.salShutdown();
  }

  
  /////////////////////////////////////////////////////
  // SAL middle-ware Events
  /////////////////////////////////////////////////////
  
  @Override
  public Integer summaryState( Object[] args ) {

    // Initialize
    SAL_ATMonochromator subscriber = new SAL_ATMonochromator();
    subscriber.salEvent( "ATMonochromator_logevent_summaryState" );

    subscriber.setDebugLevel( 1 );

    ATMonochromator.logevent_summaryState event = new ATMonochromator.logevent_summaryState();

    Integer status = CSC_STATUS.SAL__NO_UPDATES.getValue();
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_summaryState( event );
      if ( status == SAL_ATMonochromator.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
        out.println( "=== Event Status : " + status );
        out.println( "=== Event summaryState : " + event.summaryState );

        try {
          AppModel.getEntityMap()
              .get( EntityType.ATMONOCHROMATOR.toString() )._modelStateTransitionQ.put( event.summaryState );

          AppModel.getEntityMap()
              .get( EntityType.ATMONOCHROMATOR.toString() )._viewStateTransitionQ.put( event.summaryState );
        } catch ( InterruptedException ie ) {
          ie.printStackTrace( out.printf( "GOOD summaryState" ) );
        }
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    /*
          * cleanup
          */
    subscriber.salShutdown();

    return status;
  }

  @Override
  public void settingsVersion( Object[] args ) {

    // Initialize
    SAL_ATMonochromator subscriber = new SAL_ATMonochromator();
    subscriber.salEvent( "ATMonochromator_logevent_settingsVersions" );

    ATMonochromator.logevent_settingVersions event = new ATMonochromator.logevent_settingVersions();

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_settingVersions( event );
      if ( status == SAL_ATMonochromator.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    /*
          * cleanup
          */
    subscriber.salShutdown();
  }

  @Override
  public void appliedSettingsMatchStart( Object[] args ) {

    // Initialize
    SAL_ATMonochromator subscriber = new SAL_ATMonochromator();
    subscriber.salEvent( "ATMonochromator_logevent_appliedSettingsMatchStart" );

    ATMonochromator.logevent_appliedSettingsMatchStart event = new ATMonochromator.logevent_appliedSettingsMatchStart();

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_appliedSettingsMatchStart( event );
      if ( status == SAL_ATMonochromator.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    /*
          * cleanup
          */
    subscriber.salShutdown();
  }

  public static final int SAL__ATMonochromator_logevent_settingsAppliedMonoCommunication_ACTOR = 26;

  public void settingsAppliedLoop() {

    // Initialize
    SAL_ATMonochromator subscriber = new SAL_ATMonochromator();
    subscriber.salEvent( "ATMonochromator_logevent_settingsAppliedLoop" );

    ATMonochromator.logevent_settingsAppliedLoop event = new ATMonochromator.logevent_settingsAppliedLoop();

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_settingsAppliedLoop( event );
      if ( status == SAL_ATMonochromator.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    /*
          * cleanup
          */
    subscriber.salShutdown();
  }

  public void settingsAppliedMonoCommunication() {

    // Initialize
    SAL_ATMonochromator subscriber = new SAL_ATMonochromator();
    subscriber.salEvent( "ATMonochromator_logevent_settingsAppliedMonoCommunication" );

    ATMonochromator.logevent_settingsAppliedMonoCommunication event = new ATMonochromator.logevent_settingsAppliedMonoCommunication();

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_settingsAppliedMonoCommunication( event );
      if ( status == SAL_ATMonochromator.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    /*
          * cleanup
          */
    subscriber.salShutdown();
  }

  public void settingsAppliedMonoHeartbeat() {

    // Initialize
    SAL_ATMonochromator subscriber = new SAL_ATMonochromator();
    subscriber.salEvent( "ATMonochromator_logevent_settingsAppliedMonoHeartbeat" );

    ATMonochromator.logevent_settingsAppliedMonoHeartbeat event = new ATMonochromator.logevent_settingsAppliedMonoHeartbeat();

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_settingsAppliedMonoHeartbeat( event );
      if ( status == SAL_ATMonochromator.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    /*
          * cleanup
          */
    subscriber.salShutdown();
  }

  public void settingsAppliedMonochromatorRanges() {

    // Initialize
    SAL_ATMonochromator subscriber = new SAL_ATMonochromator();
    subscriber.salEvent( "ATMonochromator_logevent_settingsAppliedMonochromatorRanges" );

    ATMonochromator.logevent_settingsAppliedMonochromatorRanges event = new ATMonochromator.logevent_settingsAppliedMonochromatorRanges();

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_settingsAppliedMonochromatorRanges( event );
      if ( status == SAL_ATMonochromator.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    /*
          * cleanup
          */
    subscriber.salShutdown();
  }

  public boolean monochromatorConnected() {

    // Initialize
    SAL_ATMonochromator subscriber = new SAL_ATMonochromator();
    subscriber.salEvent( "ATMonochromator_logevent_monochromatorConnected" );

    ATMonochromator.logevent_monochromatorConnected event = new ATMonochromator.logevent_monochromatorConnected();

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_monochromatorConnected( event );
      if ( status == SAL_ATMonochromator.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    boolean connected = event.connected;

    /*
          * cleanup
          */
    subscriber.salShutdown();

    return connected;
  }

  public int selectedGrating() {

    // Initialize
    SAL_ATMonochromator subscriber = new SAL_ATMonochromator();
    subscriber.salEvent( "ATMonochromator_logevent_selectedGrating" );

    ATMonochromator.logevent_selectedGrating event = new ATMonochromator.logevent_selectedGrating();

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_selectedGrating( event );
      if ( status == SAL_ATMonochromator.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    int gratingType = event.gratingType;
    double timestamp = event.timestamp;

    /*
          * cleanup
          */
    subscriber.salShutdown();

    return gratingType;
  }

  public Map<String, Object> slitWidth() {

    // Initialize
    SAL_ATMonochromator subscriber = new SAL_ATMonochromator();
    subscriber.salEvent( "ATMonochromator_logevent_slitWidth" );

    ATMonochromator.logevent_slitWidth event = new ATMonochromator.logevent_slitWidth();

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_slitWidth( event );
      if ( status == SAL_ATMonochromator.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    Map<String /* key */, Object /* value */> valuesMap = new HashMap<>();
    valuesMap.put( "slit", event.slit /* int */ );
    valuesMap.put( "slitPosition", event.slitPosition /* float */ );
    valuesMap.put( "timeStamp", event.timestamp /* double */ );

    // e.g. To extract a value:
    //     int slit =  int.class.cast( valuesMap.get( "slit" ) );
    //     float slitPosition =  float.class.cast( valuesMap.get( "slitPosition" ) );
    //     double timeStamp =  double.class.cast( valuesMap.get( "timeStamp" ) );
  
    /*
          * cleanup
          */
    subscriber.salShutdown();

    return valuesMap;
  }

  public float wavelength() {

    // Initialize
    SAL_ATMonochromator subscriber = new SAL_ATMonochromator();
    subscriber.salEvent( "ATMonochromator_logevent_wavelength" );

    ATMonochromator.logevent_wavelength event = new ATMonochromator.logevent_wavelength();

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_wavelength( event );
      if ( status == SAL_ATMonochromator.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    float wavelength = event.wavelength;
    double timestamp = event.timestamp;

    /*
          * cleanup
          */
    subscriber.salShutdown();

    return wavelength;
  }

  public boolean inPosition() {

    // Initialize
    SAL_ATMonochromator subscriber = new SAL_ATMonochromator();
    subscriber.salEvent( "ATMonochromator_logevent_inPosition" );

    ATMonochromator.logevent_inPosition event = new ATMonochromator.logevent_inPosition();

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_inPosition( event );
      if ( status == SAL_ATMonochromator.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    boolean inPosition = event.inPosition;
    int device = event.device;

    /*
          * cleanup
          */
    subscriber.salShutdown();

    return inPosition;
  }

  public boolean loopTimeOutOfRange() {

    // Initialize
    SAL_ATMonochromator subscriber = new SAL_ATMonochromator();
    subscriber.salEvent( "ATMonochromator_logevent_loopTimeOutOfRange" );

    ATMonochromator.logevent_loopTimeOutOfRange event = new ATMonochromator.logevent_loopTimeOutOfRange();

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_loopTimeOutOfRange( event );
      if ( status == SAL_ATMonochromator.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    boolean loopTimeOutOfRange = event.loopTimeOutOfRange;

    /*
          * cleanup
          */
    subscriber.salShutdown();

    return loopTimeOutOfRange;
  }
}
