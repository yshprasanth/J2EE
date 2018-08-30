package ui.fx;

import javafx.application.Application;
        import javafx.scene.Group;
        import javafx.scene.Scene;
        import javafx.scene.layout.Region;
        import javafx.scene.layout.StackPane;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Rectangle;
        import javafx.stage.Stage;

public class StackPaneTest extends Application {

    @Override public void start(Stage stage) {
        Group group = new Group();
        Scene scene = new Scene(group);

        StackPane stack = new StackPane();
        stack.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        stack.getChildren().addAll(new Rectangle(100,100,Color.BLUE));

        group.getChildren().add(stack);

        stage.setTitle("Welcome to JavaFX!");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}