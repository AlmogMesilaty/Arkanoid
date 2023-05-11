/**
 * @author almog mesilaty
 * @ID 314973686
 */
import biuoop.KeyboardSensor;
import game.animations.AnimationRunner;
import game.levels.DirectHit;
import game.levels.LevelInformation;
import game.levels.WideEasy;
import game.levels.Green3;
import game.levels.FinalFour;
import game.managment.GameFlow;
import java.util.ArrayList;
/**
 * Receives order of levels from the user and runs them in order.
 */
public class Ass6Game {
 /**
  * Receives order of levels from the user and runs them in order.
  * @param args Strings from user, each number represents game level.
  */
 public static void main(String[] args) {
  ArrayList<LevelInformation> levels = new ArrayList<LevelInformation>();
  for (String str : args) {
   switch (str) {
    case ("1"):
     levels.add(new DirectHit());
     continue;
    case ("2"):
     levels.add(new WideEasy());
     continue;
    case ("3"):
     levels.add(new Green3());
     continue;
    case ("4"):
     levels.add(new FinalFour());
     continue;
    default:
     continue;
   }
  }
  AnimationRunner ar = new AnimationRunner("Arkanoid");
  KeyboardSensor ks = ar.getKeyboardSensor();
  if (levels.isEmpty()) {
   levels.add(new DirectHit());
   levels.add(new WideEasy());
   levels.add(new Green3());
   levels.add(new FinalFour());
  }
  GameFlow game = new GameFlow(ar, ks);
  game.runLevels(levels);
 }
}
