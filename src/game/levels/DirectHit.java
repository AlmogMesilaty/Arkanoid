package game.levels;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import gamePhysics.Velocity;
import gamePhysics.shapes.DirectHitBackground;
import gamePhysics.shapes.Sprite;
import gamePhysics.shapes.Block;
import geometry.Point;
import geometry.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * Specifies the information required to fully describe direct hit level.
 */
public class DirectHit implements LevelInformation {
 private ArrayList<Block> blocks = new ArrayList<Block>();
 /**
  * The number of balls in this level.
  * @return Current number of balls in the level.
  */
 public int numberOfBalls() {
  return 1;
 }
 /**
  * The initial velocity of each ball.
  * Note that initialBallVelocities().size() == numberOfBalls()
  * @return List of balls velocities.
  */
 public List<Velocity> initialBallVelocities() {
  List<Velocity> velocities = new ArrayList<Velocity>();
  velocities.add(new Velocity(0, -5));
  return velocities;
 }
 /**
  * Speed of the Paddle.
  * @return Paddle speed.
  */
 public int paddleSpeed() {
  return 10;
 }
 /**
  * Paddle width.
  * @return Paddle width.
  */
 public int paddleWidth() {
  return 90;
 }
 /**
  * The level name will be displayed at the top of the screen.
  * @return Level name in string.
  */
 public String levelName() {
  return "Direct Hit";
 }
 /**
  * Returns a sprite with the background of the level.
  * @return The background sprite.
  */
 public Sprite getBackground() {
  return new DirectHitBackground();
 }
 /**
  * The Blocks that make up this level, each block contains
  * its size, color and location.
  * @return List of level blocks.
  */
 public List<Block> blocks() {
  geometry.Point upperLeft = new Point(390, 150);
  Rectangle rec = new Rectangle(upperLeft, 40, 40);
  rec.setColor(Color.red);
  Block block = new Block(rec);
  this.blocks.add(block);
  return this.blocks;
 }
 /**
  * Number of blocks that should be removed
  * before the level is considered to be "cleared".
  * This number should be <= blocks.size();
  * @return Number of blocks to remove.
  */
 public int numberOfBlocksToRemove() {
  return this.blocks.size();
 }
 }
