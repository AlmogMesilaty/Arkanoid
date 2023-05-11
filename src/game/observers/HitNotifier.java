package game.observers;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
/**
 * HitNotifier.
 * Objects that send notifications upon hitting them.
 */
public interface HitNotifier {
 /**
  * Add hl as a listener to hit event.
  * @param hl listener to add.
  */
 void addHitListener(HitListener hl);
 /**
  * Remove hl from the list of listeners to hit event.
  * @param hl listener to be removed.
  */
 void removeHitListener(HitListener hl);
}
