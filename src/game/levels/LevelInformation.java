package game.levels;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import gamePhysics.Velocity;
import gamePhysics.shapes.Block;
import gamePhysics.shapes.Sprite;
import java.util.List;
/**
 * Specifies the information required to fully describe a level.
 */
public interface LevelInformation {
 /**
  * Number of balls that you start with in the level.
  * @return The number of balls.
  */
 int numberOfBalls();
 /**
  * The initial velocity of each ball.
  * Note that initialBallVelocities().size() == numberOfBalls()
  * @return List of balls velocities.
  */
 List<Velocity> initialBallVelocities();
 /**
  * Speed of the Paddle.
  * @return Paddle speed.
  */
 int paddleSpeed();
 /**
  * Paddle width.
  * @return Paddle width.
  */
 int paddleWidth();
 /**
  * The level name will be displayed at the top of the screen.
  * @return Level name in string.
  */
 String levelName();
 /**
  * Returns a sprite with the background of the level.
  * @return The background sprite.
  */
 Sprite getBackground();
 /**
  * The Blocks that make up this level, each block contains
  * its size, color and location.
  * @return List of level blocks.
  */
 List<Block> blocks();
 /**
  * Number of blocks that should be removed
  * before the level is considered to be "cleared".
  * This number should be <= blocks.size();
  * @return Number of blocks to remove.
  */
 int numberOfBlocksToRemove();
}
