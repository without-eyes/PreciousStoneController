module org.program.preciousstonemanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires log4j;
    requires java.sql;

    opens org.program.preciousstonemanager to javafx.fxml;
    opens org.program.preciousstonemanager.controller to javafx.fxml;
    opens org.program.stones to javafx.base;

    exports org.program.preciousstonemanager;
    exports org.program.preciousstonemanager.controller;
    exports org.program.preciousstonemanager.controller.abstractcontrollers;
    opens org.program.preciousstonemanager.controller.abstractcontrollers to javafx.fxml;
}