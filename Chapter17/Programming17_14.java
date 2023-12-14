import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Programming17_14 extends Application {
	@Override
	public void start(Stage mainStage) {
		Text inputFileText = new Text("Enter the name of an existing file and press enter.(ex. 'Exercise17_14.dat')");
		TextField tfInputFile = new TextField();
		Text outputFileText = new Text("Enter a name for the encrypted file.");
		TextField tfOutputFile = new TextField();
		Text status = new Text();
		status
		Button bt = new Button("Encrypt");
		bt.setDisable(true);
		
		VBox pane = new VBox();
		pane.setPadding(new Insets(10));
		
		pane.getChildren().addAll(inputFileText, tfInputFile, outputFileText, tfOutputFile, status, bt);
		
		Scene scene = new Scene(pane, 400, 200);
		
		tfInputFile.setOnAction(e -> {
			try {
				File file = new File(tfInputFile.getText());
				if (file.createNewFile()) {
					System.out.println("File not found");
					bt.setDisable(true);
					status.setText("File not found");
					file.delete();
				}
				else {
					status.setText("File '" + tfInputFile.getText() + "' found in " + file.getCanonicalPath());
					bt.setDisable(false);
					StringBuilder newName = new StringBuilder(tfInputFile.getText());
					newName.insert(newName.indexOf("."), "Encrypted");
					if (tfOutputFile.getText().equals("")) {
						tfOutputFile.setText(newName.toString());
					}
				}
			}
			catch (Exception ex) {
				System.out.println(ex.toString());
			}
		});
		
		mainStage.setScene(scene);
		mainStage.setTitle("Programming17_14");
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}
	
	/*
	 * String fileName = tfInputFile.getText();
			try (DataInputStream input = new DataInputStream(new BufferedInputStream(
					new FileInputStream(fileName)))
			) {
				 //
			}
			catch (FileNotFoundException ex) {
				System.out.println("File not found");
				status.setText("File '" + fileName + "' not found.");
				bt.setDisable(true);
			}
			catch (IOException ex) {
				System.out.println(ex.toString());
			}
	 */

}
