module org.program.preciousstonecontroller {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires log4j;


    opens org.program.preciousstonecontroller to javafx.fxml;
    exports org.program.preciousstonecontroller;
}