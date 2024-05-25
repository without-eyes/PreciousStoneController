package org.program.preciousstonemanager.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import org.program.preciousstonemanager.controllers.abstractcontrollers.SceneWithGoBackController;
import org.program.preciousstonemanager.database.DatabaseWorker;
import org.program.preciousstonemanager.models.PreciousStone;
import org.program.preciousstonemanager.models.SemiPreciousStone;
import org.program.preciousstonemanager.models.Stone;
import org.program.preciousstonemanager.models.Storage;

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

        Stone changedStone = createChangedStone(name, color, weight, value, transparency, false, preciousRadioButton.isSelected());
        Storage.deleteFromCollection(selectedStone);
        Storage.addIntoCollection(changedStone);
        DatabaseWorker.changeStone(selectedStone, changedStone);

        goBack(event);
    }

    private Stone createChangedStone(String name, String color, int weight, int value, int transparency, boolean isInNecklace, boolean isPreciousStone) {
        Stone changedStone;
        if (isPreciousStone) {
            changedStone = new PreciousStone(name, color, weight, value, transparency, false);
        } else  {
            changedStone = new SemiPreciousStone(name, color, weight, value, transparency, false);
        }
        return changedStone;
    }
}
