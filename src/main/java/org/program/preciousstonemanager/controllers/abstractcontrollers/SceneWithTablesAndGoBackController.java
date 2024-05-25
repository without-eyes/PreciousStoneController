package org.program.preciousstonemanager.controllers.abstractcontrollers;

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
import org.program.preciousstonemanager.models.Stone;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public abstract class SceneWithTablesAndGoBackController extends SceneWithGoBackController {
    protected List<Stone> storage;

    @FXML
    protected TableColumn<Stone, String> nameColumn, typeColumn, colorColumn;
    @FXML
    protected TableColumn<Stone, Integer> weightColumn, valueColumn, transparencyColumn;
    @FXML
    protected TableView<Stone> stonesTable;

    @Override
    public void switchToThisScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/" + fxmlFileName + ".fxml")));
        root = loader.load();
        SceneWithTablesAndGoBackController controller = loader.getController();
        controller.setStorage(this.storage);
        controller.showStones();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setStorage(List<Stone> storage) {
        this.storage = storage;
    }

    protected void showStones() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        transparencyColumn.setCellValueFactory(new PropertyValueFactory<>("transparency"));
        stonesTable.setItems(FXCollections.observableList(storage));
    }
}
