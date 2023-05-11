package gamePhysics.collisionMechanisem;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import biuoop.DrawSurface;
import java.util.ArrayList;
import geometry.Line;
import geometry.Point;
import geometry.SortByDistance;
/**
 * Game Environment class.
 * manages the game environment, all collidable objects,
 * and data regarding collisions.
 */
public class GameEnvironment {
 private ArrayList<Collidable> collidables = new ArrayList<Collidable>();
 /**
  * add the given callidable to the environment.
  * @param c the new collidable.
  */
 public void addCollidable(Collidable c) {
  collidables.add(c);
 }
 /**
  * Removes wanted collidable.
  * @param c collidable to remove.
  */
 public void removeCollidable(Collidable c) {
  collidables.remove(c);
 }
 /**
  * Assume an object moving from line.start() to line.end().
  * If this object will not collide with any of the collidables
  * in this collection, return null. Else, return the information
  * about the closest collision that is going to occur.
  * @param trajectory ball movement line.
  * @return closest collision point to trajectory start point.
  */
 public CollisionInfo getClosestCollision(Line trajectory) {
  //SortByDistance object enables to compare by distance to start point
  SortByDistance comperator = new SortByDistance(trajectory.start());
  //Creates a copy of collidables to go through to enable changes during iteration.
  ArrayList<Collidable> collidables = new ArrayList<Collidable>(this.collidables);
  //Sets the closestCollision to be the collision check result with the first object in the Env
  //that is not null.
  int i = 0;
  for (; i < collidables.size(); i++) {
   if (trajectory.closestIntersectionToStartOfLine(collidables.get(i).getCollisionRectangle()) != null) {
    break;
   }
  }
  //Makes sure that there is a collision
  //if not returns null.
  if (i == collidables.size()) {
   return null;
  }
  Point closestCollisionPoint =
   trajectory.closestIntersectionToStartOfLine(collidables.get(i).getCollisionRectangle());
  CollisionInfo closestCollision = new CollisionInfo(closestCollisionPoint, collidables.get(i));
  //Finds the closest collision to occur.
  for (++i; i < collidables.size(); i++) {
   Point collisionPoint = trajectory.closestIntersectionToStartOfLine(collidables.get(i).getCollisionRectangle());
   if (collisionPoint == null) {
    continue;
   }
   if (comperator.compare(closestCollision.collisionPoint(), collisionPoint) > 0) {
    closestCollision.setCollisionPoint(collisionPoint);
    closestCollision.setCollisionObject(collidables.get(i));
   }
  }
  return closestCollision;
 }
 /**
  * Draws game Environment.
  * @param d draw surface object used to draw the game.
  */
 public void drawGameEnvironment(DrawSurface d) {
  //Creates a copy of collidables to go through to enable changes during iteration.
  ArrayList<Collidable> collidables = new ArrayList<Collidable>(this.collidables);
  for (Collidable collidable : collidables) {
   collidable.getCollisionRectangle().drawRectangle(d);
  }
 }
}
