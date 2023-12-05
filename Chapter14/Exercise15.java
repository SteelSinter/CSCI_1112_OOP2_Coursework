package pack;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Exercise15 extends Application {
	@Override
	public void start(Stage primaryStage) {
		Rectangle rec = new Rectangle(30, 60);
		
		Circle circle = new Circle(150);
		circle.setFill(Color.TRANSPARENT);
		circle.setStroke(Color.TRANSPARENT);
		
		Polygon path = new Polygon();
		path.setFill(Color.TRANSPARENT);
		path.setStroke(Color.BLACK);
		
		ObservableList<Double> list = path.getPoints();
		
		for (int i = 0; i < 6; i++) {
			list.add(circle.getCenterX() + circle.getRadius() * Math.cos(2 * i * Math.PI / 6));
			list.add(circle.getCenterY() - circle.getRadius() * Math.sin(2 * i * Math.PI / 6));
		}
		
		StackPane pane = new StackPane();
		pane.getChildren().add(circle);
		pane.getChildren().add(path);
		pane.getChildren().add(rec);
		System.out.println(pane.getChildren().toString());
		
		Scene scene = new Scene(pane, 400, 400);
		scene.setFill(Color.TRANSPARENT);
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(5000));
		pt.setPath(path);
		pt.setNode(rec);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(false);
		pt.setInterpolator(Interpolator.LINEAR);
		pt.play();
		
		System.out.println(pt.getStatus());
		
		primaryStage.setAlwaysOnTop(true);
		
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setTitle("Exercise 15");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch();

	}
	
	class Octagon extends Pane {
		Polygon polygon;
		
		private void paint() {
			
		}
		
		public Polygon getOctagon() {
			return polygon;
		}
		
		@Override
		public void setWidth(double width) {
			super.setWidth(width);
			paint();
		}
		
		@Override
		public void setHeight(double height) {
			super.setHeight(height);
			paint();
		}
	}

}
