package org.program.preciousstonemanager.controllers.abstractcontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import org.program.preciousstonemanager.controllers.MainMenuController;
import org.program.preciousstonemanager.models.Stone;
import org.program.preciousstonemanager.models.Storage;

import java.io.IOException;
import java.util.Objects;

public abstract class StorageController extends SceneWithTablesAndGoBackController {
    /**
     *
     * @param event
     * @throws IOException
     */
    public void findStoneByTransparency(ActionEvent event) throws IOException {

    }

    /**
     *
     */
    public void deleteStone() {
        Stone selectedStone = stonesTable.getSelectionModel().getSelectedItem();
        logger.info("Видалення вибраного камені з таблиці: " + selectedStone.getName());
        stonesTable.getItems().remove(selectedStone);
        if (Storage.getCollection().contains(selectedStone)) {
            Storage.deleteFromCollection(selectedStone);
        } else {
            Storage.changeStoneStorage(selectedStone, false);
        }
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @Override
    public void goBack(ActionEvent event) throws IOException {
        logger.info("Перехід на попередню сцену: MainMenuScene");
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/MainMenuScene.fxml")));
        loader.load();
        MainMenuController mainMenuController = loader.getController();
        mainMenuController.switchToThisScene(event);
    }
}
