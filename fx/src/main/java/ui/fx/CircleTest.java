package ui.fx;

import javafx.application.Application;
        import javafx.beans.binding.Bindings;
        import javafx.scene.Group;
        import javafx.scene.Scene;
        import javafx.scene.shape.Circle;
        import javafx.stage.Stage;

public class CircleTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Circle c = new Circle();
        Group root = new Group(c);
        Scene scene = new Scene(root, 100, 100);

        c.centerXProperty().bind(scene.widthProperty().divide(2));
        c.centerYProperty().bind(scene.heightProperty().divide(2));
        c.radiusProperty().bind(Bindings.min(scene.widthProperty(),
                scene.heightProperty())
                .divide(2));

        stage.setTitle("A Centered Circle");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}