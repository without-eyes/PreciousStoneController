package org.program.preciousstonemanager.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import org.program.preciousstonemanager.controller.abstractcontrollers.SceneWithTablesController;
import org.program.stones.Stone;
import org.program.stones.Storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class FindByTransparencyCollectionController extends SceneWithTablesController {
    @FXML
    private TextField lowerBorderTextField, upperBorderTextField;

    @Override
    public void initialize() {
        fxmlFileName = "FindByTransparencyScene";
    }

    public void findByTransparency(ActionEvent event) {
        int lowerBorder = Integer.parseInt(lowerBorderTextField.getText());
        int upperBorder = Integer.parseInt(upperBorderTextField.getText());

        List<Stone> tempStorage = new ArrayList<>();
        for (Stone stone : Storage.collection) {
            if (stone.getTransparency() >= lowerBorder && stone.getTransparency() <= upperBorder) {
                tempStorage.add(stone);
            }
        }
        tempStorage.sort(Comparator.comparingInt(Stone::getTransparency));
        stonesTable.setItems(FXCollections.observableList(tempStorage));
    }

    public void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/CollectionScene.fxml")));
        loader.load();
        CollectionController collectionController = loader.getController();
        collectionController.switchToThisScene(event);
    }
}
