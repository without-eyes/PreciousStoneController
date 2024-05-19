package org.program.preciousstonemanager.controller.abstractcontrollers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.program.stones.Stone;
import org.program.stones.Storage;

import java.io.IOException;
import java.util.Objects;

public abstract class SceneWithTablesController extends SceneController {
    @FXML
    protected TableColumn<Stone, String> nameColumn, colorColumn;
    @FXML
    protected TableColumn<Stone, Integer> weightColumn, valueColumn, transparencyColumn;
    @FXML
    protected TableView<Stone> stonesTable;

    @Override
    public void switchToThisScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/CollectionScene.fxml")));
        root = loader.load();
        SceneWithTablesController controller = loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.showStones();
    }

    protected void showStones() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        transparencyColumn.setCellValueFactory(new PropertyValueFactory<>("transparency"));
        stonesTable.setItems(FXCollections.observableList(Storage.collection));
    }
}
