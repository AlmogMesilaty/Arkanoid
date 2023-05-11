package gamePhysics.shapes;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import biuoop.DrawSurface;
import game.managment.Counter;
import java.awt.Color;
/**
 * Displays game score.
 */
public class ScoreIndicator implements Sprite {
 private Counter score;
 /**
  * Builder.
  * @param score Game score.
  */
 public ScoreIndicator(Counter score) {
  this.score = score;
 }
 /**
  * draw the sprite to the screen.
  * @param d drawSurface object used to draw the sprite.
  */
 public void drawOn(DrawSurface d) {
  d.setColor(Color.BLACK);
  d.drawText(350, 18, this.toString(), 15);
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
  return "Score: " + String.valueOf(this.score.getValue());
 }
}
