package org.program.preciousstonemanager.controller.collection;

import org.program.preciousstonemanager.controller.abstractcontrollers.storage.FindByTransparencyController;
import org.program.preciousstonemanager.stones.Storage;

public class FindByTransparencyCollectionController extends FindByTransparencyController {
    @Override
    public void initialize() {
        fxmlFileName = "FindByTransparencyCollectionScene";
        storage = Storage.collection;
        setStorage(Storage.collection);
        pathBack = "/org/program/preciousstonemanager/CollectionScene.fxml";
    }
}
