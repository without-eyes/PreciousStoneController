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

public class CreateStoneController extends SceneController {
    @FXML
    private TextField nameTextField, colorTextField, weightTextField, valueTextField, transparencyTextField;
    @FXML
    private RadioButton preciousRadioButton, semipreciousRadioButton;


    @Override
    public void initialize() {
        fxmlFileName = "CreateStoneScene";
    }

    public void createStone(ActionEvent event) throws IOException {
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
        Storage.collection.add(stone);
        DatabaseWorker.writeIntoDatabase(stone, false);

        goBack(event);
    }

    public void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/MainMenuScene.fxml")));
        loader.load();
        MainMenuController mainMenuController = loader.getController();
        mainMenuController.switchToThisScene(event);
    }
}
