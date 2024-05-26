package org.program.preciousstonemanager.controllers.abstractcontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.Objects;

public abstract class SceneWithGoBackController extends SceneController {
    protected String previousSceneName;

    /**
     * @param previousSceneName
     */
    public void setPreviousSceneName(String previousSceneName) {
        this.previousSceneName = previousSceneName;
    }

    /**
     * @param event
     * @throws IOException
     */
    public void goBack(ActionEvent event) throws IOException {
        logger.info("Перехід на попередню сцену:" + previousSceneName);
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/" + previousSceneName + ".fxml")));
        loader.load();
        SceneController sceneController = loader.getController();
        sceneController.switchToThisScene(event);
    }
}
