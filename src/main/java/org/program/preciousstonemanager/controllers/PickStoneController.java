package org.program.preciousstonemanager.controllers;

import javafx.event.ActionEvent;
import org.program.preciousstonemanager.controllers.abstractcontrollers.SceneWithTablesAndGoBackController;
import org.program.preciousstonemanager.models.Storage;

import java.io.IOException;

public class PickStoneController extends SceneWithTablesAndGoBackController {
    @Override
    public void initialize() {
        fxmlFileName = "PickStoneScene";
        logger.info("Ініціалізація сцени: " + fxmlFileName) ;
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    public void pickStone(ActionEvent event) throws IOException {
        logger.info("Вибір каменя з колекції: " + stonesTable.getSelectionModel().getSelectedItem());
        Storage.changeStoneStorage(stonesTable.getSelectionModel().getSelectedItem(), true);
        goBack(event);
    }
}
