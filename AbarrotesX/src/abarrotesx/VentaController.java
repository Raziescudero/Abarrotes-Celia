/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abarrotesx;

import abarrotesx.helpers.ProductoJpaController;
import abarrotesx.helpers.VentaJpaController;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Producto;
import modelo.Venta;

/**
 * FXML Controller class
 *
 * @author inuya
 */
public class VentaController implements Initializable {
    
    @FXML TableView <Producto> TVent;
    @FXML TableView <Producto> TCarrito;
    @FXML TableColumn <Producto,Producto> TavInv;
    @FXML TableColumn <Producto,Producto> TavPro;
    @FXML TableColumn <Producto,Producto> TavCant;
    @FXML TableColumn <Producto,Producto> TavPreV;
    @FXML TableColumn <Producto,Producto> TavCate;
    @FXML TableColumn <Producto,Producto> TavPeso;
    @FXML TableColumn <Producto,Producto> TCCod;
    @FXML TableColumn <Producto,Producto> TCProd;
    @FXML TableColumn <Producto,Producto> TCPrecio;
    @FXML TableColumn <Producto,Producto> CCant;
    @FXML TextField TTotal;
    
    private ObservableList<Producto> lista, lista2;
    private ProductoJpaController PJPAC;
    private VentaJpaController VJPA;
    Ventanas v = new Ventanas();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        PJPAC = new ProductoJpaController();
        VJPA = new VentaJpaController();
        lista = FXCollections.observableArrayList(PJPAC.findProductoEntities());
        TVent.setItems(lista);
        TavInv.setCellValueFactory(new PropertyValueFactory<Producto,Producto>("codigo"));
        TavPro.setCellValueFactory(new PropertyValueFactory<Producto,Producto>("producto"));
        TavCant.setCellValueFactory(new PropertyValueFactory<Producto,Producto>("cantidad"));
        TavPreV.setCellValueFactory(new PropertyValueFactory<Producto,Producto>("precioVenta"));
        TavCate.setCellValueFactory(new PropertyValueFactory<Producto,Producto>("categoria"));
        TavPeso.setCellValueFactory(new PropertyValueFactory<Producto,Producto>("peso"));
        
        TCCod.setCellValueFactory(new PropertyValueFactory<Producto,Producto>("codigo"));
        TCProd.setCellValueFactory(new PropertyValueFactory<Producto,Producto>("producto"));
        TCPrecio.setCellValueFactory(new PropertyValueFactory<Producto,Producto>("precioVenta"));
    }    
    
    public void carrito() throws Exception{
        
        try{
        String id = TVent.getSelectionModel().getSelectedItem().getCodigo();
        lista2 = FXCollections.observableArrayList(PJPAC.findProducto(id));
        Producto p = PJPAC.findProducto(id);
        TCarrito.setItems(lista2);
        TTotal.setText(String.valueOf(p.getPrecioVenta()));
        } catch(Exception e){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al seleccionar");
            alert.setContentText("No hay elemento seleccionado");
            alert.show();
        }
    }
    
    public void vender() throws Exception{
        
        try{
        String id = TVent.getSelectionModel().getSelectedItem().getCodigo();
        Producto p = PJPAC.findProducto(id);
        String cod = p.getCodigo();
        float pre = p.getPrecioVenta();
        int c = 1;
        VJPA = new VentaJpaController();
        Venta ve = new Venta();
        if(p.getCantidad()>=1){
        p.getCodigo();
        ve.setCodigoProducto(p);
        ve.setFechaVenta(Date.valueOf(LocalDate.now()));
        ve.setCantidadProducto(c);
        ve.setTotalVenta(pre);
        VJPA.create(ve);
        p.setCantidad(p.getCantidad()-1);
        PJPAC.edit(p);
        Alert ac = new Alert(AlertType.INFORMATION);
        ac.setTitle("Producto vendido");
        ac.setHeaderText("Producto vendido");
        ac.setContentText("Gracias por su compra");
        ac.show();
        v.menuVenta();
        } else{
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Error de venta");
            a.setContentText("No hay producto en existencia");
            a.show();
        }
        } catch(Exception e){
            Alert b = new Alert(AlertType.ERROR);
            b.setTitle("Error");
            b.setHeaderText("Error de selección");
            b.setContentText("No hay elemento seleccionado");
            b.show();
        }
    }
    
}
