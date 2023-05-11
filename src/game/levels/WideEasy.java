package game.levels;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import gamePhysics.Velocity;
import gamePhysics.shapes.Block;
import gamePhysics.shapes.WideEasyBackground;
import gamePhysics.shapes.Sprite;
import geometry.Point;
import geometry.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * Specifies the information for "Wide Easy" level.
 */
public class WideEasy implements LevelInformation {
 private ArrayList<Block> blocks = new ArrayList<Block>();
 /**
  * The number of balls in this level.
  * @return Current number of balls in the level.
  */
 public int numberOfBalls() {
  return 10;
 }
 /**
  * The initial velocity of each ball.
  * Note that initialBallVelocities().size() == numberOfBalls()
  * @return List of balls velocities.
  */
 public List<Velocity> initialBallVelocities() {
  List<Velocity> velocities = new ArrayList<Velocity>();
  for (double i = 270; i <= 336; i += 6) {
   Velocity velocity = Velocity.fromAngleAndSpeed(i, 5);
   velocities.add(velocity);
   if (i == 294) {
    i += 6;
   }
  }
  return velocities;
 }
 /**
  * Speed of the Paddle.
  * @return Paddle speed.
  */
 public int paddleSpeed() {
  return 1;
 }
 /**
  * Paddle width.
  * @return Paddle width.
  */
 public int paddleWidth() {
  return 700;
 }
 /**
  * The level name will be displayed at the top of the screen.
  * @return Level name in string.
  */
 public String levelName() {
  return "Wide Easy";
 }
 /**
  * Returns a sprite with the background of the level.
  * @return The background sprite.
  */
 public Sprite getBackground() {
  return new WideEasyBackground();
 }
 /**
  * The Blocks that make up this level, each block contains
  * its size, color and location.
  * @return List of level blocks.
  */
 public List<Block> blocks() {
  int gap = 52;
  int iterator = 0;
  ArrayList<Color> colors = new ArrayList<Color>();
  colors.add(Color.RED);
  colors.add(Color.orange);
  colors.add(Color.yellow);
  colors.add(Color.green);
  colors.add(Color.blue);
  colors.add(Color.pink);
  colors.add(Color.cyan);
  for (int i = 10; i <= 780; i += 104) {
   geometry.Point upperLeft1 = new Point(i, 250);
   geometry.Point upperLeft2 = new Point((i + gap), 250);
   Rectangle rec1 = new Rectangle(upperLeft1, 52, 30);
   Rectangle rec2 = new Rectangle(upperLeft2, 52, 30);
   rec1.setColor(colors.get(iterator));
   rec2.setColor(colors.get(iterator));
   Block block1 = new Block(rec1);
   Block block2 = new Block(rec2);
   this.blocks.add(block1);
   this.blocks.add(block2);
   if ((i + gap) == 374) {
    i += gap;
    geometry.Point upperLeft3 = new Point((i + gap), 250);
    Rectangle rec3 = new Rectangle(upperLeft3, 52, 30);
    rec3.setColor(Color.green);
    Block block3 = new Block(rec3);
    this.blocks.add(block3);
   }
   iterator++;
  }
  return blocks;
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
