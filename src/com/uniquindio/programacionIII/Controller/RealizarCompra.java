package com.uniquindio.programacionIII.Controller;
import java.io.IOException;
import com.uniquindio.programacionIII.Application.Main;
import com.uniquindio.programacionIII.Model.Cliente;
import com.uniquindio.programacionIII.Model.Producto;
import com.uniquindio.programacionIII.Model.Singleton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;



public class RealizarCompra {

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public TableColumn<Producto, String> getColCarritoProd() {
		return colCarritoProd;
	}

	public void setColCarritoProd(TableColumn<Producto, String> colCarritoProd) {
		this.colCarritoProd = colCarritoProd;
	}

	public TableColumn<Producto, Integer> getColCarritoUnidades() {
		return colCarritoUnidades;
	}

	public void setColCarritoUnidades(TableColumn<Producto, Integer> colCarritoUnidades) {
		this.colCarritoUnidades = colCarritoUnidades;
	}

	public TableColumn<Producto, Double> getColCarritoValor() {
		return colCarritoValor;
	}

	public void setColCarritoValor(TableColumn<Producto, Double> colCarritoValor) {
		this.colCarritoValor = colCarritoValor;
	}

	public TableColumn<Producto, String> getColCompraProducto() {
		return colCompraProducto;
	}

	public void setColCompraProducto(TableColumn<Producto, String> colCompraProducto) {
		this.colCompraProducto = colCompraProducto;
	}

	public TableColumn<Producto, Integer> getColCompraUnidad() {
		return colCompraUnidad;
	}

	public void setColCompraUnidad(TableColumn<Producto, Integer> colCompraUnidad) {
		this.colCompraUnidad = colCompraUnidad;
	}

	public TableColumn<Producto, Double> getColCompraValor() {
		return colCompraValor;
	}

	public void setColCompraValor(TableColumn<Producto, Double> colCompraValor) {
		this.colCompraValor = colCompraValor;
	}

	public TableView<Producto> getTblCarrito() {
		return tblCarrito;
	}

	public void setTblCarrito(TableView<Producto> tblCarrito) {
		this.tblCarrito = tblCarrito;
	}

	public TableView<Producto> getTblCompra() {
		return tblCompra;
	}

	public void setTblCompra(TableView<Producto> tblCompra) {
		this.tblCompra = tblCompra;
	}

	public TextField getTxtSubTotal() {
		return txtSubTotal;
	}

	public void setTxtSubTotal(TextField txtSubTotal) {
		this.txtSubTotal = txtSubTotal;
	}

	public TextField getTxtTotal() {
		return txtTotal;
	}

	public void setTxtTotal(TextField txtTotal) {
		this.txtTotal = txtTotal;
	}

	public ObservableList<Producto> getMiCarrito() {
		return miCarrito;
	}

	public void setMiCarrito(ObservableList<Producto> miCarrito) {
		this.miCarrito = miCarrito;
	}

	public ObservableList<Producto> getMiTienda() {
		return miTienda;
	}

	public void setMiTienda(ObservableList<Producto> miTienda) {
		this.miTienda = miTienda;
	}

	public CantidadController getCantidadController() {
		return cantidadController;
	}

	public void setCantidadController(CantidadController cantidadController) {
		this.cantidadController = cantidadController;
	}

	public Cliente getClienteSelected() {
		return clienteSelected;
	}

	public void setClienteSelected(Cliente clienteSelected) {
		this.clienteSelected = clienteSelected;
	}

	public Integer getCantidadComprada() {
		return cantidadComprada;
	}

	public void setCantidadComprada(Integer cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}

	public Stage getCantidadStage() {
		return cantidadStage;
	}

	public void setCantidadStage(Stage cantidadStage) {
		this.cantidadStage = cantidadStage;
	}

	public Integer getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}


	private Main main;

	@FXML
	private TableColumn<Producto, String> colCarritoProd;

	@FXML
	private TableColumn<Producto, Integer> colCarritoUnidades;

	@FXML
	private TableColumn<Producto, Double> colCarritoValor;

	@FXML
	private TableColumn<Producto,String> colCompraProducto;

	@FXML
	private TableColumn<Producto, Integer> colCompraUnidad;

	@FXML
	private TableColumn<Producto, Double> colCompraValor;

	@FXML
	private TableView<Producto> tblCarrito;

	@FXML
	private TableView<Producto> tblCompra;

	@FXML
	private TextField txtSubTotal;

	@FXML
	private TextField txtTotal;

	@FXML
	private ObservableList<Producto> miCarrito = FXCollections.observableArrayList();

	@FXML
	private ObservableList<Producto> miTienda = FXCollections.observableArrayList();

	private CantidadController cantidadController; 

	private Cliente clienteSelected; 

	private Integer cantidadComprada; 

	private Stage cantidadStage; 

	private Integer subtotal = 0;

	@FXML
	void agregarAlCarrito(ActionEvent event) {

		Producto productoSelected = tblCompra.getSelectionModel().getSelectedItem();

		if(productoSelected != null) {

			abrirCantidad();

			if(Singleton.existeDisponibilidad(productoSelected, cantidadComprada)) {

				aniadirCarrito(productoSelected, cantidadComprada);
			}else {
				main.mostrarAlerta("No hay tanto de ese producto");
			}


		}else {
			main.mostrarAlerta("Para agregar productos al carrito seleccione uno");
		}
	}

	private void aniadirCarrito(Producto productoSelected, Integer cantidadComprada) {

		Producto productoCliente = new Producto(productoSelected.getNombre(), productoSelected.getAboutProduct(), productoSelected.getId(), productoSelected.getValor(), cantidadComprada);
		miCarrito.add(productoCliente);
		Singleton.reducirCantidadProducto(productoSelected, cantidadComprada);
		txtSubTotal.setText((subtotal + productoCliente.getValor())+"");
		actualizarTablas();
	}

	private void actualizarTablas() {
		tblCarrito.getItems().clear();
		tblCarrito.getItems().addAll(miCarrito);
		tblCarrito.refresh();

		tblCompra.getItems().clear();
		tblCompra.getItems().addAll(Singleton.getProductos());
		tblCompra.refresh();
	}

	private void abrirCantidad() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/uniquindio/programacionIII/View/CantidadProducto.fxml"));
		Parent root= null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		cantidadController = loader.getController();
		cantidadController.setMain(main);
		cantidadController.setCompraController(this);
		Scene scene = new Scene(root);
		cantidadStage = new Stage();
		cantidadStage.setScene(scene);
		cantidadStage.showAndWait();
	}

	@FXML
	public void eliminarProdCarrito(ActionEvent event) {
		Producto productoSelected = tblCarrito.getSelectionModel().getSelectedItem();
		
		if(productoSelected != null) {
			
			eliminarProdCarrito(productoSelected);
			
		}else {
			main.mostrarAlerta("No se ha seleccionado ningun producto");
		}
	}

	private void eliminarProdCarrito(Producto productoSelected) {
		for (int i = 0; i < miCarrito.size(); i++) {
			
			if(miCarrito.get(i).equals(productoSelected)) {
				
				miCarrito.remove(i);
				actualizarTablas();
			
			}
		}
	}

	@FXML
	void hacerCompra(ActionEvent event) {

	}


	@FXML
	void initialize() {
		assert colCarritoProd != null : "fx:id=\"colCarritoProd\" was not injected: check your FXML file 'RealizarCompra.fxml'.";
		assert colCarritoUnidades != null : "fx:id=\"colCarritoUnidades\" was not injected: check your FXML file 'RealizarCompra.fxml'.";
		assert colCarritoValor != null : "fx:id=\"colCarritoValor\" was not injected: check your FXML file 'RealizarCompra.fxml'.";
		assert colCompraProducto != null : "fx:id=\"colCompraProducto\" was not injected: check your FXML file 'RealizarCompra.fxml'.";
		assert colCompraUnidad != null : "fx:id=\"colCompraUnidad\" was not injected: check your FXML file 'RealizarCompra.fxml'.";
		assert colCompraValor != null : "fx:id=\"colCompraValor\" was not injected: check your FXML file 'RealizarCompra.fxml'.";
		assert tblCarrito != null : "fx:id=\"tblCarrito\" was not injected: check your FXML file 'RealizarCompra.fxml'.";
		assert tblCompra != null : "fx:id=\"tblCompra\" was not injected: check your FXML file 'RealizarCompra.fxml'.";
		assert txtSubTotal != null : "fx:id=\"txtSubTotal\" was not injected: check your FXML file 'RealizarCompra.fxml'.";
		assert txtTotal != null : "fx:id=\"txtTotal\" was not injected: check your FXML file 'RealizarCompra.fxml'.";

		this.colCarritoProd.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.colCarritoUnidades.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
		this.colCarritoValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
		this.colCompraProducto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.colCompraUnidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
		this.colCompraValor.setCellValueFactory(new PropertyValueFactory<>("valor"));

		miTienda.addAll(Singleton.getProductos());
		actualizarTablas();

	}

}
