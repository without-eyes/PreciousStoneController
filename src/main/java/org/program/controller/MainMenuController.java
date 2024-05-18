package org.program.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainMenuController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToThisScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/program/application/MainMenuScene.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCreateStone(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/application/CreateStoneScene.fxml")));
        loader.load();
        CreateStoneController createStoneController = loader.getController();
        createStoneController.switchToThisScene(event);
    }

    public void goToCollection(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/application/CollectionScene.fxml")));
        loader.load();
        CollectionController collectionController = loader.getController();
        collectionController.switchToThisScene(event);
    }

//    public void goToNecklace(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/application/NecklaceScene.fxml")));
//        loader.load();
//        SceneController sceneController = loader.getController();
//        sceneController.switchToShowNecklace(event);
//    }

    public void exitApplication(ActionEvent event) throws IOException {
        System.exit(0);
    }
}