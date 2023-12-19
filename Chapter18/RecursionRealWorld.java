import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class RecursionRealWorld extends Application {
	int order = 0;
	@Override
	public void start(Stage mainStage) {
		HBox pane = new HBox(new Text("Press + or - to change the order."));
		pane.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(pane, 400, 400);
		
		scene.setOnKeyPressed(e -> {
			switch (e.getCode().toString()) {
			case "EQUALS":
				++order;
				break;
			case "MINUS":
				if (order > 0)
					--order;
				break;
			}
		});
		
		mainStage.setScene(scene);
		mainStage.setTitle("RecursionRealWorld");
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
