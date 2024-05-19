package org.program.preciousstonemanager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import org.program.preciousstonemanager.controller.abstractcontrollers.SceneController;
import org.program.preciousstonemanager.database.DatabaseWorker;
import org.program.stones.PreciousStone;
import org.program.stones.SemiPreciousStone;
import org.program.stones.Stone;
import org.program.stones.Storage;

import java.io.IOException;
import java.util.Objects;

public class ChangeStoneController extends SceneController {
    private static Stone selectedStone;

    @FXML
    private TextField nameTextField, colorTextField, weightTextField, valueTextField, transparencyTextField;
    @FXML
    private RadioButton preciousRadioButton, semipreciousRadioButton;

    public static void setSelectedStone(Stone stone) {
        selectedStone = stone;
    }

    @FXML
    public void initialize() {
        fxmlFileName = "ChangeStoneScene";
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

    public void changeStone(ActionEvent event) throws IOException {
        String name = nameTextField.getText();
        String color = colorTextField.getText();
        int weight = Integer.parseInt(weightTextField.getText());
        int value = Integer.parseInt(valueTextField.getText());
        int transparency = Integer.parseInt(transparencyTextField.getText());

        Stone stone = null;
        if (preciousRadioButton.isSelected()) {
            stone = new PreciousStone(name, color, weight, value, transparency);
        } else if (semipreciousRadioButton.isSelected()) {
            stone = new SemiPreciousStone(name, color, weight, value, transparency);
        }
        Storage.collection.remove(selectedStone);
        Storage.collection.add(stone);
        DatabaseWorker.changeStone(selectedStone, stone);

        goBack(event);
    }

    public void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/CollectionScene.fxml")));
        loader.load();
        MainMenuController mainMenuController = loader.getController();
        mainMenuController.switchToThisScene(event);
    }
}
