package org.program.preciousstonemanager.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import org.program.preciousstonemanager.controllers.abstractcontrollers.SceneWithTablesAndGoBackController;
import org.program.preciousstonemanager.controllers.abstractcontrollers.StorageController;
import org.program.preciousstonemanager.models.Storage;

import java.io.IOException;
import java.util.Objects;

public class PickStoneController extends SceneWithTablesAndGoBackController {
    @Override
    public void initialize() {
        fxmlFileName = "PickStoneScene";
        logger.info("Ініціалізація сцени: " + fxmlFileName);
    }

    /**
     * @param event
     * @throws IOException
     */
    public void pickStone(ActionEvent event) throws IOException {
        logger.info("Вибір каменя з колекції: " + stonesTable.getSelectionModel().getSelectedItem());
        Storage.changeStoneStorage(stonesTable.getSelectionModel().getSelectedItem(), true);
        goBack(event);
    }

    @Override
    public void goBack(ActionEvent event) throws IOException {
        logger.info("Перехід на попередню сцену:" + previousSceneName);
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/" + previousSceneName + ".fxml")));
        loader.load();
        StorageController storageController = loader.getController();
        storageController.switchToThisScene(event);
    }
}
