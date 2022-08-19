package com.uniquindio.programacionIII.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import com.uniquindio.programacionIII.Application.Main;
import com.uniquindio.programacionIII.Model.Envasado;
import com.uniquindio.programacionIII.Model.Producto;
import com.uniquindio.programacionIII.Model.Singleton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import lombok.Data;


@Data
public class ActualizarProductoEnvasado {

	private Main main;
	
	private Producto productoSelected;
	
	private String[] paises = {"Colombia","Argentina","Chile","Ecuador","Peru"};

	@FXML
	private ComboBox<String> cmbPaises = new ComboBox<>();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private DatePicker fechaEnvasado;

	@FXML
	private TextField txtCantDisponible;

	@FXML
	private TextField txtDescripcion;

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtPeso;

	@FXML
	private TextField txtValor;

	@FXML
	void guardarInfo(ActionEvent event) {

		String nombre = txtNombre.getText();
		String descripcion = txtDescripcion.getText();
		LocalDate fecha = fechaEnvasado.getValue();
		String pais = cmbPaises.getValue();
		try {

			Double peso = Double.parseDouble(txtPeso.getText());
			Double valor = Double.parseDouble(txtValor.getText());
			Integer cantDisponible = Integer.parseInt(txtCantDisponible.getText());


			Singleton.actualizarProductoEnvasado((Envasado) productoSelected,nombre, descripcion, fecha, pais, peso, valor, cantDisponible);
			main.mostrarAlerta("Producto actualizado con exito");
			
		}catch (NumberFormatException e) {
			main.mostrarAlerta("Ingrese valores numericos");
		}catch (Exception e) {
			main.mostrarAlerta(e.getMessage());
		}

	}

	@FXML
	void initialize() {
		assert fechaEnvasado != null : "fx:id=\"fechaEnvasado\" was not injected: check your FXML file 'CrearProductoEnvasado.fxml'.";
		assert txtCantDisponible != null : "fx:id=\"txtCantDisponible\" was not injected: check your FXML file 'CrearProductoEnvasado.fxml'.";
		assert txtDescripcion != null : "fx:id=\"txtDescripcion\" was not injected: check your FXML file 'CrearProductoEnvasado.fxml'.";
		assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'CrearProductoEnvasado.fxml'.";
		assert txtPeso != null : "fx:id=\"txtPeso\" was not injected: check your FXML file 'CrearProductoEnvasado.fxml'.";
		assert txtValor != null : "fx:id=\"txtValor\" was not injected: check your FXML file 'CrearProductoEnvasado.fxml'.";
		cmbPaises.getItems().addAll(paises);
	}

}
