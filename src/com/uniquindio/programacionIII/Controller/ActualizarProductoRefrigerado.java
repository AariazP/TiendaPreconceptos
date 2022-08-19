package com.uniquindio.programacionIII.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.uniquindio.programacionIII.Application.Main;
import com.uniquindio.programacionIII.Model.Producto;
import com.uniquindio.programacionIII.Model.Refrigerado;
import com.uniquindio.programacionIII.Model.Singleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import lombok.Data;

@Data
public class ActualizarProductoRefrigerado {
	
	
	private Main main;
	
	private Producto productoSelected;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox checkAprobado;

    @FXML
    private TextField txtCantDisponible;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTemperatura;

    @FXML
    private TextField txtValor;

    @FXML
    void guardarInfo(ActionEvent event) {
    	
    	String nombre = txtNombre.getText();
    	String descripcion = txtDescripcion.getText();
    	
    	
    	try {
			
    		Integer cantDisponible = Integer.parseInt(txtCantDisponible.getText());
    		Double temperatura = Double.parseDouble(txtTemperatura.getText());
    		Double valor = Double.parseDouble(txtValor.getText());
    		Boolean aprobado = checkAprobado.isSelected();
    		
    		Singleton.actualizarProductoRefrigerado((Refrigerado) productoSelected, nombre, descripcion, cantDisponible, temperatura, valor, aprobado); 
    		main.mostrarAlerta("Producto actualizado con exito");
    		
		} catch (NumberFormatException exception) {
			main.mostrarAlerta("Ingrese valores numericos");
		}
    }

    @FXML
    void initialize() {
        assert checkAprobado != null : "fx:id=\"checkAprobado\" was not injected: check your FXML file 'CrearProductoRefrigerado.fxml'.";
        assert txtCantDisponible != null : "fx:id=\"txtCantDisponible\" was not injected: check your FXML file 'CrearProductoRefrigerado.fxml'.";
        assert txtDescripcion != null : "fx:id=\"txtDescripcion\" was not injected: check your FXML file 'CrearProductoRefrigerado.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'CrearProductoRefrigerado.fxml'.";
        assert txtTemperatura != null : "fx:id=\"txtTemperatura\" was not injected: check your FXML file 'CrearProductoRefrigerado.fxml'.";
        assert txtValor != null : "fx:id=\"txtValor\" was not injected: check your FXML file 'CrearProductoRefrigerado.fxml'.";

    }

}
