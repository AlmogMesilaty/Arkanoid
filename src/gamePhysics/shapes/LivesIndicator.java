package gamePhysics.shapes;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import biuoop.DrawSurface;
import game.managment.Counter;
import java.awt.Color;
/**
 * Indicates the number of lives ths player has.
 */
public class LivesIndicator implements Sprite {
 private Counter lives;
 /**
  * Builder.
  * @param lives Game lives.
  */
 public LivesIndicator(Counter lives) {
  this.lives = lives;
 }
 /**
  * draw the sprite to the screen.
  * @param d drawSurface object used to draw the sprite.
  */
 public void drawOn(DrawSurface d) {
  d.setColor(Color.BLACK);
  d.drawText(150, 18, this.toString(), 15);
 }
 /**
  * Notify the sprite that time has passed.
  */
 public void timePassed() {
 }
 /**
  * Send the lives as a string representation.
  * @return string representation of lives.
  */
 public String toString() {
  return "Lives: " + String.valueOf(this.lives.getValue());
 }
}
