package fr.utbm.boids.agents;

import fr.utbm.boids.Configuration;
import fr.utbm.boids.agents.Environment;
import fr.utbm.boids.agents.TimeManager;
import fr.utbm.boids.environment.Obstacle;
import fr.utbm.boids.events.BoidsReady;
import fr.utbm.boids.events.ConfigureSimulation;
import fr.utbm.boids.events.StartingSimulation;
import fr.utbm.boids.events.TimeManagingStart;
import fr.utbm.boids.gui.BoidsFxViewerController;
import fr.utbm.boids.gui.fx.EndSimulation;
import io.sarl.core.Behaviors;
import io.sarl.core.Initialize;
import io.sarl.core.InnerContextAccess;
import io.sarl.core.Lifecycle;
import io.sarl.core.Logging;
import io.sarl.lang.annotation.ImportedCapacityFeature;
import io.sarl.lang.annotation.PerceptGuardEvaluator;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.BuiltinCapacitiesProvider;
import io.sarl.lang.core.DynamicSkillProvider;
import io.sarl.lang.core.Skill;
import io.sarl.lang.core.SpaceID;
import io.sarl.lang.util.ClearableReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Inline;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.6")
@SarlElementType(17)
@SuppressWarnings("all")
public class BootAgent extends Agent {
  private int map;
  
  private int boidsQuantity;
  
  private int boidsPopulation;
  
  private int boidsVision;
  
  private boolean exited = false;
  
  private BoidsFxViewerController ctrl = null;
  
  @SyntheticMember
  private void $behaviorUnit$Initialize$0(final Initialize occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    UUID _iD = this.getID();
    String _plus = ("BootAgent-" + _iD);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.setLoggingName(_plus);
    Object _get = occurrence.parameters[0];
    this.ctrl = ((BoidsFxViewerController) _get);
    Behaviors _$CAPACITY_USE$IO_SARL_CORE_BEHAVIORS$CALLER = this.$castSkill(Behaviors.class, (this.$CAPACITY_USE$IO_SARL_CORE_BEHAVIORS == null || this.$CAPACITY_USE$IO_SARL_CORE_BEHAVIORS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_BEHAVIORS = this.$getSkill(Behaviors.class)) : this.$CAPACITY_USE$IO_SARL_CORE_BEHAVIORS);
    this.ctrl.getUISpace().register(_$CAPACITY_USE$IO_SARL_CORE_BEHAVIORS$CALLER.asEventListener());
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_1 = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_1.info("Starting simulation");
    Lifecycle _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER = this.$castSkill(Lifecycle.class, (this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE == null || this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE = this.$getSkill(Lifecycle.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE);
    InnerContextAccess _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER = this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
    _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER.spawnInContext(Environment.class, _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER.getInnerContext(), this.ctrl);
    Lifecycle _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER_1 = this.$castSkill(Lifecycle.class, (this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE == null || this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE = this.$getSkill(Lifecycle.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE);
    InnerContextAccess _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER_1 = this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
    _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER_1.spawnInContext(TimeManager.class, _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER_1.getInnerContext());
  }
  
  @SyntheticMember
  private void $behaviorUnit$ConfigureSimulation$1(final ConfigureSimulation occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info("Configuration of the environment...");
    this.boidsQuantity = occurrence.boidsQuantity;
    this.map = occurrence.mapSelection;
    this.boidsPopulation = occurrence.boidsPopulation;
    this.boidsVision = occurrence.boidsVision;
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_1 = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_1.info(("Map: " + Integer.valueOf(this.map)));
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_2 = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_2.info(("Boids quantity: " + Integer.valueOf(this.boidsQuantity)));
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_3 = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_3.info(("Boids population: " + Integer.valueOf(this.boidsPopulation)));
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_4 = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_4.info(("Boids vision: " + Integer.valueOf(this.boidsVision)));
    this.generateMap();
  }
  
  /**
   * Demande à la GUI de générer la map et fait débuter la simulation
   * @return {void}
   */
  protected void generateMap() {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info("Generating map...");
    List<Obstacle> obstacles = new ArrayList<Obstacle>();
    obstacles = this.ctrl.buildMap(this.map);
    InnerContextAccess _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER = this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
    StartingSimulation _startingSimulation = new StartingSimulation();
    _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER.getInnerContext().getDefaultSpace().emit(this.getID(), _startingSimulation, null);
  }
  
  @SyntheticMember
  private void $behaviorUnit$BoidsReady$2(final BoidsReady occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info("Boids are ready !");
    TimeManagingStart evt = new TimeManagingStart(Configuration.FREQUENCY);
    InnerContextAccess _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER = this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
    SpaceID _spaceID = _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER.getInnerContext().getDefaultSpace().getSpaceID();
    UUID _iD = this.getID();
    Address _address = new Address(_spaceID, _iD);
    evt.setSource(_address);
    InnerContextAccess _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER_1 = this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
    _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER_1.getInnerContext().getDefaultSpace().emit(this.getID(), evt, null);
  }
  
  @SyntheticMember
  private void $behaviorUnit$EndSimulation$3(final EndSimulation occurrence) {
    Lifecycle _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER = this.$castSkill(Lifecycle.class, (this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE == null || this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE = this.$getSkill(Lifecycle.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE);
    _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER.killMe();
  }
  
  @SyntheticMember
  @Pure
  private boolean $behaviorUnitGuard$EndSimulation$3(final EndSimulation it, final EndSimulation occurrence) {
    InnerContextAccess _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER = this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
    boolean _hasMemberAgent = _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER.hasMemberAgent();
    boolean _not = (!_hasMemberAgent);
    return _not;
  }
  
  @SyntheticMember
  private void $behaviorUnit$EndSimulation$4(final EndSimulation occurrence) {
    this.exited = true;
    InnerContextAccess _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER = this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
    EndSimulation _endSimulation = new EndSimulation();
    _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER.getInnerContext().getDefaultSpace().emit(this.getID(), _endSimulation, null);
  }
  
  @SyntheticMember
  @Pure
  private boolean $behaviorUnitGuard$EndSimulation$4(final EndSimulation it, final EndSimulation occurrence) {
    return (this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS).hasMemberAgent() && (!this.exited));
  }
  
  @Extension
  @ImportedCapacityFeature(Logging.class)
  @SyntheticMember
  private transient ClearableReference<Skill> $CAPACITY_USE$IO_SARL_CORE_LOGGING;
  
  @SyntheticMember
  @Pure
  @Inline(value = "$castSkill(Logging.class, ($0$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || $0$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? ($0$CAPACITY_USE$IO_SARL_CORE_LOGGING = $0$getSkill(Logging.class)) : $0$CAPACITY_USE$IO_SARL_CORE_LOGGING)", imported = Logging.class)
  private Logging $CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER() {
    if (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) {
      this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = $getSkill(Logging.class);
    }
    return $castSkill(Logging.class, this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
  }
  
  @Extension
  @ImportedCapacityFeature(Behaviors.class)
  @SyntheticMember
  private transient ClearableReference<Skill> $CAPACITY_USE$IO_SARL_CORE_BEHAVIORS;
  
  @SyntheticMember
  @Pure
  @Inline(value = "$castSkill(Behaviors.class, ($0$CAPACITY_USE$IO_SARL_CORE_BEHAVIORS == null || $0$CAPACITY_USE$IO_SARL_CORE_BEHAVIORS.get() == null) ? ($0$CAPACITY_USE$IO_SARL_CORE_BEHAVIORS = $0$getSkill(Behaviors.class)) : $0$CAPACITY_USE$IO_SARL_CORE_BEHAVIORS)", imported = Behaviors.class)
  private Behaviors $CAPACITY_USE$IO_SARL_CORE_BEHAVIORS$CALLER() {
    if (this.$CAPACITY_USE$IO_SARL_CORE_BEHAVIORS == null || this.$CAPACITY_USE$IO_SARL_CORE_BEHAVIORS.get() == null) {
      this.$CAPACITY_USE$IO_SARL_CORE_BEHAVIORS = $getSkill(Behaviors.class);
    }
    return $castSkill(Behaviors.class, this.$CAPACITY_USE$IO_SARL_CORE_BEHAVIORS);
  }
  
  @Extension
  @ImportedCapacityFeature(InnerContextAccess.class)
  @SyntheticMember
  private transient ClearableReference<Skill> $CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS;
  
  @SyntheticMember
  @Pure
  @Inline(value = "$castSkill(InnerContextAccess.class, ($0$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || $0$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? ($0$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = $0$getSkill(InnerContextAccess.class)) : $0$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS)", imported = InnerContextAccess.class)
  private InnerContextAccess $CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER() {
    if (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) {
      this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = $getSkill(InnerContextAccess.class);
    }
    return $castSkill(InnerContextAccess.class, this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
  }
  
  @Extension
  @ImportedCapacityFeature(Lifecycle.class)
  @SyntheticMember
  private transient ClearableReference<Skill> $CAPACITY_USE$IO_SARL_CORE_LIFECYCLE;
  
  @SyntheticMember
  @Pure
  @Inline(value = "$castSkill(Lifecycle.class, ($0$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE == null || $0$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE.get() == null) ? ($0$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE = $0$getSkill(Lifecycle.class)) : $0$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE)", imported = Lifecycle.class)
  private Lifecycle $CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER() {
    if (this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE == null || this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE.get() == null) {
      this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE = $getSkill(Lifecycle.class);
    }
    return $castSkill(Lifecycle.class, this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE);
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$Initialize(final Initialize occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$Initialize$0(occurrence));
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$BoidsReady(final BoidsReady occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$BoidsReady$2(occurrence));
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$EndSimulation(final EndSimulation occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    if ($behaviorUnitGuard$EndSimulation$3(occurrence, occurrence)) {
      ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$EndSimulation$3(occurrence));
    }
    if ($behaviorUnitGuard$EndSimulation$4(occurrence, occurrence)) {
      ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$EndSimulation$4(occurrence));
    }
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$ConfigureSimulation(final ConfigureSimulation occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$ConfigureSimulation$1(occurrence));
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    BootAgent other = (BootAgent) obj;
    if (other.map != this.map)
      return false;
    if (other.boidsQuantity != this.boidsQuantity)
      return false;
    if (other.boidsPopulation != this.boidsPopulation)
      return false;
    if (other.boidsVision != this.boidsVision)
      return false;
    if (other.exited != this.exited)
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + this.map;
    result = prime * result + this.boidsQuantity;
    result = prime * result + this.boidsPopulation;
    result = prime * result + this.boidsVision;
    result = prime * result + (this.exited ? 1231 : 1237);
    return result;
  }
  
  @SyntheticMember
  public BootAgent(final UUID parentID, final UUID agentID) {
    super(parentID, agentID);
  }
  
  @SyntheticMember
  @Inject
  @Deprecated
  public BootAgent(final BuiltinCapacitiesProvider provider, final UUID parentID, final UUID agentID) {
    super(provider, parentID, agentID);
  }
  
  @SyntheticMember
  @Inject
  public BootAgent(final UUID parentID, final UUID agentID, final DynamicSkillProvider skillProvider) {
    super(parentID, agentID, skillProvider);
  }
}
