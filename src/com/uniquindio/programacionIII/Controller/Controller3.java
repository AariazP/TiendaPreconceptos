package com.uniquindio.programacionIII.Controller;

import java.io.IOException;

import com.uniquindio.programacionIII.Application.Main;
import com.uniquindio.programacionIII.Model.Producto;
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
		System.out.println("Actualizar");
	}

	@FXML
	void buscar(ActionEvent event) {
		System.out.println("buscar");
	}

	@FXML
	void eliminar(ActionEvent event) {
		System.out.println("eliminar");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@FXML
	void crearPerecedero(ActionEvent event) {

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
