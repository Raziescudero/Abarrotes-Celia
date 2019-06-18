/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abarrotesx;

import abarrotesx.helpers.VentaJpaController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Venta;

/**
 * FXML Controller class
 *
 * @author inuya
 */
public class HistorialVentasController implements Initializable {
    
    @FXML private TableView Tahv;
    @FXML private TableColumn TahIDVenta;
    @FXML private TableColumn TahvCodPro;
    @FXML private TableColumn TahvfechaV;
    @FXML private TableColumn TahvCant;
    @FXML private TableColumn TahvTotal;
    
    private ObservableList<Venta> list;
    private VentaJpaController VJPA;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        VJPA = new VentaJpaController();
        list = FXCollections.observableList(VJPA.findVentaEntities());
        Tahv.setItems(list);
        TahIDVenta.setCellValueFactory(new PropertyValueFactory<Venta,Venta>("idVenta"));
        TahvCodPro.setCellValueFactory(new PropertyValueFactory<Venta,Venta>("codigoProducto"));
        TahvfechaV.setCellValueFactory(new PropertyValueFactory<Venta,Venta>("fechaVenta"));
        TahvCant.setCellValueFactory(new PropertyValueFactory<Venta,Venta>("cantidadProducto"));
        TahvTotal.setCellValueFactory(new PropertyValueFactory<Venta,Venta>("totalVenta"));
        
    }    
    
}
