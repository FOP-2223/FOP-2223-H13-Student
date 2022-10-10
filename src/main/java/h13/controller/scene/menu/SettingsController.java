package h13.controller.scene.menu;

import h13.controller.ApplicationSettings;
import h13.controller.scene.SceneController;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import static org.tudalgo.algoutils.student.Student.crash;


/**
 * A {@link SceneController} that manages the "Settings" scene.
 */
public class SettingsController extends SceneController {

    // --Variables-- //

    @Override
    public String getTitle() {
        return "Space Invaders - Settings";
    }

    @Override
    public void initStage(final Stage stage) {
        super.initStage(stage);

        crash();
    }
}
