package gamePhysics.shapes;
/**
 * @author almog mesilaty
 * @ID 314973686
 */
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * The background for Green 3 level.
 */
public class Green3Background implements Sprite {
 /**
  * draw the sprite to the screen.
  * @param d drawSurface object used to draw the sprite.
  */
 public void drawOn(DrawSurface d) {
  //Background color
  d.setColor(new Color(42, 130, 21));
  d.fillRectangle(0, 20, 800, 800);
  d.setColor(Color.WHITE);
  //Center
  d.drawCircle(410, 300, 50);
  d.drawCircle(410, 350, 50);
  d.drawCircle(410, 400, 50);
  //Left
  d.drawCircle(360, 325, 50);
  d.drawCircle(360, 375, 50);
  //Right
  d.drawCircle(460, 325, 50);
  d.drawCircle(460, 375, 50);
  //Tower
  d.setColor(new Color(46, 42, 42));
  d.fillRectangle(40, 400, 105, 200);
  //Antenna
  d.setColor(new Color(62, 58, 58));
  d.fillRectangle(82, 360, 20, 40);
  d.setColor(new Color(77, 73, 73));
  d.fillRectangle(87, 210, 10, 150);
  d.setColor(new Color(253, 253, 254));
  //Antenna lights
  d.setColor(new Color(214, 171, 102));
  d.fillCircle(92, 205, 10);
  d.setColor(new Color(244, 76, 55));
  d.fillCircle(92, 205, 7);
  d.setColor(Color.WHITE);
  d.fillCircle(92, 205, 2);
  //Windows
  for (int i = 410; i <= 590; i += 20) {
   for (int j = 45; j <= 130; j += 14) {
    d.fillRectangle(j, i, 10, 15);
   }
  }
 }
 /**
  * Notify the sprite that time has passed.
  */
 public void timePassed() { }
}
