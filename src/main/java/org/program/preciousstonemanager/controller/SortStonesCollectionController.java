package org.program.preciousstonemanager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import org.program.preciousstonemanager.controller.abstractcontrollers.SortStonesController;
import org.program.stones.Storage;

import java.io.IOException;
import java.util.Objects;

public class SortStonesCollectionController extends SortStonesController {
    @Override
    public void initialize() {
        fxmlFileName = "SortStonesCollectionScene";
    }

    @Override
    public void sortStones(ActionEvent event) throws IOException {
        Storage.collection = sortStorage(Storage.collection);
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/CollectionScene.fxml")));
        loader.load();
        CollectionController collectionController = loader.getController();
        collectionController.switchToThisScene(event);
    }
}
