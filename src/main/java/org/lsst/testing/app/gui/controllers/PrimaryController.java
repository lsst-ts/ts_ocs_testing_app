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
import org.lsst.testing.app.CmdTask;
import org.lsst.testing.app.Entity;
import org.lsst.testing.app.gui.fx.*;
import org.lsst.testing.app.salcomponent.CommandableSalComponent.*;
import org.lsst.testing.app.salconnect.SalConnect;
import org.lsst.testing.app.salservice.SalCmd;

import static java.lang.System.out;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Glow;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * ******************************************************************
 * There are 3 modalities that you can apply to the Stage through the
 * stage.initModality( Modelity ) method.
 * <p>
 * 1. Modelity.NONE
 * A newly opened window will be independent from the parent window. You can
 * interact with the parent window or close it without affecting the new window.
 * <p>
 * 2. Modelity.WINDOW_MODAL
 * A newly opened window will invoke a lock on the parent window. You can not
 * interact with the parent window until this window is closed.
 * <p>
 * 3. Modelity.APPLICATION_MODAL
 * A newly opened window invoke a lock on any other windows of the application.
 * You can not interact with any other windows until this window is closed.
 *******************************************************************
 */
/**
 * <h2>FXML Primary Controller</h2>
 * <p>
 * The controller class for <i>primaryFXML.fxml</i> document (via
 * {@code fx:controller} attribute).
 * <p>
 * The {@code @FXML} annotation can be used on fields and methods. It CANNOT be
 * used on classes and constructors.
 * <p>
 * By using a {@code @FXML} annotation on a member, you are declaring that the
 * FXML loader can access the member even if it is private. A public member used
 * by the FXML loader does not need to be annotated with {@code @FXML}. However,
 * annotating a public member with {@code @FXML} is not an error.
 */
public class PrimaryController implements Initializable {

  @FXML
  private MenuItem primaryExit;

  @FXML
  private Menu menuCSC;

  @FXML
  private Label elecLabel, monoLabel, sedsLabel;
  private static final List<Label> STATE_LABEL_LIST = new ArrayList<Label>();

  @FXML
  private Tooltip elecTooltip, monoTooltip, sedsTooltip;
  private static final List<Tooltip> STATE_TOOLTIP_LIST = new ArrayList<Tooltip>();

  @FXML
  private TextField elecStateText, monoStateText, sedsStateText;
  private static final List<TextField> STATE_TEXT_LIST = new ArrayList<TextField>();

  {
    STATE_LABEL_LIST.add( monoLabel );
    STATE_LABEL_LIST.add( sedsLabel );
    STATE_LABEL_LIST.add( elecLabel );

    STATE_TOOLTIP_LIST.add( monoTooltip );
    STATE_TOOLTIP_LIST.add( sedsTooltip );
    STATE_TOOLTIP_LIST.add( elecTooltip );

    STATE_TEXT_LIST.add( monoStateText );
    STATE_TEXT_LIST.add( sedsStateText );
    STATE_TEXT_LIST.add( elecStateText );
  }

  // Reference to AppModel, the main Application Model class
  private AppModel _appModel;

  /**
   * Initializes the controller class.
   * <p>
   * This method is automatically called after the fxml file has been loaded.
   */
  @Override
  public void initialize( URL locationUrl, ResourceBundle resourceBundle ) {

    _appModel = new AppModel();

    ExecutorService es = Executors.newCachedThreadPool();
    _appModel.cEventTask_SUMSTATE.forEach( es::submit );

    primaryExit.setOnAction( e -> {

      Platform.exit();

      System.exit( 0 );
    } );
  }

  /**
   * The {@code checkSummaryState()} method subscribes to the SummaryState topic
   * of a specific CSC on a background JavaFX thread.
   * <p>
   * A {@code Service} class creates & manages a Task that performs the work
   * on a background (daemon) thread. {@code Service} implements {@code Worker}.
   * <p>
   * <p>
   * Similar to doing: Thread th = new Thread(new Runnable task)
   * <p>
   * Similar to doing: Executors.newWorkStealingPool().execute(new Runnable task);
   *
   * @see <li>https://docs.oracle.com/javase/8/javafx/api/toc.htm
   * @see <li>https://docs.oracle.com/javase/8/javafx/concurrent/Service.html
   */
  void checkSummaryState( Entity entity, String cmdString ) throws Exception {

    Service service = new Service() {

      @Override
      protected Task createTask() {

        return new Task<Void>() {

          @Override
          protected Void call() throws Exception {

            Thread.currentThread().setName( "GuiCheck SumState Service" );

            int ndx = _appModel.getEntityList().indexOf( entity );

            TextField stateText = STATE_TEXT_LIST.get( ndx );
            Label stateLabel = STATE_LABEL_LIST.get( ndx );
            Tooltip stateTooltip = STATE_TOOLTIP_LIST.get( ndx );

            int viewState = entity._viewStateTransitionQ.take();

            if ( viewState == entity.getNextStateValue() ) {

              stateText.setText( CSC_STATE_CMD.valueOf( cmdString ).toValueString() );
              stateText.setStyle( "-fx-text-fill: darkcyan;" );
              stateText.setFont( Font.font( "System", FontWeight.BOLD, 11 ) );

              if ( cmdString.matches( "enterControl" ) ) {

                stateLabel.setStyle( "-fx-text-fill: green;" );
                stateLabel.setEffect( new Glow( 0.9 ) );
                stateLabel.setFont( Font.font( "System", FontWeight.BOLD, 14 ) );
                stateLabel.setBorder( new Border(
                    new BorderStroke( Color.BLACK,
                                      BorderStrokeStyle.SOLID,
                                      CornerRadii.EMPTY,
                                      new BorderWidths( 1, 1, 1, 0 ) ) )
                );

                stateTooltip.setText( stateLabel.getText() + " Online" );
              }

              if ( cmdString.matches( "exitControl" ) ) {

                stateLabel.setStyle( "-fx-text-fill: gainsboro;" );
                stateLabel.setEffect( new Glow() );
                stateLabel.setFont( Font.font( "System", FontWeight.NORMAL, 11 ) );
                stateLabel.setBorder( new Border(
                    new BorderStroke( Color.BLACK,
                                      BorderStrokeStyle.SOLID,
                                      CornerRadii.EMPTY,
                                      new BorderWidths( 1, 1, 1, 0 ) ) )
                );

                stateTooltip.setText( stateLabel.getText() + " Offline" );
              }
            }

            return null;
          } // end call()
        }; // end Task()
      } // end createTask()
    }; // end new Service()

    service.start();
  }

  void checkSettingsVersion( Entity entity, String cmdString ) throws Exception {
  }

  void checkAppliedSettings( Entity entity, String cmdString ) throws Exception {
  }

  void checkFilterChange( Entity entity, String cmdString ) throws Exception {
  }

  void checkTarget( Entity entity, String cmdString ) throws Exception {
  }

  // Generic "State Transition" EventHandler for any CSC State pull-down menu items
  @FXML
  private void cscState( ActionEvent event ) throws Exception {

    MenuItem mi = (MenuItem) event.getSource();

    String cmdString = mi.getText();

    // Grab the first 3 characters of the command Id string
    Entity entity = _appModel.getEntityMap() /* e.g. entityELE */
        .get( mi.getId().split( "_" )[0] ); // split by underscore & grab 1st word

    entity.setNextStateValue( CSC_STATE_CMD.valueOf( cmdString ).toValue() );

    // State Pattern: context.request() [e.g. entitySCH.enterControl()]
    new CmdTask( entity, cmdString ).call();

    checkSummaryState( entity, cmdString );
  }

  // Generic "Command Request" EventHandler for any CSC Command pull-down menu items
  @FXML
  private void cscCmd( ActionEvent event ) {

    MenuItem mi = (MenuItem) event.getSource();
    String cmdString = mi.getText();

    // 1. SalComponent (Receiver) previously defined: Executive.cscELE
    // 2a. Define Concrete SalService (Cmd) for specific SalComponent (Rcr)
    // 2b. Also, assign topic & topic arguments
    SalCmd salCmd = new SalCmd( _appModel.getCscMap() /* e.g. cscELE */
        .get( mi.getId().split( "_" )[0] ) ); // split by underscore & grab 1st word
    salCmd.setTopic( cmdString );

    // 3a. Define Invoker w/ # of threads
    // 3b. Set SalService request (a cmd in this case)
    SalConnect salConnect = new SalConnect( 1 );
    salConnect.setSalService( salCmd );

    // 4. Invoker indirectly calls cmd->execute()
    salConnect.connect();
  }

  @FXML
  private void createCSC( ActionEvent event ) throws Exception {

    out.print( Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName() + "::"
               + "Threadid: "
               + Thread.currentThread().getId() + "\n" );

    // Grab the string & index of the seleccted CSC menu item
    String cmdString = "enterControl";
    int cscIndex = menuCSC.getItems().indexOf( event.getSource() );

    Entity entity = _appModel.getEntityList().get( cscIndex /* e.g. entityMON */ );

    // 1. SalComponent (Receiver) previously defined: Executive.cscMTCS
    // 2. Define Concrete SalService (Cmd) for specific SalComponent (Rcr)
    //    Also, assign topic & topic arguments
    SalCmd salCmdCsc = new SalCmd( _appModel.getCscList().get( cscIndex ) );
    salCmdCsc.setTopic( cmdString );

    // 3. Define Invoker w/ # of threads & set SalService request
    SalConnect salConnectCsc = new SalConnect( 1 );
    salConnectCsc.setSalService( salCmdCsc );

    // 4. Invoker indirectly calls cmd->execute()
    salConnectCsc.connect();

    //checkSummaryState( entity, cmdString );        
  }

  @FXML
  private void cscStateAll( ActionEvent event ) throws Exception {

    out.print( Thread.currentThread()
        .getStackTrace()[1]
        .getMethodName() + "::"
               + "Threadid: "
               + Thread.currentThread().getId() + "\n" );

    MenuItem mi = (MenuItem) event.getSource();
    String cmdString = mi.getText()
        .split( " " )[0]; // split by space & grab 1st word

    // 3a. Define Invoker w/ # of threads
    SalConnect salConnectCsc = new SalConnect( _appModel.getCscList().size() );

    _appModel.getCscList().forEach( csc -> {

      // 1. SalComponent (Receiver) previously defined: Executive.cscMTCS
      // 2. Define Concrete SalService (Cmd) for specific SalComponent (Rcr)
      //    Also, assign topic & topic arguments
      SalCmd salCmdCsc = new SalCmd( csc );
      salCmdCsc.setTopic( cmdString );

      // 3b.Sset SalService request
      salConnectCsc.setSalService( salCmdCsc );
    } );

    // 4. Invoker indirectly calls cmd->execute()
    salConnectCsc.connect();

    _appModel.getEntityList().forEach( entity -> {

      try {
        checkSummaryState( entity, cmdString );
      } catch ( Exception ex ) {
        ex.printStackTrace( out.printf(
            "InterruptedException from  PrimaryController.createAllCSC()" ) );
        //Logger.getLogger( PrimaryController.class.getName() ).log( Level.SEVERE, null, ex );
      }
    } );
  }

  @FXML
  private void handleSetMon( ActionEvent event ) throws Exception {

    UpdateMonSetupFX.getInstance().startStage();
  }

  @FXML
  private void handleSpectImage( ActionEvent event ) throws Exception {

    CaptureSpectImageFX.getInstance().startStage();
  }

  @FXML
  private void handleScanDt( ActionEvent event ) throws Exception {

    StartScanDtFX.getInstance().startStage();
  }

  @FXML
  private void handleRunScript( ActionEvent event ) throws Exception {

    RunScriptFX.getInstance().startStage();
  }
}
