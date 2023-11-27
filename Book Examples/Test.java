package pack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class Test extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		Color[] colors = {
				Color.RED,
				Color.BLUE,
				Color.YELLOW,
				Color.GREEN,
				Color.ORANGE,
				Color.PINK,
				Color.MAGENTA,
				Color.AQUA,
				Color.GOLD,
				Color.AQUA
		};
		
		Button btOK = new Button("OK");
		Circle circle = new Circle();
		StackPane pane = new StackPane();
		
		circle.centerXProperty().bind(pane.widthProperty().divide(2));
		circle.centerXProperty().bind(pane.widthProperty().divide(2));
		circle.radiusProperty().bind(pane.widthProperty().divide(10));
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.BLUE);
		//circle.strokeProperty().bind();
		
		pane.getChildren().add(btOK);
		pane.getChildren().add(circle);
		
		Scene scene = new Scene(pane, 200, 200);
		
		primaryStage.setTitle("ALERT!");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
