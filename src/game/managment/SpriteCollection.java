package game.managment;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import biuoop.DrawSurface;
import gamePhysics.shapes.Sprite;
import java.util.ArrayList;
/**
 * collection of sprites.
 * enables to easily manage all the sprites in a given game.
 */
public class SpriteCollection {
 private ArrayList<Sprite> sprites = new ArrayList<Sprite>();
 /**
  * adds new sprite to the collection.
  * @param s the new sprite.
  */
 public void addSprite(Sprite s) {
  this.sprites.add(s);
 }
 /**
  * Call timePassed() on all sprites.
  */
 public void notifyAllTimePassed() {
  ArrayList<Sprite> sprites = new ArrayList<Sprite>(this.sprites);
  for (Sprite sprite : sprites) {
   sprite.timePassed();
  }
 }
 /**
  * Call drawOn(d) on all sprites.
  * @param d drawsurface object used to draw the sprites.
  */
 public void drawAllOn(DrawSurface d) {
  ArrayList<Sprite> sprites = new ArrayList<Sprite>(this.sprites);
  for (Sprite sprite : sprites) {
   sprite.drawOn(d);
  }
 }
 /**
  * Removes specific sprite from the list.
  * @param s sprite to remove.
  */
 public void removeSprite(Sprite s) {
  sprites.remove(s);
 }
}
