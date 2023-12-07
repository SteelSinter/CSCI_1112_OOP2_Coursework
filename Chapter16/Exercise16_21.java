package pack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Exercise16_21 extends Application {
	@Override
	public void start(Stage stage) {
		TextField field = new TextField();
		field.setMinWidth(100);
		field.setMinHeight(100);
		field.setFont(new Font("", 20));
		
		Pane pane = new StackPane();
		pane.getChildren().add(field);
		
		Scene scene = new Scene(pane, 150, 100);
		
		field.setOnAction(e -> {
			
		});
		
		stage.setScene(scene);
		stage.setTitle("Exercise16_21");
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch();

	}

}
