package com.uniquindio.programacionIII.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import com.uniquindio.programacionIII.Application.Main;
import com.uniquindio.programacionIII.Exceptions.TiendaExceptions;
import com.uniquindio.programacionIII.Model.Singleton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


public class CrearProductoEnvasado {

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public String[] getPaises() {
		return paises;
	}

	public void setPaises(String[] paises) {
		this.paises = paises;
	}

	public ComboBox<String> getCmbPaises() {
		return cmbPaises;
	}

	public void setCmbPaises(ComboBox<String> cmbPaises) {
		this.cmbPaises = cmbPaises;
	}

	public ResourceBundle getResources() {
		return resources;
	}

	public void setResources(ResourceBundle resources) {
		this.resources = resources;
	}

	public URL getLocation() {
		return location;
	}

	public void setLocation(URL location) {
		this.location = location;
	}

	public DatePicker getFechaEnvasado() {
		return fechaEnvasado;
	}

	public void setFechaEnvasado(DatePicker fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
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

	public TextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(TextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public TextField getTxtPeso() {
		return txtPeso;
	}

	public void setTxtPeso(TextField txtPeso) {
		this.txtPeso = txtPeso;
	}

	public TextField getTxtValor() {
		return txtValor;
	}

	public void setTxtValor(TextField txtValor) {
		this.txtValor = txtValor;
	}

	private Main main;
	
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


			Singleton.crearProductoEnvasado(nombre, descripcion, cantDisponible, fecha, peso, pais, valor);
			main.mostrarAlerta("Producto creado con exito");
		}catch (NumberFormatException e) {
			main.mostrarAlerta("Ingrese valores numericos");
		}catch (TiendaExceptions e) {
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
