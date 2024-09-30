import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DisplayImages extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane layout
        GridPane gridPane = new GridPane();

        // Load images from files
        Image image1 = new Image("file:flag1.jpg");
        Image image2 = new Image("file:flag2.jpg");
        Image image3 = new Image("file:flag6.jpg");
        Image image4 = new Image("file:flag7.jpg");

        // Create ImageView objects to display the images
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        ImageView imageView4 = new ImageView(image4);

        // Add ImageView objects to the GridPane at specified positions
        gridPane.add(imageView1, 0, 0); // First image at row 0, column 0
        gridPane.add(imageView2, 1, 0); // Second image at row 0, column 1
        gridPane.add(imageView3, 0, 1); // Third image at row 1, column 0
        gridPane.add(imageView4, 1, 1); // Fourth image at row 1, column 1

        // Create a Scene with the GridPane as the root node, set its size
        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setTitle("Display Images"); // Set the title of the Stage (window)
        primaryStage.setScene(scene); // Place the Scene in the Stage
        primaryStage.show(); // Display the Stage
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
