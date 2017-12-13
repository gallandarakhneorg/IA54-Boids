package fr.utbm.boids.events;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Event;

/**
 * Evenement déclenché lorsque les boids sont prêts
 */
@SarlSpecification("0.6")
@SarlElementType(14)
@SuppressWarnings("all")
public class BoidsSideReady extends Event {
  @SyntheticMember
  public BoidsSideReady() {
    super();
  }
  
  @SyntheticMember
  public BoidsSideReady(final Address source) {
    super(source);
  }
}
