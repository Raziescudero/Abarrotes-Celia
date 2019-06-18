/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abarrotesx;

import abarrotesx.helpers.ProductoJpaController;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Producto;

/**
 * FXML Controller class
 *
 * @author inuya
 */
public class Inventario implements Initializable {
    
    @FXML private TableView <Producto> TabInventario;
    @FXML private TableColumn <Producto,Producto> TabCod;
    @FXML private TableColumn <Producto,Producto> TabPro;
    @FXML private TableColumn <Producto,Producto> TabCant;
    @FXML private TableColumn <Producto,Producto> TabPreC;
    @FXML private TableColumn <Producto,Producto> TabPreV;
    @FXML private TableColumn <Producto,Producto> TabCate;
    @FXML private TableColumn <Producto,Producto> TabPeso;
    
    @FXML private TextField MCod;
    @FXML private TextField MPro;
    @FXML private TextField MCant;
    @FXML private TextField MPreC;
    @FXML private TextField MPreV;
    @FXML private TextField MCate;
    @FXML private TextField MPeso;
    
    @FXML private Label LCod;
    @FXML private Label LPro;
    @FXML private Label LCant;
    @FXML private Label LPreC;
    @FXML private Label LPreV;
    @FXML private Label LCate;
    @FXML private Label LPeso;
    
    @FXML Button BMGuardar;
    
    
    private ObservableList<Producto> lista;
    private ProductoJpaController PJPAC;
    Ventanas v = new Ventanas();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MCod.setVisible(false);
        MPro.setVisible(false);
        MCant.setVisible(false);
        MPreC.setVisible(false);
        MPreV.setVisible(false);
        MCate.setVisible(false);
        MPeso.setVisible(false);
        LCod.setVisible(false);
        LPro.setVisible(false);
        LCant.setVisible(false);
        LPreC.setVisible(false);
        LPreV.setVisible(false);
        LCate.setVisible(false);
        LPeso.setVisible(false);
        BMGuardar.setVisible(false);
        
        PJPAC = new ProductoJpaController();
        lista = FXCollections.observableList(PJPAC.findProductoEntities());
        TabInventario.setItems(lista);
        
        TabCod.setCellValueFactory(new PropertyValueFactory<Producto,Producto>("codigo"));
        TabPro.setCellValueFactory(new PropertyValueFactory<Producto,Producto>("producto"));
        TabCant.setCellValueFactory(new PropertyValueFactory<Producto,Producto>("cantidad"));
        TabPreC.setCellValueFactory(new PropertyValueFactory<Producto,Producto>("precioCompra"));
        TabPreV.setCellValueFactory(new PropertyValueFactory<Producto,Producto>("precioVenta"));
        TabCate.setCellValueFactory(new PropertyValueFactory<Producto,Producto>("categoria"));
        TabPeso.setCellValueFactory(new PropertyValueFactory<Producto,Producto>("peso"));
        TabInventario.refresh();
        
        
        
    }    
    
    public void eliminar() throws Exception{
        PJPAC= new ProductoJpaController();
        
        try{
        String id = TabInventario.getSelectionModel().getSelectedItem().getCodigo();
        Alert alerta = new Alert(AlertType.CONFIRMATION);
        alerta.setTitle("Eliminar producto");
        alerta.setContentText("¿Está seguro de eliminar este producto?");
        alerta.setHeaderText("Eliminar producto");
        ButtonType Eliminar = new ButtonType("Eliminar");
        ButtonType Cancelar= new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
        alerta.getButtonTypes().setAll(Eliminar, Cancelar);
        Optional<ButtonType> result = alerta.showAndWait();
        if(result.get() == Eliminar){
        PJPAC.destroy(id);
        Alert a = new Alert(AlertType.INFORMATION);
        a.setTitle("Eliminado");
        a.setHeaderText("Producto eliminado");
        a.setContentText("Producto eliminado exitosamente");
        a.show();
        v.menuInventario();
        }
        } catch(Exception e){
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Error");
            a.setContentText("No hay elemento seleccionado");
            a.show();
        }
    }
    
    public void menuAgregar() throws Exception{
        v.menuAgregar();
    }
    
    public void menuModificar() throws Exception{
        
        
        try{
        String id = TabInventario.getSelectionModel().getSelectedItem().getCodigo();
        Producto producto = PJPAC.findProducto(id);
        MCod.setText(producto.getCodigo());
        MPro.setText(producto.getProducto());
        MCant.setText(String.valueOf(producto.getCantidad()));
        MPreC.setText(String.valueOf(producto.getPrecioCompra()));
        MPreV.setText(String.valueOf(producto.getPrecioVenta()));
        MCate.setText(producto.getCategoria());
        MPeso.setText(producto.getPeso());
        MCod.setVisible(true);
        MCod.setEditable(false);
        MPro.setVisible(true);
        MCant.setVisible(true);
        MPreC.setVisible(true);
        MPreV.setVisible(true);
        MCate.setVisible(true);
        MPeso.setVisible(true);
        LCod.setVisible(true);
        LPro.setVisible(true);
        LCant.setVisible(true);
        LPreC.setVisible(true);
        LPreV.setVisible(true);
        LCate.setVisible(true);
        LPeso.setVisible(true);
        BMGuardar.setVisible(true);
        }catch(Exception e){
        Alert a = new Alert(AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText("Error al modificar");
        a.setContentText("No hay elemento seleccionado");
        a.show();
         }
        
    }
    
    public void guardar() throws Exception{
        
        PJPAC = new ProductoJpaController();
        String id = TabInventario.getSelectionModel().getSelectedItem().getCodigo();
        Producto producto = PJPAC.findProducto(id);
        producto.setCodigo(MCod.getText());
        producto.setProducto(MPro.getText());
        producto.setCantidad(Integer.parseInt(MCant.getText()));
        producto.setPrecioCompra(Float.parseFloat(MPreC.getText()));
        producto.setPrecioVenta(Float.parseFloat(MPreV.getText()));
        producto.setCategoria(MCate.getText());
        producto.setPeso(MPeso.getText());
        PJPAC.edit(producto);
        Alert a = new Alert(AlertType.INFORMATION);
        a.setTitle("Modificado");
        a.setHeaderText("Producto modificado");
        a.setContentText("Producto guardado");
        a.show();
        MCod.setVisible(false);
        MPro.setVisible(false);
        MCant.setVisible(false);
        MPreC.setVisible(false);
        MPreV.setVisible(false);
        MCate.setVisible(false);
        MPeso.setVisible(false);
        LCod.setVisible(false);
        LPro.setVisible(false);
        LCant.setVisible(false);
        LPreC.setVisible(false);
        LPreV.setVisible(false);
        LCate.setVisible(false);
        LPeso.setVisible(false);
        BMGuardar.setVisible(false);
        v.menuInventario();
    }
    
    
    
    
    
    public void refresh() throws Exception{
        v.menuInventario();
    }
    
    
    
}
