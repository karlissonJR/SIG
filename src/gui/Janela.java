package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Janela extends Application{

	private static Stage stage;
	private static Scene menuPrincipal;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		stage = primaryStage;
		
		Pane fxmlMenuPrincipal = FXMLLoader.load(getClass().getResource("fxml/MenuPrincipal.fxml"));
		menuPrincipal = new Scene(fxmlMenuPrincipal);
		
		primaryStage.setWidth(500);
		primaryStage.setHeight(400);
		primaryStage.setScene(menuPrincipal);
		primaryStage.setTitle("SIG");
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	public static void run(String[] args) {
		launch(args);
	}

}
