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
	private boolean won = false;
	private boolean lost = false;
	
	private TextFieldPane textField = new TextFieldPane();
	private Text numbersGuessed = new Text("Numbers guessed: ");
	private Text instructions2 = new Text("Guesses left: 5");
	private Text hint = new Text("");
	private Text hint2 = new Text("");
	
	@Override
	public void start(Stage primaryStage) {
		//System.out.println(number);
		Text instructions = new Text("Guess a number between 1 - 100");
		
		FlowPane pane = new FlowPane(Orientation.VERTICAL);
		pane.setPadding(new Insets(20, 20, 20, 20));
		pane.setVgap(10);
		pane.getChildren().addAll(instructions, instructions2, numbersGuessed, textField.getField(), hint, hint2);
		
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
			if (won || lost) {
				instructions2.setText("Guesses left: " + guesses);
				return;
			}
			try {
				Integer.parseInt(guess);
			}
			catch (Exception e) {
				return;
			}
			if (guess.contains(" ") || Integer.parseInt(guess) < 0) {
				return;
			}
			if (guesses == 2)
				if (number % 2 == 0)
					hint2.setText("Hint: the number is even.");
				else
					hint2.setText("Hint: the number is odd.");
			instructions2.setText("Guesses left: " + (guesses - 1));
			
			numbersGuessed.setText(numbersGuessed.getText().concat(" " + guess));
			textField.getField().setText("");
			
			if (Integer.parseInt(guess) == number) {
				hint.setText(guess + " was correct!");
				--guesses;
				hint2.setText("You guessed the number in " + (5 - guesses) + " guesses.");
				won = true;
			}
			if (Integer.parseInt(guess) > number) {
				hint.setText(guess + " is higher.");
				--guesses;
			}
			if (Integer.parseInt(guess) < number) {
				hint.setText(guess + " is lower.");
				--guesses;
			}
			if (guesses <= 0 && !won) {
				hint.setText("You lost. The number was " + number + ".");
				lost = true;
				return;
			}
			
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
