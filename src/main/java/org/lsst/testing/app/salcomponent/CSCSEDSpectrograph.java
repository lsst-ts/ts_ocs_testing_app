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

import org.lsst.sal.SAL_sedSpectrometer;
import org.lsst.testing.app.AppModel;
import org.lsst.testing.app.EntityType;

import static java.lang.System.out;
import java.util.HashMap;
import java.util.Map;

/**
 * <h2>Calibration SED Spectrometer CSC</h2>
 * 
 * {@code CSCSEDSpectrograph} is a (Concrete) Receiver class in the command pattern
 */
public class CSCSEDSpectrograph implements CommandableSalComponent {

    @Override public String getName() { return "CSCSEDSpectrometer"; }

    @Override public void enterControl( Object [] args ) {

        SAL_sedSpectrometer publisher = new SAL_sedSpectrometer();
        publisher.salCommand( "sedSpectrometer_command_enterControl" );

        publisher.setDebugLevel( 1 );
        
        sedSpectrometer.command_enterControl command = new sedSpectrometer.command_enterControl();
        command.private_revCode = "LSST SEDSpectrometer enterControl COMMAND";
        command.device = "sedSpectrometer";
        command.property = "state";
        command.action = "enterControl";
        command.state = true;

        int cmdId = publisher.issueCommand_enterControl( command );

        try {
            Thread.sleep( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_enterControl( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    @Override public void start( Object [] args ) {

        SAL_sedSpectrometer publisher = new SAL_sedSpectrometer();
        publisher.salCommand( "sedSpectrometer_command_start" );

        publisher.setDebugLevel( 1 );
        
        sedSpectrometer.command_start command = new sedSpectrometer.command_start();
        command.private_revCode = "LSST SEDSpectrometer start COMMAND";
        command.device = "sedSpectrometer";
        command.property = "state";
        command.action = "start";

        int cmdId = publisher.issueCommand_start( command );

        try {
            Thread.sleep( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_start( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();

    }

    @Override public void enable( Object [] args ) {

        SAL_sedSpectrometer publisher = new SAL_sedSpectrometer();
        publisher.salCommand( "sedSpectrometer_command_enable" );

        publisher.setDebugLevel( 1 );
        
        sedSpectrometer.command_enable command = new sedSpectrometer.command_enable();
        command.private_revCode = "LSST SEDSpectrometer enable COMMAND";
        command.device = "sedSpectrometer";
        command.property = "state";
        command.action = "enable";
        command.state = true;

        int cmdId = publisher.issueCommand_enable( command );

        try {
            Thread.sleep( 200 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_enable( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    @Override public void disable( Object [] args ) {

        SAL_sedSpectrometer publisher = new SAL_sedSpectrometer();
        publisher.salCommand( "sedSpectrometer_command_disable" );

        publisher.setDebugLevel( 1 );
        
        sedSpectrometer.command_disable command = new sedSpectrometer.command_disable();
        command.private_revCode = "LSST SEDSpectrometer disable COMMAND";
        command.device = "sedSpectrometer";
        command.property = "state";
        command.action = "disable";
        command.state = true;

        int cmdId = publisher.issueCommand_disable( command );

        try {
            Thread.sleep( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_disable( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    @Override public void standby( Object [] args ) {

        SAL_sedSpectrometer publisher = new SAL_sedSpectrometer();
        publisher.salCommand( "sedSpectrometer_command_standby" );

        publisher.setDebugLevel( 1 );
        
        sedSpectrometer.command_standby command = new sedSpectrometer.command_standby();
        command.private_revCode = "LSST SEDSpectrometer standby COMMAND";
        command.device = "sedSpectrometer";
        command.property = "state";
        command.action = "standby";
        command.state = true;

        int cmdId = publisher.issueCommand_standby( command );

        try {
            Thread.sleep( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_standby( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    @Override public void exitControl( Object [] args ) {

        SAL_sedSpectrometer publisher = new SAL_sedSpectrometer();
        publisher.salCommand( "sedSpectrometer_command_exitControl" );

        publisher.setDebugLevel( 1 );
        
        sedSpectrometer.command_exitControl command = new sedSpectrometer.command_exitControl();
        command.private_revCode = "LSST SEDSpectrometer exitControl COMMAND";
        command.device = "sedSpectrometer";
        command.property = "state";
        command.action = "exitControl";
        command.state = true;

        int cmdId = publisher.issueCommand_exitControl( command );

        try {
            Thread.sleep( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_exitControl( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    public void captureSpectImage( Object [] args ) {
        
        SAL_sedSpectrometer publisher = new SAL_sedSpectrometer();
        publisher.salCommand( "sedSpectrometer_command_captureSpectImage" );

        publisher.setDebugLevel( 1 );
        
        sedSpectrometer.command_captureSpectImage command = new sedSpectrometer.command_captureSpectImage();
        command.private_revCode = "LSST SEDSpectrometer captureSpectImage COMMAND";
        command.device = "sedSpectrometer";
        command.property = "calibration";
        command.action = "captureSpectImage";
        command.integrationTime = (float) args[0];
        command.imageType = (String) args[1];
        command.lamp = (String) args[2];

        int cmdId = publisher.issueCommand_captureSpectImage( command );

        try {
            Thread.sleep( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_captureSpectImage( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    public void setSpectTempSetpoint( float setpoint ) {

        SAL_sedSpectrometer publisher = new SAL_sedSpectrometer();
        publisher.salCommand( "sedSpectrometer_command_setSpectTempSetpoint" );

        publisher.setDebugLevel( 1 );
        
        sedSpectrometer.command_setSpectTempSetpoint command = new sedSpectrometer.command_setSpectTempSetpoint();
        command.private_revCode = "LSST SEDSpectrometer setSpectTempSetpoint COMMAND";
        command.device = "sedSpectrometer";
        command.property = "calibration";
        command.action = "setSpectTempSetpoint";
        command.setpoint = setpoint;

        int cmdId = publisher.issueCommand_setSpectTempSetpoint( command );

        try {
            Thread.sleep( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_setSpectTempSetpoint( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    public void stopImageCapture( boolean stop ) {

        SAL_sedSpectrometer publisher = new SAL_sedSpectrometer();
        publisher.salCommand( "sedSpectrometer_command_stopImageCapture" );

        publisher.setDebugLevel( 1 );
        
        sedSpectrometer.command_stopImageCapture command = new sedSpectrometer.command_stopImageCapture();
        command.private_revCode = "LSST SEDSpectrometer stopImageCapture COMMAND";
        command.device = "sedSpectrometer";
        command.property = "calibration";
        command.action = "stopImageCapture";
        command.stop = stop;

        int cmdId = publisher.issueCommand_stopImageCapture( command );

        try {
            Thread.sleep( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_stopImageCapture( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    @Override public Integer summaryState() {
    
        // Initialize
        SAL_sedSpectrometer subscriber = new SAL_sedSpectrometer();
        subscriber.salEvent( "sedSpectrometer_logevent_SummaryState" );

        subscriber.setDebugLevel( 1 );
        
        sedSpectrometer.logevent_SummaryState event = new sedSpectrometer.logevent_SummaryState();

        Integer status = CSC_STATUS.SAL__NO_UPDATES.getValue();
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_SummaryState( event );
            if ( status == SAL_sedSpectrometer.SAL__OK ) {
                
                out.println( "=== Event Logged : " + event );
                out.println( "=== Event Status : " + status );
                out.println( "=== Event SummaryState : " + event.summaryState );
                
                try {
                    AppModel.getEntityMap()
                            .get( EntityType.SEDSPECTROGRAPH.toString() )
                            ._modelStateTransitionQ.put( event.summaryState );
                    
                    AppModel.getEntityMap()
                            .get( EntityType.SEDSPECTROGRAPH.toString() )
                            ._viewStateTransitionQ.put( event.summaryState );
                } catch ( InterruptedException ie ) {
                    ie.printStackTrace( out.printf( "GOOD SummaryState" ));
                }
            }

            try {
                Thread.sleep( 100 );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        /* Remove the DataWriters etc */
        subscriber.salShutdown();

        return status;
    }

    @Override public void settingsVersion() {

        // Initialize
        SAL_sedSpectrometer subscriber = new SAL_sedSpectrometer();
        subscriber.salEvent( "sedSpectrometer_logevent_SettingVersions" );

        subscriber.setDebugLevel( 1 );
        
        sedSpectrometer.logevent_SettingVersions event = new sedSpectrometer.logevent_SettingVersions();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_SettingVersions( event );
            if ( status == SAL_sedSpectrometer.SAL__OK ) {
                
                out.println( "=== Event Logged : " + event );
            }

            try {
                Thread.sleep( 100 );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        /* Remove the DataWriters etc */
        subscriber.salShutdown();
    }

    @Override public void appliedSettingsMatchStart() {

        // Initialize
        SAL_sedSpectrometer subscriber = new SAL_sedSpectrometer();
        subscriber.salEvent( "sedSpectrometer_logevent_AppliedSettingsMatchStart" );

        subscriber.setDebugLevel( 1 );
        
        sedSpectrometer.logevent_AppliedSettingsMatchStart event = new sedSpectrometer.logevent_AppliedSettingsMatchStart();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_AppliedSettingsMatchStart( event );
            if ( status == SAL_sedSpectrometer.SAL__OK ) {
                
                out.println( "=== Event Logged : " + event );
            }

            try {
                Thread.sleep( 100 );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        /* Remove the DataWriters etc */
        subscriber.salShutdown();
    }

    public Map<String, Object> MeasuredSpectrum() {

        // Initialize
        SAL_sedSpectrometer subscriber = new SAL_sedSpectrometer();
        subscriber.salEvent( "sedSpectrometer_logevent_MeasuredSpectrum" );

        subscriber.setDebugLevel( 1 );
        
        sedSpectrometer.logevent_MeasuredSpectrum event = new sedSpectrometer.logevent_MeasuredSpectrum();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_MeasuredSpectrum( event );
            if ( status == SAL_sedSpectrometer.SAL__OK ) {
                
                out.println( "=== Event Logged : " + event );
            }

            try {
                Thread.sleep( 100 );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        Map<String /*key*/, Object /*value*/> valuesMap = new HashMap<>();
        valuesMap.put( "imageName"      , event.imageName /*String*/       );
        valuesMap.put( "wavelength"     , event.wavelength /*double[2048*/ );
        valuesMap.put( "intensity"      , event.intensity /*double[2048*/  );
        valuesMap.put( "integrationTime", event.integrationTime /*float*/  );
        valuesMap.put( "temperature"    , event.temperature /*double*/    );
        
        // e.g. To extract a value:
        //    String imageName = String.class.cast( valuesMap.get( "imageName") );
        //    double[] wavelength = double[].class.cast( valuesMap.get( "wavelength") ) ;
        //    double[] intensity = double[].class.cast( valuesMap.get( "intensity") );
        //    float integrationTime = float.class.cast( valuesMap.get( "integrationTime") );
        //    double temperature = double.class.cast( valuesMap.get( "temperature") );

        /* Remove the DataWriters etc */
        subscriber.salShutdown();
        
        return valuesMap;
    }

    public Map<String, Object> LargeFileObjectAvailable() {

        // Initialize
        SAL_sedSpectrometer subscriber = new SAL_sedSpectrometer();
        subscriber.salEvent( "sedSpectrometer_logevent_LargeFileObjectAvailable" );

        subscriber.setDebugLevel( 1 );
        
        sedSpectrometer.logevent_LargeFileObjectAvailable event = new sedSpectrometer.logevent_LargeFileObjectAvailable();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_LargeFileObjectAvailable( event );
            if ( status == SAL_sedSpectrometer.SAL__OK ) {
                
                out.println( "=== Event Logged : " + event );
            }

            try {
                Thread.sleep( 100 );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        Map<String /*key*/, Object /*value*/> valuesMap = new HashMap<>();
        valuesMap.put( "url"      , event.URL /*String*/       );
        valuesMap.put( "generator", event.Generator /*String*/ );
        valuesMap.put( "version"  , event.Version /*float*/    );
        
        // e.g. To extract a value:
        //     String url = String.class.cast( valuesMap.get( "url") );
        //     String generator = String.class.cast( valuesMap.get( "generator") );
        //     float version = float.class.cast( valuesMap.get( "version") );
        
        /* Remove the DataWriters etc */
        subscriber.salShutdown();

        return valuesMap;
    }
}
