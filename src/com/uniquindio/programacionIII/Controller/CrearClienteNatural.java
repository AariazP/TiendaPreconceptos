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
import lombok.Data;

@Data
public class CrearClienteNatural {
	
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
				main.mostrarAlerta("Cliente creado con exito");
				
			}else {
				
				throw new LecturaException("Complete los campos de texto");
				
			}
			
		} catch (Exception e) {
			
			main.mostrarAlerta(e.getMessage());
			
		}

	}
}
