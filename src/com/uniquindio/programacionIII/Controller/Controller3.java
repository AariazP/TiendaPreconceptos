package com.uniquindio.programacionIII.Controller;

import com.uniquindio.programacionIII.Application.Main;
import com.uniquindio.programacionIII.Model.Producto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import lombok.Data;

@Data
public class Controller3 {
	
	private Main main;


	@FXML
	private TableView<Producto> tblProductos;

	@FXML
	void actualizar(ActionEvent event) {
		System.out.println("Actualizar");
	}

	@FXML
	void buscar(ActionEvent event) {
		System.out.println("buscar");
	}

	@FXML
	void crear(ActionEvent event) {
		System.out.println("crear");
	}

	@FXML
	void eliminar(ActionEvent event) {
		System.out.println("eliminar");
	}

	@FXML
	void reemplazar(ActionEvent event) {
		System.out.println("reemplazar");
	}

}
