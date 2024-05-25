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
    }

    @Override
    public void findStoneByTransparency(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/FindByTransparencyScene.fxml")));
        loader.load();
        FindByTransparencyController findByTransparencyController = loader.getController();
        findByTransparencyController.setStorage(storage);
        findByTransparencyController.setPreviousSceneName(fxmlFileName);
        findByTransparencyController.switchToThisScene(event);
    }

    public void changeStone(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/ChangeStoneScene.fxml")));
        loader.load();
        ChangeStoneController changeStoneController = loader.getController();
        changeStoneController.setPreviousSceneName(fxmlFileName);
        ChangeStoneController.setSelectedStone(stonesTable.getSelectionModel().getSelectedItem());
        changeStoneController.switchToThisScene(event);
    }
}
