package com.uniquindio.programacionIII.Application;
	
import java.io.IOException;

import com.uniquindio.programacionIII.Controller.Controller1;
import com.uniquindio.programacionIII.Controller.Controller2;
import com.uniquindio.programacionIII.Controller.Controller3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	private Controller1 controller1;
	private Controller2 controller2;
	private Controller3 controller3;
	
	private Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		controller1 = new Controller1();
		controller2  = new Controller2();
		controller3 = new Controller3();
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/uniquindio/programacionIII/View/FrameInit.fxml"));
			Scene scene = new Scene(loader.load());
			controller1 = loader.getController();
			controller1.setMain(this);
			primaryStage.setScene(scene);
			stage = primaryStage;
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void abrirFrameClientes() {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("/com/uniquindio/programacionIII/View/FrameClientes.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
}
