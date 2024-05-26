package org.program.preciousstonemanager.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.program.preciousstonemanager.controllers.abstractcontrollers.SceneWithGoBackController;
import org.program.preciousstonemanager.models.PreciousStone;
import org.program.preciousstonemanager.models.SemiPreciousStone;
import org.program.preciousstonemanager.models.Stone;
import org.program.preciousstonemanager.models.Storage;

import java.io.IOException;
import java.util.Objects;

public class CreateStoneController extends SceneWithGoBackController {
    @FXML
    private TextField nameTextField, colorTextField, weightTextField, valueTextField, transparencyTextField;
    @FXML
    private RadioButton preciousRadioButton, semipreciousRadioButton;

    @Override
    public void initialize() {
        fxmlFileName = "CreateStoneScene";
        logger.info("Ініціалізація сцени: " + fxmlFileName);
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @Override
    public void switchToThisScene(ActionEvent event) throws IOException {
        logger.info("Перехід на сцену: " + fxmlFileName);
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/" + fxmlFileName + ".fxml")));
        root = loader.load();
        CreateStoneController controller = loader.getController();
        controller.setPreviousSceneName(this.previousSceneName);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    public void createStone(ActionEvent event) throws IOException {
        String name = nameTextField.getText();
        String color = colorTextField.getText();
        int weight = Integer.parseInt(weightTextField.getText());
        int value = Integer.parseInt(valueTextField.getText());
        int transparency = Integer.parseInt(transparencyTextField.getText());

        Stone stone = createNewStone(name, color, weight, value, transparency, false, preciousRadioButton.isSelected());
        Storage.addIntoCollection(stone);

        logger.info("Створення каменя: " + stone.getName());

        goBack(event);
    }

    /**
     *
     * @param name
     * @param color
     * @param weight
     * @param value
     * @param transparency
     * @param isInNecklace
     * @param isPreciousStone
     * @return
     */
    private Stone createNewStone(String name, String color, int weight, int value, int transparency, boolean isInNecklace, boolean isPreciousStone) {
        Stone newStone;
        if (isPreciousStone) {
            newStone = new PreciousStone(name, color, weight, value, transparency, isInNecklace);
        } else  {
            newStone = new SemiPreciousStone(name, color, weight, value, transparency, isInNecklace);
        }
        return newStone;
    }
}
