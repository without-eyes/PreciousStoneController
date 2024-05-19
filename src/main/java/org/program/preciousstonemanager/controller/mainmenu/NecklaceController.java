package org.program.preciousstonemanager.controller.mainmenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import org.program.preciousstonemanager.controller.abstractcontrollers.storage.StorageController;
import org.program.preciousstonemanager.controller.collection.ChangeStoneController;
import org.program.preciousstonemanager.database.DatabaseWorker;
import org.program.stones.Stone;
import org.program.stones.Storage;

import java.io.IOException;
import java.util.Objects;

public class NecklaceController extends StorageController {
    @Override
    public void initialize() {
        fxmlFileName = "NecklaceScene";
        storage = Storage.necklace;
    }

    public void pickStone(ActionEvent actionEvent) {

    }

//    public void findStoneByTransparency(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/FindByTransparencyNecklaceScene.fxml")));
//        loader.load();
//        FindByTransparencyNecklaceController findByTransparencyNecklaceController = loader.getController();
//        findByTransparencyNecklaceController.switchToThisScene(event);
//    }

    public void calculateNecklaceValueAndWeight(ActionEvent actionEvent) {

    }

    public void removeStone(ActionEvent actionEvent) {

    }

    public void clearNecklace(ActionEvent actionEvent) {
        
    }
}
