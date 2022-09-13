package com.uniquindio.programacionIII.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.uniquindio.programacionIII.Application.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;



public class CantidadController {
	
	public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public RealizarCompra getCompraController() {
        return compraController;
    }

    public void setCompraController(RealizarCompra compraController) {
        this.compraController = compraController;
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

    public TextField getTxtCantidad() {
        return txtCantidad;
    }

    public void setTxtCantidad(TextField txtCantidad) {
        this.txtCantidad = txtCantidad;
    }

    private Main main; 
	
	private RealizarCompra compraController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCantidad;

    @FXML
    public void guardarCantidad(ActionEvent event) {
    	if(txtCantidad.getText().equals("")) main.mostrarAlerta("Escriba en el campo de texto");
    	else {
			try {
				Integer cantidad = Integer.parseInt(txtCantidad.getText());
				compraController.setCantidadComprada(cantidad);
				main.mostrarAlerta("El producto se agrego");
			} catch (NumberFormatException e) {
				
				main.mostrarAlerta("Debe agregar valores numericos");
				
			}
		}
    }

    @FXML
    void initialize() {
        assert txtCantidad != null : "fx:id=\"txtCantidad\" was not injected: check your FXML file 'CantidadProducto.fxml'.";

    }

}
