import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorSelector extends Application {
    // Define ScrollBars for Red, Green, Blue, and Opacity
    private ScrollBar sbRed = new ScrollBar();
    private ScrollBar sbGreen = new ScrollBar();
    private ScrollBar sbBlue = new ScrollBar();
    private ScrollBar sbOpacity = new ScrollBar();
    private Text text = new Text("Sample Text");

    @Override
    public void start(Stage primaryStage) {
        // Set ScrollBar properties
        setupScrollBar(sbRed, "Red");
        setupScrollBar(sbGreen, "Green");
        setupScrollBar(sbBlue, "Blue");
        setupScrollBar(sbOpacity, "Opacity");

        // Add listener to update text color
        ChangeListener<Number> colorChangeListener = (ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> updateTextColor();
        sbRed.valueProperty().addListener(colorChangeListener);
        sbGreen.valueProperty().addListener(colorChangeListener);
        sbBlue.valueProperty().addListener(colorChangeListener);
        sbOpacity.valueProperty().addListener(colorChangeListener);

        // Layout
        VBox vBox = new VBox(10, new Label("Red"), sbRed, new Label("Green"), sbGreen, new Label("Blue"), sbBlue, new Label("Opacity"), sbOpacity, text);
        Scene scene = new Scene(vBox, 400, 300);

        primaryStage.setTitle("Color Selector");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setupScrollBar(ScrollBar scrollBar, String color) {
        scrollBar.setMin(0);
        scrollBar.setMax(255);
        scrollBar.setValue(127); // Default value
        scrollBar.setBlockIncrement(1);
        scrollBar.setUnitIncrement(1);
    }

    private void updateTextColor() {
        double red = sbRed.getValue() / 255.0;
        double green = sbGreen.getValue() / 255.0;
        double blue = sbBlue.getValue() / 255.0;
        double opacity = sbOpacity.getValue() / 255.0;
        text.setFill(Color.color(red, green, blue, opacity));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
