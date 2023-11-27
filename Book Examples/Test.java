package pack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.text.Font;
import javafx.stage.Stage;

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
		
		Button button = new Button("Press this button");
		Circle circle = new Circle();
		StackPane pane = new StackPane();
		Font font = new Font("Comic Sans MS", 10);
		Image image = new Image("https://i.etsystatic.com/23587835/r/il/0c6e6d/3690885284/il_fullxfull.3690885284_4uhn.jpg");
		ImageView imageView = new ImageView(image);
		//BackgroundFill bFill = ;
		
		button.rotateProperty().bind(pane.widthProperty());
		button.scaleXProperty().bind(pane.widthProperty().divide(100));
		button.scaleYProperty().bind(pane.widthProperty().divide(100));
		button.setFont(font);
		
		imageView.scaleXProperty().bind(pane.widthProperty().divide(1200));
		imageView.scaleYProperty().bind(pane.heightProperty().divide(1200));
		
		pane.rotateProperty().bind(button.rotateProperty());
		//pane.setStyle("-fx-background-color: #" + Color.color(pane.getWidth() / 10, pane.getHeight() / 10, 0).hashCode());
		
		circle.centerXProperty().bind(pane.widthProperty().divide(2));
		circle.centerXProperty().bind(pane.widthProperty().divide(2));
		circle.radiusProperty().bind(pane.widthProperty().divide(10));
		circle.setStroke(Color.RED);
		circle.setFill(Color.BLUE);
		circle.setStyle("-fx-stroke: orange; -fx-fill: red;");
		
		pane.getChildren().add(button);
		//pane.getChildren().add(circle);
		pane.getChildren().add(imageView);
		
		Scene scene = new Scene(pane, 180, 200);
		
		primaryStage.setTitle("ALERT!");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
