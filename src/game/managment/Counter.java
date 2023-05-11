package game.managment;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
/**
 * Class that is used for counting.
 */
public class Counter {
 private int value = 0;
 /**
  * Add number to current count.
  * @param number the number to add to current count.
  */
 public void increase(int number) {
  this.value += number;
 }
 /**
  * subtract number from current count.
  * @param number the number to subtract to current count.
  */
 public void decrease(int number) throws Exception {
  if (this.getValue() < number) {
   Exception e = new Exception("Cannot subtract from zero");
  }
  this.value -= number;
 }
 /**
  * get current count.
  * @return Current count value.
  */
 public int getValue() {
  return this.value;
 }
 /**
  * Returns counter value as a string.
  * @return String of the counter current value.
  */
 @Override
 public String toString() {
  return String.valueOf(this.getValue());
 }
}
