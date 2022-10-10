package h13.view.gui;

import h13.controller.scene.game.GameController;
import h13.controller.scene.ControlledScene;
import javafx.beans.binding.Bindings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import static h13.controller.GameConstants.ASPECT_RATIO;
import static h13.controller.GameConstants.ORIGINAL_GAME_BOUNDS;
import static org.tudalgo.algoutils.student.Student.crash;

/**
 * A GameScene is a {@link Scene} that contains the {@link GameBoard} and is controlled by a {@link GameController}.
 */
public class GameScene extends Scene implements ControlledScene<GameController> {

    // --Variables-- //

    /**
     * A Typesafe reference to the root Node of this Scene.
     */
    private final Group root;

    /**
     * The {@link GameBoard} of this Scene.
     * This is the only Node that is added to the root Node.
     *
     * @see GameBoard
     */
    private GameBoard gameBoard;
    /**
     * The {@link GameController} that controls this {@link GameScene}.
     *
     * @see GameController
     */
    private GameController gameController;

    // --Constructors-- //

    /**
     * Creates a new GameScene.
     */
    public GameScene() {
        super(new Group(), Color.BLACK);
        // Typesafe reference to the root group of the scene.
        root = (Group) getRoot();
        init();
    }

    // --Getters and Setters-- //

    /**
     * Gets the value of {@link #gameBoard} field.
     *
     * @return The value of {@link #gameBoard} field.
     * @see #gameBoard
     */
    public GameBoard getGameBoard() {
        return gameBoard;
    }

    @Override
    public GameController getController() {
        return gameController;
    }

    // --Methods-- //

    /**
     * Initializes the GameScene.
     */
    private void init() {
        // Game Board
        initGameboard();

        // Game Controller
        gameController = new GameController(this);
    }

    /**
     * Initializes the GameBoard, binding its size to the size of the Scene.
     */
    private void initGameboard() {
        gameBoard = new GameBoard(ORIGINAL_GAME_BOUNDS.getWidth(), ORIGINAL_GAME_BOUNDS.getHeight(), this);

        // Size
        crash();
        // Positioning
        crash();

        root.getChildren().add(gameBoard);
    }
}
