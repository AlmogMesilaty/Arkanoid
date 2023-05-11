package gamePhysics.shapes;
/**
 * @author almog mesilaty
 * @ID 314973686
 */
import biuoop.DrawSurface;
import game.animations.GameLevel;
import game.observers.BallRemover;
import geometry.Rectangle;
import java.awt.Color;
/**
 * game object that can be drawn to the screen (and which is not just a background image).
 * Sprites can be drawn on the screen, and can be notified that
 * time has passed (so that they know to change their position / shape / appearance / etc).
 */
public class GameBorder implements Sprite {
 private Block upWall;
 private Block rightWall;
 private Block deathZone;
 private Block leftWall;
 /**
  * Constructor.
  * @param ballRemover The game ball remover.
  */
 public GameBorder(BallRemover ballRemover) {
  //Up wall.
  geometry.Point upperLeft2 = new geometry.Point(0, 20);
  Rectangle rec2 = new Rectangle(upperLeft2, 800, 10);
  this.upWall = new Block(rec2);
  this.upWall.getCollisionRectangle().setColor(Color.GRAY);
  //Right wall.
  geometry.Point upperLeft3 = new geometry.Point(790, 30);
  Rectangle rec3 = new Rectangle(upperLeft3, 10, 590);
  this.rightWall = new Block(rec3);
  this.rightWall.getCollisionRectangle().setColor(Color.GRAY);
  //Death Zone.
  geometry.Point upperLeft4 = new geometry.Point(10, 600);
  Rectangle rec4 = new Rectangle(upperLeft4, 780, 10);
  this.deathZone = new Block(rec4);
  this.deathZone.getCollisionRectangle().setColor(Color.GRAY);
  this.deathZone.addHitListener(ballRemover);
  //Left wall.
  geometry.Point upperLeft5 = new geometry.Point(0, 30);
  Rectangle rec5 = new Rectangle(upperLeft5, 10, 590);
  this.leftWall = new Block(rec5);
  this.leftWall.getCollisionRectangle().setColor(Color.GRAY);
 }
 /**
  * draw the sprite to the screen.
  * @param d drawSurface object used to draw the sprite.
  */
 public void drawOn(DrawSurface d) {
  this.upWall.drawOn(d);
  this.rightWall.drawOn(d);
  this.leftWall.drawOn(d);
 }
 /**
  * Notify the sprite that time has passed.
  */
 public void timePassed() {
  this.upWall.timePassed();
  this.rightWall.timePassed();
  this.deathZone.timePassed();
  this.leftWall.timePassed();
 }
 /**
  * Adds block into a game.
  * @param g the game to add to.
  */
 public void addToGame(GameLevel g) {
  this.upWall.addToGame(g);
  this.rightWall.addToGame(g);
  this.deathZone.addToGame(g);
  this.leftWall.addToGame(g);
 }
}