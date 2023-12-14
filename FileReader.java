import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
public class FileReader extends Application {
	@Override
	public void start(Stage mainStage) {
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File(".."));
		Button button = new Button("Choose file");
		ScrollPane sp = new ScrollPane();
		Text text = new Text("File contents will appear here.");
		sp.setContent(text);
		text.setFont(Font.font("", FontPosture.ITALIC, 12));
		
		VBox pane = new VBox();
		pane.getChildren().addAll(button, sp);
		text.wrappingWidthProperty().bind(pane.widthProperty().subtract(12));
		
		Scene scene = new Scene(pane, 400, 600);
		
		button.setOnAction(e -> {
			File file = fc.showOpenDialog(mainStage);
			try (DataInputStream input = new DataInputStream(new BufferedInputStream(
					new FileInputStream(file)))
			) {
				if (file != null) {
					text.setText("");
					int i;
					while ((i = input.read()) != -1) {
						text.setText(text.getText().concat(String.valueOf(i)));
					}
				}
			}
			catch (Exception ex) {}
		});
		
		mainStage.setScene(scene);
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
