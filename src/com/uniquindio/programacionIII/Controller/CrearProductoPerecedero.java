package com.uniquindio.programacionIII.Controller;

import java.time.LocalDate;

import com.uniquindio.programacionIII.Application.Main;
import com.uniquindio.programacionIII.Exceptions.TiendaExceptions;
import com.uniquindio.programacionIII.Model.Singleton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import lombok.Data;

@Data
public class CrearProductoPerecedero {
	
	private Main main;

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
			Singleton.crearProductoPerecedero(descripcion, cantDisponible, nombre, valor, fechaVencimiento);
			main.mostrarAlerta("Producto creado con exito");
		} catch (NumberFormatException e) {
			main.mostrarAlerta("Ingrese valores numericos");
		} catch (TiendaExceptions e) {
			main.mostrarAlerta(e.getMessage());
		}
    	
    }

}
