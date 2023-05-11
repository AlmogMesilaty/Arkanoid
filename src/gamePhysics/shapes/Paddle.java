package gamePhysics.shapes;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import biuoop.KeyboardSensor;
import gamePhysics.Velocity;
import gamePhysics.collisionMechanisem.Collidable;
import geometry.Point;
/**
 * Block that is able to move around the screen according to keystrokes.
 */
public class Paddle extends Block implements Sprite, Collidable {
 private biuoop.KeyboardSensor keyboard;
 private int paddleSpeed;
 /**
  * block constructor.
  * @param collisionShape the paddle shape.
  * @param keyboard keyboard object used to detect user keystrokes.
  * @param paddleSpeed paddle speed.
  */
 public Paddle(geometry.Rectangle collisionShape, KeyboardSensor keyboard, int paddleSpeed) {
  super(collisionShape);
  this.keyboard = keyboard;
  this.paddleSpeed = paddleSpeed * 10;
 }
 /**
  * Get paddle speed, returns the paddle speed.
  * @return Paddle Speed.
  */
 public int getPaddleSpeed() {
  int roundedSpeed = (int) Math.round(this.paddleSpeed);
  return roundedSpeed;
 }
 /**
  * Get paddle speed, returns the paddle speed.
  * @return Paddle Speed.
  */
 public int getPaddleWidth() {
  int roundedWidth = (int) Math.round(this.getCollisionRectangle().getWidth());
  return roundedWidth;
 }
 /**
  * changes the paddle position slightly left.
  */
 public void moveLeft() {
  if (this.getCollisionRectangle().getUpperLeft().getX() > 10) {
    Point newPosition = new geometry.Point(this.getCollisionRectangle().getUpperLeft().getX() - 0.1,
    this.getCollisionRectangle().getUpperLeft().getY());
   this.getCollisionRectangle().setUpperLeft(newPosition);
  }
 }
 /**
  * changes the paddle position slightly right.
  */
 public void moveRight() {
  if (this.getCollisionRectangle().getUpperLeft().getX() + this.getCollisionRectangle().getWidth() < 790) {
    Point newPosition = new Point(this.getCollisionRectangle().getUpperLeft().getX() + 0.1,
    this.getCollisionRectangle().getUpperLeft().getY());
   this.getCollisionRectangle().setUpperLeft(newPosition);
  }
 }

 /**
  * notify the object that time passed and checks for user keystrokes,
  * if the user pressed the left arrow key,
  * calls movLeft.
  * if the user pressed right key, calls move right.
  * moves in a loop in order to avoid large jumps in location that can cause missing intersection point.
  */
 @Override
 public void timePassed() {
  if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
   for (int i = 0; i < this.paddleSpeed; i++) {
    this.moveLeft();
   }
  }
  if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
   for (int i = 0; i < this.paddleSpeed; i++) {
    this.moveRight();
   }
  }
 }
 /**
  *  separate the paddle into 5 equally-spaced regions.
  *  changes ball behavior according to the hit region left-most region
  *  1 and the rightmost as 5 (so the middle region is 3).
  *  If the ball hits the middle region (region 3), it keeps its horizontal direction.
  *  However, if we hit region 1, the ball should bounce back with an angle of 300 degrees.
  *  Similarly, for region 2 a little to the left,
  *  for region 4 a little to the right,
  *  and for region 5 bounces in a right angle.
  * @param collisionPoint the point of the collision.
  * @param currentVelocity the velocity of the ball during the collision.
  * @return
  */
 @Override
 public Velocity hit(geometry.Point collisionPoint, Velocity currentVelocity, Ball hitter) {
  int oneThird = Math.floorDiv((int) this.getCollisionRectangle().getWidth(), 3);
  double paddleThirdPoint = this.getCollisionRectangle().getUpperLeft().getX() + oneThird;
  double twoThirdsPoint = this.getCollisionRectangle().getUpperLeft().getX() + (2 * oneThird);
  double paddleEnd = this.getCollisionRectangle().getUpperLeft().getX() + this.getCollisionRectangle().getWidth();
  double paddleBack = this.getCollisionRectangle().getUpperLeft().getY() + this.getCollisionRectangle().getHeight();
  //Collision Values.
  double xCollision = Math.round(collisionPoint.getX());
  double yCollision = Math.floor(collisionPoint.getY());
  //checks that the hit comes from above the paddle
  if (yCollision <= Math.floor(paddleBack)) {
   boolean region1 = xCollision <= Math.ceil(this.getCollisionRectangle().getUpperLeft().getX())
                     && yCollision < this.getCollisionRectangle().getUpperLeft().getY();
   boolean region2 = xCollision <= paddleThirdPoint;
   boolean region3 = xCollision > paddleThirdPoint && xCollision <= twoThirdsPoint;
   boolean region4 = xCollision > twoThirdsPoint;
   boolean region5 = xCollision >= Math.floor(paddleEnd)
                     && yCollision < this.getCollisionRectangle().getUpperLeft().getY();
   Velocity newVelocity = currentVelocity;
   //Calculates balls hit speed.
   double speed = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
   //Updates ball direction according to hit region.
   if (region1) {
    newVelocity = Velocity.fromAngleAndSpeed(Math.toRadians(210), speed);
    return newVelocity;
   }
   if (region2) {
    newVelocity = Velocity.fromAngleAndSpeed(Math.toRadians(240), speed);
    return newVelocity;
   }
   if (region3) {
    newVelocity = Velocity.fromAngleAndSpeed(Math.toRadians(270), speed);
    return newVelocity;
   }
   if (region4) {
    newVelocity = Velocity.fromAngleAndSpeed(Math.toRadians(300), speed);
    return newVelocity;
   }
   if (region5) {
    newVelocity = Velocity.fromAngleAndSpeed(Math.toRadians(330), speed);
    return newVelocity;
   }
  }
  return super.hit(collisionPoint, currentVelocity, hitter);
 }
}