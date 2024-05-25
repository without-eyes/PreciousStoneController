package org.program.preciousstonemanager.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.util.Pair;
import org.program.preciousstonemanager.controllers.abstractcontrollers.StorageController;
import org.program.preciousstonemanager.models.Stone;
import org.program.preciousstonemanager.models.Storage;

import java.io.IOException;
import java.util.Objects;

public class NecklaceController extends StorageController {
    @FXML
    private Label valueLabel, weightLabel;

    @Override
    public void initialize() {
        fxmlFileName = "NecklaceScene";
    }

    public void pickStone(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/PickStoneScene.fxml")));
        loader.load();
        PickStoneController pickStoneController = loader.getController();
        pickStoneController.setStorage(Storage.getNecklace());
        pickStoneController.setPreviousSceneName("NecklaceScene");
        pickStoneController.switchToThisScene(event);
    }

    public void findStoneByTransparency(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/FindByTransparencyScene.fxml")));
        loader.load();
        FindByTransparencyController findByTransparencyController = loader.getController();
        findByTransparencyController.setStorage(Storage.getNecklace());
        findByTransparencyController.setPreviousSceneName("NecklaceScene");
        findByTransparencyController.switchToThisScene(event);
    }

    public void calculateNecklaceValueAndWeight() {
        Pair stats = getNecklaceValueAndWeight();
        valueLabel.setText("Вартість($): " + stats.getKey());
        weightLabel.setText("Вага(ct): " + stats.getValue());
    }

    private Pair<Integer, Integer> getNecklaceValueAndWeight() {
        int value = 0;
        int weight = 0;
        for (Stone stone : Storage.getNecklace()) {
            value += stone.getValue();
            weight += stone.getWeight();
        }
        return new Pair<>(value, weight);
    }

    public void removeStone() {
        Stone selectedStone = stonesTable.getSelectionModel().getSelectedItem();
        Storage.changeStoneStorage(selectedStone, false);
        stonesTable.getItems().remove(selectedStone);
    }

    public void clearNecklace() {
        try {
            for (Stone stone : Storage.getNecklace()) {
                Storage.changeStoneStorage(stone, false);
            }
        } catch (Exception e) {
        }
        stonesTable.getItems().clear();
    }
}
