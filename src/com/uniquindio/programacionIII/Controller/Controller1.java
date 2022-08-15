package com.uniquindio.programacionIII.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import com.uniquindio.programacionIII.Application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lombok.Data;

@Data

public class Controller1 {

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
