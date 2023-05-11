package game.animations;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import biuoop.DrawSurface;
/**
 * Animation that appears at the end of the game,
 * shows the score and a massage for the player.
 */
public class EndScreen implements Animation {
 private String screenMassage;
 private boolean stop = false;
 /**
  * Constructor.
  * @param screenMassage Winner / Looser massage sent from game flow.
  */
 public EndScreen(String screenMassage) {
  this.screenMassage = screenMassage;
 }
 /**
  * Checks if "p" was pressed if so draws pause screen using draw surface.
  * @param d Draw surface object.
  */
 public void doOneFrame(DrawSurface d) {
  d.drawText(10, d.getHeight() / 2, this.screenMassage, 32);
 }
 /**
  * Returns if the game should be returned or not according to user keyboard input.
  * @return true if space was pressed and false otherwise.
  */
 public boolean shouldStop() {
  return this.stop;
 }
}
