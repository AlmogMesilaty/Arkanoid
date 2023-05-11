package game.animations;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import biuoop.DrawSurface;
import game.managment.SpriteCollection;
import biuoop.Sleeper;
import gamePhysics.shapes.Sprite;
import java.awt.Color;
/**
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
 private double numOfSeconds;
 private int countFrom;
 private SpriteCollection gameScreen;
 private boolean running;
 private Sleeper sleeper = new Sleeper();
 private long millisecondsPerFrame;
 private Sprite background;
 /**
  * Constructor.
  * @param numOfSeconds The amount of seconds before game starts.
  * @param countFrom The number to start the count from.
  * @param gameScreen Given game screen.
  * @param background The background of the upcoming level.
  */
 public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen, Sprite background) {
  this.numOfSeconds = numOfSeconds;
  this.countFrom = countFrom;
  this.gameScreen = gameScreen;
  this.running = true;
  this.millisecondsPerFrame  = Math.round((this.numOfSeconds / this.countFrom) * 1000);
  this.background = background;
 }
 /**
  * Displays numbers from count from to zero in the center of the game screen.
  * @param d Draw surface object use to draw the number to the screen.
  */
 public void doOneFrame(DrawSurface d) {
  long startTime = System.currentTimeMillis();
   this.background.drawOn(d);
   this.gameScreen.drawAllOn(d);
  if (this.countFrom > 0) {
   d.setColor(Color.WHITE);
   d.drawText(d.getWidth() / 2 - 5, d.getHeight() / 2, String.valueOf(this.countFrom), 50);
   this.countFrom -= 1;
   long usedTime = System.currentTimeMillis() - startTime;
   long milliSecondLeftToSleep = this.millisecondsPerFrame - (usedTime + (1000 / 60));
   if (milliSecondLeftToSleep > 0) {
    this.sleeper.sleepFor(milliSecondLeftToSleep);
   }
  } else {
   long usedTime = System.currentTimeMillis() - startTime;
   long milliSecondLeftToSleep = this.millisecondsPerFrame - (usedTime + (1000 / 60));
   if (milliSecondLeftToSleep > 0) {
    this.sleeper.sleepFor(milliSecondLeftToSleep);
   }
   this.running = false;
  }
 }
 /**
  * Boolean variable indicates rather the animation should continue to run,
  * or stopped. According to the stopping conditions.
  * @return The current status of the animation.
  */
 public boolean shouldStop() {
  return !this.running;
 }
}
