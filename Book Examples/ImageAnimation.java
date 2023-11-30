package pack;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ImageAnimation extends Application {
	@Override
	public void start(Stage primaryStage) {
		Image image = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXGYV6HD5iRCt35kTs1QzWWD94pVKpwRvv0Q&usqp=CAU");
		ImageView imageView = new ImageView(image);
		Circle circle = new Circle(10);
		circle.setFill(Color.WHITE);
		
		Circle path = new Circle(200);
		path.setStroke(Color.BLACK);
		path.setFill(Color.WHITE);
		path.setFill(Color.BLACK);
		
		StackPane pane1 = new StackPane(path, circle, imageView);
		pane1.setBackground(new Background(new BackgroundFill(Color.valueOf("#000000"), new CornerRadii(1), new Insets(10))));
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(10000));
		pt.setPath(path);
		pt.setNode(circle);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(false);
		pt.setInterpolator(Interpolator.LINEAR);
		pt.play();
		
		Scene scene = new Scene(pane1, 500, 500);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("ANimaITON");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch();

	}

}
