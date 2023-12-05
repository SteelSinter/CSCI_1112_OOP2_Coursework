package pack;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ListenersFundamental extends Application{
	@Override
	public void start(Stage primaryStage) {
		
		BallPane ballPane = new BallPane();
		
		HBox buttons = new HBox(5);
		Button btUp = new Button("UP");
		Button btDown = new Button("DOWN");
		Button btLeft = new Button("LEFT");
		Button btRight = new Button("RIGHT");
		buttons.getChildren().addAll(btUp, btDown, btLeft, btRight);
		btUp.setOnAction(e -> {
			System.out.println("Button up");
			ballPane.moveUp();
		});
		btDown.setOnAction(e -> {
			ballPane.moveDown();
		});
		
		BorderPane pane = new BorderPane();
		
		pane.setCenter(ballPane);
		pane.setBottom(buttons);
		pane.setPadding(new Insets(10));
		BorderPane.setAlignment(buttons, Pos.CENTER);
		
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
		Circle ball = new Circle(30);
		BallPane() {
			ball.setStroke(Color.BLUE);
			getChildren().add(ball);
			
		}
		
		public Circle getBall() {
			return ball;
		}
		
		public void moveUp() {
			ball.setCenterY(ball.getCenterY() + 30);
		}
		
		public void moveDown() {
			setLayoutY(getLayoutY() + movementInterval);
			
		}
	}

}
