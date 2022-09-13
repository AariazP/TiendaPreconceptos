package com.uniquindio.programacionIII.Controller;

import java.time.LocalDate;

import com.uniquindio.programacionIII.Application.Main;
import com.uniquindio.programacionIII.Model.Perecedero;
import com.uniquindio.programacionIII.Model.Producto;
import com.uniquindio.programacionIII.Model.Singleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;




public class ActualizarProductoPerecedero {
	
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Producto getProductoSelected() {
		return productoSelected;
	}

	public void setProductoSelected(Producto productoSelected) {
		this.productoSelected = productoSelected;
	}

	public TextField getTxtCantDisponible() {
		return txtCantDisponible;
	}

	public void setTxtCantDisponible(TextField txtCantDisponible) {
		this.txtCantDisponible = txtCantDisponible;
	}

	public TextField getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(TextField txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public DatePicker getFecha() {
		return fecha;
	}

	public void setFecha(DatePicker fecha) {
		this.fecha = fecha;
	}

	public TextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(TextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public TextField getTxtValor() {
		return txtValor;
	}

	public void setTxtValor(TextField txtValor) {
		this.txtValor = txtValor;
	}

	private Main main;
	
	private Producto productoSelected; 

	@FXML
	private TextField txtCantDisponible;

	@FXML
	private TextField txtDescripcion;

	@FXML
	private DatePicker fecha;

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtValor;

	@FXML
	void guardarInfo(ActionEvent event) {

		String nombre = txtNombre.getText();
		String descripcion = txtDescripcion.getText();
		LocalDate fechaVencimiento = fecha.getValue();

		try {
			Integer cantDisponible = Integer.parseInt(txtCantDisponible.getText());
			Double valor = Double.parseDouble(txtValor.getText());
			Singleton.actualizarProductoPerecedero((Perecedero) productoSelected,nombre, descripcion, fechaVencimiento, cantDisponible, valor);
			main.mostrarAlerta("Producto actualizado con exito");
		} catch (NumberFormatException e) {
			main.mostrarAlerta("Ingrese valores numericos");
		}

	}
}
