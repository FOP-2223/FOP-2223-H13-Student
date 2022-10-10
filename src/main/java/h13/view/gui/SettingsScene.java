package h13.view.gui;

import h13.controller.scene.menu.SettingsController;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static org.tudalgo.algoutils.student.Student.crash;

/**
 * The {@link SettingsScene} is a {@link SubMenuScene} that displays the settings menu.
 */
public class SettingsScene extends SubMenuScene<SettingsController, TabPane> {

    /**
     * Creates a new {@link SettingsScene}.
     */
    public SettingsScene() {
        super(new TabPane(), new SettingsController(), "Settings");
        init();
    }

    /**
     * Initialize the content of the scene.
     */
    private void init() {
        final var contentRoot = getContentRoot();
        crash();
    }
}
