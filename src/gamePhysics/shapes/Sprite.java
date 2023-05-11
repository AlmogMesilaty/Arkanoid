package gamePhysics.shapes;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import biuoop.DrawSurface;
/**
 * game object that can be drawn to the screen (and which is not just a background image).
 * Sprites can be drawn on the screen, and can be notified that
 * time has passed (so that they know to change their position / shape / appearance / etc).
 */
public interface Sprite {
 /**
  * draw the sprite to the screen.
  * @param d drawSurface object used to draw the sprite.
  */
 void drawOn(DrawSurface d);
 /**
  * Notify the sprite that time has passed.
  */
 void timePassed();
}
