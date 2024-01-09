import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class Minesweeper extends Application {
	final String BUTTON_STYLE = "-fx-border-radius: 0; -fx-border-color: #999999;"
			+ " -fx-background-radius: 0; -fx-background-color: #ffffff;"/* -fx-text-fill: #999999*/;
	final int MINES = 15;
	int width = 10, height = 10, squareSize = 30;
	
	@Override
	public void start(Stage mainStage) {
		
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
		private boolean firstMove = true;
		
		Board(int width, int height) {
			matrix = new int[width][height];
			for (int c = 0; c < width; c++) {
				for (int r = 0; r < height; r++) {
					int col = c, row = r;
					Button bt = new Button();
					matrix[c][r] = 0;
					bt.setMinSize(30, 30);
					bt.setStyle(BUTTON_STYLE);
					bt.setOnAction(e -> {
						System.out.println("C:" + col + " " + "R:" + row);
						if (firstMove)
							addMines(MINES);
					});
					add(bt, c, r);
				}
			}
			
		}
		
		private void addMines(int mines) {
			double mineChance = (double)mines / (width * height);
			for (int c = 0; c < width; c++) {
				for (int r = 0; r < height; r++) {
					double rand = Math.random();
					System.out.println(mineChance);
					System.out.println(rand);
				}
			}
			firstMove = false;
		}
	}

}
