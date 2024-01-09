import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class Minesweeper extends Application {
	final String BUTTON_STYLE = "-fx-border-radius: 0; -fx-border-color: #999999;"
			+ " -fx-background-radius: 0; -fx-background-color: #ffffff;"/* -fx-text-fill: #999999*/;
	final String FLAG = "P";
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
		private int[][] numberMatrix;
		private boolean firstMove = true;
		
		Board(int width, int height) {
			matrix = new boolean[width][height];
			numberMatrix = new int[width][height];
			for (int c = 0; c < width; c++) {
				for (int r = 0; r < height; r++) {
					int col = c, row = r;
					Button bt = new Button();
					bt.setText(" ");
					bt.setFont(new Font("", 19));
					matrix[c][r] = false;
					bt.setMinSize(squareSize, squareSize);
					bt.setStyle(BUTTON_STYLE);
					bt.setPadding(new Insets(0));
					
					bt.setOnMouseClicked(e -> {
						switch (e.getButton().toString()) {
						case "PRIMARY":
							dig(col, row);
							break;
						case "SECONDARY":
							flag(col, row);
							break;
						}
					});
					add(bt, c, r);
				}
			}
			
		}
		
		private void addMines(int mines, int firstC, int firstR) {
			int mineChance = (int)(((double)mines / (width * height)) * 1000);
			while (mines > 0) {
				for (int c = 0; c < width; c++) {
					for (int r = 0; r < height; r++) {
						int rand = (int)(Math.random() * 1000);
						if (rand == mineChance && c != firstC && r != firstR && !isMine(c, r)) {
							matrix[c][r] = true;
							mines--;
							System.out.println(mines);
						}
					}
				}
			}
			firstMove = false;
		}
		
		private void countMines() {
			for (int c = 0; c < width; c++) {
				for (int r = 0; r < height; r++) {
					Button bt = (Button)nodeAt(c, r);
					if (isMine(c, r)) {
						numberMatrix[c][r] = -1;
					}
					else {
						// count mines aorund it
					}
				}
			}
		}
		
		public void dig(int c, int r) {
			Button bt = (Button)nodeAt(c, r);
			//System.out.println("C:" + c + " " + "R:" + r);
			if (firstMove) {
				addMines(MINES, c, r);
			}
			if (isMine(c, r) && !isMarked(c, r)) {
				bt.setDisable(true);
				bt.setStyle(BUTTON_STYLE + ";-fx-background-color: #ff0000");
			}
		}
		
		public void flag(int c, int r) {
			Button b = (Button)nodeAt(c, r);
			System.out.println(r);
			switch (b.getText()) {
			case " ":
				b.setText(FLAG);
				break;
			case FLAG:
				b.setText("?");
				break;
			case "?":
				b.setText(" ");
			}
			System.out.println("Right click");
			System.out.println("C:" + c + " " + "R:" + r);
		}
		
		public void revealMines() {
			for (int c = 0; c < width; c++) {
				for (int r = 0; r < height; r++) {
					if (isMine(c, r)) {
						Button bt = (Button)nodeAt(c, r);
						bt.setDisable(true);
						bt.setStyle(BUTTON_STYLE + ";-fx-background-color: #ff0000");
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
		
		public boolean isMine(int c, int r) {
			return matrix[c][r];
		}
		
		public boolean isMarked(int c, int r) {
			Button bt = (Button)nodeAt(c, r);
			return bt.getText().equals("?") || bt.getText().equals(FLAG);
		}
	}

}
