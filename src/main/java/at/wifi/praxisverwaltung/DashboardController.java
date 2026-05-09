package at.wifi.praxisverwaltung;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DashboardController {
    @FXML
    public Label loginText;
    @FXML
    public TextField usernameTextField;
    @FXML
    public TextField passwordTextField;
    @FXML
    public Button loginButton;
    @FXML
    public Label welcomeText;
    @FXML
    public Label dashboardWelcome;

    @FXML
    public void onLoginButtonClick(ActionEvent actionEvent) {
    }
}
