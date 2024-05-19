package org.program.preciousstonemanager.controller.abstractcontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import org.program.stones.Stone;

import java.io.IOException;
import java.text.Collator;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public abstract class SortStonesController extends SceneController {
    @FXML
    protected RadioButton nameRadioButton, typeRadioButton, colorRadioButton, weightRadioButton, valueRadioButton, transparencyRadioButton;

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
