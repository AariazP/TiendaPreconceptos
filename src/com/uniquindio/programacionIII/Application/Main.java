package com.uniquindio.programacionIII.Application;

import java.io.IOException;

import com.uniquindio.programacionIII.Controller.AlertaController;
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
	private Stage stageInicial, stageClientes, stageProductos;
	private AlertaController alertaController;


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
			stageInicial = primaryStage;
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Controller1 getController1() {
		return controller1;
	}

	public void setController1(Controller1 controller1) {
		this.controller1 = controller1;
	}

	public Controller2 getController2() {
		return controller2;
	}

	public void setController2(Controller2 controller2) {
		this.controller2 = controller2;
	}

	public Controller3 getController3() {
		return controller3;
	}

	public void setController3(Controller3 controller3) {
		this.controller3 = controller3;
	}

	public Stage getStageInicial() {
		return stageInicial;
	}

	public void setStageInicial(Stage stageInicial) {
		this.stageInicial = stageInicial;
	}

	public Stage getStageClientes() {
		return stageClientes;
	}

	public void setStageClientes(Stage stageClientes) {
		this.stageClientes = stageClientes;
	}

	public Stage getStageProductos() {
		return stageProductos;
	}

	public void setStageProductos(Stage stageProductos) {
		this.stageProductos = stageProductos;
	}

	public AlertaController getAlertaController() {
		return alertaController;
	}

	public void setAlertaController(AlertaController alertaController) {
		this.alertaController = alertaController;
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void abrirFrameClientes() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/uniquindio/programacionIII/View/FrameClientes.fxml"));
			Scene scene = new Scene(loader.load());
			controller2 = loader.getController();
			controller2.setMain(this);
			stageClientes = new Stage();
			stageClientes.setScene(scene);
			stageInicial.close();
			stageClientes.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void abrirProductos() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/uniquindio/programacionIII/View/FrameProductos.fxml"));
			Scene scene = new Scene(loader.load());
			controller3 = loader.getController();
			controller3.setMain(this);
			stageProductos = new Stage();
			stageProductos.setScene(scene);
			stageProductos.close();
			stageProductos.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mostrarAlerta(String message) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/uniquindio/programacionIII/View/Alerta.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		alertaController = loader.getController();
		alertaController.setLabel(message);
		Scene scene = new Scene(root);
		Stage stage2 = new Stage();
		stage2.setScene(scene);
		stage2.show();
	}

	public void cerrarFrameClienteNatura() {
		controller2.cerrarFrameClienteNatura();
	}

	public void irLogin() {
		
		if(stageClientes != null) stageClientes.close();
		if(stageProductos != null) stageProductos.close();
		
		stageInicial.show();
	}


}
