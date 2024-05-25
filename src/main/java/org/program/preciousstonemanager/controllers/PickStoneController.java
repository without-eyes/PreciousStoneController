package org.program.preciousstonemanager.controllers;

import javafx.event.ActionEvent;
import org.program.preciousstonemanager.controllers.abstractcontrollers.SceneWithTablesAndGoBackController;
import org.program.preciousstonemanager.models.Storage;

import java.io.IOException;

public class PickStoneController extends SceneWithTablesAndGoBackController {
    @Override
    public void initialize() {
        fxmlFileName = "PickStoneScene";
    }

    public void pickStone(ActionEvent event) throws IOException {
        Storage.changeStoneStorage(stonesTable.getSelectionModel().getSelectedItem(), true);
        goBack(event);
    }
}
