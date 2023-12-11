package pack;
import java.io.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class FileCopier extends Application{
	@Override
	public void start(Stage primaryStage) {
		File file = new File("test.dat");
		try {
			file.createNewFile();
		}
		catch (IOException e) {
			
		}
		Button btFilePath = new Button("File to copy");
		Button btDestination = new Button("Destination folder");
		Button btCopy = new Button("Copy");
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Data Files", "*.dat"));
		DirectoryChooser directoryChooser = new DirectoryChooser();
		
		String file1, file2;
		
		btFilePath.setOnAction(e -> {
			File selectedFile = fileChooser.showOpenDialog(primaryStage);
			if (selectedFile != null) {
				System.out.println(selectedFile.getPath());
			}
			file1 = selectedFile.getPath();
		});
		
		btDestination.setOnAction(e -> {
			File selectedDirectory = directoryChooser.showDialog(primaryStage);
			if (selectedDirectory != null) {
				System.out.println(selectedDirectory.getPath());
			}
			file2 = selectedDirectory.getPath();
		});
		
		btCopy.setOnAction(e -> {
			try {
				if (file == null) {
					return;
				}
			}
			catch (Exception ex) {
				
			}
		});
		Pane pane = new VBox();
		pane.getChildren().addAll(btFilePath, btDestination);
		
		Scene scene = new Scene(pane, 200, 100);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
