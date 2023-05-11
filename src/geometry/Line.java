package geometry;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.Random;
/**
 * line, line segment connects two points, a start point and an end point.
 * Lines have lengths, and may intersect with other lines.
 * It can also tell if it is the same as another line segment.
 */
public class Line {
 private Point start;
 private Point end;
 /**
  * constructor, creates line instance giving two points,
  * sets the starting point to the one with smaller x value.
  * @param start given start point value.
  * @param end given end point value.
  */
 public Line(Point start, Point end) {
   this.start = start;
   this.end = end;
 }
 /**
  * constructor, creates line instance line from individual coordinates,
  * creates points from the coordinates using Point class constructing method,
  * calls Line constructor with the new points.
  * @param x1 given start point x value.
  * @param y1 given start pont y value.
  * @param x2 given end point x value.
  * @param y2 given end point y value.
  */
 public Line(double x1, double y1, double x2, double y2) {
  this(new Point(x1, y1), new Point(x2, y2));
 }
 /**
  * calculates line length.
  * @return length value in double.
  */
 public double length() {
  return this.start.distance(this.end);
 }
 /**
  * calculates x and y values of line middle point.
  * @return point instance with x and y values equals the middle point of the line.
  */
 public Point middle() {
  double middleX = (this.end.getX() + this.start.getX()) / 2;
  double middleY = (this.start.getY() + this.end.getY()) / 2;
  return new Point(middleX, middleY);
 }
 /**
  * returns line start point.
  * @return line start point.
  */
 public Point start() {
  return this.start;
 }
 /**
  * returns line end point.
  * @return line end point.
  */
 public Point end() {
  return this.end;
 }
 /**
  * checks if two lines are equals, by comparing their start and end points.
  * @param other line for comparison.
  * @return boolean according to the answer.
  */
 public boolean equals(Line other) {
  return (this.start == other.start && this.end == other.end)
         || (this.start == other.end && this.end == other.start);
 }
 /**
  * calculates y value of line intersection with y-axis.
  * subtracts start x value multiply by the line slope from y start value.
  * y=ax-b => y-ax=b.
  * @return value of y-axis intersection im double.
  */
 public double yAxesIntersection() {
  if (this.isHorizontal()) {
   return this.start.getY();
  }
  if (this.isVertical()) {
   throw new RuntimeException("vertical lines don't cross y axis");
  }
  return this.start.getY() - (this.start.getX() * this.incline());
 }
 /**
  * calculates x value of two line intersection.
  * y=ax+b, y=cx+d => ax+b=cx+d => ax-cx=d-b => (a-c)x=d-b => x=d-b/a-c.
  * @param other the line to check intersection with.
  * @return x intersection value in double.
  */
 public double xIntersectionValue(Line other) {
  if (this.isVertical()) {
   return this.start.getX();
  } else if (other.isVertical()) {
   return other.start.getX();
  }
  double a = this.incline();
  double b = this.yAxesIntersection();
  double c = other.incline();
  double d = other.yAxesIntersection();
  if (c == a && !this.equals(other)) {
   return 0;
  } else if (c == a) {
   return this.start.getX();
  }
  return (d - b) / (a - c);
 }
 /**
  * calculates y value of lines intersection point.
  * uses instance slope, intersection x value and y-axis intersection in line formula.
  * @param other line that's intersects.
  * @return y value of intersection in double.
  */
 public double yIntersectionValue(Line other) {
  if (this.isVertical()) {
   return other.yIntersectionValue(this);
  }
  if (this.isHorizontal()) {
   return this.start.getY();
  } else if (other.isHorizontal()) {
   return other.start.getY();
  }
  return this.xIntersectionValue(other) * this.incline() + this.yAxesIntersection();
 }
 /**
  * checks if the line is vertical, by comparing x values of start and end.
  * @return boolean according to the answer.
  */
 public boolean isHorizontal() {
  return this.start.getY() == this.end.getY();
 }
 /**
  * checks if the line is vertical.
  * @return returns if the line is vertical or not.
  */
 public boolean isVertical() {
  return this.start.getX() == this.end.getX();
 }
 /**
  * calculates line incline.
  * @return incline value in double.
  */
 public double incline() {
  if (this.isHorizontal()) {
   return 0;
  }
  if (this.isVertical()) {
   throw new RuntimeException("vertical line has no incline");
  }
  double x1 = this.start.getX();
  double x2 = this.end.getX();
  double y1 = this.start.getY();
  double y2 = this.end.getY();
  return (y2 - y1) / (x2 - x1);
 }
 /**
  * checks if two line intersects.
  * checks if x intersection value is bigger than the two lines smallest shared x value,
  * and smaller than the two lines largest shared x value.
  * @param other the line to check intersection with.
  * @return boolean according to the answer.
  */
 public boolean isIntersecting(Line other) {
  if (this.isVertical() && other.isVertical()) {
   return false;
  }
  double xIntersectionValue = 0;
  double yIntersectionValue = 0;
  if (this.isVertical()) {
   xIntersectionValue = Math.round(this.start.getX());
   yIntersectionValue = Math.round(other.yIntersectionValue(this));
  } else if (other.isVertical()) {
   xIntersectionValue = Math.round(other.start.getX());
   yIntersectionValue = Math.round(this.yIntersectionValue(other));
  } else {
   xIntersectionValue = Math.round(xIntersectionValue(other));
   yIntersectionValue = Math.round(yIntersectionValue(other));
  }
  double maxX = Math.min(Math.max(this.start.getX(), this.end.getX()),
                Math.max(other.start.getX(), other.end.getX()));
  double minX = Math.max(Math.min(this.start.getX(), this.end.getX()),
                Math.min(other.start.getX(), other.end.getX()));
  double maxY = Math.min(Math.max(this.start.getY(), this.end().getY()),
                Math.max(other.start().getY(), other.end().getY()));
  double minY = Math.max(Math.min(this.start().getY(), this.end.getY()),
                Math.min(other.start().getY(), other.end.getY()));
  //checks if the intersection point falls in the segments area.
   if (xIntersectionValue <= Math.ceil(maxX) && xIntersectionValue >= Math.floor(minX)
       && yIntersectionValue <= Math.ceil(maxY) && yIntersectionValue >= Math.floor(minY)) {
    return true;
   }
   return false;
 }
 /**
  * Returns the intersection point if the lines intersect, and null if their not.
  * @param other the line to check intersection with.
  * @return point of intersection as Point instance.
  */
 public Point intersectionWith(Line other) {
  if (!this.isIntersecting(other)) {
   return null;
  }
  double xIntersectionValue = xIntersectionValue(other);
  double yIntersectionValue = yIntersectionValue(other);
  if (this.isVertical()) {
   xIntersectionValue = this.start.getX();
   yIntersectionValue = other.yIntersectionValue(this);
  }
  return new Point(xIntersectionValue, yIntersectionValue);
 }
 /**
  * generates random line.
  * @return new line.
  */
 public static Line generateRandomLine() {
  Random rand = new Random();
  double x1 = MyConstants.ABSTRACT_ART_WIDTH * rand.nextDouble();
  double x2 = MyConstants.ABSTRACT_ART_WIDTH * rand.nextDouble();
  double y1 = MyConstants.ABSTRACT_ART_HEIGHT * rand.nextDouble();
  double y2 = MyConstants.ABSTRACT_ART_HEIGHT * rand.nextDouble();
  return new Line(x1, y1, x2, y2);
 }
 /**
  * draws animation of line on the screen.
  * @param d draw surface object.
  */
 public void drawLine(DrawSurface d) {
  int x1 = (int) Math.round(this.start().getX());
  int y1 = (int) Math.round(this.start().getY());
  int x2 = (int) Math.round(this.end().getX());
  int y2 = (int) Math.round(this.end().getY());
  d.drawLine(x1, y1, x2, y2);
 }
 /**
  * If this line does not intersect with the rectangle, return null.
  * Otherwise, return the closest intersection point to the
  * start of the line.
  * @param rect the object checked for intersection.
  * @return the closest intersection point to the line start point.
  */
 public Point closestIntersectionToStartOfLine(Rectangle rect) {
  ArrayList<Point> intersectionPoints = new ArrayList<Point>(rect.intersectionPoints(this));
  if (!intersectionPoints.isEmpty()) {
   //creates object from SortByName comparator class.
   SortByDistance sortByDistance = new SortByDistance(this.start);
   intersectionPoints.sort(sortByDistance);
   //returns first element of rhe sorted list ie the closest intersection point.
   return intersectionPoints.get(0);
  }
  return null;
 }
}
