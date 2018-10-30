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

import org.lsst.testing.app.salcomponent.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h2>AppModel</h2>
 * <p>
 * The {@code AppModel} is the application model class
 */
public class AppModel {

  private static final CommandableSalComponent _cscMON = new CSCATMonochromator();
  private static final CommandableSalComponent _cscSED = new CSCFiberSpectrograph();
  private static final CommandableSalComponent _cscELE = new CSCElectrometer();

  private static final Entity _entityMON = new Entity( _cscMON );
  private static final Entity _entitySED = new Entity( _cscSED );
  private static final Entity _entityELE = new Entity( _cscELE );

  /**
   * Returns a Map of CSCs.
   *
   * @return Map of pre-instantiated CSCs
   */
  @SuppressWarnings ("serial")
  public static Map<String, CommandableSalComponent> getCscMap() {

    return Collections.unmodifiableMap( new HashMap<String, CommandableSalComponent>() {

      {
        // (CSC key, CSC value)
        put( EntityType.ATMONOCHROMATOR.toSubString(), _cscMON );
        put( EntityType.FIBERSPECTROGRAPH.toSubString(), _cscSED );
        put( EntityType.ELECTROMETER.toSubString(), _cscELE );
      }
    } );
  }

  /**
   * Returns a List of CSCs.
   *
   * @return List of pre-instantiated CSCs
   */
  public static List<CommandableSalComponent> getCscList() {

    return Collections.unmodifiableList( Arrays.asList(
        _cscMON,
        _cscSED,
        _cscELE
    )
    );
  }

  /**
   * Returns a Map of the Entity objects.
   *
   * @return Map of pre-instantiated Entity objects
   */
  @SuppressWarnings ("serial")
  public static Map<String, Entity> getEntityMap() {

    return Collections.unmodifiableMap( new HashMap<String, Entity>() {

      {
        // (Entity key, Entity value)
        put( EntityType.ATMONOCHROMATOR.toSubString(), _entityMON );
        put( EntityType.FIBERSPECTROGRAPH.toSubString(), _entitySED );
        put( EntityType.ELECTROMETER.toSubString(), _entityELE );
      }
    } );
  }

  /**
   * Returns a List of Entity objects.
   *
   * @return List of pre-instantiated Entity objects
   */
  public static List<Entity> getEntityList() {

    return Collections.unmodifiableList( Arrays.asList(
        _entityMON,
        _entitySED,
        _entityELE
    )
    );
  }

  public static final List<CmdTask> rCmdTasks_ENTERCTRL = Arrays.asList(
      new CmdTask( _entityMON, "enterControl" ),
      new CmdTask( _entitySED, "enterControl" ),
      new CmdTask( _entityELE, "enterControl" )
  );

  public static final List<CmdTask> rCmdTasks_START = Arrays.asList(
      new CmdTask( _entityMON, "start" ),
      new CmdTask( _entitySED, "start" ),
      new CmdTask( _entityELE, "start" )
  );

  public static final List<CmdTask> rCmdTasks_ENABLE = Arrays.asList(
      new CmdTask( _entityMON, "enable" ),
      new CmdTask( _entitySED, "enable" ),
      new CmdTask( _entityELE, "enable" )
  );

  public static final List<CmdTask> rCmdTasks_DISABLE = Arrays.asList(
      new CmdTask( _entityMON, "disable" ),
      new CmdTask( _entitySED, "disable" ),
      new CmdTask( _entityELE, "disable" )
  );

  public static final List<CmdTask> rCmdTasks_STANDBY = Arrays.asList(
      new CmdTask( _entityMON, "standby" ),
      new CmdTask( _entitySED, "standby" ),
      new CmdTask( _entityELE, "standby" )
  );

  public static final List<CmdTask> rCmdTasks_EXITCTRL = Arrays.asList(
      new CmdTask( _entityMON, "exitControl" ),
      new CmdTask( _entitySED, "exitControl" ),
      new CmdTask( _entityELE, "exitControl" )
  );

  public static final List<CmdTask> rCmdTasks_MONO = Arrays.asList(
      new CmdTask( _cscMON, "CalibrateWavelength" ),
      new CmdTask( _cscMON, "ChangeLightIntensity" ),
      new CmdTask( _cscMON, "ChangeSlitWidth" ),
      new CmdTask( _cscMON, "ChangeWavelength" ),
      new CmdTask( _cscMON, "Power" ),
      new CmdTask( _cscMON, "PowerWhiteLight" ),
      new CmdTask( _cscMON, "SelectGrating" ),
      new CmdTask( _cscMON, "SetCoolingTemperature" ),
      new CmdTask( _cscMON, "updateMonochromatorSetup" )
  );

  public static final List<CmdTask> rCmdTasks_SEDS = Arrays.asList(
      new CmdTask( _cscSED, "captureSpectImage" ),
      new CmdTask( _cscSED, "setSpectTempSetpoint" ),
      new CmdTask( _cscSED, "stopImageCapture" )
  );

  public static final List<CmdTask> rCmdTasks_ELEC = Arrays.asList(
      new CmdTask( _cscELE, "StartScanDt" ),
      new CmdTask( _cscELE, "StopScan" )
  );

  public static final List<EventTask> cEventTask_SUMSTATE = Arrays.asList(
      new EventTask( _cscELE, "summaryState" ),
      new EventTask( _cscMON, "summaryState" ),
      new EventTask( _cscSED, "summaryState" )
  );

  public static final List<EventCallable> cEventTask_SETTINGS = Arrays.asList(
      new EventCallable( _cscELE, "settingsVersion" ),
      new EventCallable( _cscMON, "settingsVersion" ),
      new EventCallable( _cscSED, "settingsVersion" )
  );

  public static final List<EventCallable> cEventTask_APPLIEDSETTINGS = Arrays.asList(
      new EventCallable( _cscELE, "appliedSettingsMatchStartTest" ),
      new EventCallable( _cscMON, "appliedSettingsMatchStartTest" ),
      new EventCallable( _cscSED, "appliedSettingsMatchStartTest" )
  );

  public static final List<EventCallable> cEventTask_MONO = Arrays.asList(
      new EventCallable( _cscMON, "inPosition" ),
      new EventCallable( _cscMON, "LoopTimeOutOfRange" ),
      new EventCallable( _cscMON, "MonochromatorConnected" ),
      new EventCallable( _cscMON, "SelectedGrating" ),
      new EventCallable( _cscMON, "SlitWidth" ),
      new EventCallable( _cscMON, "Wavelength" )
  );

  public static final List<EventCallable> cEventTask_SEDS = Arrays.asList(
      new EventCallable( _cscSED, "LargeFileObjectAvailable" ),
      new EventCallable( _cscSED, "MeasuredSpectrum" )
  );

  public static final List<EventCallable> cEventTask_ELEC = Arrays.asList(
      new EventCallable( _cscELE, "digitalFilterChange" ),
      new EventCallable( _cscELE, "IntegrationTime" ),
      new EventCallable( _cscELE, "Intensity" ),
      new EventCallable( _cscELE, "IntensityReq" ),
      new EventCallable( _cscELE, "LargeFileObjectAvailable" ),
      new EventCallable( _cscELE, "LoopTimeOutOfRange" ),
      new EventCallable( _cscELE, "measureRange" ),
      new EventCallable( _cscELE, "measureType" ),
      new EventCallable( _cscELE, "ReadingOutOfLimit" ),
      new EventCallable( _cscELE, "SettingsApplied_ReadingSettings" )
  );
}
