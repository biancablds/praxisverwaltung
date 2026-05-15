module at.wifi.praxisverwaltung.praxisverwaltung {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.mariadb.jdbc;

    exports database;

    opens controller to javafx.fxml;
    exports controller;
}