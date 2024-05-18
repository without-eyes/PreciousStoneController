package org.program.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import org.program.stones.Stone;

import java.io.IOException;
import java.text.Collator;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public abstract class SortStonesController {
    protected Stage stage;
    protected Scene scene;
    protected Parent root;

    @FXML
    protected RadioButton nameRadioButton, typeRadioButton, colorRadioButton, weightRadioButton, valueRadioButton, transparencyRadioButton;

    public void switchToThisScene(ActionEvent event) throws IOException {

    }

    public void sortStones(ActionEvent event) throws IOException {

    }

    protected List<Stone> sortStorage(List<Stone> storage) {
        Collator collator = Collator.getInstance(Locale.US);
        if (nameRadioButton.isSelected()) {
            storage.sort(Comparator.comparing(Stone::getName, collator));
        } else if (typeRadioButton.isSelected()) {
            storage.sort(Comparator.comparing(Stone::getType, collator));
        } else if (colorRadioButton.isSelected()) {
            storage.sort(Comparator.comparing(Stone::getColor, collator));
        } else if (weightRadioButton.isSelected()) {
            storage.sort(Comparator.comparingInt(Stone::getWeight));
        } else if (valueRadioButton.isSelected()) {
            storage.sort(Comparator.comparingInt(Stone::getValue));
        } else if (transparencyRadioButton.isSelected()) {
            storage.sort(Comparator.comparingInt(Stone::getTransparency));
        }
        return storage;
    }
}
