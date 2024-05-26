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
        logger.info("Ініціалізація сцени: " + fxmlFileName);
    }

    /**
     * @param event
     * @throws IOException
     */
    public void pickStone(ActionEvent event) throws IOException {
        logger.info("Перехід на сцену: PickStoneScene");
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/PickStoneScene.fxml")));
        loader.load();
        PickStoneController pickStoneController = loader.getController();
        pickStoneController.setStorage(Storage.getNecklace());
        pickStoneController.setPreviousSceneName("NecklaceScene");
        pickStoneController.switchToThisScene(event);
    }

    /**
     * @param event
     * @throws IOException
     */
    public void findStoneByTransparency(ActionEvent event) throws IOException {
        logger.info("Перехід на сцену: FindStoneByTransparencyScene");
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/FindByTransparencyScene.fxml")));
        loader.load();
        FindByTransparencyController findByTransparencyController = loader.getController();
        findByTransparencyController.setStorage(Storage.getNecklace());
        findByTransparencyController.setPreviousSceneName("NecklaceScene");
        findByTransparencyController.switchToThisScene(event);
    }

    /**
     *
     */
    public void calculateNecklaceValueAndWeight() {
        logger.info("Обрахування вартості і ваги намиста");
        Pair stats = getNecklaceValueAndWeight();
        valueLabel.setText("Вартість($): " + stats.getKey());
        weightLabel.setText("Вага(ct): " + stats.getValue());
    }

    /**
     * @return
     */
    private Pair<Integer, Integer> getNecklaceValueAndWeight() {
        int value = 0;
        int weight = 0;
        for (Stone stone : Storage.getNecklace()) {
            value += stone.getValue();
            weight += stone.getWeight();
        }
        return new Pair<>(value, weight);
    }

    /**
     *
     */
    public void removeStone() {
        Stone selectedStone = stonesTable.getSelectionModel().getSelectedItem();
        logger.info("Видалення вибраного каменя: " + selectedStone.getName());
        Storage.changeStoneStorage(selectedStone, false);
        stonesTable.getItems().remove(selectedStone);
    }

    /**
     *
     */
    public void clearNecklace() {
        logger.info("Очищення намиста");
        try {
            for (Stone stone : Storage.getNecklace()) {
                Storage.changeStoneStorage(stone, false);
            }
        } catch (Exception e) {
        }
        stonesTable.getItems().clear();
    }
}
