package com.uniquindio.programacionIII.Controller;

import java.time.LocalDate;

import com.uniquindio.programacionIII.Exceptions.LecturaException;
import com.uniquindio.programacionIII.Model.ClienteNatural;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CrearClienteNatural {
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
	void guardarInformacion(ActionEvent event) {
		
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
				
				ClienteNatural cliente = new ClienteNatural(nombre, apellidos, identificacion, direccion, telefono, email, fecha);
				System.out.println(cliente);
			}else {
				throw new LecturaException("Complete los campos de texto");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
