module at.wifi.praxisverwaltung.praxisverwaltung {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens controller to javafx.fxml;
    exports controller;
}