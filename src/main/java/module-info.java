module org.program.preciousstonecontroller {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires log4j;
    requires java.sql;


    opens org.program.application to javafx.fxml;
    exports org.program.application;
    exports org.program.controller;
    opens org.program.controller to javafx.fxml;
}