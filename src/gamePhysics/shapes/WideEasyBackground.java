package gamePhysics.shapes;
/**
 * @author almog mesilaty
 * @ID 314973686
 */
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.Random;

/**
 * The background for "Wide Easy" level.
 */
public class WideEasyBackground implements Sprite {
 /**
  * draw the sprite to the screen.
  * @param d drawSurface object used to draw the sprite.
  */
 public void drawOn(DrawSurface d) {
  //Background color.
  d.setColor(Color.WHITE);
  d.fillRectangle(0, 20, 800, 800);
  //Target.
  d.setColor(new Color(237, 229, 176));
  Random rand = new Random();
  for (int i = 0; i <= 100; i++) {
   d.drawLine(rand.nextInt(760), 250, 150, 120);
  }
  d.fillCircle(150, 120, 70);
  d.setColor(new Color(234, 213, 73));
  d.fillCircle(150, 120, 60);
  d.setColor(Color.YELLOW.brighter());
  d.fillCircle(150, 120, 50);
 }
 /**
  * Notify the sprite that time has passed.
  */
 public void timePassed() { }
}
