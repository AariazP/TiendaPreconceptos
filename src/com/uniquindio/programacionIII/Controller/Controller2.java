package com.uniquindio.programacionIII.Controller;

import java.io.IOException;

import com.uniquindio.programacionIII.Application.Main;
import com.uniquindio.programacionIII.Exceptions.TiendaExceptions;
import com.uniquindio.programacionIII.Model.Cliente;
import com.uniquindio.programacionIII.Model.ClienteNatural;
import com.uniquindio.programacionIII.Model.Singleton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
	private TableView<Cliente> tblClientes = new TableView<>();

	@FXML
	private ObservableList<Cliente> lista = FXCollections.observableArrayList();

	@FXML
	private TableColumn<Cliente, Integer> colD = new TableColumn<>();

	@FXML
	private TableColumn<Cliente, String> colNombre = new TableColumn<>();

	@FXML
	private TableColumn<Cliente, String> colTelefono = new TableColumn<>();

	@FXML
	private TableColumn<Cliente, String> colTipo = new TableColumn<>();

	private CrearClienteNatural controllerClienteNatural;

	private CrearClienteJuridico controllerClienteJuridico;

	private ActualizarClienteNatural controllerActualizarClienteNatural;

	private Stage stageNatural, stageJuridico;


	@FXML
	void actualizarCliente(ActionEvent event) {
		Cliente clienteSelected = tblClientes.getSelectionModel().getSelectedItem();

		if(clienteSelected == null) {

			main.mostrarAlerta("Para actualizar un cliente /n seleccione uno de la tabla");

		}else {


			if(clienteSelected instanceof ClienteNatural) {

				mostrarActualizarFrame(clienteSelected);


			}else {

			}

			main.mostrarAlerta("Cliente actualizado");
			actualizarTablaClientes();
		}
	}


	private void mostrarActualizarFrame(Cliente clienteSelected) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/uniquindio/programacionIII/View/ActualizarClienteNatural.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		controllerActualizarClienteNatural = loader.getController();
		controllerActualizarClienteNatural.setMain(main);
		controllerActualizarClienteNatural.setCliente(clienteSelected);
		Scene scene = new Scene(root);
		stageJuridico = new Stage();
		stageJuridico.setScene(scene);
		stageJuridico.showAndWait();
		actualizarTablaClientes();
	}

	@FXML
	void crearClienteNatural(ActionEvent event) {
		crearClienteNatural();
	}


	public void actualizarTablaClientes() {
		lista.clear();
		tblClientes.getItems().clear();
		lista.addAll(Singleton.getClientes());
		tblClientes.getItems().addAll(lista);
		tblClientes.refresh();
	}

	private void crearClienteNatural() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/uniquindio/programacionIII/View/CrearClienteNatural.fxml"));
			Parent root = loader.load();
			controllerClienteNatural = loader.getController();
			controllerClienteNatural.setMain(main);
			Scene scene = new Scene(root);
			stageNatural = new Stage();
			stageNatural.setScene(scene);
			stageNatural.showAndWait();
			actualizarTablaClientes();

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
			controllerClienteJuridico = loader.getController();
			controllerClienteJuridico.setMain(main);
			Scene scene = new Scene(root);
			stageJuridico = new Stage();
			stageJuridico.setScene(scene);
			stageJuridico.showAndWait();
			actualizarTablaClientes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void eliminarCliente(ActionEvent event) {
		Cliente clienteSelected = tblClientes.getSelectionModel().getSelectedItem();

		if(clienteSelected == null) {
			main.mostrarAlerta("Para eliminar un cliente /n seleccione uno de la tabla");
		}else {
			try {
				Singleton.eliminarCliente(clienteSelected);
				main.mostrarAlerta("Cliente eliminado");
				actualizarTablaClientes();
			} catch (TiendaExceptions e) {
				main.mostrarAlerta(e.getMessage());
			}
		}
	}

	@FXML
	void realizarCompra(ActionEvent event) {
		System.out.println("comprar");
	}

	@FXML
	void irLogin(ActionEvent event) {

	}

	@FXML
	public void initialize() {
		this.colD.setCellValueFactory(new PropertyValueFactory<>("id"));
		this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		this.colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
	}

	public void cerrarFrameClienteNatura() {
		stageNatural.close();
	}


}
