/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abarrotesx;

import abarrotesx.helpers.ProductoJpaController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Producto;

/**
 * FXML Controller class
 *
 * @author inuya
 */
public class Agregar implements Initializable {

    @FXML private Button BAGuardar;
    
    @FXML private TextField TCod;
    @FXML private TextField TPro;
    @FXML private TextField TCant;
    @FXML private TextField TPrec;
    @FXML private TextField TPreV;
    @FXML private TextField TCate;
    @FXML private TextField TPeso;

    private ProductoJpaController PJPA;
    Ventanas ventana;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
    
    public void crear() throws Exception{
        BAGuardar = new Button();
        PJPA = new ProductoJpaController();
        Producto producto = new Producto();
        
        producto.setCodigo(TCod.getText());
        producto.setProducto(TPro.getText());
        producto.setCantidad(Integer.parseInt(TCant.getText()));
        producto.setPrecioCompra(Float.parseFloat(TPrec.getText()));
        producto.setPrecioVenta(Float.parseFloat(TPreV.getText()));
        producto.setCategoria(TCate.getText());
        producto.setPeso(TPeso.getText());
        
        PJPA.create(producto);
        
        Alert agregado = new Alert(AlertType.INFORMATION);
        agregado.setContentText("Producto guardado");
        agregado.setHeaderText("Producto guardado");
        agregado.setTitle("Agregado");
        agregado.show();
        
       
        }
    
    
    public void volver() throws Exception{
        ventana = new Ventanas();
        ventana.menuInventario();
    }
    }
    

