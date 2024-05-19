package org.program.preciousstonemanager.controller.abstractcontrollers.storage;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import org.program.preciousstonemanager.controller.abstractcontrollers.scenes.SceneWithTablesAndGoBackController;
import org.program.preciousstonemanager.stones.Stone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public abstract class FindByTransparencyController extends SceneWithTablesAndGoBackController {
    protected List<Stone> storage;
    protected String pathBack;

    @FXML
    private TextField lowerBorderTextField, upperBorderTextField;

    public void findByTransparency(ActionEvent event) {
        int lowerBorder = Integer.parseInt(lowerBorderTextField.getText());
        int upperBorder = Integer.parseInt(upperBorderTextField.getText());

        List<Stone> tempStorage = new ArrayList<>();
        for (Stone stone : storage) {
            if (stone.getTransparency() >= lowerBorder && stone.getTransparency() <= upperBorder) {
                tempStorage.add(stone);
            }
        }
        tempStorage.sort(Comparator.comparingInt(Stone::getTransparency));
        stonesTable.setItems(FXCollections.observableList(tempStorage));
    }

    public void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource(pathBack)));
        loader.load();
        StorageController storageController = loader.getController();
        storageController.switchToThisScene(event);
    }
}
