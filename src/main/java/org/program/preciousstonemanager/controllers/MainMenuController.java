package org.program.preciousstonemanager.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import org.program.preciousstonemanager.controllers.abstractcontrollers.SceneController;
import org.program.preciousstonemanager.models.Storage;

import java.io.IOException;
import java.util.Objects;

public class MainMenuController extends SceneController {
    @Override
    public void initialize() {
        fxmlFileName = "MainMenuScene";
    }

    public void goToCreateStone(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/CreateStoneScene.fxml")));
        loader.load();
        CreateStoneController createStoneController = loader.getController();
        createStoneController.setPreviousSceneName(fxmlFileName);
        createStoneController.switchToThisScene(event);
    }

    public void goToCollection(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/CollectionScene.fxml")));
        loader.load();
        CollectionController collectionController = loader.getController();
        collectionController.setStorage(Storage.getCollection());
        collectionController.switchToThisScene(event);
    }

    public void goToNecklace(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/NecklaceScene.fxml")));
        loader.load();
        NecklaceController necklaceController = loader.getController();
        necklaceController.setStorage(Storage.getNecklace());
        necklaceController.switchToThisScene(event);
    }

    public void exitApplication() {
        System.exit(0);
    }
}