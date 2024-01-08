import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class Minesweeper extends Application {
	
	@Override
	public void start(Stage mainStage) {
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 250, 250);
		
		mainStage.setScene(scene);
		mainStage.setResizable(false);
		mainStage.setTitle("Mineclear Game");
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}
	
	class Board extends GridPane {
		
		Board(int width, int height) {
			
			
		}
	}

}
