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

import org.lsst.sal.SAL_FiberSpectrograph;
import org.lsst.testing.app.AppModel;
import org.lsst.testing.app.EntityType;

import static java.lang.System.out;
import java.util.HashMap;
import java.util.Map;

/**
 * <h2>Calibration SED Spectrometer CSC</h2>
 * <p>
 * {@code CSCFiberSpectrograph} is a (Concrete) Receiver class in the command pattern
 */
public class CSCFiberSpectrograph implements CommandableSalComponent {

  @Override
  public String getName() {
    return "CSCFiberSpectrograph";
  }

  /////////////////////////////////////////////////////
  // SAL middle-ware Commands
  /////////////////////////////////////////////////////
  
  @Override
  public void start( Object[] args ) {

    SAL_FiberSpectrograph publisher = new SAL_FiberSpectrograph();
    publisher.salCommand( "FiberSpectrograph_command_start" );

    publisher.setDebugLevel( 1 );

    FiberSpectrograph.command_start command = new FiberSpectrograph.command_start();
    command.private_revCode = "LSST FiberSpectrograph start COMMAND";
    command.device = "FiberSpectrograph";
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

    SAL_FiberSpectrograph publisher = new SAL_FiberSpectrograph();
    publisher.salCommand( "FiberSpectrograph_command_enable" );

    publisher.setDebugLevel( 1 );

    FiberSpectrograph.command_enable command = new FiberSpectrograph.command_enable();
    command.private_revCode = "LSST FiberSpectrograph enable COMMAND";
    command.device = "FiberSpectrograph";
    command.property = "state";
    command.action = "enable";
    command.value = true;

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

    SAL_FiberSpectrograph publisher = new SAL_FiberSpectrograph();
    publisher.salCommand( "FiberSpectrograph_command_disable" );

    publisher.setDebugLevel( 1 );

    FiberSpectrograph.command_disable command = new FiberSpectrograph.command_disable();
    command.private_revCode = "LSST FiberSpectrograph disable COMMAND";
    command.device = "FiberSpectrograph";
    command.property = "state";
    command.action = "disable";
    command.value = true;

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

    SAL_FiberSpectrograph publisher = new SAL_FiberSpectrograph();
    publisher.salCommand( "FiberSpectrograph_command_standby" );

    publisher.setDebugLevel( 1 );

    FiberSpectrograph.command_standby command = new FiberSpectrograph.command_standby();
    command.private_revCode = "LSST FiberSpectrograph standby COMMAND";
    command.device = "FiberSpectrograph";
    command.property = "state";
    command.action = "standby";
    command.value = true;

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

    SAL_FiberSpectrograph publisher = new SAL_FiberSpectrograph();
    publisher.salCommand( "FiberSpectrograph_command_exitControl" );

    publisher.setDebugLevel( 1 );

    FiberSpectrograph.command_exitControl command = new FiberSpectrograph.command_exitControl();
    command.private_revCode = "LSST FiberSpectrograph exitControl COMMAND";
    command.device = "FiberSpectrograph";
    command.property = "state";
    command.action = "exitControl";
    command.value = true;

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

  public void captureSpectImage( Object[] args ) {

    SAL_FiberSpectrograph publisher = new SAL_FiberSpectrograph();
    publisher.salCommand( "FiberSpectrograph_command_captureSpectImage" );

    publisher.setDebugLevel( 1 );

    FiberSpectrograph.command_captureSpectImage command = new FiberSpectrograph.command_captureSpectImage();
    command.private_revCode = "LSST FiberSpectrograph captureSpectImage COMMAND";
    command.device = "FiberSpectrograph";
    command.property = "calibration";
    command.action = "captureSpectImage";
    command.integrationTime = (float) args[0];
    command.imageType = (String) args[1];
    command.lamp = (String) args[2];

    int cmdId = publisher.issueCommand_captureSpectImage( command );

    try {
      Thread.sleep( 200 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

    int timeout = 4;
    publisher.waitForCompletion_captureSpectImage( cmdId, timeout );

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
    SAL_FiberSpectrograph subscriber = new SAL_FiberSpectrograph();
    subscriber.salEvent( "FiberSpectrograph_logevent_summaryState" );

    subscriber.setDebugLevel( 1 );

    FiberSpectrograph.logevent_summaryState event = new FiberSpectrograph.logevent_summaryState();

    Integer status = CSC_STATUS.SAL__NO_UPDATES.getValue();
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_summaryState( event );
      if ( status == SAL_FiberSpectrograph.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
        out.println( "=== Event Status : " + status );
        out.println( "=== Event SummaryState : " + event.summaryState );

        try {
          AppModel.getEntityMap()
              .get( EntityType.FIBERSPECTROGRAPH.toString() )._modelStateTransitionQ.put( event.summaryState );

          AppModel.getEntityMap()
              .get( EntityType.FIBERSPECTROGRAPH.toString() )._viewStateTransitionQ.put( event.summaryState );
        } catch ( InterruptedException ie ) {
          ie.printStackTrace( out.printf( "GOOD SummaryState" ) );
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
    SAL_FiberSpectrograph subscriber = new SAL_FiberSpectrograph();
    subscriber.salEvent( "FiberSpectrograph_logevent_settingVersions" );

    subscriber.setDebugLevel( 1 );

    FiberSpectrograph.logevent_settingVersions event = new FiberSpectrograph.logevent_settingVersions();

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_settingVersions( event );
      if ( status == SAL_FiberSpectrograph.SAL__OK ) {

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
    SAL_FiberSpectrograph subscriber = new SAL_FiberSpectrograph();
    subscriber.salEvent( "FiberSpectrograph_logevent_appliedSettingsMatchStart" );

    subscriber.setDebugLevel( 1 );

    FiberSpectrograph.logevent_appliedSettingsMatchStart event = new FiberSpectrograph.logevent_appliedSettingsMatchStart();

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_appliedSettingsMatchStart( event );
      if ( status == SAL_FiberSpectrograph.SAL__OK ) {

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

  public Map<String, Object> measuredSpectrum() {

    // Initialize
    SAL_FiberSpectrograph subscriber = new SAL_FiberSpectrograph();
    subscriber.salEvent( "FiberSpectrograph_logevent_MeasuredSpectrum" );

    subscriber.setDebugLevel( 1 );

    FiberSpectrograph.logevent_measuredSpectrum event = new FiberSpectrograph.logevent_measuredSpectrum();

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_measuredSpectrum( event );
      if ( status == SAL_FiberSpectrograph.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    Map<String /* key */, Object /* value */> valuesMap = new HashMap<>();
    valuesMap.put( "imageName", event.imageName /* String */ );
    valuesMap.put( "wavelength", event.wavelength /* double[2048] */ );
    valuesMap.put( "intensity", event.intensity /* double[2048] */ );
    valuesMap.put( "integrationTime", event.integrationTime /* float */ );
    valuesMap.put( "temperature", event.temperature /* double */ );

    // e.g. To extract a value:
    //    String imageName = String.class.cast( valuesMap.get( "imageName") );
    //    double[] wavelength = double[].class.cast( valuesMap.get( "wavelength") ) ;
    //    double[] intensity = double[].class.cast( valuesMap.get( "intensity") );
    //    float integrationTime = float.class.cast( valuesMap.get( "integrationTime") );
    //    double temperature = double.class.cast( valuesMap.get( "temperature") );

    /*
           * cleanup
           */
    subscriber.salShutdown();

    return valuesMap;
  }

  public Map<String, Object> largeFileObjectAvailable() {

    // Initialize
    SAL_FiberSpectrograph subscriber = new SAL_FiberSpectrograph();
    subscriber.salEvent( "FiberSpectrograph_logevent_largeFileObjectAvailable" );

    subscriber.setDebugLevel( 1 );

    FiberSpectrograph.logevent_largeFileObjectAvailable event = new FiberSpectrograph.logevent_largeFileObjectAvailable();

    int status;
    while ( Boolean.TRUE ) {

      status = subscriber.getEvent_largeFileObjectAvailable( event );
      if ( status == SAL_FiberSpectrograph.SAL__OK ) {

        out.println( "=== Event Logged : " + event );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    Map<String /* key */, Object /* value */> valuesMap = new HashMap<>();
    valuesMap.put( "url", event.url /* String */ );
    valuesMap.put( "generator", event.generator /* String */ );
    valuesMap.put( "version", event.version /* float */ );
    valuesMap.put( "byte_Size", event.byte_Size /* int */ );
    valuesMap.put( "checksum", event.checksum /* String */ );
    valuesMap.put( "mime_Type", event.mime_Type /* String */ );
    valuesMap.put( "id", event.id /* String */ );

    // e.g. To extract a value:
    //     String url = String.class.cast( valuesMap.get( "url") );
    //     String generator = String.class.cast( valuesMap.get( "generator") );
    //     float version = float.class.cast( valuesMap.get( "version") );
    
    /*
          * cleanup
          */
    subscriber.salShutdown();

    return valuesMap;
  }

  /////////////////////////////////////////////////////
  // SAL middle-ware Telemetry
  /////////////////////////////////////////////////////
  
  //public Map<String, Object>  setSpectTempSetpoint( float setpoint ) {
  public void setSpectTempSetpoint( float setpoint ) {

    SAL_FiberSpectrograph subscriber = new SAL_FiberSpectrograph();
    subscriber.salTelemetrySub( "FiberSpectrograph_spectTemperature" );

    subscriber.setDebugLevel( 1 );

    FiberSpectrograph.spectTemperature salTMInstance = new FiberSpectrograph.spectTemperature();
    int samples = subscriber.flushSamples( salTMInstance );
    System.out.println( "=== [spectTemperature Subscriber] Ready ..." );

    boolean terminate = Boolean.FALSE;
    int count = 0;
    int i = 0;
    double[] temps = new double[100];
    double[] ts = new double[100];
    while ( i < 100 ) {

      i++;
      samples = subscriber.getSample( salTMInstance );
      if ( samples == SAL_FiberSpectrograph.SAL__OK ) {

        temps[count] = salTMInstance.temperature;
        ts[count] = salTMInstance.timestamp;
        count++;

        System.out.println( "=== [spectTemperature Subscriber] samples " + salTMInstance.private_sndStamp );
        System.out.println( "=== [spectTemperature Subscriber] message received :" + count );
      }

      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }

    Map<String /* key */, Object /* value */> valuesMap = new HashMap<>();
    valuesMap.put( "temperature", salTMInstance.temperature /* double[100] */ );
    valuesMap.put( "timestamp", salTMInstance.timestamp /* double[100] */ );

    /*
          * cleanup
          */
    subscriber.salShutdown();

    // return valuesMap;
  }
}
