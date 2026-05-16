package controller;

import database.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

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

    @FXML
    public void onLoginButtonClick() throws IOException {

        String username = usernameTextField.getText();
        String password = passwordField.getText();

        if (authenticate(username, password)) {
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("/views/overview.fxml"));

            Stage stage = (Stage) loginButton.getScene().getWindow();
            Scene overviewScene = new Scene(loader.load());
            overviewScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/style/overview.css")).toExternalForm());
            stage.setScene(overviewScene);
            stage.setMaximized(true);
            stage.show();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login fehlgeschlagen");
            alert.setHeaderText(null);
            alert.setContentText("Benutzername oder Passwort ist falsch.");
            alert.showAndWait();
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
