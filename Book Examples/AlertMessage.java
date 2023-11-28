package pack;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AlertMessage extends Application {
	@Override
	public void start(Stage primaryStage) {
		TextArea textArea = new TextArea();
		GridPane pane = new GridPane();
		
		pane.getChildren().addAll(textArea);
		
		Scene scene = new Scene(pane, 500, 500);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("ALERT!");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
