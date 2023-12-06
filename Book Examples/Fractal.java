package pack;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Fractal extends Application {
	public static final double X_START = 0, Y_START = 0, LENGTH = 5;
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		double x1 = X_START, y1 = Y_START,
				x2 = X_START + LENGTH, y2 = X_START + LENGTH;
		for (int i = 0; i < 10; i++) {
			pane.getChildren().add(new Line(x1, y1, x2, y2));
			x1 += LENGTH;
			y1 += LENGTH;
			x2 = x1 + LENGTH;
			y2 = y1 + LENGTH;
		}
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("FRACTAL");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
