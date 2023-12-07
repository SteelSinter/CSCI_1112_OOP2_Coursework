/*
 * Author: James Jesus
 * Date: 12/7/2023
 */
package pack;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise16_21 extends Application {
	@Override
	public void start(Stage stage) {
		Media music = new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
		MediaPlayer mediaPlayer = new MediaPlayer(music);
		TextField field = new TextField();
		field.setMinWidth(100);
		field.setMinHeight(100);
		field.setFont(new Font("", 20));
		
		Pane pane = new StackPane();
		pane.getChildren().add(field);
		
		Scene scene = new Scene(pane, 150, 100);
		
		EventHandler<ActionEvent> countdownHandler = e -> {
			try {
				field.setText(String.valueOf(Integer.parseInt(field.getText()) - 1));
			}
			catch (Exception ex) {}
		};
		
		Timeline countdown = new Timeline(new KeyFrame(Duration.millis(1000), countdownHandler));
		countdown.setOnFinished(e -> mediaPlayer.play());
		
		field.setOnAction(e -> {
			try {
				countdown.setCycleCount(Integer.parseInt(field.getText()));
				countdown.play();
			}
			catch (Exception ex) {}
		});
		
		stage.setScene(scene);
		stage.setTitle("Exercise16_21");
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch();

	}
}
