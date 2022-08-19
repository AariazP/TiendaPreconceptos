package com.uniquindio.programacionIII.Controller;

import java.io.IOException;

import com.uniquindio.programacionIII.Application.Main;
import com.uniquindio.programacionIII.Exceptions.TiendaExceptions;
import com.uniquindio.programacionIII.Model.Envasado;
import com.uniquindio.programacionIII.Model.Producto;
import com.uniquindio.programacionIII.Model.Refrigerado;
import com.uniquindio.programacionIII.Model.Singleton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lombok.Data;

@Data
public class Controller3 {

	private Main main;

	private Stage envasadoStage, perecederoStage, refrigeradoStage;

	private CrearProductoRefrigerado refrigeradoController;

	private CrearProductoEnvasado envasadoController;

	private CrearProductoPerecedero perecederoController;
	
	private ActualizarProductoEnvasado actualizarEnvasado;
	
	private ActualizarProductoPerecedero actualizarPerecedero;
	
	private ActualizarProductoRefrigerado actualizarRefrigerado;

	@FXML
	private TableColumn<Producto, Integer> colCantDisponble = new TableColumn<Producto, Integer>();

	@FXML
	private TableColumn<Producto, String> colNombre= new TableColumn<Producto, String>();

	@FXML
	private TableColumn<Producto, String> colTipo= new TableColumn<Producto, String>();

	@FXML
	private TableColumn<Producto, String> colValor= new TableColumn<Producto, String>();

	@FXML
	private TableView<Producto> tblProductos= new TableView<Producto>();

	@FXML
	private ObservableList<Producto> lista = FXCollections.observableArrayList();


	@FXML
	void actualizar(ActionEvent event) {

		Producto productoSelected = tblProductos.getSelectionModel().getSelectedItem();

		if(productoSelected != null) {

			mostrarActualizarProducto(productoSelected);

		}else {
			main.mostrarAlerta("Para actualizar seleccione un producto de la tabla");
		}
	}

	private void mostrarActualizarProducto(Producto productoSelected) {

		if(productoSelected instanceof Envasado) {
			mostrarActualizarEnvasado(productoSelected);
		}else if(productoSelected instanceof Refrigerado) {
			mostrarActualizarRefrigerado(productoSelected);
		}else {
			mostrarActualizarPerecedero(productoSelected);
		}
	}

	private void mostrarActualizarPerecedero(Producto productoSelected) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/uniquindio/programacionIII/View/ActualizarProductoPerecedero.fxml"));
		Parent root = null;

		try {
			root = loader.load();
			actualizarPerecedero = loader.getController();
			actualizarPerecedero.setMain(main);
			actualizarPerecedero.setProductoSelected(productoSelected);
			Scene scene = new Scene(root);
			perecederoStage = new Stage();
			perecederoStage.setScene(scene);
			perecederoStage.showAndWait();
			actualizarTablaProducto();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void mostrarActualizarRefrigerado(Producto productoSelected) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/uniquindio/programacionIII/View/ActualizarProductoRefrigerado.fxml"));
		Parent root = null;

		try {
			root = loader.load();
			actualizarRefrigerado = loader.getController();
			actualizarRefrigerado.setMain(main);
			actualizarRefrigerado.setProductoSelected(productoSelected);
			Scene scene = new Scene(root);
			refrigeradoStage = new Stage();
			refrigeradoStage.setScene(scene);
			refrigeradoStage.showAndWait();
			actualizarTablaProducto();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void mostrarActualizarEnvasado(Producto productoSelected) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/uniquindio/programacionIII/View/ActualizarProductoEnvasado.fxml"));
		Parent root = null;

		try {
			root = loader.load();
			actualizarEnvasado = loader.getController();
			actualizarEnvasado.setMain(main);
			actualizarEnvasado.setProductoSelected(productoSelected);
			Scene scene = new Scene(root);
			envasadoStage = new Stage();
			envasadoStage.setScene(scene);
			envasadoStage.showAndWait();
			actualizarTablaProducto();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void buscar(ActionEvent event) {
		System.out.println("buscar");
	}

	@FXML
	void eliminar(ActionEvent event) {
		
		Producto productoSelected = tblProductos.getSelectionModel().getSelectedItem();
		
		if(productoSelected != null) {
			try {
				Singleton.eliminarProducto(productoSelected);
			} catch (TiendaExceptions e) {
				main.mostrarAlerta(e.getMessage());
			}
		}else {
			main.mostrarAlerta("Seleccione un producto de la tabla para eliminar");
		}
	}

	@FXML
	void reemplazar(ActionEvent event) {
		System.out.println("reemplazar");
	}

	@FXML
	void irLogin(ActionEvent event) {
		main.irLogin();
	}

	@FXML
	void crearEnvasado(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/uniquindio/programacionIII/View/CrearProductoEnvasado.fxml"));
		Parent root = null;

		try {
			root = loader.load();
			envasadoController = loader.getController();
			envasadoController.setMain(main);
			Scene scene = new Scene(root);
			envasadoStage = new Stage();
			envasadoStage.setScene(scene);
			envasadoStage.showAndWait();
			actualizarTablaProducto();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void crearRefrigerado(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/uniquindio/programacionIII/View/CrearProductoRefrigerado.fxml"));
		Parent root = null;
		try {
			root = loader.load();
			refrigeradoController = loader.getController();
			refrigeradoController.setMain(main);
			Scene scene = new Scene(root);
			refrigeradoStage = new Stage();
			refrigeradoStage.setScene(scene);
			refrigeradoStage.showAndWait();
			actualizarTablaProducto();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	@FXML
	void crearPerecedero(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/uniquindio/programacionIII/View/CrearProductoPerecedero.fxml"));
		Parent root = null;

		try {
			root = loader.load();
			perecederoController = loader.getController();
			perecederoController.setMain(main);
			Scene scene = new Scene(root);
			perecederoStage = new Stage();
			perecederoStage.setScene(scene);
			perecederoStage.showAndWait();
			actualizarTablaProducto();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actualizarTablaProducto() {
		lista.clear();
		tblProductos.getItems().clear();
		lista.addAll(Singleton.getProductos());
		tblProductos.getItems().addAll(lista);
		tblProductos.refresh();
	}

	@FXML
	public void initialize() {
		this.colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
		this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.colCantDisponble.setCellValueFactory(new PropertyValueFactory<>("cantDisponible"));
		this.colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
	}

}
