package gamePhysics.shapes;
/**
 * @author almog mesilaty
 * @ID 314973686
 */
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * game object that can be drawn to the screen (and which is not just a background image).
 * Sprites can be drawn on the screen, and can be notified that
 * time has passed (so that they know to change their position / shape / appearance / etc).
 */
public class DirectHitBackground implements Sprite {
  /**
   * draw the sprite to the screen.
   * @param d drawSurface object used to draw the sprite.
   */
  public void drawOn(DrawSurface d) {
   //Background color.
   d.setColor(Color.BLACK);
   d.fillRectangle(0, 20, 800, 800);
   //Target.
   d.setColor(Color.BLUE);
   d.drawCircle(410, 170, 120);
   d.drawCircle(410, 170, 90);
   d.drawCircle(410, 170, 60);
   d.drawLine(280, 170, 380, 170);
   d.drawLine(440, 170, 540, 170);
   d.drawLine(410, 140, 410, 40);
   d.drawLine(410, 200, 410, 300);
  }
  /**
   * Notify the sprite that time has passed.
   */
  public void timePassed() { }
}
