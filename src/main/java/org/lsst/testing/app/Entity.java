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
 *
 * You should have received a copy of the LSST License Statement and
 * the GNU General Public License along with this program.  If not,
 * see <http://www.lsstcorp.org/LegalNotices/>.
 *
 */

package org.lsst.testing.app;

import org.lsst.testing.app.salcomponent.CommandableSalComponent;

import java.util.concurrent.SynchronousQueue;

/**
 * <h2>Entity</h2>
 * <p>
 * {@code Entity} is a Context class implementation in the state pattern
 */
public class Entity implements DomainObject {

  @Override
  public String getName() {
    return "Entity->" + this._etype.toString();
  }

  /*
   * The state/etype of Commandable Entity
   */
  protected EntityType _etype;

  private EntityState _state; // association via composition
  private Integer _stateValue;
  private Integer _nextStateValue;

  public SynchronousQueue<Integer> _modelStateTransitionQ = new SynchronousQueue<>();
  public SynchronousQueue<Integer> _viewStateTransitionQ = new SynchronousQueue<>();

  /*
   * Command Receiver
   */
  protected CommandableSalComponent _salComponent;

  public Entity( CommandableSalComponent csc ) {

    this._salComponent = csc;
    this._state = new OfflineState();
  }

  public CommandableSalComponent getCSC() {
    return _salComponent;
  }

  public void setCSC( CommandableSalComponent csc ) {
    this._salComponent = csc;
  }

  public Entity( EntityType etype ) {

    /*
     * Starting up & initial transition to OfflineState
     */
    this._etype = etype;

    this._state = new OfflineState();
  }

  public String getEntityType() {
    return _etype.toString();
  }

  public void setState( EntityState state ) {
    _state = state;
  }

  public EntityState getState() {
    return _state;
  }

  public void setStateValue( Integer stateValue ) {
    _stateValue = stateValue;
  }

  public Integer getStateValue() {
    return _stateValue;
  }

  public void setNextStateValue( Integer nextStateValue ) {
    _nextStateValue = nextStateValue;
  }

  public Integer getNextStateValue() {
    return _nextStateValue;
  }

  /*
   * Delegate to the entity state object & pass the this ptr
   */
  public void enterControl() {
    this._state.enterControl( this );
  }

  public void start() {
    this._state.start( this );
  }

  public void enable() {
    this._state.enable( this );
  }

  public void disable() {
    this._state.disable( this );
  }

  public void standby() {
    this._state.standby( this );
  }

  public void exitControl() {
    this._state.exitControl( this );
  }

}
