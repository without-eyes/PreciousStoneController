package org.program.preciousstonemanager.controller.abstractcontrollers.scenes;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import org.program.preciousstonemanager.controller.mainmenu.CollectionController;

import java.io.IOException;
import java.util.Objects;

public abstract class SceneWithGoBackController extends SceneController {
    protected String pathBack;

    public void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource(pathBack)));
        loader.load();
        CollectionController collectionController = loader.getController();
        collectionController.switchToThisScene(event);
    }
}
