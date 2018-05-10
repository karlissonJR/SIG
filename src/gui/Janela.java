package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Janela extends Application{

	private static Stage stage;
	private static Scene menuPrincipal;
	private static Scene menuDoFuncionario;
	private static Scene telaCadastroEstoque;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		stage = primaryStage;
		
		Pane fxmlMenuPrincipal = FXMLLoader.load(getClass().getResource("fxml/MenuPrincipal.fxml"));
		menuPrincipal = new Scene(fxmlMenuPrincipal);
		
		Pane fxmlMenuDoFuncionario = FXMLLoader.load(getClass().getResource("fxml/MenuDoFuncionario.fxml"));
		menuDoFuncionario = new Scene(fxmlMenuDoFuncionario);
		
		Pane fxmlTelaCadastroEstoque = FXMLLoader.load(getClass().getResource("fxml/TelaCadastroEstoque.fxml"));
		telaCadastroEstoque = new Scene(fxmlTelaCadastroEstoque);
		
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.setScene(menuPrincipal);
		primaryStage.setTitle("SIG");
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	public static void run(String[] args) {
		launch(args);
	}

	public static void mudarCena(String cena) {
		switch(cena) {
		case "menuPrincipal":
			stage.setScene(menuPrincipal);
			stage.setWidth(800);
			stage.setHeight(600);
			break;
		case "menuFuncionario":
			stage.setScene(menuDoFuncionario);
			stage.setWidth(800);
			stage.setHeight(600);
			break;
		case "telaCadastroEstoque":
			stage.setScene(telaCadastroEstoque);
			stage.setWidth(400);
			stage.setHeight(400);
			break;
		}
	}
	
}
