package geometry;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import java.util.Comparator;
/**
 * compares distance to specific point.
 */
public class SortByDistance implements Comparator<Point> {
 private Point startPoint;
 /**
  * compares the distance of two given point from start point filed.
  * @param a first point.
  * @param b second point.
  * @return positive value if first closer than second zero if equal, else negative.
  */
 public int compare(Point a, Point b) {
  if (this.startPoint.distance(a) - this.startPoint.distance(b) > 0) {
   return 1;
  } else if (this.startPoint.distance(a) - this.startPoint.distance(b) < 0) {
   return -1;
  }
  return 0;
 }
 /**
  * constructor.
  * @param startPoint the start point to compare distance to.
  */
 public SortByDistance(Point startPoint) {
  this.startPoint = startPoint;
 }
}
