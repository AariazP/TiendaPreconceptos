package com.uniquindio.programacionIII.Controller;

import java.io.IOException;

import com.uniquindio.programacionIII.Application.Main;
import com.uniquindio.programacionIII.Model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import lombok.Data;

@Data
public class Controller2 {


	private Main main;
	@FXML
	private Button btnActualizar;

	@FXML
	private Button btnComprar;

	@FXML
	private Button btnEliminar;

	@FXML
	private Button btnReemplazar;

	@FXML
	private Button btncrear;

	@FXML
	private TableView<Cliente> tblClientes;

	private CrearClienteNatural controllerClienteNatural;

	@FXML
	void actualizarCliente(ActionEvent event) {
		System.out.println("Actualizar");
	}

	@FXML
	void crearClienteNatural(ActionEvent event) {
		crearClienteNatural();
	}

	private void crearClienteNatural() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/uniquindio/programacionIII/View/CrearClienteNatural.fxml"));
			Parent root = loader.load();
			controllerClienteNatural = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		
	
	public void crearClienteJuridico(ActionEvent event) {
		crearClienteJuridico();
	}
	private void crearClienteJuridico() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/uniquindio/programacionIII/View/CrearClienteJuridico.fxml"));
			Parent root;
			root = loader.load();
			controllerClienteNatural = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@FXML
	void eliminarCliente(ActionEvent event) {
		System.out.println("eliminar");
	}

	@FXML
	void realizarCompra(ActionEvent event) {
		System.out.println("comprar");
	}

	@FXML
	void reemplazarCliente(ActionEvent event) {
		System.out.println("reemplazar");
	}
}
