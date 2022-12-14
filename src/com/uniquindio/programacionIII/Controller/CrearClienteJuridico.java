package com.uniquindio.programacionIII.Controller;


import com.uniquindio.programacionIII.Application.Main;
import com.uniquindio.programacionIII.Exceptions.EscrituraException;
import com.uniquindio.programacionIII.Model.Singleton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;



public class CrearClienteJuridico {

	public Main getMain() {
		return main;
	}


	public void setMain(Main main) {
		this.main = main;
	}


	public TextField getTxtApellidos() {
		return txtApellidos;
	}


	public void setTxtApellidos(TextField txtApellidos) {
		this.txtApellidos = txtApellidos;
	}


	public TextField getTxtDireccion() {
		return txtDireccion;
	}


	public void setTxtDireccion(TextField txtDireccion) {
		this.txtDireccion = txtDireccion;
	}


	public TextField getTxtId() {
		return txtId;
	}


	public void setTxtId(TextField txtId) {
		this.txtId = txtId;
	}


	public TextField getTxtNit() {
		return txtNit;
	}


	public void setTxtNit(TextField txtNit) {
		this.txtNit = txtNit;
	}


	public TextField getTxtNombre() {
		return txtNombre;
	}


	public void setTxtNombre(TextField txtNombre) {
		this.txtNombre = txtNombre;
	}


	public TextField getTxtTelefono() {
		return txtTelefono;
	}


	public void setTxtTelefono(TextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}


	public TextField getTxtTributaria() {
		return txtTributaria;
	}


	public void setTxtTributaria(TextField txtTributaria) {
		this.txtTributaria = txtTributaria;
	}


	private Main main;

	@FXML
	private TextField txtApellidos;

	@FXML
	private TextField txtDireccion;

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtNit;

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtTelefono;

	@FXML
	private TextField txtTributaria;

	@FXML
	void guardarInformacion(ActionEvent event) {

		String nombre = txtNombre.getText();
		String apellidos = txtApellidos.getText();
		String identificacion = txtId.getText();
		String direccion = txtDireccion.getText();
		String telefono = txtTelefono.getText();
		String nit =txtNit.getText();
		String idTributaria = txtTributaria.getText();
		System.out.println("Entra al metodo");
		try {
			if(!nombre.equals("") && !apellidos.equals("") && !identificacion.equals("") &&
					!direccion.equals("") && !telefono.equals("") && !nit.equals("") ) {
				System.out.println("Entra a la condicion");

				Singleton.crearClienteJuridico(nombre,apellidos,identificacion,direccion,telefono,nit,idTributaria);
				main.mostrarAlerta("Cliente creado con exito");

			}else {
				StringBuilder str = new StringBuilder("Ya existe un cliente /n con esas caracteristicas");
				
				throw new EscrituraException(str.toString());
			}

		} catch (Exception e) {

			main.mostrarAlerta(e.getMessage());
		}


	}


	@FXML
	void initialize() {
		assert txtApellidos != null : "fx:id=\"txtApellidos\" was not injected: check your FXML file 'CrearClienteJuridico.fxml'.";
		assert txtDireccion != null : "fx:id=\"txtDireccion\" was not injected: check your FXML file 'CrearClienteJuridico.fxml'.";
		assert txtId != null : "fx:id=\"txtId\" was not injected: check your FXML file 'CrearClienteJuridico.fxml'.";
		assert txtNit != null : "fx:id=\"txtNit\" was not injected: check your FXML file 'CrearClienteJuridico.fxml'.";
		assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'CrearClienteJuridico.fxml'.";
		assert txtTelefono != null : "fx:id=\"txtTelefono\" was not injected: check your FXML file 'CrearClienteJuridico.fxml'.";
		assert txtTributaria != null : "fx:id=\"txtTributaria\" was not injected: check your FXML file 'CrearClienteJuridico.fxml'.";

	}
}
