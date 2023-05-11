package gamePhysics.shapes;
/**
 * @author almog mesilaty
 * @ID 314973686
 */
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * Background for the "Final Four" level.
 */
public class FinalFourBackground implements Sprite {
 /**
  * draw the sprite to the screen.
  * @param d drawSurface object used to draw the sprite.
  */
 public void drawOn(DrawSurface d) {
  //Background color.
  d.setColor(new Color(23, 136, 208));
  d.fillRectangle(0, 20, 800, 800);
  //Rain1.
  d.setColor(Color.WHITE);
  for (int i = 125; i <= 225; i += 10) {
   d.drawLine(i, 400, (i - 25), 600);
  }
  //Cloud1.
  d.setColor(new Color(202, 202, 203));
  d.fillCircle(130, 395, 20);
  d.fillCircle(140, 420, 20);
  d.setColor(new Color(186, 186, 187));
  d.fillCircle(160, 390, 25);
  d.setColor(new Color(169, 169, 170));
  d.fillCircle(200, 400, 30);
  d.fillCircle(170, 420, 20);
  //Rain2.
  d.setColor(Color.WHITE);
  for (int i = 615; i <= 715; i += 10) {
   d.drawLine(i, 500, (i - 30), 600);
  }
  //Cloud2.
  d.setColor(new Color(202, 202, 203));
  d.fillCircle(630, 495, 20);
  d.fillCircle(640, 520, 20);
  d.setColor(new Color(186, 186, 187));
  d.fillCircle(660, 490, 25);
  d.setColor(new Color(169, 169, 170));
  d.fillCircle(700, 500, 30);
  d.fillCircle(670, 520, 20);
 }
 /**
  * Notify the sprite that time has passed.
  */
 public void timePassed() { }
}
