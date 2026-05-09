module at.wifi.praxisverwaltung.praxisverwaltung {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens at.wifi.praxisverwaltung to javafx.fxml;
    exports at.wifi.praxisverwaltung;
}