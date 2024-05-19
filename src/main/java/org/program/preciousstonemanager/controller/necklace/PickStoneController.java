package org.program.preciousstonemanager.controller.necklace;

import javafx.event.ActionEvent;
import org.program.preciousstonemanager.controller.abstractcontrollers.scenes.SceneWithTablesAndGoBackController;
import org.program.preciousstonemanager.database.DatabaseWorker;
import org.program.preciousstonemanager.stones.Stone;
import org.program.preciousstonemanager.stones.Storage;

import java.io.IOException;

public class PickStoneController extends SceneWithTablesAndGoBackController {
    @Override
    public void initialize() {
        fxmlFileName = "PickStoneScene";
        storage = Storage.collection;
        pathBack = "/org/program/preciousstonemanager/NecklaceScene.fxml";
    }

    public void pickStone(ActionEvent event) throws IOException {
        Stone selectedStone = stonesTable.getSelectionModel().getSelectedItem();
        DatabaseWorker.changeStoneLocation(selectedStone);
        selectedStone.setIsInNecklace(true);
        Storage.necklace.add(selectedStone);
        Storage.collection.remove(selectedStone);
        goBack(event);
    }
}
