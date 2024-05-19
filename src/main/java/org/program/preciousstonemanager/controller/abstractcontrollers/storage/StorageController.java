package org.program.preciousstonemanager.controller.abstractcontrollers.storage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import org.program.preciousstonemanager.controller.MainMenuController;
import org.program.preciousstonemanager.controller.abstractcontrollers.scenes.SceneWithTablesAndGoBackController;

import java.io.IOException;
import java.util.Objects;

public abstract class StorageController extends SceneWithTablesAndGoBackController {
    public void switchToSortStones(ActionEvent event) throws IOException {

    }

    public void findStoneByTransparency(ActionEvent event) throws IOException {

    }

    public void deleteStone(ActionEvent event) throws IOException {

    }

    @Override
    public void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/MainMenuScene.fxml")));
        loader.load();
        MainMenuController mainMenuController = loader.getController();
        mainMenuController.switchToThisScene(event);
    }
}
