package ui.fx;


import javafx.application.Application;
        import javafx.scene.Scene;
        import javafx.scene.canvas.Canvas;
        import javafx.scene.canvas.GraphicsContext;
        import javafx.scene.layout.Pane;
        import javafx.scene.paint.Color;
        import javafx.stage.Stage;
public class CanvasTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(300, 100);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setLineWidth(2.0);
        gc.setFill(Color.RED);

        gc.strokeRoundRect(10, 10, 50, 50, 10, 10);

        gc.fillOval(70, 10, 50, 20);

        gc.strokeText("Hello Canvas", 150, 20);

        Pane root = new Pane();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("");
        stage.show();
    }
}