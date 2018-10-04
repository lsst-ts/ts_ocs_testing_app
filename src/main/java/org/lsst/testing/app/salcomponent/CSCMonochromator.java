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

import org.lsst.sal.SAL_atMonochromator;
import org.lsst.testing.app.AppModel;
import org.lsst.testing.app.EntityType;

import static java.lang.System.out;
import java.util.HashMap;
import java.util.Map;

/**
 * <h2>Calibration Monochromator CSC</h2>
 * 
 * {@code CSCMonochromator} is a (Concrete) Receiver class in the command pattern
 */

public class CSCMonochromator implements CommandableSalComponent {

    @Override public String getName() { return "CSCMonochrometer"; }

    @Override public void enterControl( Object [] args ) {

        SAL_atMonochromator publisher = new SAL_atMonochromator();
        publisher.salCommand( "atMonochromator_command_enterControl" );

        publisher.setDebugLevel( 1 );
        
        atMonochromator.command_enterControl command = new atMonochromator.command_enterControl();
        command.private_revCode = "LSST Monochromator enterControl COMMAND";
        command.device = "atMonochromator";
        command.property = "state";
        command.action = "enterControl";

        int cmdId = publisher.issueCommand_enterControl( command );

        try {
            Thread.sleep( 200 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_enterControl( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    @Override public void start( Object [] args ) {

        SAL_atMonochromator publisher = new SAL_atMonochromator();
        publisher.salCommand( "atMonochromator_command_start" );

        publisher.setDebugLevel( 1 );
        
        atMonochromator.command_start command = new atMonochromator.command_start();
        command.private_revCode = "LSST Monochromator start COMMAND";
        command.device = "atMonochromator";
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

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    @Override public void enable( Object [] args ) {

        SAL_atMonochromator publisher = new SAL_atMonochromator();
        publisher.salCommand( "atMonochromator_command_enable" );

        publisher.setDebugLevel( 1 );
        
        atMonochromator.command_enable command = new atMonochromator.command_enable();
        command.private_revCode = "LSST Monochromator enable COMMAND";
        command.device = "atMonochromator";
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

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    @Override public void disable( Object [] args ) {

        SAL_atMonochromator publisher = new SAL_atMonochromator();
        publisher.salCommand( "atMonochromator_command_disable" );

        publisher.setDebugLevel( 1 );
        
        atMonochromator.command_disable command = new atMonochromator.command_disable();
        command.private_revCode = "LSST Monochromator disable COMMAND";
        command.device = "atMonochromator";
        command.property = "state";
        command.action = "disable";

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

        SAL_atMonochromator publisher = new SAL_atMonochromator();
        publisher.salCommand( "atMonochromator_command_standby" );

        publisher.setDebugLevel( 1 );
        
        atMonochromator.command_standby command = new atMonochromator.command_standby();
        command.private_revCode = "LSST Monochromator standby COMMAND";
        command.device = "atMonochromator";
        command.property = "state";
        command.action = "standby";

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

        SAL_atMonochromator publisher = new SAL_atMonochromator();
        publisher.salCommand( "atMonochromator_command_exitControl" );

        publisher.setDebugLevel( 1 );
        
        atMonochromator.command_exitControl command = new atMonochromator.command_exitControl();
        command.private_revCode = "LSST Monochromator exitControl COMMAND";
        command.device = "atMonochromator";
        command.property = "state";
        command.action = "exitControl";

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

    public void updateMonochromatorSetup( Object [] args ) {

        SAL_atMonochromator publisher = new SAL_atMonochromator();
        publisher.salCommand( "atMonochromator_command_updateMonochromatorSetup" );

        publisher.setDebugLevel( 1 );
        
        atMonochromator.command_updateMonochromatorSetup command = new atMonochromator.command_updateMonochromatorSetup();
        command.private_revCode = "LSST Monochromator PowerWhiteLight COMMAND";
        command.device = "atMonochromator";
        command.property = "calibration";
        command.action = "updateMonochromatorSetup";
        command.gratingType = (int) args[0];
        command.fontEntranceSlitWidth = (double) args[1];
        command.fontExitSlitWidth = (double) args[2];
        command.wavelength = (double) args[3];

        int cmdId = publisher.issueCommand_updateMonochromatorSetup( command );

        try {
            Thread.sleep( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_updateMonochromatorSetup( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    public void CalibrateWavelength( float wavelength ) {

        SAL_atMonochromator publisher = new SAL_atMonochromator();
        publisher.salCommand( "atMonochromator_command_CalibrateWavelength" );

        publisher.setDebugLevel( 1 );
        
        atMonochromator.command_CalibrateWavelength command = new atMonochromator.command_CalibrateWavelength();
        command.private_revCode = "LSST Monochromator CalibrateWavelength COMMAND";
        command.device = "atMonochromator";
        command.property = "calibration";
        command.action = "CalibrateWavelength";
        command.wavelength = wavelength;

        int cmdId = publisher.issueCommand_CalibrateWavelength( command );

        try {
            Thread.sleep( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_CalibrateWavelength( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    public void ChangeLightIntensity( float intensity ) {

        SAL_atMonochromator publisher = new SAL_atMonochromator();
        publisher.salCommand( "atMonochromator_command_ChangeLightIntensity" );

        publisher.setDebugLevel( 1 );
        
        atMonochromator.command_ChangeLightIntensity command = new atMonochromator.command_ChangeLightIntensity();
        command.private_revCode = "LSST Monochromator ChangeLightIntensity COMMAND";
        command.device = "atMonochromator";
        command.property = "calibration";
        command.action = "ChangeLightIntensity";
        command.intensity = intensity;

        int cmdId = publisher.issueCommand_ChangeLightIntensity( command );

        try {
            Thread.sleep( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_ChangeLightIntensity( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    public void ChangeSlitWidth( int slit, float slitWidth ) {

        SAL_atMonochromator publisher = new SAL_atMonochromator();
        publisher.salCommand( "atMonochromator_command_ChangeSlitWidth" );

        publisher.setDebugLevel( 1 );
        
        atMonochromator.command_ChangeSlitWidth command = new atMonochromator.command_ChangeSlitWidth();
        command.private_revCode = "LSST Monochromator ChangeSlitWidth COMMAND";
        command.device = "atMonochromator";
        command.property = "calibration";
        command.action = "ChangeSlitWidth";
        command.slit = slit;
        command.slitWidth = slitWidth;

        int cmdId = publisher.issueCommand_ChangeSlitWidth( command );

        try {
            Thread.sleep( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_ChangeSlitWidth( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    public void ChangeWavelength( float wavelength ) {

        SAL_atMonochromator publisher = new SAL_atMonochromator();
        publisher.salCommand( "atMonochromator_command_ChangeWavelength" );

        publisher.setDebugLevel( 1 );
        
        atMonochromator.command_ChangeWavelength command = new atMonochromator.command_ChangeWavelength();
        command.private_revCode = "LSST Monochromator ChangeWavelength COMMAND";
        command.device = "atMonochromator";
        command.property = "calibration";
        command.action = "ChangeWavelength";
        command.wavelength = wavelength;

        int cmdId = publisher.issueCommand_ChangeWavelength( command );

        try {
            Thread.sleep( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_ChangeWavelength( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    public void Power( boolean power ) {

        SAL_atMonochromator publisher = new SAL_atMonochromator();
        publisher.salCommand( "atMonochromator_command_Power" );

        publisher.setDebugLevel( 1 );
        
        atMonochromator.command_Power command = new atMonochromator.command_Power();
        command.private_revCode = "LSST Monochromator Power COMMAND";
        command.device = "atMonochromator";
        command.property = "calibration";
        command.action = "Power";
        command.power = power;

        int cmdId = publisher.issueCommand_Power( command );

        try {
            Thread.sleep( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_Power( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    public void PowerWhiteLight( boolean power ) {

        SAL_atMonochromator publisher = new SAL_atMonochromator();
        publisher.salCommand( "atMonochromator_command_PowerWhiteLight" );

        publisher.setDebugLevel( 1 );
        
        atMonochromator.command_PowerWhiteLight command = new atMonochromator.command_PowerWhiteLight();
        command.private_revCode = "LSST Monochromator PowerWhiteLight COMMAND";
        command.device = "atMonochromator";
        command.property = "calibration";
        command.action = "PowerWhiteLight";
        command.power = power;

        int cmdId = publisher.issueCommand_PowerWhiteLight( command );

        try {
            Thread.sleep( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_PowerWhiteLight( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    public void SelectGrating( int gratingType ) {

        SAL_atMonochromator publisher = new SAL_atMonochromator();
        publisher.salCommand( "atMonochromator_command_SelectGrating" );

        publisher.setDebugLevel( 1 );
        
        atMonochromator.command_SelectGrating command = new atMonochromator.command_SelectGrating();
        command.private_revCode = "LSST Monochromator SelectGrating COMMAND";
        command.device = "atMonochromator";
        command.property = "calibration";
        command.action = "SelectGrating";
        command.gratingType = gratingType;

        int cmdId = publisher.issueCommand_SelectGrating( command );

        try {
            Thread.sleep( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_SelectGrating( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    public void SetCoolingTemperature( float temperature ) {

        SAL_atMonochromator publisher = new SAL_atMonochromator();
        publisher.salCommand( "atMonochromator_command_SetCoolingTemperature" );

        publisher.setDebugLevel( 1 );
        
        atMonochromator.command_SetCoolingTemperature command = new atMonochromator.command_SetCoolingTemperature();
        command.private_revCode = "LSST Monochromator PowerWhiteLight COMMAND";
        command.device = "atMonochromator";
        command.property = "calibration";
        command.action = "SetCoolingTemperature";
        command.temperature = temperature;

        int cmdId = publisher.issueCommand_SetCoolingTemperature( command );

        try {
            Thread.sleep( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_SetCoolingTemperature( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    @Override public Integer summaryState() {
    
        // Initialize
        SAL_atMonochromator subscriber = new SAL_atMonochromator();
        subscriber.salEvent( "atMonochromator_logevent_SummaryState" );

        subscriber.setDebugLevel( 1 );
        
        atMonochromator.logevent_SummaryState event = new atMonochromator.logevent_SummaryState();

        Integer status = CSC_STATUS.SAL__NO_UPDATES.getValue();
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_SummaryState( event );
            if ( status == SAL_atMonochromator.SAL__OK ) {
                
                out.println( "=== Event Logged : " + event );
                out.println( "=== Event Status : " + status );
                out.println( "=== Event SummaryState : " + event.summaryState );
                
                try {
                    AppModel.getEntityMap()
                            .get( EntityType.MONOCHROMATOR.toString() )
                            ._modelStateTransitionQ.put( event.summaryState );
                    
                    AppModel.getEntityMap()
                            .get( EntityType.MONOCHROMATOR.toString() )
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
        SAL_atMonochromator subscriber = new SAL_atMonochromator();
        subscriber.salEvent( "atMonochromator_logevent_SettingVersions" );

        atMonochromator.logevent_SettingVersions event = new atMonochromator.logevent_SettingVersions();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_SettingVersions( event );
            if ( status == SAL_atMonochromator.SAL__OK ) {
                
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
        SAL_atMonochromator subscriber = new SAL_atMonochromator();
        subscriber.salEvent( "atMonochromator_logevent_AppliedSettingsMatchStart" );

        atMonochromator.logevent_AppliedSettingsMatchStart event = new atMonochromator.logevent_AppliedSettingsMatchStart();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_AppliedSettingsMatchStart( event );
            if ( status == SAL_atMonochromator.SAL__OK ) {
                
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

    public boolean MonochromatorConnected() {

        // Initialize
        SAL_atMonochromator subscriber = new SAL_atMonochromator();
        subscriber.salEvent( "atMonochromator_logevent_MonochromatorConnected" );

        atMonochromator.logevent_MonochromatorConnected event = new atMonochromator.logevent_MonochromatorConnected();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_MonochromatorConnected( event );
            if ( status == SAL_atMonochromator.SAL__OK ) {
                
                out.println( "=== Event Logged : " + event );
            }

            try {
                Thread.sleep( 100 );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        boolean connected = event.connected;
        
        /* Remove the DataWriters etc */
        subscriber.salShutdown();
        
        return connected;
    }

    public int SelectedGrating() {

        // Initialize
        SAL_atMonochromator subscriber = new SAL_atMonochromator();
        subscriber.salEvent( "atMonochromator_logevent_SelectedGrating" );

        atMonochromator.logevent_SelectedGrating event = new atMonochromator.logevent_SelectedGrating();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_SelectedGrating( event );
            if ( status == SAL_atMonochromator.SAL__OK ) {
                
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
        
        /* Remove the DataWriters etc */
        subscriber.salShutdown();
        
        return gratingType;
    }

    public Map<String, Object> SlitWidth() {

        // Initialize
        SAL_atMonochromator subscriber = new SAL_atMonochromator();
        subscriber.salEvent( "atMonochromator_logevent_SlitWidth" );

        atMonochromator.logevent_SlitWidth event = new atMonochromator.logevent_SlitWidth();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_SlitWidth( event );
            if ( status == SAL_atMonochromator.SAL__OK ) {
                
                out.println( "=== Event Logged : " + event );
            }

            try {
                Thread.sleep( 100 );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        Map<String /*key*/, Object /*value*/> valuesMap = new HashMap<>();
        valuesMap.put( "slit"        , event.slit /*int*/          );
        valuesMap.put( "slitPosition", event.slitPosition /*float*/ );
        valuesMap.put( "timeStamp"   , event.timestamp /*double*/  );
        
        // e.g. To extract a value:
        //     int slit =  int.class.cast( valuesMap.get( "slit" ) );
        //     float slitPosition =  float.class.cast( valuesMap.get( "slitPosition" ) );
        //     double timeStamp =  double.class.cast( valuesMap.get( "timeStamp" ) );
            
        /* Remove the DataWriters etc */
        subscriber.salShutdown();
        
        return valuesMap;
    }

    public float Wavelength() {

        // Initialize
        SAL_atMonochromator subscriber = new SAL_atMonochromator();
        subscriber.salEvent( "atMonochromator_logevent_Wavelength" );

        atMonochromator.logevent_Wavelength event = new atMonochromator.logevent_Wavelength();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_Wavelength( event );
            if ( status == SAL_atMonochromator.SAL__OK ) {
                
                out.println( "=== Event Logged : " + event );
            }

            try {
                Thread.sleep( 100 );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        float  wavelength = event.wavelength;
        double timestamp = event.timestamp;
        
        /* Remove the DataWriters etc */
        subscriber.salShutdown();
        
        return wavelength;
    }

    public boolean inPosition() {

        // Initialize
        SAL_atMonochromator subscriber = new SAL_atMonochromator();
        subscriber.salEvent( "atMonochromator_logevent_inPosition" );

        atMonochromator.logevent_inPosition event = new atMonochromator.logevent_inPosition();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_inPosition( event );
            if ( status == SAL_atMonochromator.SAL__OK ) {
                
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
        
        /* Remove the DataWriters etc */
        subscriber.salShutdown();
        
        return inPosition;
    }

    public boolean LoopTimeOutOfRange() {

        // Initialize
        SAL_atMonochromator subscriber = new SAL_atMonochromator();
        subscriber.salEvent( "atMonochromator_logevent_LoopTimeOutOfRange" );

        atMonochromator.logevent_LoopTimeOutOfRange event = new atMonochromator.logevent_LoopTimeOutOfRange();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_LoopTimeOutOfRange( event );
            if ( status == SAL_atMonochromator.SAL__OK ) {
                
                out.println( "=== Event Logged : " + event );
            }

            try {
                Thread.sleep( 100 );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        boolean loopTimeOutOfRange = event.loopTimeOutOfRange;
        
        /* Remove the DataWriters etc */
        subscriber.salShutdown();
        
        return loopTimeOutOfRange;
    }
}
