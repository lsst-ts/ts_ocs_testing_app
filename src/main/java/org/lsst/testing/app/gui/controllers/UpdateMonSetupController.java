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

package org.lsst.testing.app.gui.controllers;

import org.lsst.testing.app.AppModel;
import org.lsst.testing.app.gui.fx.UpdateMonSetupFX;
import org.lsst.testing.app.salconnect.SalConnect;
import org.lsst.testing.app.salservice.SalCmd;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import org.lsst.testing.app.EntityType;

/**
 * <h2>FXML UpdateMonoSetup Controller</h2>
 * <p>
 * The controller class for <i>updateMonoSetupFXML.fxml</i> document (via
 * {@code fx:controller} attribute).
 */
public class UpdateMonSetupController implements Initializable {

  private AppModel _appModel;

  @FXML
  private SplitMenuButton gratingMenub;

  @FXML
  private ScrollBar entranceScroll, exitScroll;

  @FXML
  private TextField entranceScrollText, exitScrollText, wavelengthText;

  @FXML
  private Button applyButton, sendButton, exitButton;

  /**
   * Initializes the controller class.
   * <p>
   * This method is automatically called after the fxml file has been loaded.
   */
  @Override
  public void initialize( URL locationUrl, ResourceBundle resourceBundle ) {

    _appModel = new AppModel();

    entranceScroll.valueProperty().addListener(
        ( observable, oldvalue, newvalue )
        -> {
      double d = newvalue.doubleValue();
      //System.out.println("TextField Text Changed (newValue: " + Double.toString( 5.5 - d ) + ")");
      entranceScrollText.textProperty()
          .setValue( Double.valueOf( String.format( "%.2f", 5.5 - d ) )
              .toString()
          );
    }
    );

    exitScroll.valueProperty().addListener(
        ( observable, oldvalue, newvalue )
        -> {
      double d = newvalue.doubleValue();
      //System.out.println("TextField Text Changed (newValue: " + Double.toString( 5.5 - d ) + ")");
      exitScrollText.textProperty()
          .setValue( Double.valueOf( String.format( "%.2f", 5.5 - d ) )
              .toString()
          );
    }
    );
  }

//    @Override
//    public void stop() throws Exception {
//        
//        super.stop();
//
//        if ( controller != null ) {
//            //controller.startHousekeeping(); 
//        }
//
//        // Terminates the JavaFX Application & Launcher threads
//        Platform.exit();
//        // Terminates the current JVM (basically killing non-JavaFX threads)
//        System.exit( 0 );
//    }
  @FXML
  private void gratingSelect( ActionEvent event ) {

    MenuItem mi = (MenuItem) event.getSource();

    gratingMenub.setText( mi.getText() );
  }

  @FXML
  private void handleApply( ActionEvent event ) {

    Map<String /*
         * key
         */, Object /*
         * value
         */> argsMap = new TreeMap<>();

    argsMap.put( "1gratingType", Integer.parseInt( gratingMenub.getText() /*
              * int
              */ ) );
    argsMap.put( "2fontEntranceSlitWidth", Double.parseDouble( entranceScrollText.getText() /*
              * double
              */ ) );
    argsMap.put( "3fontExitSlitWidth", Double.parseDouble( exitScrollText.getText() /*
              * double
              */ ) );
    argsMap.put( "4wavelength", Double.parseDouble( wavelengthText.getText() /*
              * double
              */ ) );

    System.out.println( "" );
    argsMap.forEach( ( key, value ) -> System.out.println( key + ": " + value ) );
  }

  @FXML
  private void handleSend( ActionEvent event ) {

    // Create a sorted map (sorted by key)
    Map<String /*
         * key
         */, Object /*
         * value
         */> argsMap = new TreeMap<>();

    argsMap.put( "1gratingType", Integer.parseInt( gratingMenub.getText() /*
              * int
              */ ) );
    argsMap.put( "2fontEntranceSlitWidth", Double.parseDouble( entranceScrollText.getText() /*
              * double
              */ ) );
    argsMap.put( "3fontExitSlitWidth", Double.parseDouble( exitScrollText.getText() /*
              * double
              */ ) );
    argsMap.put( "4wavelength", Double.parseDouble( wavelengthText.getText() /*
              * double
              */ ) );

    // 1. SalComponent (Receiver) previously defined: Executive.cscELE
    // 2a. Define Concrete SalService (Cmd) for specific SalComponent (Rcr)
    // 2b. Also, assign topic & topic arguments
    SalCmd salCmd = new SalCmd( _appModel.getCscMap().get( EntityType.ATMONOCHROMATOR.toString() ) );
    salCmd.setTopic( "updateMonochromatorSetup" );
    salCmd.setTopicArgs( argsMap.values().toArray() );

    // 3a. Define Invoker w/ # of threads
    // 3b. Set SalService request (a cmd in this case)
    SalConnect salConnect = new SalConnect( 1 );
    salConnect.setSalService( salCmd );

    // 4. Invoker indirectly calls cmd->execute()
    salConnect.connect();
  }

  @FXML
  private void handleExit( ActionEvent event ) throws Exception {

    UpdateMonSetupFX.getInstance().closeStage();
  }
}
