package gamePhysics.shapes;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * Indicates the level name on the screen.
 */
public class LevelIndicator implements Sprite {
 private String levelName;
 /**
  * Builder.
  * @param levelName Name of level.
  */
 public LevelIndicator(String levelName) {
  this.levelName = levelName;
 }
 /**
  * draw the sprite to the screen.
  * @param d drawSurface object used to draw the sprite.
  */
 public void drawOn(DrawSurface d) {
  d.setColor(Color.BLACK);
  d.drawText(550, 18, this.toString(), 15);
 }
 /**
  * Notify the sprite that time has passed.
  */
 public void timePassed() {
 }
 /**
  * Send the score as a string representation.
  * @return string representation of score.
  */
 public String toString() {
  return "Level Name: " + this.levelName;
 }
}
