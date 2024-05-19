package org.program.preciousstonemanager.controller.collection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import org.program.preciousstonemanager.controller.abstractcontrollers.scenes.SceneWithGoBackController;
import org.program.preciousstonemanager.database.DatabaseWorker;
import org.program.preciousstonemanager.stones.PreciousStone;
import org.program.preciousstonemanager.stones.SemiPreciousStone;
import org.program.preciousstonemanager.stones.Stone;
import org.program.preciousstonemanager.stones.Storage;

import java.io.IOException;

public class ChangeStoneController extends SceneWithGoBackController {
    protected static Stone selectedStone;

    @FXML
    protected TextField nameTextField, colorTextField, weightTextField, valueTextField, transparencyTextField;
    @FXML
    protected RadioButton preciousRadioButton, semipreciousRadioButton;

    public static void setSelectedStone(Stone stone) {
        selectedStone = stone;
    }

    @FXML
    public void initialize() {
        fxmlFileName = "ChangeStoneScene";
        pathBack = "/org/program/preciousstonemanager/CollectionScene.fxml";
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
            stone = new PreciousStone(name, color, weight, value, transparency, false);
        } else if (semipreciousRadioButton.isSelected()) {
            stone = new SemiPreciousStone(name, color, weight, value, transparency, false);
        }
        Storage.collection.remove(selectedStone);
        Storage.collection.add(stone);
        DatabaseWorker.changeStone(selectedStone, stone);

        goBack(event);
    }
}
