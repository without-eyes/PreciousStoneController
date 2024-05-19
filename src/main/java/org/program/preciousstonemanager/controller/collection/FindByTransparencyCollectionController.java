package org.program.preciousstonemanager.controller.collection;

import org.program.preciousstonemanager.controller.abstractcontrollers.storage.FindByTransparencyController;
import org.program.stones.Storage;

public class FindByTransparencyCollectionController extends FindByTransparencyController {
    @Override
    public void initialize() {
        fxmlFileName = "FindByTransparencyScene";
        storage = Storage.collection;
        pathBack = "/org/program/preciousstonemanager/CollectionScene.fxml";
    }
}
