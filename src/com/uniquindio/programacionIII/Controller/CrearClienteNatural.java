package com.uniquindio.programacionIII.Controller;

import java.time.LocalDate;

import com.uniquindio.programacionIII.Application.Main;
import com.uniquindio.programacionIII.Exceptions.LecturaException;
import com.uniquindio.programacionIII.Exceptions.TiendaExceptions;
import com.uniquindio.programacionIII.Model.Singleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;




public class CrearClienteNatural {
	
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public TextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(TextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public DatePicker getTxtDate() {
		return txtDate;
	}

	public void setTxtDate(DatePicker txtDate) {
		this.txtDate = txtDate;
	}

	public TextField getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(TextField txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public TextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(TextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public TextField getTxtIdentificacion() {
		return txtIdentificacion;
	}

	public void setTxtIdentificacion(TextField txtIdentificacion) {
		this.txtIdentificacion = txtIdentificacion;
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

	private Main main;
	
	@FXML
	private TextField txtApellido;

	@FXML
	private DatePicker txtDate;

	@FXML
	private TextField txtDireccion;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtIdentificacion;

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtTelefono;

	@FXML
	void guardarInformacion(ActionEvent event)throws TiendaExceptions {
		
		String nombre = txtNombre.getText();
		String apellidos = txtApellido.getText();
		String telefono = txtTelefono.getText();
		String identificacion = txtIdentificacion.getText();
		String email = txtEmail.getText();
		String direccion = txtDireccion.getText();
		LocalDate fecha = txtDate.getValue();
		
		try {
			
			if(!nombre.equals("") && !apellidos.equals("") && !telefono.equals("") && !identificacion.equals("")
					&& !email.equals("") && fecha != null && !direccion.equals("")) {
				
				Singleton.crearClienteNatural(nombre, apellidos, identificacion, direccion, telefono, email, fecha);
				main.cerrarFrameClienteNatura();
				main.mostrarAlerta("Cliente creado con exito");
				
			}else {
				
				throw new LecturaException("Complete los campos de texto");
				
			}
			
		} catch (Exception e) {
			main.cerrarFrameClienteNatura();
			main.mostrarAlerta(e.getMessage());
			
		}

	}
}
