import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) {
        Text text = new Text("Hello World");
        text.setFont(Font.font("Verdana", 40));
        text.setFill(Color.RED);
        
        StackPane root = new StackPane();
        root.getChildren().add(text);
        
        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().add("style.css");
        
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

