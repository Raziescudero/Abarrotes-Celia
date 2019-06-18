package abarrotesx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Ventanas {
    Button BSalir;
    private static Stage stage = new Stage();
    
    public void menuPrincipal() throws Exception{
        Pane pane = (Pane) FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage.setTitle("Abarrotes Celia");
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    
    public void menuAgregar() throws Exception{
        Pane paneAgregar = (Pane) FXMLLoader.load(getClass().getResource("Agregar.fxml"));
        stage.setTitle("Agregar producto");
        Scene scene = new Scene(paneAgregar);
        stage.setScene(scene);
        stage.show();
        
    }
    
    public void menuInventario() throws Exception{
        Pane paneInventario = (Pane) FXMLLoader.load(getClass().getResource("Inventario.fxml"));
        stage.setTitle("Inventario");
        Scene scene = new Scene(paneInventario);
        stage.setScene(scene);
        stage.show();
    }
    
    public void menuModificar() throws Exception{
        Pane paneModificar = (Pane) FXMLLoader.load(getClass().getResource("Modificar.fxml"));
        stage.setTitle("Modificar producto");
        Scene scene = new Scene(paneModificar);
        stage.setScene(scene);
        stage.show();
    }
    
    public void menuVenta() throws Exception{
        Pane paneVenta = (Pane) FXMLLoader.load(getClass().getResource("Venta.fxml"));
        stage.setTitle("Venta");
        Scene scene = new Scene (paneVenta);
        stage.setScene(scene);
        stage.show();
    }
    
    public void menuHistorial() throws Exception{
        Pane paneHistorial = (Pane) FXMLLoader.load(getClass().getResource("HistorialVentas.fxml"));
        stage.setTitle("Historial de venta");
        Scene scene = new Scene (paneHistorial);
        stage.setScene(scene);
        stage.show();
    }
    
}
