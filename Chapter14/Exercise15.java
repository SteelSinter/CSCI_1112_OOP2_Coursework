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
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Exercise15 extends Application{
	@Override
	public void start(Stage primaryStage) {
		Rectangle rec = new Rectangle(30, 60);
		
		Octagon path = new Octagon();
		
		StackPane pane = new StackPane();
		pane.getChildren().addAll(path, rec);
		System.out.println(pane.getChildren().toString());
		
		Scene scene = new Scene(pane, 400, 400);
		scene.setFill(Color.TRANSPARENT);
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(5000));
		pt.setPath(path.getOctagon());
		pt.setNode(rec);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(false);
		
		pt.setInterpolator(Interpolator.LINEAR);
		
		pt.play();
		
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
			polygon = new Polygon();
			polygon.setFill(Color.TRANSPARENT);
			polygon.setStroke(Color.BLACK);
			
			ObservableList<Double> list = polygon.getPoints();
			
			double centerX = getWidth() / 2;
			double centerY = getHeight() / 2;
			double radius = Math.min(getWidth(), getHeight()) * 0.4;
			
			for (int i = 0; i < 6; i++) {
				list.add(centerX + radius * Math.cos(2 * i * Math.PI / 6));
				list.add(centerY - radius * Math.sin(2 * i * Math.PI / 6));
			}
			
			getChildren().clear();
			getChildren().add(polygon);
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
