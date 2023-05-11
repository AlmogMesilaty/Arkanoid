package game.levels;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import gamePhysics.Velocity;
import gamePhysics.shapes.Block;
import gamePhysics.shapes.FinalFourBackground;
import gamePhysics.shapes.Sprite;
import geometry.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * Class that has all information regarding Final Four level.
 */
public class FinalFour implements LevelInformation {
 private ArrayList<Block> blocks = new ArrayList<Block>();
 /**
  * The number of balls in this level.
  * @return Current number of balls in the level.
  */
 public int numberOfBalls() {
  return 3;
 }
 /**
  * The initial velocity of each ball.
  * Note that initialBallVelocities().size() == numberOfBalls()
  * @return List of balls velocities.
  */
 public List<Velocity> initialBallVelocities() {
  List<Velocity> velocities = new ArrayList<Velocity>();
  velocities.add(new Velocity(-2, -4));
  velocities.add(new Velocity(0, -6));
  velocities.add(new Velocity(2, -4));
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
  return "Final Four";
 }
 /**
  * Returns a sprite with the background of the level.
  * @return The background sprite.
  */
 public Sprite getBackground() {
  return new FinalFourBackground();
 }
 /**
  * The Blocks that make up this level, each block contains
  * its size, color and location.
  * @return List of level blocks.
  */
 public List<Block> blocks() {
  int iterator = 0;
  ArrayList<Color> colors = new ArrayList<Color>();
  colors.add(Color.GRAY);
  colors.add(Color.RED);
  colors.add(Color.GREEN);
  colors.add(Color.WHITE);
  colors.add(Color.pink);
  colors.add(Color.cyan);
  for (int j = 100; j <= 250; j += 30) {
   for (int i = 10; i < 790; i += 52) {
    geometry.Point upperLeft1 = new geometry.Point(i, j);
    Rectangle rec1 = new Rectangle(upperLeft1, 52, 30);
    rec1.setColor(colors.get(iterator));
    Block block1 = new Block(rec1);
    this.blocks.add(block1);
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
