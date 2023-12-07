package pack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Balls extends Application {
	public static final int AMOUNT_OF_CIRCLES = 300;
	@Override
	public void start(Stage primaryStage) {
		ArrayList<cCircle> circles = new ArrayList<cCircle>();
		Pane pane = new Pane();
		pane.setPadding(new Insets(10));
		
		for (int i = 0; i < AMOUNT_OF_CIRCLES; i++) {
			cCircle newCir = new cCircle(randomRange(1, 10));
			newCir.setFill(Color.rgb(
					randomRange(0, 255), 
					randomRange(0, 255), 
					randomRange(0, 255)));
			circles.add(newCir);
		}
		
		
		circles.sort(Comparator.naturalOrder());
		
		int r = 0;
		
		for (cCircle c: circles) {
			pane.getChildren().add(c);
			c.setCenterY(c.getRadius() * 10);
			c.setCenterX(r);
			r += (int)c.getRadius();
		}
		
		Scene scene = new Scene(pane, 1366, 700);
		scene.setFill(Color.TRANSPARENT);
		
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setScene(scene);
		primaryStage.setAlwaysOnTop(true);
		primaryStage.setTitle("Balls");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}
	
	public static int randomRange(int min, int max) {
		int n = min;
		do {
			String s = "";
			for (int i = 0; i < String.valueOf(max).length(); i++) {
				s = s.concat(String.valueOf((int)(Math.random() * 10)));
			}
			n = Integer.valueOf(s);
		} while (!(n > min && n < max));
		return n;
	}
	
	class cCircle extends Circle implements Comparable<cCircle> {
		public cCircle(int i) {
			super(i);
		}
		@Override
		public int compareTo(cCircle other) {
			return Double.compare(getRadius(), other.getRadius());
		}
	}

}
