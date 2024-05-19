package org.program.preciousstonemanager.controller.mainmenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import org.program.preciousstonemanager.controller.abstractcontrollers.storage.StorageController;
import org.program.preciousstonemanager.controller.necklace.FindByTransparencyNecklaceController;
import org.program.preciousstonemanager.controller.necklace.PickStoneController;
import org.program.preciousstonemanager.database.DatabaseWorker;
import org.program.preciousstonemanager.stones.Stone;
import org.program.preciousstonemanager.stones.Storage;

import java.io.IOException;
import java.util.Objects;

public class NecklaceController extends StorageController {
    @FXML
    private Label valueLabel, weightLabel;

    @Override
    public void initialize() {
        fxmlFileName = "NecklaceScene";
        storage = Storage.necklace;
    }

    public void pickStone(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/PickStoneScene.fxml")));
        loader.load();
        PickStoneController pickStoneController = loader.getController();
        pickStoneController.switchToThisScene(event);
    }

    public void findStoneByTransparency(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/FindByTransparencyNecklaceScene.fxml")));
        loader.load();
        FindByTransparencyNecklaceController findByTransparencyNecklaceController = loader.getController();
        findByTransparencyNecklaceController.switchToThisScene(event);
    }

    public void calculateNecklaceValueAndWeight(ActionEvent event) {
        int necklaceValue = 0;
        int necklaceWeight = 0;

        for (Stone stone : Storage.necklace) {
            if (stone.getIsInNecklace()) {
                necklaceValue += stone.getValue();
                necklaceWeight += stone.getWeight();
            }
        }

        valueLabel.setText("Вартість($): " + necklaceValue);
        weightLabel.setText("Вага(ct): " + necklaceWeight);
    }

    public void removeStone(ActionEvent actionEvent) {
        Stone selectedStone = stonesTable.getSelectionModel().getSelectedItem();
        Storage.necklace.remove(selectedStone);
        DatabaseWorker.changeStoneLocation(selectedStone);
        selectedStone.setIsInNecklace(false);
        Storage.collection.add(selectedStone);
        stonesTable.getItems().remove(selectedStone);
    }

    public void clearNecklace(ActionEvent event) {
        try {
            for (Stone stone : Storage.necklace) {
                DatabaseWorker.changeStoneLocation(stone);
                stone.setIsInNecklace(false);
            }
        } catch (Exception e) {

        }
        stonesTable.getItems().clear();
    }
}
