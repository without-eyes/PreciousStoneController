package org.program.preciousstonemanager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import org.program.preciousstonemanager.controller.abstractcontrollers.SceneWithTablesController;
import org.program.preciousstonemanager.database.DatabaseWorker;
import org.program.stones.Stone;
import org.program.stones.Storage;

import java.io.IOException;
import java.util.Objects;

public class NecklaceController extends SceneWithTablesController {
    @Override
    public void initialize() {
        fxmlFileName = "NecklaceScene";
    }

    public void switchToSortStones(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/SortStonesNecklaceScene.fxml")));
        loader.load();
        SortStonesCollectionController sortStonesCollectionController = loader.getController();
        sortStonesCollectionController.switchToThisScene(event);
    }

    public void findStoneByTransparency(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/FindByTransparencyNecklaceScene.fxml")));
        loader.load();
        FindByTransparencyCollectionController findByTransparencyCollectionController = loader.getController();
        findByTransparencyCollectionController.switchToThisScene(event);
    }

    public void changeStone(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/ChangeStoneScene.fxml")));
        loader.load();
        ChangeStoneController changeStoneController = loader.getController();
        ChangeStoneController.setSelectedStone(stonesTable.getSelectionModel().getSelectedItem());
        changeStoneController.switchToThisScene(event);
    }

    public void deleteStone(ActionEvent event) throws IOException {
        Stone selectedStone = stonesTable.getSelectionModel().getSelectedItem();
        stonesTable.getItems().remove(selectedStone);
        Storage.collection.remove(selectedStone);
        DatabaseWorker.deleteStone(selectedStone);
    }

    public void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/MainMenuScene.fxml")));
        loader.load();
        MainMenuController mainMenuController = loader.getController();
        mainMenuController.switchToThisScene(event);
    }
}
