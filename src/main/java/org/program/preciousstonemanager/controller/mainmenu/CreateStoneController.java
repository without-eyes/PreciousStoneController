package org.program.preciousstonemanager.controller.mainmenu;

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

public class CreateStoneController extends SceneWithGoBackController {
    @FXML
    private TextField nameTextField, colorTextField, weightTextField, valueTextField, transparencyTextField;
    @FXML
    private RadioButton preciousRadioButton, semipreciousRadioButton;

    @Override
    public void initialize() {
        fxmlFileName = "CreateStoneScene";
        pathBack = "/org/program/preciousstonemanager/MainMenuScene.fxml";
    }

    public void createStone(ActionEvent event) throws IOException {
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
        Storage.collection.add(stone);
        DatabaseWorker.writeIntoDatabase(stone, false);

        goBack(event);
    }
}
