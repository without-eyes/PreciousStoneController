package org.program.preciousstonemanager.controller.abstractcontrollers.scenes;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.Objects;

public abstract class SceneWithGoBackController extends SceneController {
    protected String pathBack;

    public void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource(pathBack)));
        loader.load();
        SceneController sceneController = loader.getController();
        sceneController.switchToThisScene(event);
    }
}
