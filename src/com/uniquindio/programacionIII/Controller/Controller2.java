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



public class Controller2 {


	public Main getMain() {
		return main;
	}


	public void setMain(Main main) {
		this.main = main;
	}


	public Button getBtnActualizar() {
		return btnActualizar;
	}


	public void setBtnActualizar(Button btnActualizar) {
		this.btnActualizar = btnActualizar;
	}


	public Button getBtnComprar() {
		return btnComprar;
	}


	public void setBtnComprar(Button btnComprar) {
		this.btnComprar = btnComprar;
	}


	public Button getBtnEliminar() {
		return btnEliminar;
	}


	public void setBtnEliminar(Button btnEliminar) {
		this.btnEliminar = btnEliminar;
	}


	public Button getBtnReemplazar() {
		return btnReemplazar;
	}


	public void setBtnReemplazar(Button btnReemplazar) {
		this.btnReemplazar = btnReemplazar;
	}


	public Button getBtncrear() {
		return btncrear;
	}


	public void setBtncrear(Button btncrear) {
		this.btncrear = btncrear;
	}


	public TableView<Cliente> getTblClientes() {
		return tblClientes;
	}


	public void setTblClientes(TableView<Cliente> tblClientes) {
		this.tblClientes = tblClientes;
	}


	public ObservableList<Cliente> getLista() {
		return lista;
	}


	public void setLista(ObservableList<Cliente> lista) {
		this.lista = lista;
	}


	public TableColumn<Cliente, Integer> getColD() {
		return colD;
	}


	public void setColD(TableColumn<Cliente, Integer> colD) {
		this.colD = colD;
	}


	public TableColumn<Cliente, String> getColNombre() {
		return colNombre;
	}


	public void setColNombre(TableColumn<Cliente, String> colNombre) {
		this.colNombre = colNombre;
	}


	public TableColumn<Cliente, String> getColTelefono() {
		return colTelefono;
	}


	public void setColTelefono(TableColumn<Cliente, String> colTelefono) {
		this.colTelefono = colTelefono;
	}


	public TableColumn<Cliente, String> getColTipo() {
		return colTipo;
	}


	public void setColTipo(TableColumn<Cliente, String> colTipo) {
		this.colTipo = colTipo;
	}


	public CrearClienteNatural getControllerClienteNatural() {
		return controllerClienteNatural;
	}


	public void setControllerClienteNatural(CrearClienteNatural controllerClienteNatural) {
		this.controllerClienteNatural = controllerClienteNatural;
	}


	public CrearClienteJuridico getControllerClienteJuridico() {
		return controllerClienteJuridico;
	}


	public void setControllerClienteJuridico(CrearClienteJuridico controllerClienteJuridico) {
		this.controllerClienteJuridico = controllerClienteJuridico;
	}


	public ActualizarClienteNatural getControllerActualizarClienteNatural() {
		return controllerActualizarClienteNatural;
	}


	public void setControllerActualizarClienteNatural(ActualizarClienteNatural controllerActualizarClienteNatural) {
		this.controllerActualizarClienteNatural = controllerActualizarClienteNatural;
	}


	public RealizarCompra getCompraController() {
		return compraController;
	}


	public void setCompraController(RealizarCompra compraController) {
		this.compraController = compraController;
	}


	public Stage getStageNatural() {
		return stageNatural;
	}


	public void setStageNatural(Stage stageNatural) {
		this.stageNatural = stageNatural;
	}


	public Stage getStageJuridico() {
		return stageJuridico;
	}


	public void setStageJuridico(Stage stageJuridico) {
		this.stageJuridico = stageJuridico;
	}


	public Stage getStageCompra() {
		return stageCompra;
	}


	public void setStageCompra(Stage stageCompra) {
		this.stageCompra = stageCompra;
	}

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
	
	private RealizarCompra compraController;

	private Stage stageNatural, stageJuridico, stageCompra;


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
		
		Cliente clienteSelected = tblClientes.getSelectionModel().getSelectedItem();
		if(clienteSelected != null) {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/uniquindio/programacionIII/View/RealizarCompra.fxml"));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			compraController = loader.getController();
			compraController.setMain(main);
			compraController.setClienteSelected(clienteSelected);
			Scene scene = new Scene(root);
			stageCompra = new Stage();
			stageCompra.setScene(scene);
			stageCompra.showAndWait();

		}else {
			main.mostrarAlerta("Para hacer la compra seleccione un cliente de la tabla");
		}
		
		
	}

	@FXML
	void irLogin(ActionEvent event) {
		main.irLogin();
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
