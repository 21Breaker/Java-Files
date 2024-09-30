import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class BatchUpdateExample extends Application {

    // Text fields for database URL, username, and password
    private TextField tfUrl = new TextField();
    private TextField tfUser = new TextField();
    private TextField tfPassword = new TextField();
    private Label lblStatus = new Label(); // Label to display connection status and performance times

    @Override
    public void start(Stage primaryStage) {
        // Create UI for database connection
        GridPane pane = new GridPane();
        pane.add(new Label("Database URL:"), 0, 0);
        pane.add(tfUrl, 1, 0);
        pane.add(new Label("Username:"), 0, 1);
        pane.add(tfUser, 1, 1);
        pane.add(new Label("Password:"), 0, 2);
        pane.add(tfPassword, 1, 2);
        Button btnConnect = new Button("Connect to Database");
        pane.add(btnConnect, 1, 3);
        pane.add(lblStatus, 1, 4);

        // Set action for the connect button
        btnConnect.setOnAction(e -> connectToDatabase());

        // Set up the scene and stage
        Scene scene = new Scene(pane, 400, 200);
        primaryStage.setTitle("Database Connection");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void connectToDatabase() {
        String url = tfUrl.getText();
        String user = tfUser.getText();
        String password = tfPassword.getText();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            lblStatus.setText("Connected to the database");

            // Insert records without batch update
            long startTime = System.currentTimeMillis();
            insertRecords(connection, false);
            long endTime = System.currentTimeMillis();
            lblStatus.setText(lblStatus.getText() + "\nTime without batch: " + (endTime - startTime) + " ms");

            // Insert records with batch update
            startTime = System.currentTimeMillis();
            insertRecords(connection, true);
            endTime = System.currentTimeMillis();
            lblStatus.setText(lblStatus.getText() + "\nTime with batch: " + (endTime - startTime) + " ms");

        } catch (SQLException ex) {
            lblStatus.setText("Failed to connect to the database");
            ex.printStackTrace();
        }
    }

    private void insertRecords(Connection connection, boolean useBatch) throws SQLException {
        String sql = "INSERT INTO Temp(num1, num2, num3) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            Random random = new Random();

            for (int i = 0; i < 1000; i++) {
                // Set random values for each column
                pstmt.setDouble(1, random.nextDouble());
                pstmt.setDouble(2, random.nextDouble());
                pstmt.setDouble(3, random.nextDouble());

                if (useBatch) {
                    pstmt.addBatch(); // Add to batch
                    if (i % 100 == 0) { // Execute batch every 100 records
                        pstmt.executeBatch();
                    }
                } else {
                    pstmt.executeUpdate(); // Execute immediately
                }
            }

            if (useBatch) {
                pstmt.executeBatch(); // Execute remaining batch
            }
        }
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
