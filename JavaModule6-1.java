import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.sql.*;

public class StaffDatabaseApp extends Application {
    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/yourDatabase";
    private static final String USER = "yourUsername";
    private static final String PASS = "yourPassword";

    // UI components
    private TextField tfId = new TextField();
    private TextField tfLastName = new TextField();
    private TextField tfFirstName = new TextField();
    private TextField tfMi = new TextField();
    private TextField tfAddress = new TextField();
    private TextField tfCity = new TextField();
    private TextField tfState = new TextField();
    private TextField tfTelephone = new TextField();
    private TextField tfEmail = new TextField();
    private Button btnView = new Button("View");
    private Button btnInsert = new Button("Insert");
    private Button btnUpdate = new Button("Update");

    @Override
    public void start(Stage primaryStage) {
        // Create UI
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("ID:"), 0, 0);
        gridPane.add(tfId, 1, 0);
        gridPane.add(new Label("Last Name:"), 0, 1);
        gridPane.add(tfLastName, 1, 1);
        gridPane.add(new Label("First Name:"), 0, 2);
        gridPane.add(tfFirstName, 1, 2);
        gridPane.add(new Label("MI:"), 0, 3);
        gridPane.add(tfMi, 1, 3);
        gridPane.add(new Label("Address:"), 0, 4);
        gridPane.add(tfAddress, 1, 4);
        gridPane.add(new Label("City:"), 0, 5);
        gridPane.add(tfCity, 1, 5);
        gridPane.add(new Label("State:"), 0, 6);
        gridPane.add(tfState, 1, 6);
        gridPane.add(new Label("Telephone:"), 0, 7);
        gridPane.add(tfTelephone, 1, 7);
        gridPane.add(new Label("Email:"), 0, 8);
        gridPane.add(tfEmail, 1, 8);
        gridPane.add(btnView, 0, 9);
        gridPane.add(btnInsert, 1, 9);
        gridPane.add(btnUpdate, 2, 9);

        // Set button actions
        btnView.setOnAction(e -> viewRecord());
        btnInsert.setOnAction(e -> insertRecord());
        btnUpdate.setOnAction(e -> updateRecord());

        // Set up the scene and stage
        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setTitle("Staff Database App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void viewRecord() {
        String id = tfId.getText();
        String query = "SELECT * FROM Staff WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                tfLastName.setText(rs.getString("lastName"));
                tfFirstName.setText(rs.getString("firstName"));
                tfMi.setText(rs.getString("mi"));
                tfAddress.setText(rs.getString("address"));
                tfCity.setText(rs.getString("city"));
                tfState.setText(rs.getString("state"));
                tfTelephone.setText(rs.getString("telephone"));
                tfEmail.setText(rs.getString("email"));
            } else {
                showAlert("Record not found");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void insertRecord() {
        String query = "INSERT INTO Staff (id, lastName, firstName, mi, address, city, state, telephone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, tfId.getText());
            pstmt.setString(2, tfLastName.getText());
            pstmt.setString(3, tfFirstName.getText());
            pstmt.setString(4, tfMi.getText());
            pstmt.setString(5, tfAddress.getText());
            pstmt.setString(6, tfCity.getText());
            pstmt.setString(7, tfState.getText());
            pstmt.setString(8, tfTelephone.getText());
            pstmt.setString(9, tfEmail.getText());
            pstmt.executeUpdate();
            showAlert("Record inserted successfully");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateRecord() {
        String query = "UPDATE Staff SET lastName = ?, firstName = ?, mi = ?, address = ?, city = ?, state = ?, telephone = ?, email = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, tfLastName.getText());
            pstmt.setString(2, tfFirstName.getText());
            pstmt.setString(3, tfMi.getText());
            pstmt.setString(4, tfAddress.getText());
            pstmt.setString(5, tfCity.getText());
            pstmt.setString(6, tfState.getText());
            pstmt.setString(7, tfTelephone.getText());
            pstmt.setString(8, tfEmail.getText());
            pstmt.setString(9, tfId.getText());
            pstmt.executeUpdate();
            showAlert("Record updated successfully");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
