package pack;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ListenersRealWorld extends Application{
	BorderPane pane = new BorderPane();
	@Override
	public void start(Stage primaryStage) {
		
		BallPane ballPane = new BallPane();
		
		HBox buttons = new HBox(5);
		Button btUp = new Button("UP");
		Button btDown = new Button("DOWN");
		Button btLeft = new Button("LEFT");
		Button btRight = new Button("RIGHT");
		buttons.getChildren().addAll(btUp, btDown, btLeft, btRight);
		Text text = new Text("            ");
		
		pane.setCenter(ballPane);
		pane.setBottom(buttons);
		pane.setLeft(text);
		pane.setPadding(new Insets(10));
		BorderPane.setAlignment(buttons, Pos.CENTER);
		BorderPane.setAlignment(ballPane, Pos.CENTER);
		
		btUp.setOnAction(e -> {
			ballPane.moveUp();
		});
		btDown.setOnAction(e -> {
			ballPane.moveDown();
		});
		btLeft.setOnAction(e -> {
			ballPane.moveLeft();
		});
		btRight.setOnAction(e -> {
			ballPane.moveRight();
		});
		
		Scene scene = new Scene(pane, 400, 400);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFX Listeners");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}
	
	public class BallPane extends Pane {
		private int movementInterval = 10;
		Circle ball = new Circle(30);
		BallPane() {
			ball.setStroke(Color.BLUE);
			getChildren().add(ball);
			
		}
		
		public boolean checkSpot(double d) {
			if (d < 0)
				return false;
			if (d > pane.getWidth() || d > pane.getHeight())
				return false;
			return true;
		}
		
		public Circle getBall() {
			return ball;
		}
		
		public void moveUp() {
			if (checkSpot(ball.getCenterY() - 10)) {
				ball.setCenterY(ball.getCenterY() - 10);
			}
		}
		
		public void moveDown() {
			if (checkSpot(ball.getCenterY() + 10))
				ball.setCenterY(ball.getCenterY() + 10);
		}
		
		public void moveLeft() {
			if (checkSpot(ball.getCenterX() - 10))
				ball.setCenterX(ball.getCenterX() - 10);
		}
		
		public void moveRight() {
			if (checkSpot(ball.getCenterX() + 10))
				ball.setCenterX(ball.getCenterX() + 10);
		}
	}

}
