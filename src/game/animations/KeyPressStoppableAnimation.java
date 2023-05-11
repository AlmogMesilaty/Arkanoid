package game.animations;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * Animation implementations that wait for a key press.
 */
public class KeyPressStoppableAnimation implements Animation {
 private KeyboardSensor ks;
 private String key;
 private Animation animation;
 private boolean stop;
 private boolean isAlreadyPressed;
 /**
  * Constructor.
  * @param sensor
  * @param key
  * @param animation
  */
 public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
  this.ks = sensor;
  this.key = key;
  this.animation = animation;
  this.stop = false;
  this.isAlreadyPressed = true;
 }
 /**
  * Checks if key was pressed if so draws pause screen using draw surface.
  * @param d Draw surface object.
  */
 public void doOneFrame(DrawSurface d) {
  animation.doOneFrame(d);
  if (this.ks.isPressed(this.key) && !isAlreadyPressed) {
   this.stop = true;
  } else if (!this.ks.isPressed(this.key)) {
   this.isAlreadyPressed = false;
  }
 }
 /**
  * Returns if the game should be returned or not according to user keyboard input.
  * @return true if space was pressed and false otherwise.
  */
 public boolean shouldStop() {
  return this.stop;
 }
}
