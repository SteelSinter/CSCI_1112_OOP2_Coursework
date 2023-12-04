package pack;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Planets extends Application{
	public static final int YEAR = 5000;
	public static final double SCROLL_SPEED = 0.01;
	public static final int SIZE_SCALE = 10;
	
	@Override
	public void start(Stage primaryStage) {
		Circle sun = new Circle(109);
		sun.setStroke(Color.YELLOW);
		sun.setFill(Color.YELLOW);
		Planet earth = new Planet(1, Color.BLUE);
		Text earthText = new Text("EARTH");
		earthText.setStroke(Color.WHITE);
		Circle earthOrbit = new Circle(600);
		earthOrbit.setStroke(Color.BLACK);
		earthOrbit.setFill(Color.BLACK);
		Circle moon = new Circle(1 * SIZE_SCALE);
		moon.setFill(Color.WHITE);
		Circle moonOrbit = new Circle(30);
		moonOrbit.setStroke(Color.BLACK);
		
		StackPane textPane = new StackPane(earthText);
		StackPane pane = new StackPane(earthOrbit, moonOrbit , sun, earth, moon, textPane);
		
		PathTransition ptEarth = new PathTransition();
		ptEarth.setDuration(Duration.millis(YEAR));
		ptEarth.setPath(earthOrbit);
		ptEarth.setNode(earth);
		ptEarth.setCycleCount(Timeline.INDEFINITE);
		ptEarth.setAutoReverse(false);
		ptEarth.setInterpolator(Interpolator.LINEAR);
		ptEarth.play();
		
		PathTransition ptMoon = new PathTransition();
		ptMoon.setDuration(Duration.millis(YEAR * 13));
		ptMoon.setPath(moonOrbit);
		ptMoon.setNode(moon);
		ptMoon.setCycleCount(Timeline.INDEFINITE);
		ptMoon.setAutoReverse(false);
		ptMoon.setInterpolator(Interpolator.LINEAR);
		ptMoon.play();
		
		Scene scene = new Scene(pane, 1000, 700);
		
		scene.setOnScroll(e -> {
			double scroll = e.getDeltaX() + e.getDeltaY();
			if (scroll > 0) {
				pane.setScaleX(pane.getScaleX() + SCROLL_SPEED);
				pane.setScaleY(pane.getScaleY() + SCROLL_SPEED);
			}
			else if (scroll < 0) {
				pane.setScaleX(pane.getScaleX() - SCROLL_SPEED);
				pane.setScaleY(pane.getScaleY() - SCROLL_SPEED);
			}
		});
		
		scene.setOnMouseDragged(e -> {
			System.out.println("DRAGG");
			System.out.println(e.getX());
		});
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Planets");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}
	
	class Planet extends StackPane {
		private double radius;
		private Paint color;
		private Circle circle;
		
		Planet(int radius, Paint color) {
			circle = new Circle(radius * SIZE_SCALE);
			circle.setFill(color);
			circle.setStroke(color);
			this.getChildren().add(circle);
		}
	}

}
