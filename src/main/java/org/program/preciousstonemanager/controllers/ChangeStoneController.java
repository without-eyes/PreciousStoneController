package org.program.preciousstonemanager.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import org.program.preciousstonemanager.controllers.abstractcontrollers.SceneWithGoBackController;
import org.program.preciousstonemanager.controllers.abstractcontrollers.StorageController;
import org.program.preciousstonemanager.database.DatabaseWorker;
import org.program.preciousstonemanager.models.PreciousStone;
import org.program.preciousstonemanager.models.SemiPreciousStone;
import org.program.preciousstonemanager.models.Stone;
import org.program.preciousstonemanager.models.Storage;

import java.io.IOException;
import java.util.Objects;

public class ChangeStoneController extends SceneWithGoBackController {
    protected static Stone selectedStone;

    @FXML
    protected TextField nameTextField, colorTextField, weightTextField, valueTextField, transparencyTextField;
    @FXML
    protected RadioButton preciousRadioButton, semipreciousRadioButton;

    /**
     * @param stone
     */
    public static void setSelectedStone(Stone stone) {
        logger.info("Встановлення вибраного каменя: " + stone.getName());
        selectedStone = stone;
    }

    @FXML
    public void initialize() {
        fxmlFileName = "ChangeStoneScene";
        logger.info("Ініціалізація сцени: " + fxmlFileName);
        if (selectedStone != null) {
            nameTextField.setText(selectedStone.getName());
            if (selectedStone.getType().equals("дорогоцінний")) {
                preciousRadioButton.setSelected(true);
            } else if (selectedStone.getType().equals("напівкоштовний")) {
                semipreciousRadioButton.setSelected(true);
            }
            colorTextField.setText(selectedStone.getColor());
            weightTextField.setText(String.valueOf(selectedStone.getWeight()));
            valueTextField.setText(String.valueOf(selectedStone.getValue()));
            transparencyTextField.setText(String.valueOf(selectedStone.getTransparency()));
        }
    }

    /**
     * @param event
     * @throws IOException
     */
    public void changeStone(ActionEvent event) throws IOException {
        String name = nameTextField.getText();
        String color = colorTextField.getText();
        int weight = Integer.parseInt(weightTextField.getText());
        int value = Integer.parseInt(valueTextField.getText());
        int transparency = Integer.parseInt(transparencyTextField.getText());

        Stone changedStone = createChangedStone(name, color, weight, value, transparency, false, preciousRadioButton.isSelected());
        Storage.deleteFromCollection(selectedStone);
        Storage.addIntoCollection(changedStone);
        DatabaseWorker.changeStone(selectedStone, changedStone);

        logger.info("Зміна каменя: " + selectedStone.getName());

        goBack(event);
    }

    /**
     * @param name
     * @param color
     * @param weight
     * @param value
     * @param transparency
     * @param isInNecklace
     * @param isPreciousStone
     * @return
     */
    private Stone createChangedStone(String name, String color, int weight, int value, int transparency, boolean isInNecklace, boolean isPreciousStone) {
        Stone changedStone;
        if (isPreciousStone) {
            changedStone = new PreciousStone(name, color, weight, value, transparency, false);
        } else {
            changedStone = new SemiPreciousStone(name, color, weight, value, transparency, false);
        }
        return changedStone;
    }

    @Override
    public void goBack(ActionEvent event) throws IOException {
        logger.info("Перехід на попередню сцену:" + previousSceneName);
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/" + previousSceneName + ".fxml")));
        loader.load();
        StorageController storageController = loader.getController();
        storageController.setStorage(Storage.getCollection());
        storageController.switchToThisScene(event);
    }
}
