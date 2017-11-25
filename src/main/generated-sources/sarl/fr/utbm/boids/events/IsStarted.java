package fr.utbm.boids.events;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Event;

/**
 * event pour prévenir l'environnement que le Boids est lancé
 */
@SarlSpecification("0.6")
@SarlElementType(14)
@SuppressWarnings("all")
public class IsStarted extends Event {
  @SyntheticMember
  public IsStarted() {
    super();
  }
  
  @SyntheticMember
  public IsStarted(final Address source) {
    super(source);
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 588368462L;
}
