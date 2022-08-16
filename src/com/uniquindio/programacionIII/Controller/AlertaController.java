package com.uniquindio.programacionIII.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AlertaController {
	@FXML
    private Label lblAlerta;
	
	public void setLabel(String mensaje) {
		lblAlerta.setText(mensaje);
	}
	
}
