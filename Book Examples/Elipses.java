package pack;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class Elipses extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		StackPane pane = createShapes(25);
		pane.setPadding(new Insets(10));
		Scene scene = new Scene(pane, 500, 500);
		
		primaryStage.setTitle("Nice shapes");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}
	
	public static StackPane createShapes(int count) {
		StackPane pane = new StackPane();
		for (int i = 0; i < count; i++) {
			Ellipse e = new Ellipse(50, 20);
			e.setScaleX(150);
			e.setScaleY(150);
			e.scaleXProperty().bind(pane.scaleXProperty());
			e.scaleYProperty().bind(pane.scaleYProperty());
			e.setRotate(i * 180 / 16);
			e.setCenterX(pane.getWidth() / 2);
			e.setCenterY(pane.getHeight() / 2);
			e.setFill(Color.color(Math.random(), Math.random(), Math.random()));
			e.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
			pane.getChildren().add(e);
		}
		
		return pane;
	}

}
