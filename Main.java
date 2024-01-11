package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 * Mine clearing game.
 * 
 * @author James Jesus
 *
 */
public class Main extends Application {
	final String BUTTON_STYLE = "-fx-border-radius: 0; -fx-border-color: #999999;"
			+ " -fx-background-radius: 0; -fx-background-color: #ffffff;"/* -fx-text-fill: #999999*/;
	final String FLAG = "P";
	int mines = 15;
	int width = 10, height = 10, squareSize = 30;
	Button btReset = new Button("RESET");
	
	@Override
	public void start(Stage mainStage) {
		btReset.setStyle(BUTTON_STYLE);
		btReset.setMinSize(squareSize * 2, squareSize);
		btReset.setMaxSize(squareSize * 2, squareSize);
		btReset.setFont(new Font("", squareSize * .45));
		
		Board board = new Board(width, height);
		
		Pane gamePane = new Pane(board);
		
		VBox vBox = new VBox(); 
		Scene scene = new Scene(vBox, width * squareSize, height * squareSize + squareSize);
		
		btReset.setOnAction(e -> {
			gamePane.getChildren().clear();
			gamePane.getChildren().add(new Board(width, height));
		});
		
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
		private int width, height;
		int squaresRevealed = 0;
		/**
		 * Holds all the data and operations for the game board.
		 * 
		 * @param width Width of the board.
		 * @param height Height of the board.
		 */
		Board(int width, int height) {
			this.width = width;
			this.height = height;
			matrix = new boolean[width][height];
			numberMatrix = new int[width][height];
			for (int c = 0; c < width; c++) {
				for (int r = 0; r < height; r++) {
					int col = c, row = r;
					Button bt = new Button();
					bt.setText(" ");
					bt.setFont(new Font("", squareSize * .6));
					matrix[c][r] = false;
					bt.setMinSize(squareSize, squareSize);
					bt.setMaxSize(squareSize, squareSize);
					bt.setStyle(BUTTON_STYLE);
					bt.setPadding(new Insets(0));
					bt.setContentDisplay(ContentDisplay.CENTER);
					
					bt.setOnMouseClicked(e -> {
						//System.out.println("C:" + col + " " + "R:" + row);
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
		/**
		 * Triggers win state.
		 */
		private void win() {
			btReset.setText(":)");
			for (int c = 0; c < width; c++) {
				for (int r = 0; r < height; r++) {
					Button bt = (Button)nodeAt(c, r);
					if (!bt.isDisabled()) {
						bt.setDisable(true);
						bt.setStyle(BUTTON_STYLE + "; -fx-opacity: 1;");
					}
				}
			}
		}
		/**
		 * Triggers game over state.
		 */
		private void lose() {
			for (int c = 0; c < width; c++) {
				for (int r = 0; r < height; r++) {
					Button bt = (Button)nodeAt(c, r);
					if (!bt.isDisabled()) {
						bt.setDisable(true);
						bt.setStyle(BUTTON_STYLE + "; -fx-opacity: 1;");
					}
				}
			}
			btReset.setText(":(");
		}
		/**
		 * Places the mines on a hidden matrix with a random chance based on the amount of mines.
		 * Cannot place a mine on the first square chosen by the player.
		 * 
		 * @param mines Number of mines to place.
		 * @param firstC First column chosen.
		 * @param firstR First row chosen.
		 */
		private void addMines(int mines, int firstC, int firstR) {
			int mineChance = (int)(((double)mines / (width * height)) * 1000);
			while (mines > 0) {
				for (int c = 0; c < width; c++) {
					for (int r = 0; r < height; r++) {
						int rand = (int)(Math.random() * 1000);
						if (rand == mineChance && c != firstC && r != firstR && !isMine(c, r)) {
							matrix[c][r] = true;
							mines--;
							// System.out.println(mines); gets -1 sometimes
						}
					}
				}
			}
			firstMove = false;
		}
		/**
		 * Counts the mines on the board and assigns a number to a hidden matrix for each square.
		 */
		private void countMines() {
			for (int c = 0; c < width; c++) {
				for (int r = 0; r < height; r++) {
					if (!isMine(c, r) && inBounds(c, r)) {
						numberMatrix[c][r] = countBorderingMines(c, r);
					}
					else
						numberMatrix[c][r] = -1;
				}
			}
		}
		/**
		 * Counts the number of bordering mines for a square.
		 * 
		 * @param col
		 * @param row
		 * @return Number of mines.
		 */
		private int countBorderingMines(int col, int row) {
			int mines = 0;
			int[][] cords = {{col - 1, row - 1}, {col, row - 1}, {col + 1, row - 1}, 
					{col - 1, row}, {col + 1, row}, {col - 1, row + 1}, {col, row + 1}, {col + 1, row + 1}
			};
			for (int i = 0; i < 8; i++) {
				if (inBounds(cords[i][0], cords [i][1]) && isMine(cords[i][0], cords [i][1]))
					mines++;
			}
			return mines;
		}
		/**
		 * Digs the places around a square.
		 * @param col
		 * @param row
		 */
		private void digAround(int col, int row) {
			int[][] cords = {{col - 1, row - 1}, {col, row - 1}, {col + 1, row - 1}, 
					{col - 1, row}, {col + 1, row}, {col - 1, row + 1}, {col, row + 1}, {col + 1, row + 1}
			};
			for (int i = 0; i < 8; i++) {
				if (inBounds(cords[i][0], cords [i][1]) && !((Button)nodeAt(cords[i][0], cords [i][1])).isDisabled())
					dig(cords[i][0], cords [i][1]);
			}
		}
		/**
		 * Digs a spot. Digs the spots around it if 0. Game over if it's a mine.
		 * @param c
		 * @param r
		 */
		public void dig(int c, int r) {
			Button bt = (Button)nodeAt(c, r);
			if (firstMove) {
				addMines(mines, c, r);
				countMines();
			}
			if (isMine(c, r) && !isMarked(c, r)) {
				bt.setDisable(true);
				bt.setStyle(BUTTON_STYLE + ";-fx-background-color: #ff0000; -fx-opacity: 1;");
				revealMines();
				lose();
			}
			if (!isMine(c, r) && !isMarked(c, r)) {
				int number = numberMatrix[c][r];
				bt.setText(String.valueOf(number));
				bt.setDisable(true);
				bt.setStyle(BUTTON_STYLE + "; -fx-opacity: 1;");
				bt.setTextFill(setNumberColor(number));
				if (number == 0)
					digAround(c, r);
				++squaresRevealed;
				if (squaresRevealed >= (width * height) - mines) {
					win();
				}
			}
		}
		/**
		 * Flags or marks a spot.
		 * @param c
		 * @param r
		 */
		public void flag(int c, int r) {
			Button b = (Button)nodeAt(c, r);
			switch (b.getText()) {
			case " ":
				b.setText(FLAG);
				b.setTextFill(Color.RED);
				break;
			case FLAG:
				b.setText("?");
				break;
			case "?":
				b.setText(" ");
			}
		}
		/**
		 * Reveals all mines on the board.
		 */
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
		/**
		 * 
		 * @param col
		 * @param row
		 * @return Node at given index.
		 */
		public Node nodeAt(int col, int row) {
		    for (Node node : getChildren()) {
		        if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
		            return node;
		        }
		    }
		    return null;
		}
		/**
		 * Get a color for each number.
		 * @param c
		 * @return Color for given int.
		 */
		public Color setNumberColor(int c) {
			switch (c) {
			case 0: return Color.GRAY;
			case 1: return Color.BLUE;
			case 2: return Color.GREEN;
			case 3: return Color.INDIANRED;
			case 4: return Color.DARKBLUE;
			case 5: return Color.DARKRED;
			case 6: return Color.TEAL;
			case 7: return Color.BLACK;
			case 8: return Color.MAGENTA;
			default: return Color.BLACK;
			}
		}
		/**
		 * Checks a spot for a mine.
		 * 
		 * @param c column
		 * @param r row
		 * @return
		 */
		public boolean isMine(int c, int r) {
			return matrix[c][r];
		}
		/**
		 * Checks if an index is in bounds.
		 * 
		 * @param c
		 * @param r
		 * @return
		 */
		public boolean inBounds(int c, int r) {
			if (c < getBoardWidth() && c >= 0 && r < getBoardHeight() && r >= 0) {
				return true;
			}
			return false;
		}
		/**
		 * Checks if an index has been marked.
		 * 
		 * @param c
		 * @param r
		 * @return
		 */
		public boolean isMarked(int c, int r) {
			Button bt = (Button)nodeAt(c, r);
			return bt.getText().equals("?") || bt.getText().equals(FLAG);
		}
		/**
		 * 
		 * @return Width of the board.
		 */
		public int getBoardWidth() {
			return width;
		}
		/**
		 * 
		 * @return Height of the board.
		 */
		public int getBoardHeight() {
			return height;
		}
		
	}

}