import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
public class PlanetsV2 extends Application {
	public static final int AU = 200, YEAR = 5000, SIZE_SCALE = 1, DISTANCE_SCALE = 1, TIME_SCALE = 1;
	public boolean orbitsVisible;
	@Override
	public void start(Stage mainStage) {
		StackPane mainStackPane = new StackPane();
		OrbitPath earthOrbit = new OrbitPath(AU * DISTANCE_SCALE);
		Planet earth = new Planet(10 * SIZE_SCALE, Color.BLUE);
		OrbitPath moonOrbit = new OrbitPath(AU / 10 * DISTANCE_SCALE, earth);
		Moon moon = new Moon(2 * SIZE_SCALE, Color.WHITE);
		Body sun = new Body(100, Color.YELLOW);
		mainStackPane.getChildren().addAll(earthOrbit, sun, earth, moon, moonOrbit);
		
		createOrbit(moon, moonOrbit, 12.4);
		createOrbit(earth, earthOrbit, 1);
		
		Scene scene = new Scene(mainStackPane, 200, 200);
		
		mainStage.setScene(scene);
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public static void createOrbit(Node node, Shape path, double speed) {
		PathTransition pt = new PathTransition();
		pt.setNode(node);
		pt.setPath(path);
		pt.setDuration(Duration.millis(speed * YEAR * TIME_SCALE));
		pt.setInterpolator(Interpolator.LINEAR);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.play();
	}

}

class OrbitPath extends Circle {
	OrbitPath(int r) {
		super(r);
		setFill(Color.TRANSPARENT);
		setStroke(Color.RED);
	}
	
	OrbitPath(int r, Body b) {
		super(r);
		setFill(Color.TRANSPARENT);
		setStroke(Color.RED);
		this.centerXProperty().bind(b.centerXProperty());
		this.centerYProperty().addListener(ov -> {
			//////////////////
		});
	}
}

class Body extends Circle {
	String fill, stroke;
	Body(int r) {
		super(r);
	}
	
	Body(int r, Color c) {
		super(r, c);
	}
}

class Planet extends Body {
	Label name;
	
	Planet(int r) {
		super(r);
	}
	
	Planet(int r, Color c) {
		super(r, c);
	}
}

class Moon extends Body {
	Label name;
	
	Moon(int r) {
		super(r);
	}
	
	Moon(int r, Color c) {
		super(r, c);
	}
}