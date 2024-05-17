package org.program.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.log4j.chainsaw.Main;
import org.program.execution.DatabaseWorker;
import org.program.stones.PreciousStone;
import org.program.stones.SemiPreciousStone;
import org.program.stones.Stone;
import org.program.stones.Storage;

import java.io.IOException;
import java.util.Objects;

public class CreateStoneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField nameTextField, colorTextField, weightTextField, valueTextField, transparencyTextField;
    @FXML
    private RadioButton preciousRadioButton, semipreciousRadioButton;

    public void switchToCreateStone(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/program/application/CreateStoneScene.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void createStone(ActionEvent event) throws IOException {
        String name = nameTextField.getText();
        String color = colorTextField.getText();
        int weight = Integer.parseInt(weightTextField.getText());
        int value = Integer.parseInt(valueTextField.getText());
        int transparency = Integer.parseInt(transparencyTextField.getText());

        if (preciousRadioButton.isSelected()) {
            PreciousStone stone = new PreciousStone(name, color, weight, value, transparency);
            Storage.collection.add(stone);
            DatabaseWorker.writeIntoDatabase(stone, false);
        } else if (semipreciousRadioButton.isSelected()) {
            SemiPreciousStone stone = new SemiPreciousStone(name, color, weight, value, transparency);
            Storage.collection.add(stone);
            DatabaseWorker.writeIntoDatabase(stone, false);
        }

        goBack(event);
    }

    public void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/application/MainMenuScene.fxml")));
        loader.load();
        MainMenuController mainMenuController = loader.getController();
        mainMenuController.switchToMainMenu(event);
    }
}
