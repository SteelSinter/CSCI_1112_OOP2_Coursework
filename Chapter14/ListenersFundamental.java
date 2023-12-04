package pack;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ListenersFundamental extends Application{
	@Override
	public void start(Stage primaryStage) {
		Circle ball = new Circle(20);
		StackPane ballPane = new StackPane(ball);
		BorderPane pane = new BorderPane();
		Button btUp = new Button("UP");
		Button btDown = new Button("DOWN");
		Button btLeft = new Button("LEFT");
		Button btRight = new Button("RIGHT");
		pane.setTop(btUp);
		pane.setBottom(btDown);
		pane.setRight(btRight);
		pane.setLeft(btLeft);
		pane.setCenter(ballPane);
		pane.setPadding(new Insets(10));
		pane.setAlignment(btUp, Pos.TOP_CENTER);
		pane.setAlignment(btDown, Pos.CENTER);
		pane.setAlignment(btRight, Pos.CENTER_RIGHT);
		pane.setAlignment(btLeft, Pos.CENTER_LEFT);
		
		btUp.setOnAction
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFX Listeners");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
