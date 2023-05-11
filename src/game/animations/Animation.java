package game.animations;
/**
 * @author almog mesilaty
 * @ID: 314973686
 */
import biuoop.DrawSurface;
/**
 * Template interface.
 * in charge of the game specific logic and stopping conditions.
 */
public interface Animation {
 /**
  * Updates the animation according to user input and game logics.
  * Draws the new state of the animation.
  * @param d Draw surface object use to draw the new state of the animation.
  */
 void doOneFrame(DrawSurface d);
 /**
  * Boolean variable indicates rather the animation should continue to run,
  * or stopped. According to the stopping conditions.
  * @return The current status of the animation.
  */
 boolean shouldStop();
}
