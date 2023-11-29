package pack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NumberGuess extends Application {
	private int number = (int)(Math.random() * 100);
	private int guesses = 5;
	
	private TextFieldPane textField = new TextFieldPane();
	private Text numbersGuessed = new Text("Numbers guessed: ");
	
	@Override
	public void start(Stage primaryStage) {
		System.out.println(number);
		Text instructions = new Text("Guess a number between 1 and 100.");
		
		Text guessesLeft = new Text("Guesses left: ");
		
		Text hint = new Text("Number higher or lower");
		Text hint2 = new Text("Number even or odd");
		
		FlowPane pane = new FlowPane(Orientation.VERTICAL);
		pane.setPadding(new Insets(20, 20, 20, 20));
		pane.setVgap(10);
		pane.getChildren().addAll(instructions, numbersGuessed, textField.getField(), hint, hint2);
		
		Scene scene = new Scene(pane, 240, 200);
		
		TextInputHandler textHandler = new TextInputHandler();
		textField.getField().setOnAction(textHandler);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Guess the number");
		primaryStage.show();
	}
	
	class TextInputHandler implements EventHandler<ActionEvent> {
		
		@Override
		public void handle(ActionEvent ev) {
			String guess = textField.getContent();
			try {
				Integer.parseInt(guess);
			}
			catch (Exception e) {
				return;
			}
			if (guess.contains(" ")) {
				return;
			}
			if (Integer.parseInt(guess) == number) {
				
			}
				//Text field prompt can show guesses left or something
				
			numbersGuessed.setText(numbersGuessed.getText().concat(" " + guess));
			textField.getField().setText("");
			
		}
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);

	}

}

class TextFieldPane extends StackPane {
	private TextField textField = new TextField();
	TextFieldPane() {
		//
	}
	
	public TextField getField() {
		return textField;
	}
	
	public String getContent() {
		return textField.getText();
	}
}
