import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class Minesweeper extends Application {
	final String BUTTON_STYLE = "-fx-border-radius: 0; -fx-border-color: #999999;"
			+ " -fx-background-radius: 0; -fx-background-color: #ffffff;"/* -fx-text-fill: #999999*/;
	
	@Override
	public void start(Stage mainStage) {
		int width = 10, height = 10, squareSize = 30;
		
		Pane pane = new Pane();
		
		Board board = new Board(width, height);
		pane.getChildren().add(board);
		
		Scene scene = new Scene(pane, width * squareSize, height * squareSize);
		// size of window is based on grid until menu at top is added.
		
		mainStage.setScene(scene);
		mainStage.setResizable(false);
		mainStage.setTitle("Mineclear Game");
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}
	
	class Board extends GridPane {
		private int[][] matrix;
		
		Board(int width, int height) {
			matrix = new int[width][height];
			for (int c = 0; c < width; c++) {
				for (int r = 0; r < height; r++) {
					Button bt = new Button();
					matrix[c][r] = 0;
					bt.setMinSize(30, 30);
					bt.setStyle(BUTTON_STYLE);
					add(bt, c, r);
				}
			}
			
		}
	}

}
