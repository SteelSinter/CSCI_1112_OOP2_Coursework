package pack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PaneTest extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		Font font = new Font("Times New Roman", 12);
		RadioButton radioButton = new RadioButton();
		Circle circle = new Circle();
		
		Image image = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDWFQvGTmwI3MA700uO-PN-G5xSwv86455Ig&usqp=CAU");
		ImageView imageView = new ImageView(image);
		
		Text text = new Text("WATER IS WET");
		text.setFont(font);
		
		Button button = new Button("Button");
		button.setFont(new Font("Comic Sans MS", 15));
		
		DatePicker datePicker = new DatePicker();
		
		FlowPane pane = new FlowPane();
		pane.getChildren().addAll(button, radioButton, circle, text, datePicker, imageView);
		pane.setPadding(new Insets(15, 15, 15, 15));
		pane.setVgap(15);
		pane.setHgap(15);
		
		Scene scene = new Scene(pane, 500, 500);
		
		primaryStage.setTitle("Hello Hello Heleo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
