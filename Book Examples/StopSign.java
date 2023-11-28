package pack;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StopSign extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		Pane octagon = new Octagon();
		StackPane stackPane = new StackPane();
		
		Text text = new Text("STOP");
		text.setFont(new Font("", 30));
		text.setFill(Color.WHITE);
		text.scaleXProperty().bind(octagon.scaleXProperty().multiply(3));
		text.scaleYProperty().bind(octagon.scaleYProperty().multiply(3));
		
		stackPane.getChildren().addAll(octagon, text);
		stackPane.setRotate(22.5);
		
		Scene scene = new Scene(stackPane, 400, 400);
		
		primaryStage.setTitle("Stop sign");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}

class Octagon extends Pane {
	private void paint() {
		Polygon polygon = new Polygon();
		polygon.setFill(Color.RED);
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