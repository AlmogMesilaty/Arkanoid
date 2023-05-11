package game.animations;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
/**
 * Runs an animation object.
 */
public class AnimationRunner {
 private GUI gui;
 private int framesPerSecond = 60;
 private Sleeper sleeper = new Sleeper();
 /**
  * Constructor.
  * @param levelName Current level name.
  */
 public AnimationRunner(String levelName) {
  this.framesPerSecond = framesPerSecond;
  this.gui = new GUI(levelName, 800, 600);
 }
 /**
  * Takes an animation object and runs it, managing gui and frames.
  * @param animation The animation object to run.
  */
 public void run(Animation animation) {
  int millisecondsPerFrame = 1000 / this.framesPerSecond;
  while (!animation.shouldStop()) {
   long startTime = System.currentTimeMillis(); // timing
   DrawSurface d = gui.getDrawSurface();

   animation.doOneFrame(d);

   gui.show(d);
   // timing
   long usedTime = System.currentTimeMillis() - startTime;
   long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
   if (milliSecondLeftToSleep > 0) {
    this.sleeper.sleepFor(milliSecondLeftToSleep);
   }
  }
 }
 /**
  * Enables gameLevels to get keyboard sensor for their paddle.
  * @return Keyboard sensor.
  */
 public KeyboardSensor getKeyboardSensor() {
  return this.gui.getKeyboardSensor();
 }
 /**
  * Changes the number of seconds per screen.
  * @param num New number seconds per screen.
  */
 public void setSecondsPerScreen(int num) {
  this.framesPerSecond = num;
 }
}
