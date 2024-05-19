package org.program.preciousstonemanager.controller.necklace;

import org.program.preciousstonemanager.controller.abstractcontrollers.storage.FindByTransparencyController;
import org.program.preciousstonemanager.stones.Storage;

public class FindByTransparencyNecklaceController extends FindByTransparencyController {
    @Override
    public void initialize() {
        fxmlFileName = "FindByTransparencyNecklaceScene";

        // БАГ
        storage = Storage.necklace;
        setStorage(Storage.necklace);


        pathBack = "/org/program/preciousstonemanager/NecklaceScene.fxml";
    }
}
