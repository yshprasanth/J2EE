package ui.fx;


import javafx.application.Application;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
        import javafx.scene.layout.GridPane;
        import javafx.scene.layout.Priority;
        import javafx.stage.Stage;
public class GridPaneTest2 extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 180, 250);


        String[] keys =
                {
                        "1", "2", "3",
                        "4", "5", "6",
                        "7", "8", "9",
                        "*", "0", "#"
                };

        GridPane numPad = new GridPane();
        for (int i = 0; i < 12; i++)
        {
            Button button = new Button(keys[i]);
            //button.getStyleClass().add("num-button");
            numPad.add(button, i % 3, (int) Math.ceil(i / 3));
        }

        Button call = new Button("Call");
        call.setTooltip(new Tooltip("Hello"));
        call.setId("call-button");
        call.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        numPad.add(call, 0, 4);

        GridPane.setColumnSpan(call, 3);
        GridPane.setHgrow(call, Priority.ALWAYS);

        root.setCenter(numPad);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}