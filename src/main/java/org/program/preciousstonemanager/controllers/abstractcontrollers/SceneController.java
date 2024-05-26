package org.program.preciousstonemanager.controllers.abstractcontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.program.preciousstonemanager.database.DatabaseWorker;

import java.io.IOException;
import java.util.Objects;

public abstract class SceneController {
    protected static final Logger logger = Logger.getLogger(DatabaseWorker.class);

    protected Stage stage;
    protected Scene scene;
    protected Parent root;

    protected String fxmlFileName;

    @FXML
    public void initialize() {
        fxmlFileName = "";
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    public void switchToThisScene(ActionEvent event) throws IOException {
        logger.info("Перехід на сцену: " + fxmlFileName);
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/program/preciousstonemanager/" + fxmlFileName + ".fxml")));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
