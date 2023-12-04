package pack;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ListenersFundamental extends Application{
	@Override
	public void start(Stage primaryStage) {
		
		BallPane ballPane = new BallPane();
		ballPane.setMaxWidth(ballPane.getBall().getRadius() * 2);
		BorderPane pane = new BorderPane();
		Button btUp = new Button("UP");
		Button btDown = new Button("DOWN");
		Button btLeft = new Button("LEFT");
		Button btRight = new Button("RIGHT");
		
		pane.setCenter(ballPane);
		pane.setTop(btUp);
		pane.setBottom(btDown);
		pane.setRight(btRight);
		pane.setLeft(btLeft);
		pane.setPadding(new Insets(10));
		pane.setAlignment(btUp, Pos.TOP_CENTER);
		pane.setAlignment(btDown, Pos.CENTER);
		pane.setAlignment(btRight, Pos.CENTER_RIGHT);
		pane.setAlignment(btLeft, Pos.CENTER_LEFT);

		btUp.setOnAction(e -> {
			ballPane.moveUp();
		});
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFX Listeners");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}
	
	public class BallPane extends StackPane {
		private int movementInterval = 10;
		private Circle ball;
		BallPane() {
			ball = new Circle(30);
			getChildren().add(ball);
			
		}
		
		public Circle getBall() {
			return ball;
		}
		
		public void moveUp() {
			setTranslateY(movementInterval);
		}
		
		public void moveDown() {
			setTranslateY(movementInterval);
		}
	}

}
