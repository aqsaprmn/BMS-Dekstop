/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package BookHenry;

import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController {

    @FXML
    private Button Close;

    @FXML
    private Label lblError;

    @FXML
    private TextField textEmail;

    @FXML
    private PasswordField textPassword;

    @FXML
    private Button signIn;

    @FXML
    private Button signUp;

    @FXML
    private Pane formSignIn;

    @FXML
    private Pane formSignUp;

    @FXML
    private Button signInDaftar;

    @FXML
    private TextField signUpUsername;

    @FXML
    private PasswordField signUpPassword;

    @FXML
    private Button signUpProses;

    @FXML
    private Label salahSignUp;

    @FXML
    void handleButtonAction(MouseEvent event) throws IOException {
        Button sourceButton = (Button) event.getSource();

        if (sourceButton == Close) {
            System.exit(0);
        }

        if (sourceButton == signIn) {

            if (signIn().equals("Sukses")) {
                try {
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
//                    stage.initStyle(StageStyle.DECORATED);
//                    stage.setMaximized(true);
                    stage.close();

                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("BooksV2.fxml")));
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception ex) {
                    showAlert("Error", "", "" + ex);
                }
            }
        }

        if (sourceButton == signUp) {
            OnSignIn();
        }

        if (sourceButton == signInDaftar) {
            OnSignUp();
        }

        if (sourceButton == signUpProses) {

            if (signUp().equals("Sukses")) {
                OnSignIn();
            } else if (signUp().equals("Gagal")) {
                OnSignIn();
                salahSignUp.setText("Username Sudah Terdaftar!");
            } else if (signUp().equals("kosong")) {
                salahSignUp.setText("Isi Username atau Password!");
            }
        }
    }

    public void OnSignUp() {
        formSignIn.setVisible(true);
        formSignUp.setVisible(false);
    }

    public void OnSignIn() {
        formSignIn.setVisible(false);
        formSignUp.setVisible(true);
    }

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    java.sql.Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    private String signIn() {
        conn = DBConnect.getConnection();

        String username = textEmail.getText();
        String password = textPassword.getText();

        String query = "SELECT * FROM admin WHERE username = ? and password = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (!rs.next()) {
                lblError.setText("Email/Password salah!");
                System.err.println("Sign In Gagal");
                return "Salah";
            } else {
                showDialog("Sign In", "Sign In Sukses", "Selamat Datang " + username);
                System.out.println("Sign In Sukses");
                return "Sukses";
            }
        } catch (Exception ex) {
            showAlert("Error", "", "" + ex);
            return "Eception";
        }

    }

    private String signUp() {
        conn = DBConnect.getConnection();

        String SuUsername = signUpUsername.getText();
        String SuPassword = signUpPassword.getText();
        int id = 0;

        if (SuUsername == "" || SuUsername.equals("") || SuPassword == "" || SuPassword.equals("")) {
            return "kosong";
        }
        String query = "SELECT * FROM admin WHERE username = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, SuUsername);
            rs = ps.executeQuery();
            if (!rs.next()) {
                String insert = "INSERT INTO admin (id , username , password) VALUES (?,?,?)";
                try {
                    ps = conn.prepareStatement(insert);
                    ps.setInt(1, id);
                    ps.setString(2, SuUsername);
                    ps.setString(3, SuPassword);
                    ps.execute();
                    showDialog("Sign Up", "Sign Up Sukses", "Silahkan Sign In!");
                    return "Sukses";
                } catch (Exception ex) {
                    showAlert("Error", "Sign Up", "" + ex);
                    return "Exception";
                }
            } else {
                showDialog("Sign Up", "Sign Up Gagal", "Silahkan Daftar Kembali!");
                System.out.println("Sign Up Gagal");
                return "Gagal";
            }
        } catch (Exception ex) {
            showAlert("Error", "Sign Up", "" + ex);
            return "Exception";
        }
    }

    private void showDialog(String header, String title, String text) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(text);
        alert.setHeaderText(header);
        alert.setTitle(title);
        alert.showAndWait();
    }

    private void showAlert(String header, String title, String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(text);
        alert.setHeaderText(header);
        alert.setTitle(title);
        alert.showAndWait();
    }
}
