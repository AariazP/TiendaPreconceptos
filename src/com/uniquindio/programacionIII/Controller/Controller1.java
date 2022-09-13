package com.uniquindio.programacionIII.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import com.uniquindio.programacionIII.Application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class Controller1 {

	public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
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

    public Button getBtnIrCliente() {
        return btnIrCliente;
    }

    public void setBtnIrCliente(Button btnIrCliente) {
        this.btnIrCliente = btnIrCliente;
    }

    public Button getBtnIrProductos() {
        return btnIrProductos;
    }

    public void setBtnIrProductos(Button btnIrProductos) {
        this.btnIrProductos = btnIrProductos;
    }

    private Main main;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIrCliente;

    @FXML
    private Button btnIrProductos;

    public void changeFrame(ActionEvent e) {
    	if(e.getSource() == btnIrCliente) {
    		main.abrirFrameClientes();
    	}else if(e.getSource() == btnIrProductos) {
    		main.abrirProductos();
    	}
    	
    }
    
	@FXML
    void initialize() {
        assert btnIrCliente != null : "fx:id=\"btnIrCliente\" was not injected: check your FXML file 'FrameInit.fxml'.";
        assert btnIrProductos != null : "fx:id=\"btnIrProductos\" was not injected: check your FXML file 'FrameInit.fxml'.";
    }

	
}
