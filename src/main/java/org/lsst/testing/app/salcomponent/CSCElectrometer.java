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

import org.lsst.sal.SAL_calibrationElectrometer;
import org.lsst.testing.app.AppModel;

import static java.lang.System.out;
import java.util.HashMap;
import java.util.Map;

/**
 * <h2>Auxiliary Camera Control System (ACCS) CSC</h2>
 * 
 * {@code CSCElectrometer} is a (Concrete) Receiver class in the command pattern
 */
public class CSCElectrometer implements CommandableSalComponent {

    @Override public String getName() { return "CSCElectrometer"; }

    @Override public void start( Object [] args ) {

        SAL_calibrationElectrometer publisher = new SAL_calibrationElectrometer(  );
        publisher.salCommand( "calibrationElectrometer_command_start" );
        publisher.setDebugLevel( 1 );

        calibrationElectrometer.command_start command = new calibrationElectrometer.command_start();
        command.private_revCode = "LSST Electrometer start COMMAND";
        command.device = "calibrationElectrometer";
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

    @Override public void enable( Object[] args ) {

        SAL_calibrationElectrometer publisher = new SAL_calibrationElectrometer(  );
        publisher.salCommand( "calibrationElectrometer_command_enable" );
        publisher.setDebugLevel( 1 );

        calibrationElectrometer.command_enable command = new calibrationElectrometer.command_enable();
        command.private_revCode = "LSST Electrometer enable COMMAND";
        command.device = "calibrationElectrometer";
        command.property = "state";
        command.action = "enable";

        int cmdId = publisher.issueCommand_enable( command );

        try {
            Thread.sleep( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_enable( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    @Override public void disable( Object [] args ) {

        SAL_calibrationElectrometer publisher = new SAL_calibrationElectrometer(  );
        publisher.salCommand( "calibrationElectrometer_command_disable" );
        publisher.setDebugLevel( 1 );

        calibrationElectrometer.command_disable command = new calibrationElectrometer.command_disable();
        command.private_revCode = "LSST Electrometer disable COMMAND";
        command.device = "calibrationElectrometer";
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

        SAL_calibrationElectrometer publisher = new SAL_calibrationElectrometer(  );
        publisher.salCommand( "calibrationElectrometer_command_standby" );
        publisher.setDebugLevel( 1 );

        calibrationElectrometer.command_standby command = new calibrationElectrometer.command_standby();
        command.private_revCode = "LSST Electrometer standby COMMAND";
        command.device = "calibrationElectrometer";
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

        SAL_calibrationElectrometer publisher = new SAL_calibrationElectrometer(  );
        publisher.salCommand( "calibrationElectrometer_command_exitControl" );
        publisher.setDebugLevel( 1 );

        calibrationElectrometer.command_exitControl command = new calibrationElectrometer.command_exitControl();
        command.private_revCode = "LSST Electrometer exitControl COMMAND";
        command.device = "calibrationElectrometer";
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

    public void StartScanDt( Object [] args ) {

        SAL_calibrationElectrometer publisher = new SAL_calibrationElectrometer(  );
        publisher.salCommand( "calibrationElectrometer_command_StartScanDt" );
        publisher.setDebugLevel( 1 );

        calibrationElectrometer.command_StartScanDt command = new calibrationElectrometer.command_StartScanDt();
        command.private_revCode = "LSST Electrometer StartScanDt COMMAND";
        command.device = "calibrationElectrometer";
        command.property = "calibration";
        command.action = "StartScanDt";
        command.electId = 1;
        command.time = (float) args[0];

        int cmdId = publisher.issueCommand_StartScanDt( command );

        try {
            Thread.sleep( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_StartScanDt( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    public void StopScan() {

        SAL_calibrationElectrometer publisher = new SAL_calibrationElectrometer(  );
        publisher.salCommand( "calibrationElectrometer_command_StopScan" );
        publisher.setDebugLevel( 1 );

        calibrationElectrometer.command_StopScan command = new calibrationElectrometer.command_StopScan();
        command.private_revCode = "LSST Electrometer StopScan COMMAND";
        command.device = "calibrationElectrometer";
        command.property = "calibration";
        command.action = "StopScan";
        command.electId = 1;

        int cmdId = publisher.issueCommand_StopScan( command );

        try {
            Thread.sleep( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        int timeout = 4;
        publisher.waitForCompletion_StopScan( cmdId, timeout );

        /* Remove the DataWriters etc */
        publisher.salShutdown();
    }

    @Override public Integer summaryState() {

        // Initialize
        SAL_calibrationElectrometer subscriber = new SAL_calibrationElectrometer(  );
        subscriber.salEvent( "calibrationElectrometer_logevent_SummaryState" );
        subscriber.setDebugLevel( 1 );

        calibrationElectrometer.logevent_SummaryState event = new calibrationElectrometer.logevent_SummaryState();

        Integer status = CSC_STATUS.SAL__NO_UPDATES.getValue();
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_SummaryState( event );
            if ( status == SAL_calibrationElectrometer.SAL__OK ) {
                
                out.println( "=== Event Logged : " + event );
                out.println( "=== Event Status : " + status );
                out.println( "=== Event SummaryState : " + event.summaryState );
                
                try {
                    AppModel.getEntityMap().get( "ele" )._stateTransitionQ.put( event.summaryState );
                    AppModel.getEntityMap().get( "ele" )._guiStateTransitionQ.put( event.summaryState );
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
        SAL_calibrationElectrometer subscriber = new SAL_calibrationElectrometer(  );
        subscriber.salEvent( "calibrationElectrometer_logevent_SettingVersions" );
        subscriber.setDebugLevel( 1 );

        calibrationElectrometer.logevent_SettingVersions event = new calibrationElectrometer.logevent_SettingVersions();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_SettingVersions( event );
            if ( status == SAL_calibrationElectrometer.SAL__OK ) {
                
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
        SAL_calibrationElectrometer subscriber = new SAL_calibrationElectrometer(  );
        subscriber.salEvent( "calibrationElectrometer_logevent_AppliedSettingsMatchStart" );
        subscriber.setDebugLevel( 1 );

        calibrationElectrometer.logevent_AppliedSettingsMatchStart event = new calibrationElectrometer.logevent_AppliedSettingsMatchStart();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_AppliedSettingsMatchStart( event );
            if ( status == SAL_calibrationElectrometer.SAL__OK ) {
                
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

    public boolean LoopTimeOutOfRange() {

        // Initialize
        SAL_calibrationElectrometer subscriber = new SAL_calibrationElectrometer();
        subscriber.salEvent( "calibrationElectrometer_logevent_LoopTimeOutOfRange" );

        calibrationElectrometer.logevent_LoopTimeOutOfRange event = new calibrationElectrometer.logevent_LoopTimeOutOfRange();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_LoopTimeOutOfRange( event );
            if ( status == SAL_calibrationElectrometer.SAL__OK ) {
                
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

    public Map<String, Object> LargeFileObjectAvailable() {

        // Initialize
        SAL_calibrationElectrometer subscriber = new SAL_calibrationElectrometer();
        subscriber.salEvent( "calibrationElectrometer_logevent_LargeFileObjectAvailable" );

        subscriber.setDebugLevel( 1 );
        
        calibrationElectrometer.logevent_LargeFileObjectAvailable event = new calibrationElectrometer.logevent_LargeFileObjectAvailable();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_LargeFileObjectAvailable( event );
            if ( status == SAL_calibrationElectrometer.SAL__OK ) {
                
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
    
    public boolean ReadingOutOfLimit() {

        // Initialize
        SAL_calibrationElectrometer subscriber = new SAL_calibrationElectrometer();
        subscriber.salEvent( "calibrationElectrometer_logevent_ReadingOutOfLimit" );

        calibrationElectrometer.logevent_ReadingOutOfLimit event = new calibrationElectrometer.logevent_ReadingOutOfLimit();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_ReadingOutOfLimit( event );
            if ( status == SAL_calibrationElectrometer.SAL__OK ) {
                
                out.println( "=== Event Logged : " + event );
            }

            try {
                Thread.sleep( 100 );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        boolean readingOutOfLimit = event.readingOutOfLimit;
        
        /* Remove the DataWriters etc */
        subscriber.salShutdown();
        
        return readingOutOfLimit;
    }

    public Map<String, Object> IntegrationTime() {

        // Initialize
        SAL_calibrationElectrometer subscriber = new SAL_calibrationElectrometer();
        subscriber.salEvent( "calibrationElectrometer_logevent_IntegrationTime" );

        subscriber.setDebugLevel( 1 );
        
        calibrationElectrometer.logevent_IntegrationTime event = new calibrationElectrometer.logevent_IntegrationTime();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_IntegrationTime( event );
            if ( status == SAL_calibrationElectrometer.SAL__OK ) {
                
                out.println( "=== Event Logged : " + event );
            }

            try {
                Thread.sleep( 100 );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        Map<String /*key*/, Object /*value*/> valuesMap = new HashMap<>();
        valuesMap.put( "electtId", event.electtId /*short*/ );
        valuesMap.put( "intTime" , event.intTime /*float*/  );
        
        // e.g. To extract a value:
        //     short electtId = short.class.cast( valuesMap.get( "electtId") );
        //     float intTime = float.class.cast( valuesMap.get( "intTime") );
        
        /* Remove the DataWriters etc */
        subscriber.salShutdown();

        return valuesMap;
    }
    
    public Map<String, Object> Intensity() {

        // Initialize
        SAL_calibrationElectrometer subscriber = new SAL_calibrationElectrometer();
        subscriber.salEvent( "calibrationElectrometer_logevent_Intensity" );

        subscriber.setDebugLevel( 1 );
        
        calibrationElectrometer.logevent_Intensity event = new calibrationElectrometer.logevent_Intensity();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_Intensity( event );
            if ( status == SAL_calibrationElectrometer.SAL__OK ) {
                
                out.println( "=== Event Logged : " + event );
            }

            try {
                Thread.sleep( 100 );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        Map<String /*key*/, Object /*value*/> valuesMap = new HashMap<>();
        valuesMap.put( "electId"  , event.electId /*short*/    );
        valuesMap.put( "intensity", event.intensity /*double*/ );
        valuesMap.put( "unit"     , event.unit /*String*/       );
        valuesMap.put( "timestamp", event.timestamp /*double*/ );
        
        // e.g. To extract a value:
        //     short electId = short.class.cast( valuesMap.get( "electId") );
        //     double intensity = double.class.cast( valuesMap.get( "intensity") );
        //     String unit = String.class.cast( valuesMap.get( "unit") );
        //     double timestamp = double.class.cast( valuesMap.get( "timestamp") );
        
        /* Remove the DataWriters etc */
        subscriber.salShutdown();

        return valuesMap;
    }
    
    public Map<String, Object> IntensityReq() {

        // Initialize
        SAL_calibrationElectrometer subscriber = new SAL_calibrationElectrometer();
        subscriber.salEvent( "calibrationElectrometer_logevent_IntensityReq" );

        subscriber.setDebugLevel( 1 );
        
        calibrationElectrometer.logevent_IntensityReq event = new calibrationElectrometer.logevent_IntensityReq();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_IntensityReq( event );
            if ( status == SAL_calibrationElectrometer.SAL__OK ) {
                
                out.println( "=== Event Logged : " + event );
            }

            try {
                Thread.sleep( 100 );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        Map<String /*key*/, Object /*value*/> valuesMap = new HashMap<>();
        valuesMap.put( "electId"        , event.electId /*short*/            );
        valuesMap.put( "intensity"      , event.intensity /*double[1000]*/    );
        valuesMap.put( "masureTimestamp", event.masureTimestamp /*double[2]*/ );
        valuesMap.put( "mode"           , event.mode /*short*/               );
        valuesMap.put( "packetId"       , event.packetId /*short*/           );
        valuesMap.put( "size"           , event.size /*short*/               );
        valuesMap.put( "temperature"    , event.temperature /*float[2]*/       );
        valuesMap.put( "unit"           , event.unit /*String*/               );
        
        // e.g. To extract a value:
        //     short electId = short.class.cast( valuesMap.get( "electId") );
        //     double intensity[] = double.class.cast( valuesMap.get( "intensity") );
        //     double masureTimestamp[] = double.class.cast( valuesMap.get( "masureTimestamp") );
        //     short mode = short.class.cast( valuesMap.get( "mode") );
        //     short packetId = short.class.cast( valuesMap.get( "packetId") );
        //     short size = short.class.cast( valuesMap.get( "size") );
        //     float temperature[] = float.class.cast( valuesMap.get( "temperature") );
        //     String unit = String.class.cast( valuesMap.get( "unit") );

        /* Remove the DataWriters etc */
        subscriber.salShutdown();

        return valuesMap;
    }
    
    public Map<String, Object> SettingsApplied_ReadingSettings() {

        // Initialize
        SAL_calibrationElectrometer subscriber = new SAL_calibrationElectrometer();
        subscriber.salEvent( "calibrationElectrometer_logevent_SettingsApplied_ReadingSettings" );

        subscriber.setDebugLevel( 1 );
        
        calibrationElectrometer.logevent_SettingsApplied_ReadingSettings event = new calibrationElectrometer.logevent_SettingsApplied_ReadingSettings();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_SettingsApplied_ReadingSettings( event );
            if ( status == SAL_calibrationElectrometer.SAL__OK ) {
                
                out.println( "=== Event Logged : " + event );
            }

            try {
                Thread.sleep( 100 );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        Map<String /*key*/, Object /*value*/> valuesMap = new HashMap<>();
        valuesMap.put( "avgFilterType"     , event.avgFilterType /*int*/          );
        valuesMap.put( "electId"           , event.electId /*short*/              );
        valuesMap.put( "errorPath"         , event.errorPath /*String*/            );
        valuesMap.put( "filterActive"      , event.filterActive /*boolean*/       );
        valuesMap.put( "inputRange"        , event.inputRange /*double*/          );
        valuesMap.put( "integrationTime"   , event.integrationTime /*double*/     );
        valuesMap.put( "medianFilterStatus", event.medianFilterStatus /*boolean*/ );
        valuesMap.put( "mode"              , event.mode /*int*/                   );
        valuesMap.put( "radingOption"      , event.radingOption /*int*/           );
        valuesMap.put( "readingTimeout"    , event.readingTimeout /*int*/         );
        
        // e.g. To extract a value:
        //     int avgFilterType = int.class.cast( valuesMap.get( "avgFilterType") );
        //     short electId = short.class.cast( valuesMap.get( "electId") );
        //     String errorPath = String.class.cast( valuesMap.get( "errorPath") );
        //     boolean filterActive = boolean.class.cast( valuesMap.get( "filterActive") );
        //     double inputRange = double.class.cast( valuesMap.get( "inputRange") );
        //     double integrationTime = double.class.cast( valuesMap.get( "integrationTime") );
        //     boolean medianFilterStatus = boolean.class.cast( valuesMap.get( "medianFilterStatus") );
        //     int mode = int.class.cast( valuesMap.get( "mode") );
        //     int radingOption = int.class.cast( valuesMap.get( "radingOption") );
        //     int readingTimeout = int.class.cast( valuesMap.get( "readingTimeout") );

        /* Remove the DataWriters etc */
        subscriber.salShutdown();

        return valuesMap;
    }
    
    public Map<String, Object> measureType() {

        // Initialize
        SAL_calibrationElectrometer subscriber = new SAL_calibrationElectrometer();
        subscriber.salEvent( "calibrationElectrometer_logevent_measureType" );

        subscriber.setDebugLevel( 1 );
        
        calibrationElectrometer.logevent_measureType event = new calibrationElectrometer.logevent_measureType();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_measureType( event );
            if ( status == SAL_calibrationElectrometer.SAL__OK ) {
                
                out.println( "=== Event Logged : " + event );
            }

            try {
                Thread.sleep( 100 );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        Map<String /*key*/, Object /*value*/> valuesMap = new HashMap<>();
        valuesMap.put( "electId", event.electId /*short*/ );
        valuesMap.put( "mode"   , event.mode /*short*/    );
        
        // e.g. To extract a value:
        //     short electId = short.class.cast( valuesMap.get( "electId") );
        //     short mode = short.class.cast( valuesMap.get( "mode") );

        /* Remove the DataWriters etc */
        subscriber.salShutdown();

        return valuesMap;
    }
    
    public Map<String, Object> measureRange() {

        // Initialize
        SAL_calibrationElectrometer subscriber = new SAL_calibrationElectrometer();
        subscriber.salEvent( "calibrationElectrometer_logevent_measureRange" );

        subscriber.setDebugLevel( 1 );
        
        calibrationElectrometer.logevent_measureRange event = new calibrationElectrometer.logevent_measureRange();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_measureRange( event );
            if ( status == SAL_calibrationElectrometer.SAL__OK ) {
                
                out.println( "=== Event Logged : " + event );
            }

            try {
                Thread.sleep( 100 );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        Map<String /*key*/, Object /*value*/> valuesMap = new HashMap<>();
        valuesMap.put( "rangeValue", event.rangeValue /*float*/ );
        valuesMap.put( "electId"   , event.electId /*short*/    );
        
        // e.g. To extract a value:
        //     float rangeValue = float.class.cast( valuesMap.get( "rangeValue") );
        //     short electId = short.class.cast( valuesMap.get( "electId") );

        /* Remove the DataWriters etc */
        subscriber.salShutdown();

        return valuesMap;
    }
    
    public Map<String, Object> digitalFilterChange() {

        // Initialize
        SAL_calibrationElectrometer subscriber = new SAL_calibrationElectrometer();
        subscriber.salEvent( "calibrationElectrometer_logevent_digitalFilterChange" );

        subscriber.setDebugLevel( 1 );
        
        calibrationElectrometer.logevent_digitalFilterChange event = new calibrationElectrometer.logevent_digitalFilterChange();

        int status;
        while ( Boolean.TRUE ) {
            
            status = subscriber.getEvent_digitalFilterChange( event );
            if ( status == SAL_calibrationElectrometer.SAL__OK ) {
                
                out.println( "=== Event Logged : " + event );
            }

            try {
                Thread.sleep( 100 );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        Map<String /*key*/, Object /*value*/> valuesMap = new HashMap<>();
        valuesMap.put( "avgFilterActive", event.avgFilterActive /*boolean*/ );
        valuesMap.put( "electId"        , event.electId /*short*/           );
        valuesMap.put( "filterStatus"   , event.filterStatus /*boolean*/    );
        valuesMap.put( "medFilterActive", event.medFilterActive /*boolean*/ );
        
        // e.g. To extract a value:
        //     boolean avgFilterActive = boolean.class.cast( valuesMap.get( "avgFilterActive") );
        //     short electId = short.class.cast( valuesMap.get( "electId") );
        //     boolean filterStatus = boolean.class.cast( valuesMap.get( "filterStatus") );
        //     boolean medFilterActive = boolean.class.cast( valuesMap.get( "medFilterActive") );

        /* Remove the DataWriters etc */
        subscriber.salShutdown();

        return valuesMap;
    }
}
