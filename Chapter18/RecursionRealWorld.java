import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class RecursionRealWorld extends Application {
	int order = 0;
	TrianglesPane triPane = new TrianglesPane();
	VBox pane = new VBox(triPane, new Text("Press + or - to change the order."));
	@Override
	public void start(Stage mainStage) {
		pane.setAlignment(Pos.CENTER);
		BorderPane bPane = new BorderPane();
		bPane.setCenter(triPane);
		bPane.setBottom(pane);
		
		Scene scene = new Scene(bPane, 400, 400);
		
		scene.setOnKeyPressed(e -> {
			switch (e.getCode().toString()) {
			case "EQUALS":
				if (order <= 8)
					order++;
				break;
			case "MINUS":
				if (order > 0)
					order--;
				break;
			}
			triPane.draw();
		});
		
		pane.widthProperty().addListener(ov -> triPane.draw());
		pane.heightProperty().addListener(ov -> triPane.draw());
		
		mainStage.setScene(scene);
		mainStage.setTitle("RecursionRealWorld");
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}
	
	class TrianglesPane extends Pane {
		
		public void draw() {
			Point2D p1 = new Point2D(getWidth() / 2, 10);
			Point2D p2 = new Point2D(10, getHeight() - 10);
			Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);
			
			getChildren().clear();
			
			drawTriangles(order, p1, p2, p3);
		}
		
		public void drawTriangles(int order, Point2D p1, Point2D p2, Point2D p3) {
			if (order == 0) {
				Polygon tri = new Polygon();
				tri.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
				tri.setStroke(Color.BLACK);
				tri.setFill(Color.TRANSPARENT);
				
				getChildren().add(tri);
			}
			else {
				Point2D p12 = p1.midpoint(p2);
				Point2D p23 = p2.midpoint(p3);
				Point2D p31 = p3.midpoint(p1);
				
				drawTriangles(order - 1, p1, p12, p31);
				drawTriangles(order - 1, p12, p2, p23);
				drawTriangles(order - 1, p31, p23, p3);
			}
		}
	}

}
