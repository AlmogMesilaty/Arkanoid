package game.animations;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import biuoop.DrawSurface;
/**
 * Enables the user to stop the game using p button in the keyboard.
 */
public class PauseScreen implements Animation {
 private boolean stop = false;
  /**
  * Checks if "p" was pressed if so draws pause screen using draw surface.
  * @param d Draw surface object.
  */
 public void doOneFrame(DrawSurface d) {
  d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
 }
 /**
  * Returns if the game should be returned or not according to user keyboard input.
  * @return true if space was pressed and false otherwise.
  */
 public boolean shouldStop() {
  return this.stop;
 }
}
