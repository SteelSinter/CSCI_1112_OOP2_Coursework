import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class Minesweeper extends Application {
	final String BUTTON_STYLE = "-fx-border-radius: 0; -fx-border-color: #999999;"
			+ " -fx-background-radius: 0; -fx-background-color: #ffffff;"/* -fx-text-fill: #999999*/;
	final int MINES = 15;
	int width = 10, height = 10, squareSize = 35;
	
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
		private boolean[][] matrix;
		private boolean firstMove = true;
		
		Board(int width, int height) {
			matrix = new boolean[width][height];
			for (int c = 0; c < width; c++) {
				for (int r = 0; r < height; r++) {
					int col = c, row = r;
					Button bt = new Button();
					matrix[c][r] = false;
					bt.setMinSize(squareSize, squareSize);
					bt.setStyle(BUTTON_STYLE);
					bt.setOnAction(e -> {
						System.out.println("C:" + col + " " + "R:" + row);
						Button b = (Button)nodeAt(row, col);
						System.out.println(b.getText());
						if (firstMove) {
							addMines(MINES, col, row);
						}
					});
					add(bt, c, r);
				}
			}
			
		}
		
		private void addMines(int mines, int firstC, int firstR) {
			int mineChance = (int)(((double)mines / (width * height)) * 1000);
			//System.out.println(mineChance);
			while (mines > 0) {
				for (int c = 0; c < width; c++) {
					for (int r = 0; r < height; r++) {
						int rand = (int)(Math.random() * 1000);
						//System.out.println(rand);
						if (rand == mineChance && c != firstC && r != firstR) {
							matrix[c][r] = true;
							mines--;
							System.out.println(mines);
						}
					}
				}
			}
			firstMove = false;
			revealMines(); // tmeporeoroperpoa
		}
		
		public void revealMines() {
			for (int c = 0; c < width; c++) {
				for (int r = 0; r < height; r++) {
					if (matrix[c][r]) {
						Button bt = (Button)nodeAt(c, r);
						bt.setText("M");
						bt.setStyle(BUTTON_STYLE + ";-fx-text-fill: #ff0000");
					}
				}
			}
		}
		
		public Node nodeAt(int col, int row) {
		    for (Node node : getChildren()) {
		        if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
		            return node;
		        }
		    }
		    return null;
		}
	}

}
