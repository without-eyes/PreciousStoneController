module org.program.preciousstonemanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires log4j;
    requires java.sql;
    requires mysql.connector.j;

    opens org.program.preciousstonemanager to javafx.fxml;
    opens org.program.preciousstonemanager.controllers to javafx.fxml;
    opens org.program.preciousstonemanager.models to javafx.base;

    exports org.program.preciousstonemanager;
    exports org.program.preciousstonemanager.controllers;
    exports org.program.preciousstonemanager.controllers.abstractcontrollers;
    opens org.program.preciousstonemanager.controllers.abstractcontrollers to javafx.fxml;
}