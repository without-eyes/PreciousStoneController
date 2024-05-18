package org.program.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.program.execution.DatabaseWorker;
import org.program.stones.PreciousStone;
import org.program.stones.SemiPreciousStone;
import org.program.stones.Stone;
import org.program.stones.Storage;

import java.io.IOException;
import java.util.Objects;

public class ChangeStoneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private static Stone selectedStone;

    @FXML
    private TextField nameTextField, colorTextField, weightTextField, valueTextField, transparencyTextField;
    @FXML
    private RadioButton preciousRadioButton, semipreciousRadioButton;

    @FXML
    public void initialize() {
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

    public void switchToThisScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/application/ChangeStoneScene.fxml")));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void changeStone(ActionEvent event) throws IOException {
        String name = nameTextField.getText();
        String color = colorTextField.getText();
        int weight = Integer.parseInt(weightTextField.getText());
        int value = Integer.parseInt(valueTextField.getText());
        int transparency = Integer.parseInt(transparencyTextField.getText());

        Stone stone= null;
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
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/application/CollectionScene.fxml")));
        loader.load();
        MainMenuController mainMenuController = loader.getController();
        mainMenuController.switchToThisScene(event);
    }

    public static void setSelectedStone(Stone stone) {
        selectedStone = stone;
    }
}
