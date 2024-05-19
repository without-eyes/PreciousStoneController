package org.program.preciousstonemanager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import org.program.preciousstonemanager.controller.abstractcontrollers.SceneController;

import java.io.IOException;
import java.util.Objects;

public class MainMenuController extends SceneController {
    @Override
    public void initialize() {
        fxmlFileName = "MainMenuScene";
    }

    public void switchToCreateStone(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/CreateStoneScene.fxml")));
        loader.load();
        CreateStoneController createStoneController = loader.getController();
        createStoneController.switchToThisScene(event);
    }

    public void goToCollection(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/CollectionScene.fxml")));
        loader.load();
        CollectionController collectionController = loader.getController();
        collectionController.switchToThisScene(event);
    }

    public void goToNecklace(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/NecklaceScene.fxml")));
        loader.load();
        SceneController sceneController = loader.getController();
        sceneController.switchToThisScene(event);
    }

    public void exitApplication(ActionEvent event) throws IOException {
        System.exit(0);
    }
}