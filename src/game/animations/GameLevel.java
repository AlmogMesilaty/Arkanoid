package game.animations;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import game.levels.LevelInformation;
import gamePhysics.shapes.LevelIndicator;
import game.managment.Counter;
import gamePhysics.shapes.LivesIndicator;
import gamePhysics.shapes.ScoreIndicator;
import game.managment.SpriteCollection;
import game.observers.BallRemover;
import game.observers.BallAdder;
import game.observers.BlockRemover;
import game.observers.ScoreTrackingListener;
import gamePhysics.Velocity;
import gamePhysics.collisionMechanisem.GameEnvironment;
import gamePhysics.collisionMechanisem.Collidable;
import gamePhysics.shapes.Sprite;
import gamePhysics.shapes.Ball;
import gamePhysics.shapes.Block;
import gamePhysics.shapes.Paddle;
import gamePhysics.shapes.GameBorder;
import geometry.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
/**
 * Creates the game and it's parts and runs it.
 */
public class GameLevel implements Animation {
 private SpriteCollection sprites;
 private GameEnvironment environment;
 private Counter remainingBlocks;
 private Counter remainingBalls;
 private Counter score;
 private Counter lives;
 private AnimationRunner runner;
 private boolean running;
 private KeyboardSensor keyboard;
 private Sprite backGround;
 private LevelInformation levelInformation;
 private Paddle paddle;
 /**
  * hold the sprites and the collidables,
  * and in charge of the animation.
  * @param levelInformation Current level information.
  * @param ar Animation runner sent from game flow class.
  * @param ks Keyboard sensor sent from game flow class.
  * @param score
  * @param lives
  */
 //Constructor.
 public GameLevel(LevelInformation levelInformation, KeyboardSensor ks,
                  AnimationRunner ar, Counter score, Counter lives) {
  this.sprites = new SpriteCollection();
  this.environment = new GameEnvironment();
  this.runner = ar;
  this.keyboard = ks;
  this.levelInformation = levelInformation;
  this.backGround = levelInformation.getBackground();
  this.score = score;
  this.lives = lives;
 }
 /**
  * Getter for game environment.
  * @return game environment.
  */
 public GameEnvironment getEnvironment() {
  return this.environment;
 }
 /**
  * add a colidable to the game collidable.
  * @param c new collidable.
  */
 public void addCollidable(Collidable c) {
  this.environment.addCollidable(c);
 }
 /**
  * add a sprite to the game sprites.
  * @param s the new sprite to add.
  */
 public void addSprite(Sprite s) {
  this.sprites.addSprite(s);
 }
 /**
  * Initialize a new game: create the Blocks and Ball (and Paddle),
  * and add them to the game.
  */
 public void initialize() {
  //Create balls counter.
  this.remainingBalls = new Counter();
  //Create blocks counter.
  this.remainingBlocks = new Counter();
  //Creates hit listeners.
  BlockRemover blockRemover = new BlockRemover(this, this.remainingBlocks);
  BallAdder ballAdder = new BallAdder(this, this.remainingBalls);
  BallRemover ballRemover = new BallRemover(this, this.remainingBalls);
  //Create scoreTrackingListener
  ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
  //Adds score indicator to game.
  this.addSprite(new ScoreIndicator(this.score));
  //Adds level indicator to game.
  this.addSprite(new LevelIndicator(this.levelInformation.levelName()));
  //Adds lives indicator to game.
  this.addSprite(new LivesIndicator(this.lives));
  //Game borders.
  GameBorder gameBorder = new GameBorder(ballRemover);
  gameBorder.addToGame(this);
  //Paddle.
  int paddleWidth = this.levelInformation.paddleWidth();
  int paddleSpeed = this.levelInformation.paddleSpeed();
  geometry.Point upperLeft = new geometry.Point(410 - (paddleWidth / 2), 570);
  Rectangle rec = new Rectangle(upperLeft, paddleWidth, 20);
  this.paddle = new Paddle(rec, this.keyboard, paddleSpeed);
  this.paddle.getCollisionRectangle().setColor(Color.yellow);
  this.paddle.addToGame(this);
  //Balls.
  ArrayList<Velocity> velocities = new ArrayList<Velocity>();
  velocities.addAll(this.levelInformation.initialBallVelocities());
  for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
   Ball ball = new Ball(410, 550, 5, Color.WHITE);
   ball.setVelocity(velocities.get(i));
   ball.setGameEnvironment(this.environment);
   remainingBalls.increase(1);
   ball.addToGame(this);
  }
  //Blocks.
  for (Block block : this.levelInformation.blocks()) {
   block.addHitListener(blockRemover);
   block.addHitListener(scoreTrackingListener);
   this.remainingBlocks.increase(1);
   block.addToGame(this);
  }
 }
 /**
  * Game partial initialization after you loose one life.
  */
 public void retry() {
  this.paddle.removeFromGame(this);
  //Paddle.
  int paddleWidth = this.levelInformation.paddleWidth();
  int paddleSpeed = this.levelInformation.paddleSpeed();
  geometry.Point upperLeft = new geometry.Point(410 - (paddleWidth / 2), 570);
  Rectangle rec = new Rectangle(upperLeft, paddleWidth, 20);
  this.paddle = new Paddle(rec, this.keyboard, paddleSpeed);
  this.paddle.getCollisionRectangle().setColor(Color.yellow);
  this.paddle.addToGame(this);
  //Balls.
  ArrayList<Velocity> velocities = new ArrayList<Velocity>();
  velocities.addAll(this.levelInformation.initialBallVelocities());
  for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
   Ball ball = new Ball(410, 550, 5, Color.WHITE);
   ball.setVelocity(velocities.get(i));
   ball.setGameEnvironment(this.environment);
   remainingBalls.increase(1);
   ball.addToGame(this);
  }
 }
 /**
  * Tell the caller if animation is still running or reached one of her
  * stopping conditions.
  * @return The opposite value of running.
  */
 public boolean shouldStop() {
  return !this.running;
 }
 /**
  * Run the game -- start the animation loop.
  */
 public void run() {
  this.runner.run(new CountdownAnimation(2, 3, this.sprites, this.backGround)); // Countdown before turn starts
  this.running = true;
  this.runner.run(this);
 }
 /**
  * Draws all game parts in their current state.
  * Notifies all sprites that time passed.
  * Checks if the new game state should stop or continue running.
  * @param d The frame drawing surface.
  */
 public void doOneFrame(DrawSurface d) {
  levelInformation.getBackground().drawOn(d);
  this.sprites.drawAllOn(d);
  this.sprites.notifyAllTimePassed();
  //Stopping condition
  if (this.remainingBlocks.getValue() == 0) {
   this.score.increase(100);
   this.running = false;
  }
  if (this.remainingBalls.getValue() == 0) {
   this.running = false;
  }
  //Checks for user intended stops
  if (this.keyboard.isPressed("p")) {
   this.runner.run(new KeyPressStoppableAnimation(this.keyboard, this.keyboard.SPACE_KEY, new PauseScreen()));
  }
 }
 /**
  * Removes collidable from the game environment.
  * @param c the collidable to remove.
  */
 public void removeColliadable(Collidable c) {
  this.environment.removeCollidable(c);
 }
 /**
  * Removes sprite from the game sprite collection.
  * @param s sprite to remove.
  */
 public void removeSprite(Sprite s) {
  this.sprites.removeSprite(s);
 }
 /**
  * Returns the current blocks number.
  * @return How many blocks are currently in the game.
  */
 public int remainingBlocks() {
  return this.remainingBlocks.getValue();
 }
 /**
  * Returns the current balls number.
  * @return How many balls are currently in the game.
  */
 public int remainingBalls() {
  return this.remainingBalls.getValue();
 }
}
