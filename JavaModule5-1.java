import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DisplayImages extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane
        GridPane gridPane = new GridPane();

        // Load images
        Image image1 = new Image("file:flag1.jpg");
        Image image2 = new Image("file:flag2.jpg");
        Image image3 = new Image("file:flag6.jpg");
        Image image4 = new Image("file:flag7.jpg");

        // Create ImageViews
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        ImageView imageView4 = new ImageView(image4);

        // Add ImageViews to the GridPane
        gridPane.add(imageView1, 0, 0);
        gridPane.add(imageView2, 1, 0);
        gridPane.add(imageView3, 0, 1);
        gridPane.add(imageView4, 1, 1);

        // Create a Scene and place it in the Stage
        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setTitle("Display Images");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
