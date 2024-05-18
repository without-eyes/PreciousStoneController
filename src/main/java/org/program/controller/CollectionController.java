package org.program.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.program.execution.DatabaseWorker;
import org.program.stones.Stone;
import org.program.stones.Storage;

import java.io.IOException;
import java.util.Objects;

public class CollectionController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableColumn<Stone, String> nameColumn, colorColumn;
    @FXML
    private TableColumn<Stone, Integer> weightColumn, valueColumn, transparencyColumn;
    @FXML
    private TableView<Stone> stonesTable;

    public void switchToThisScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/application/CollectionScene.fxml")));
        root = loader.load();
        CollectionController controller = loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.showStones();
    }

    public void switchToSortStones(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/application/SortStonesCollectionScene.fxml")));
        loader.load();
        SortStonesCollectionController sortStonesCollectionController = loader.getController();
        sortStonesCollectionController.switchToThisScene(event);
    }

    public void findStoneByTransparency(ActionEvent event) throws IOException {

    }

    public void changeStone(ActionEvent event) throws IOException {

    }

    public void deleteStone(ActionEvent event) throws IOException {
        Stone selectedStone = stonesTable.getSelectionModel().getSelectedItem();
        stonesTable.getItems().remove(selectedStone);
        Storage.collection.remove(selectedStone);
        DatabaseWorker.deleteFile(selectedStone);
    }

    public void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/application/MainMenuScene.fxml")));
        loader.load();
        MainMenuController mainMenuController = loader.getController();
        mainMenuController.switchToThisScene(event);
    }

    private void showStones() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        transparencyColumn.setCellValueFactory(new PropertyValueFactory<>("transparency"));
        stonesTable.setItems(FXCollections.observableList(Storage.collection));
    }
}
