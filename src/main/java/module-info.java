module at.wifi.praxisverwaltung.praxisverwaltung {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.wifi.praxisverwaltung.praxisverwaltung to javafx.fxml;
    exports at.wifi.praxisverwaltung.praxisverwaltung;
}