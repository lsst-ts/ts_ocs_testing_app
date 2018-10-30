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

import org.lsst.sal.SAL_Electrometer;
import org.lsst.testing.app.AppModel;
import org.lsst.testing.app.EntityType;

import static java.lang.System.out;
import java.util.HashMap;
import java.util.Map;

/**
 * <h2>Auxiliary Camera Control System (ACCS) CSC</h2>
 * <p>
 * {@code CSCElectrometer} is a (Concrete) Receiver class in the command pattern
 */
public class CSCElectrometer implements CommandableSalComponent {

  @Override
  public String getName() {
    return "CSCElectrometer";
  }

  /////////////////////////////////////////////////////
  // SAL middle-ware Commands
  /////////////////////////////////////////////////////
  
  @Override
  public void start( Object[] args ) {

    short aKey = (short) args[0];

    SAL_Electrometer publisher = new SAL_Electrometer( aKey );
    publisher.salCommand( "Electrometer_command_start" );
    publisher.setDebugLevel( 1 );

    Electrometer.command_start command = new Electrometer.command_start();
    command.private_revCode = "LSST Electrometer start COMMAND";
    command.device = "Electrometer";
    command.property = "state";
    command.action = "start";

    command.ElectrometerID = aKey;

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

    short aKey = (short) args[0];

    SAL_Electrometer publisher = new SAL_Electrometer( aKey );
    publisher.salCommand( "Electrometer_command_enable" );
    publisher.setDebugLevel( 1 );

    Electrometer.command_enable command = new Electrometer.command_enable();
    command.private_revCode = "LSST Electrometer enable COMMAND";
    command.device = "Electrometer";
    command.property = "state";
    command.action = "enable";

    command.ElectrometerID = aKey;

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

    short aKey = (short) args[0];

    SAL_Electrometer publisher = new SAL_Electrometer( aKey );
    publisher.salCommand( "Electrometer_command_disable" );
    publisher.setDebugLevel( 1 );

    Electrometer.command_disable command = new Electrometer.command_disable();
    command.private_revCode = "LSST Electrometer disable COMMAND";
    command.device = "Electrometer";
    command.property = "state";
    command.action = "disable";

    command.ElectrometerID = aKey;

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

    short aKey = (short) args[0];

    SAL_Electrometer publisher = new SAL_Electrometer( aKey );
    publisher.salCommand( "Electrometer_command_standby" );
    publisher.setDebugLevel( 1 );

    Electrometer.command_standby command = new Electrometer.command_standby();
    command.private_revCode = "LSST Electrometer standby COMMAND";
    command.device = "Electrometer";
    command.property = "state";
    command.action = "standby";

    command.ElectrometerID = aKey;

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

    short aKey = (short) args[0];

    SAL_Electrometer publisher = new SAL_Electrometer( aKey );
    publisher.salCommand( "Electrometer_command_exitControl" );
    publisher.setDebugLevel( 1 );

    Electrometer.command_exitControl command = new Electrometer.command_exitControl();
    command.private_revCode = "LSST Electrometer exitControl COMMAND";
    command.device = "Electrometer";
    command.property = "state";
    command.action = "exitControl";

    command.ElectrometerID = aKey;

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

  public void performZeroCalib( Object[] args ) {

    short aKey = (short) args[0];

    SAL_Electrometer publisher = new SAL_Electrometer( aKey );
    publisher.salCommand( "Electrometer_command_performZeroCalib" );
    publisher.setDebugLevel( 1 );

    Electrometer.command_performZeroCalib command = new Electrometer.command_performZeroCalib();
    command.private_revCode = "LSST Electrometer performZeroCalib COMMAND";
    command.device = "Electrometer";
    command.property = "calibration";
    command.action = "performZeroCalib";

    command.ElectrometerID = aKey;
    command.value = (boolean) args[0];

    int cmdId = publisher.issueCommand_performZeroCalib( command );

    try {
      Thread.sleep( 200 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

    int timeout = 4;
    publisher.waitForCompletion_performZeroCalib( cmdId, timeout );

    /*
          * cleanup
          */
    publisher.salShutdown();
  }

  public void setDigitalFilter( Object[] args ) {

    short aKey = (short) args[0];

    SAL_Electrometer publisher = new SAL_Electrometer( aKey );
    publisher.salCommand( "Electrometer_command_setDigitalFilter" );
    publisher.setDebugLevel( 1 );

    Electrometer.command_setDigitalFilter command = new Electrometer.command_setDigitalFilter();
    command.private_revCode = "LSST Electrometer setDigitalFilter COMMAND";
    command.device = "Electrometer";
    command.property = "calibration";
    command.action = "setDigitalFilter";

    command.ElectrometerID = aKey;
    command.activateAvgFilter = (boolean) args[1];
    command.activateFilter = (boolean) args[2];
    command.activateMedFilter = (boolean) args[3];

    int cmdId = publisher.issueCommand_setDigitalFilter( command );

    try {
      Thread.sleep( 200 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

    int timeout = 4;
    publisher.waitForCompletion_setDigitalFilter( cmdId, timeout );

    /*
          * cleanup
          */
    publisher.salShutdown();
  }

  public void setIntegrationTime( Object[] args ) {

    short aKey = (short) args[0];

    SAL_Electrometer publisher = new SAL_Electrometer( aKey );
    publisher.salCommand( "Electrometer_command_setIntegrationTime" );
    publisher.setDebugLevel( 1 );

    Electrometer.command_setIntegrationTime command = new Electrometer.command_setIntegrationTime();
    command.private_revCode = "LSST Electrometer setIntegrationTime COMMAND";
    command.device = "Electrometer";
    command.property = "calibration";
    command.action = "setIntegrationTime";

    command.ElectrometerID = aKey;
    command.intTime = (float) args[1];

    int cmdId = publisher.issueCommand_setIntegrationTime( command );

    try {
      Thread.sleep( 200 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

    int timeout = 4;
    publisher.waitForCompletion_setIntegrationTime( cmdId, timeout );

    /*
          * cleanup
          */
    publisher.salShutdown();
  }

  public void setMode( Object[] args ) {

    short aKey = (short) args[0];

    SAL_Electrometer publisher = new SAL_Electrometer( aKey );
    publisher.salCommand( "Electrometer_command_setMode" );
    publisher.setDebugLevel( 1 );

    Electrometer.command_setMode command = new Electrometer.command_setMode();
    command.private_revCode = "LSST Electrometer setMode COMMAND";
    command.device = "Electrometer";
    command.property = "calibration";
    command.action = "setMode";

    command.ElectrometerID = aKey;
    command.mode = (short) args[1];

    int cmdId = publisher.issueCommand_setMode( command );

    try {
      Thread.sleep( 200 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

    int timeout = 4;
    publisher.waitForCompletion_setMode( cmdId, timeout );

    /*
          * cleanup
          */
    publisher.salShutdown();
  }

  public void setRange( Object[] args ) {

    short aKey = (short) args[0];

    SAL_Electrometer publisher = new SAL_Electrometer( aKey );
    publisher.salCommand( "Electrometer_command_setRange" );
    publisher.setDebugLevel( 1 );

    Electrometer.command_setRange command = new Electrometer.command_setRange();
    command.private_revCode = "LSST Electrometer setRange COMMAND";
    command.device = "Electrometer";
    command.property = "calibration";
    command.action = "setRange";

    command.ElectrometerID = aKey;
    command.setRange = (float) args[1];

    int cmdId = publisher.issueCommand_setRange( command );

    try {
      Thread.sleep( 200 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

    int timeout = 4;
    publisher.waitForCompletion_setRange( cmdId, timeout );

    /*
          * cleanup
          */
    publisher.salShutdown();
  }

  public void startScanDt( Object[] args ) {

    short aKey = (short) args[0];

    SAL_Electrometer publisher = new SAL_Electrometer( aKey );
    publisher.salCommand( "Electrometer_command_startScanDt" );
    publisher.setDebugLevel( 1 );

    Electrometer.command_startScanDt command = new Electrometer.command_startScanDt();
    command.private_revCode = "LSST ElectrometerstartScanDt COMMAND";
    command.device = "Electrometer";
    command.property = "calibration";
    command.action = "startScanDt";

    command.ElectrometerID = aKey;
    command.scanDuration = (float) args[1];

    int cmdId = publisher.issueCommand_startScanDt( command );

    try {
      Thread.sleep( 200 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

    int timeout = 4;
    publisher.waitForCompletion_startScanDt( cmdId, timeout );

    /*
          * cleanup
          */
    publisher.salShutdown();
  }

  public void startScan( Object[] args ) {

    short aKey = (short) args[0];

    SAL_Electrometer publisher = new SAL_Electrometer( aKey );
    publisher.salCommand( "Electrometer_command_startScan" );
    publisher.setDebugLevel( 1 );

    Electrometer.command_startScan command = new Electrometer.command_startScan();
    command.private_revCode = "LSST Electrometer startScan COMMAND";
    command.device = "Electrometer";
    command.property = "calibration";
    command.action = "startScan";

    command.ElectrometerID = aKey;
    command.value = (boolean) args[1];

    int cmdId = publisher.issueCommand_startScan( command );

    try {
      Thread.sleep( 200 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

    int timeout = 4;
    publisher.waitForCompletion_startScan( cmdId, timeout );

    /*
          * cleanup
          */
    publisher.salShutdown();
  }

  public void stopScan( Object[] args ) {

    short aKey = (short) args[0];

    SAL_Electrometer publisher = new SAL_Electrometer( aKey );
    publisher.salCommand( "Electrometer_command_stopScan" );
    publisher.setDebugLevel( 1 );

    Electrometer.command_stopScan command = new Electrometer.command_stopScan();
    command.private_revCode = "LSST Electrometer stopScan COMMAND";
    command.device = "Electrometer";
    command.property = "calibration";
    command.action = "stopScan";

    command.ElectrometerID = aKey;
    command.value = (boolean) args[1];

    int cmdId = publisher.issueCommand_stopScan( command );

    try {
      Thread.sleep( 200 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

    int timeout = 4;
    publisher.waitForCompletion_stopScan( cmdId, timeout );

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

    short aKey = (short) args[0];

    // Initialize
    SAL_Electrometer subscriber = new SAL_Electrometer( aKey );
    subscriber.salEvent( "Electrometer_logevent_summaryState" );
    subscriber.setDebugLevel( 1 );

    Electrometer.logevent_summaryState event = new Electrometer.logevent_summaryState();
    event.ElectrometerID = aKey;

    Integer status = CSC_STATUS.SAL__NO_UPDATES.getValue();
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_summaryState( event );
      if ( status == SAL_Electrometer.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
        out.println( "=== Event Status : " + status );
        out.println( "=== Event summaryState : " + event.summaryState );

        try {
          AppModel.getEntityMap()
              .get( EntityType.ELECTROMETER.toString() )._modelStateTransitionQ.put( event.summaryState );

          AppModel.getEntityMap()
              .get( EntityType.ELECTROMETER.toString() )._viewStateTransitionQ.put( event.summaryState );
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

    short aKey = (short) args[0];

    // Initialize
    SAL_Electrometer subscriber = new SAL_Electrometer( aKey );
    subscriber.salEvent( "Electrometer_logevent_settingVersions" );
    subscriber.setDebugLevel( 1 );

    Electrometer.logevent_settingVersions event = new Electrometer.logevent_settingVersions();
    event.ElectrometerID = aKey;

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_settingVersions( event );
      if ( status == SAL_Electrometer.SAL__OK ) {

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

    short aKey = (short) args[0];

    // Initialize
    SAL_Electrometer subscriber = new SAL_Electrometer( aKey );
    subscriber.salEvent( "Electrometer_logevent_appliedSettingsMatchStart" );
    subscriber.setDebugLevel( 1 );

    Electrometer.logevent_appliedSettingsMatchStart event = new Electrometer.logevent_appliedSettingsMatchStart();
    event.ElectrometerID = aKey;

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_appliedSettingsMatchStart( event );
      if ( status == SAL_Electrometer.SAL__OK ) {

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

  public Map<String, Object> largeFileObjectAvailable( Object[] args ) {

    short aKey = (short) args[0];

    // Initialize
    SAL_Electrometer subscriber = new SAL_Electrometer( aKey );
    subscriber.salEvent( "Electrometer_logevent_largeFileObjectAvailable" );
    subscriber.setDebugLevel( 1 );

    Electrometer.logevent_largeFileObjectAvailable event = new Electrometer.logevent_largeFileObjectAvailable();
    event.ElectrometerID = aKey;

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_largeFileObjectAvailable( event );
      if ( status == SAL_Electrometer.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    Map<String /* key */, Object /* value */> valuesMap = new HashMap<>();
    valuesMap.put( "ElectrometerID", event.ElectrometerID /* String */ );
    valuesMap.put( "url", event.url /* String */ );
    valuesMap.put( "generator", event.generator /* String */ );
    valuesMap.put( "version", event.version /* float */ );
    valuesMap.put( "byteSize", event.byteSize /* int */ );
    valuesMap.put( "checkSum", event.checkSum /* String */ );
    valuesMap.put( "mimeType", event.mimeType /* String */ );
    valuesMap.put( "id", event.id /* String */ );

    // e.g. To extract a value:
    //     String ElectrometerID = String.class.cast( valuesMap.get( "ElectrometerID") );
    //     String url = String.class.cast( valuesMap.get( "url") );
    //     String generator = String.class.cast( valuesMap.get( "generator") );
    //     float version = float.class.cast( valuesMap.get( "version") );
    //     int byteSize = float.class.cast( valuesMap.get( "byteSize") );
    //     String checkSum = float.class.cast( valuesMap.get( "checkSum") );
    //     String mimeType = float.class.cast( valuesMap.get( "mimeType") );
    //     String id = float.class.cast( valuesMap.get( "id") );

    /*
          * cleanup
          */
    subscriber.salShutdown();

    return valuesMap;
  }

  public Map<String, Object> integrationTime( Object[] args ) {

    short aKey = (short) args[0];

    // Initialize
    SAL_Electrometer subscriber = new SAL_Electrometer( aKey );
    subscriber.salEvent( "Electrometer_logevent_integrationTime" );
    subscriber.setDebugLevel( 1 );

    Electrometer.logevent_integrationTime event = new Electrometer.logevent_integrationTime();
    event.ElectrometerID = aKey;

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_integrationTime( event );
      if ( status == SAL_Electrometer.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    Map<String /* key */, Object /* value */> valuesMap = new HashMap<>();
    valuesMap.put( "ElectrometerID", event.ElectrometerID /* String */ );
    valuesMap.put( "intTime", event.intTime /* float */ );

    // e.g. To extract a value:
    //     String ElectrometerID = String.class.cast( valuesMap.get( "ElectrometerID") );
    //     float intTime = float.class.cast( valuesMap.get( "intTime") );

    /*
          * cleanup
          */
    subscriber.salShutdown();

    return valuesMap;
  }

  public Map<String, Object> intensity( Object[] args ) {

    short aKey = (short) args[0];

    // Initialize
    SAL_Electrometer subscriber = new SAL_Electrometer( aKey );
    subscriber.salEvent( "Electrometer_logevent_intensity" );
    subscriber.setDebugLevel( 1 );

    Electrometer.logevent_intensity event = new Electrometer.logevent_intensity();
    event.ElectrometerID = aKey;

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_intensity( event );
      if ( status == SAL_Electrometer.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    Map<String /* key */, Object /* value */> valuesMap = new HashMap<>();
    valuesMap.put( "ElectrometerID", event.ElectrometerID /* String */ );
    valuesMap.put( "intensity", event.intensity /* double */ );
    valuesMap.put( "unit", event.unit /* String */ );
    valuesMap.put( "timestamp", event.timestamp /* double */ );

    // e.g. To extract a value:
    //     String ElectrometerID = String.class.cast( valuesMap.get( "ElectrometerID") );
    //     double intensity = double.class.cast( valuesMap.get( "intensity") );
    //     String unit = String.class.cast( valuesMap.get( "unit") );
    //     double timestamp = double.class.cast( valuesMap.get( "timestamp") );

    /*
          * cleanup
          */
    subscriber.salShutdown();

    return valuesMap;
  }

  public Map<String, Object> settingsAppliedReadSets( Object[] args ) {

    short aKey = (short) args[0];

    // Initialize
    SAL_Electrometer subscriber = new SAL_Electrometer( aKey );
    subscriber.salEvent( "Electrometer_logevent_settingsAppliedReadSets" );
    subscriber.setDebugLevel( 1 );

    Electrometer.logevent_settingsAppliedReadSets event = new Electrometer.logevent_settingsAppliedReadSets();
    event.ElectrometerID = aKey;

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_settingsAppliedReadSets( event );
      if ( status == SAL_Electrometer.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    Map<String /* key */, Object /* value */> valuesMap = new HashMap<>();
    valuesMap.put( "ElectrometerID", event.ElectrometerID /* String */ );
    valuesMap.put( "avgFilterType", event.avgFilterActive /* boolean */ );
    valuesMap.put( "filterActive", event.filterActive /* boolean */ );
    valuesMap.put( "inputRange", event.inputRange /* double */ );
    valuesMap.put( "integrationTime", event.integrationTime /* double */ );
    valuesMap.put( "medianFilterStatus", event.medianFilterActive /* boolean */ );
    valuesMap.put( "mode", event.mode /* int */ );

    // e.g. To extract a value:
    //     String ElectrometerID = String.class.cast( valuesMap.get( "ElectrometerID") );
    //     int avgFilterType = int.class.cast( valuesMap.get( "avgFilterType") );
    //     boolean filterActive = boolean.class.cast( valuesMap.get( "filterActive") );
    //     double inputRange = double.class.cast( valuesMap.get( "inputRange") );
    //     double integrationTime = double.class.cast( valuesMap.get( "integrationTime") );
    //     boolean medianFilterStatus = boolean.class.cast( valuesMap.get( "medianFilterStatus") );
    //     int mode = int.class.cast( valuesMap.get( "mode") );

    /*
          * cleanup
          */
    subscriber.salShutdown();

    return valuesMap;
  }

  public Map<String, Object> settingsAppliedSerConf( Object[] args ) {

    short aKey = (short) args[0];

    // Initialize
    SAL_Electrometer subscriber = new SAL_Electrometer( aKey );
    subscriber.salEvent( "Electrometer_logevent_settingsAppliedSerConf" );
    subscriber.setDebugLevel( 1 );

    Electrometer.logevent_settingsAppliedSerConf event = new Electrometer.logevent_settingsAppliedSerConf();
    event.ElectrometerID = aKey;

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_settingsAppliedSerConf( event );
      if ( status == SAL_Electrometer.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    Map<String /* key */, Object /* value */> valuesMap = new HashMap<>();
    valuesMap.put( "ElectrometerID", event.ElectrometerID /* String */ );
    valuesMap.put( "baudRate", event.baudRate /* short */ );
    valuesMap.put( "bytesToRead", event.bytesToRead /* int */ );
    valuesMap.put( "dataBits", event.dataBits /* double */ );
    valuesMap.put( "dsrdtr", event.dsrdtr /* boolean */ );
    valuesMap.put( "parity", event.parity /* int */ );
    valuesMap.put( "stopBits", event.stopBits /* int */ );
    valuesMap.put( "termChar", event.termChar /* int */ );
    valuesMap.put( "timeout", event.timeout /* float */ );
    valuesMap.put( "visaResource", event.visaResource /* String */ );
    valuesMap.put( "xonxoff", event.xonxoff /* boolean */ );

    // e.g. To extract a value:
    //     String ElectrometerID = String.class.cast( valuesMap.get( "ElectrometerID") );
    //     int baudRate = int.class.cast( valuesMap.get( "baudRate") );
    //     int bytesToRead = int.class.cast( valuesMap.get( "bytesToRead") );
    //     int dataBits = int.class.cast( valuesMap.get( "dataBits") );
    //     boolean dsrdtr = int.class.cast( valuesMap.get( "dsrdtr") );
    //     int parity = int.class.cast( valuesMap.get( "parity") );
    //     int stopBits = int.class.cast( valuesMap.get( "stopBits") );
    //     int termChar = int.class.cast( valuesMap.get( "termChar") );
    //     float timeout = int.class.cast( valuesMap.get( "timeout") );
    //     String visaResource = String.class.cast( valuesMap.get( "visaResource") );
    //     boolean xonxoff = int.class.cast( valuesMap.get( "xonxoff") );

    /*
          * cleanup
          */
    subscriber.salShutdown();

    return valuesMap;
  }

  public Map<String, Object> measureType( Object[] args ) {

    short aKey = (short) args[0];

    // Initialize
    SAL_Electrometer subscriber = new SAL_Electrometer( aKey );
    subscriber.salEvent( "Electrometer_logevent_measureType" );
    subscriber.setDebugLevel( 1 );

    Electrometer.logevent_measureType event = new Electrometer.logevent_measureType();
    event.ElectrometerID = aKey;

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_measureType( event );
      if ( status == SAL_Electrometer.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    Map<String /* key */, Object /* value */> valuesMap = new HashMap<>();
    valuesMap.put( "ElectrometerID", event.ElectrometerID /* String */ );
    valuesMap.put( "mode", event.mode /* short */ );

    // e.g. To extract a value:
    //     String ElectrometerID = String.class.cast( valuesMap.get( "ElectrometerID") );
    //     short mode = short.class.cast( valuesMap.get( "mode") );

    /*
          * cleanup
          */
    subscriber.salShutdown();

    return valuesMap;
  }

  public Map<String, Object> measureRange( Object[] args ) {

    short aKey = (short) args[0];

    // Initialize
    SAL_Electrometer subscriber = new SAL_Electrometer( aKey );
    subscriber.salEvent( "Electrometer_logevent_measureRange" );
    subscriber.setDebugLevel( 1 );

    Electrometer.logevent_measureRange event = new Electrometer.logevent_measureRange();
    event.ElectrometerID = aKey;

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_measureRange( event );
      if ( status == SAL_Electrometer.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    Map<String /* key */, Object /* value */> valuesMap = new HashMap<>();
    valuesMap.put( "ElectrometerID", event.ElectrometerID /* String */ );
    valuesMap.put( "rangeValue", event.rangeValue /* float */ );

    // e.g. To extract a value:
    //     String ElectrometerID = String.class.cast( valuesMap.get( "ElectrometerID") );
    //     float rangeValue = float.class.cast( valuesMap.get( "rangeValue") );

    /*
          * cleanup
          */
    subscriber.salShutdown();

    return valuesMap;
  }

  public Map<String, Object> digitalFilterChange( Object[] args ) {

    short aKey = (short) args[0];

    // Initialize
    SAL_Electrometer subscriber = new SAL_Electrometer( aKey );
    subscriber.salEvent( "Electrometer_logevent_digitalFilterChange" );
    subscriber.setDebugLevel( 1 );

    Electrometer.logevent_digitalFilterChange event = new Electrometer.logevent_digitalFilterChange();
    event.ElectrometerID = aKey;

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_digitalFilterChange( event );
      if ( status == SAL_Electrometer.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    Map<String /* key */, Object /* value */> valuesMap = new HashMap<>();
    valuesMap.put( "ElectrometerID", event.ElectrometerID /* String */ );
    valuesMap.put( "activateAverageFilter", event.activateAverageFilter /* boolean */ );
    valuesMap.put( "activateFilter", event.activateFilter /* boolean */ );
    valuesMap.put( "activateMedianFilter", event.activateMedianFilter /* boolean */ );

    // e.g. To extract a value:
    //     String ElectrometerID = String.class.cast( valuesMap.get( "ElectrometerID") );
    //     boolean activateAverageFilter = boolean.class.cast( valuesMap.get( "activateAverageFilter") );
    //     boolean activateFilter = boolean.class.cast( valuesMap.get( "activateFilter") );
    //     boolean activateMedianFilter = boolean.class.cast( valuesMap.get( "activateMedianFilter") );

    /*
          * cleanup
          */
    subscriber.salShutdown();

    return valuesMap;
  }

  public static final int SAL__Electrometer_logevent_detailedState_ACTOR = 19;
  public static final int SAL__Electrometer_logevent_errorCode_ACTOR = 21;

  public static final int SAL__Electrometer_logevent_heartbeat_ACTOR = 22;

  public static final int SAL__Electrometer_logevent_settingsAppliedSerConf_ACTOR = 34;

}
