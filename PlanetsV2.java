import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class PlanetsV2 extends Application {
	@Override
	public void start(Stage mainStage) {
		StackPane mainStackPane = new StackPane();
		mainStackPane.getChildren().addAll();
		
		Scene scene = new Scene(mainStackPane, 200, 200);
		
		mainStage.setScene(scene);
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}

class Body extends Circle {
	String fill, stroke;
	
}

class Planet extends Body {
	Text nameLabel;
	String name;
	
	Planet(int radius) {
		
	}
}