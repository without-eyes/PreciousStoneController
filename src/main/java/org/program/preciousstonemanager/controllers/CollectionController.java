package org.program.preciousstonemanager.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import org.program.preciousstonemanager.controllers.abstractcontrollers.StorageController;

import java.io.IOException;
import java.util.Objects;

public class CollectionController extends StorageController {
    @Override
    public void initialize() {
        fxmlFileName = "CollectionScene";
        logger.info("Ініціалізація сцени: " + fxmlFileName);
    }

    /**
     * @param event
     * @throws IOException
     */
    @Override
    public void findStoneByTransparency(ActionEvent event) throws IOException {
        logger.info("Перехід на сцену: FindStoneByTransparency");
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/FindByTransparencyScene.fxml")));
        loader.load();
        FindByTransparencyController findByTransparencyController = loader.getController();
        findByTransparencyController.setStorage(storage);
        findByTransparencyController.setPreviousSceneName(fxmlFileName);
        findByTransparencyController.switchToThisScene(event);
    }

    /**
     * @param event
     * @throws IOException
     */
    public void changeStone(ActionEvent event) throws IOException {
        logger.info("Перехід на сцену: ChangeStoneScene");
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/ChangeStoneScene.fxml")));
        loader.load();
        ChangeStoneController changeStoneController = loader.getController();
        changeStoneController.setPreviousSceneName(fxmlFileName);
        ChangeStoneController.setSelectedStone(stonesTable.getSelectionModel().getSelectedItem());
        changeStoneController.switchToThisScene(event);
    }
}
