package pack;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EventsRealWorld extends Application {
	@Override
	public void start(Stage primaryStage) {
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10));
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		
		Text invisText = new Text("Programming is fun");
		invisText.setFill(Color.rgb(0, 0, 0, 0));
		
		Pane textPane = new Pane();
		Text text = new Text("Programming is fun.");
		text.setX(55);
		text.setY(60);
		textPane.getChildren().add(text);
		
		Button btLeft = new Button("Left");
		Button btRight = new Button("Right");
		
		VBox radioButtons = new VBox(15);
		
		RadioButton btRed = new RadioButton("Red");
		RadioButton btWhite = new RadioButton("White");
		RadioButton btBlue = new RadioButton("Blue");
		
		radioButtons.getChildren().addAll(btRed, btWhite, btBlue);
		
		ToggleGroup group = new ToggleGroup();
		btRed.setToggleGroup(group);
		btRed.setTextOverrun(OverrunStyle.CLIP);
		btWhite.setToggleGroup(group);
		btWhite.setTextOverrun(OverrunStyle.CLIP);
		btBlue.setToggleGroup(group);
		btBlue.setTextOverrun(OverrunStyle.CLIP);
		
		gridPane.add(invisText , 2, 0);
		gridPane.add(btLeft, 0, 3);
		gridPane.add(btRight, 3, 3);
		gridPane.add(radioButtons, 5, 0);
		
		Pane pane = new Pane();
		pane.getChildren().addAll(textPane, gridPane);
		
		btLeft.setOnAction(e -> {
			if (!((text.getX() - 10) < 0))
			text.setX(text.getX() - 10);
			});
		btRight.setOnAction(e -> {
			if (!((text.getX() + 10) > pane.getWidth() - 110))
			text.setX(text.getX() + 10);
		});
		
		btRed.setOnAction(e -> text.setFill(Color.RED));
		btWhite.setOnAction(e -> text.setFill(Color.WHITE));
		btBlue.setOnAction(e -> text.setFill(Color.BLUE));
		
		Scene scene = new Scene(pane, 300, 150);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFX Events Skill");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
