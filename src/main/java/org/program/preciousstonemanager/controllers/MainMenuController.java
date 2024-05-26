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
        logger.info("Ініціалізація сцени: " + fxmlFileName);
    }

    /**
     * @param event
     * @throws IOException
     */
    public void goToCreateStone(ActionEvent event) throws IOException {
        logger.info("Перехід на сцену: CreateStoneScene");
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/CreateStoneScene.fxml")));
        loader.load();
        CreateStoneController createStoneController = loader.getController();
        createStoneController.setPreviousSceneName(fxmlFileName);
        createStoneController.switchToThisScene(event);
    }

    /**
     * @param event
     * @throws IOException
     */
    public void goToCollection(ActionEvent event) throws IOException {
        logger.info("Перехід на сцену: CollectionScene");
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/CollectionScene.fxml")));
        loader.load();
        CollectionController collectionController = loader.getController();
        collectionController.setStorage(Storage.getCollection());
        collectionController.switchToThisScene(event);
    }

    /**
     * @param event
     * @throws IOException
     */
    public void goToNecklace(ActionEvent event) throws IOException {
        logger.info("Перехід на сцену: NecklaceScene");
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/NecklaceScene.fxml")));
        loader.load();
        NecklaceController necklaceController = loader.getController();
        necklaceController.setStorage(Storage.getNecklace());
        necklaceController.switchToThisScene(event);
    }

    /**
     *
     */
    public void exitApplication() {
        logger.info("Закінчення роботи програми");
        System.exit(0);
    }
}