package game.managment;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import biuoop.KeyboardSensor;
import game.animations.AnimationRunner;
import game.animations.EndScreen;
import game.animations.GameLevel;
import game.animations.KeyPressStoppableAnimation;
import game.levels.LevelInformation;
import java.util.List;
import static java.lang.System.exit;
/**
 * Class that is in charge of creating the different levels and moving from one
 * level to the next.
 */
public class GameFlow {
 private Counter score = new Counter();
 private Counter lives = new Counter();
 private KeyboardSensor ks;
 private AnimationRunner ar;
 /**
  * Constructor.
  * @param ar Animation runner enables to run the animations.
  * @param ks Keyboard sensor.
  */
 public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
  this.ar = ar;
  this.ks = ks;
 }
 /**
  * Initializes and run all the levles in the list "levels",
  * one by one.
  * @param levels A list of levels to run.
  */
 public void runLevels(List<LevelInformation> levels) {
  this.lives.increase(7);
  boolean lost = false;
  GameLevel level = new GameLevel(levels.get(0), this.ks, this.ar, this.score, this.lives);
  for (int i = 0; i < levels.size(); i++) {
   if (!lost) {
    level = new GameLevel(levels.get(i), this.ks, this.ar, this.score, this.lives);
    level.initialize();
   } else {
    lost = false;
    level.retry();
   }
   while (level.remainingBlocks() > 0 && level.remainingBalls() > 0) {
    level.run();
   }
   if (level.remainingBalls() == 0 && this.lives.getValue() <= 0) {
    String screenMassage = "Game Over. Your score is " + score.toString();
    this.ar.run(new KeyPressStoppableAnimation(this.ks, this.ks.SPACE_KEY, new EndScreen(screenMassage)));
    exit(1);
   } else if (level.remainingBalls() == 0) {
    try {
     this.lives.decrease(1);
    } catch (Exception e) {
     System.out.printf("Negative number of lives");
    }
    lost = true;
    --i;
   }
  }
  String screenMassage = "You win! Your score is " + score.toString();
  this.ar.run(new KeyPressStoppableAnimation(this.ks, this.ks.SPACE_KEY, new EndScreen(screenMassage)));
  exit(1);
 }
}
