package controller;

import database.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    public Label loginText;
    @FXML
    public TextField usernameTextField;
    @FXML
    public Button loginButton;
    @FXML
    public Label welcomeText;
    public PasswordField passwordField;

//    @FXML
//    public void onLoginButtonClick() throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/dashboard.fxml"));
//        Stage stage = new Stage();
//
//        Scene dashboard = new Scene(loader.load());
//        DashboardController dashboardController = loader.getController();
//
//        stage.setScene(dashboard);
//        stage.setMaximized(true);
//        stage.show();
//    }
    @FXML
    public void onLoginButtonClick() throws IOException {

        String username = usernameTextField.getText();
        String password = passwordField.getText();

        if (authenticate(username, password)) {
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("/views/dashboard.fxml"));

            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.setMaximized(true);
            stage.show();

        } else {
            welcomeText.setText("Benutzername oder Passwort falsch!");
            welcomeText.setTextFill(javafx.scene.paint.Color.RED);
        }
    }

    private boolean authenticate(String username, String password) {

        String sql = "SELECT * FROM employees WHERE username = ? AND password = ?";

        try (
                Connection con = DBManager.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}
