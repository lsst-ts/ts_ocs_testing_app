/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.lsst.testing.app.gui.controllers;

import org.lsst.testing.app.AppModel;
import org.lsst.testing.app.gui.fx.CaptureSpectImageFX;
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
 * <h2>FXML CaptureSpectImage Controller</h2>
 * <p>
 * The controller class for <i>captureSpectImageFXML.fxml</i> document (via
 * {@code fx:controller} attribute).
 */
public class CaptureSpectImageController implements Initializable {

  private AppModel _appModel;

  @FXML
  private SplitMenuButton imageMenub, lightMenub;

  @FXML
  private ScrollBar integrateScroll;

  @FXML
  private TextField integrateScrollText;

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

    integrateScroll.valueProperty().addListener(
        ( observable, oldvalue, newvalue )
        -> {
      double d = newvalue.doubleValue();
      integrateScrollText.textProperty()
          .setValue( Double.valueOf( String.format( "%.2f", 5.25 - d ) )
              .toString()
          );
    }
    );
  }

  @FXML
  private void imageTypeSelect( ActionEvent event ) {

    MenuItem mi = (MenuItem) event.getSource();

    imageMenub.setText( mi.getText() );
  }

  @FXML
  private void lampSelect( ActionEvent event ) {

    MenuItem mi = (MenuItem) event.getSource();

    lightMenub.setText( mi.getText() );
  }

  @FXML
  private void handleApply( ActionEvent event ) {

    // Create a sorted map (sorted by key)
    Map<String /*
         * key
         */, Object /*
         * value
         */> argsMap = new TreeMap<>();

    argsMap.put( "1integrationTime", Float.parseFloat( integrateScrollText.getText() /*
              * float
              */ ) );
    argsMap.put( "2imageType", imageMenub.getText() /*
     * String
     */ );
    argsMap.put( "3lamp", lightMenub.getText() /*
     * String
     */ );

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

    argsMap.put( "1integrationTime", Float.parseFloat( integrateScrollText.getText() /*
              * float
              */ ) );
    argsMap.put( "2imageType", imageMenub.getText() /*
     * String
     */ );
    argsMap.put( "3lamp", lightMenub.getText() /*
     * String
     */ );

    // 1. SalComponent (Receiver) previously defined: Executive.cscELE
    // 2a. Define Concrete SalService (Cmd) for specific SalComponent (Rcr)
    // 2b. Also, assign topic & topic arguments
    SalCmd salCmd = new SalCmd( _appModel.getCscMap().get( EntityType.FIBERSPECTROGRAPH.toString() ) );
    salCmd.setTopic( "captureSpectImage" );
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

    CaptureSpectImageFX.getInstance().closeStage();
  }
}
