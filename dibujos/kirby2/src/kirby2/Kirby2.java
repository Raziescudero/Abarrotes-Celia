
package kirby2;

import java.util.HashSet;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.QuadCurveTo;
import javafx.stage.Stage;

/**
 *
 * @author Raziel
 */
public class Kirby2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
       /* 
        AudioClip song = new AudioClip("/brawl.mp3");
        song.play();
        song.setVolume(0.85);
        */
        Image imagen2 = new Image("/superwii.jpg");
        ImageView fondo2 = new ImageView();
        fondo2.setImage(imagen2);
        fondo2.setFitHeight(600);
        fondo2.setFitWidth(1000);
        //fondo2.setOpacity(0.9);
        
        fondo2.setLayoutX(-65);
        fondo2.setLayoutY(-20);
       
         Pane root = new Pane();
        
        root.setOnMouseClicked(evt->{
           double x = evt.getX();
           double y = evt.getY();
           System.out.println("Coordenadas " + "X: "+ x + " Y: "+ y);
           
       });
        
        
        Path cuerpo2 = new Path();
        
        MoveTo movto = new MoveTo(279, 275);
        QuadCurveTo curva = new QuadCurveTo(298, 115, 446, 97);
        QuadCurveTo curva2 = new QuadCurveTo(578, 101, 599, 250);
        QuadCurveTo curva3 = new QuadCurveTo(605, 290, 597, 322);
        QuadCurveTo curva4 = new QuadCurveTo(571, 311, 535, 317);
        QuadCurveTo curva5 = new QuadCurveTo(494, 328, 477, 344);
        QuadCurveTo curva6 = new QuadCurveTo(462, 355, 452, 376);
        QuadCurveTo cirva = new QuadCurveTo(424, 425, 447, 470);
        QuadCurveTo cirva2 = new QuadCurveTo(371, 477, 305, 393);
        QuadCurveTo cirva3 = new QuadCurveTo(270, 342, 279, 275);
        
        
        cuerpo2.getElements().addAll(movto, curva, curva2, curva3, curva4, curva5, curva6, cirva, cirva2, cirva3);
        cuerpo2.setStrokeWidth(2.3);
        
        Path brazoIz = new Path();
        
        MoveTo movto2 = new MoveTo(326, 155);
        QuadCurveTo curva7 = new QuadCurveTo(327, 91, 372, 38);
        QuadCurveTo curva8 = new QuadCurveTo(409, 3, 435, 39);
        QuadCurveTo curva9 = new QuadCurveTo(445, 66, 444, 96);
        QuadCurveTo curva10 = new QuadCurveTo(366, 110, 326, 155);
        
        brazoIz.getElements().addAll(movto2, curva7, curva8, curva9, curva10);
        brazoIz.setStrokeWidth(2.3);
        
        Path pataIz = new Path();
        
        MoveTo movto9 = new MoveTo(432, 470);
        QuadCurveTo corvo = new QuadCurveTo(440, 513, 418, 555);
        QuadCurveTo corvo2 = new QuadCurveTo(399, 585, 363, 557);
        QuadCurveTo corvo3 = new QuadCurveTo(300, 496, 301, 388);
        QuadCurveTo corvo4 = new QuadCurveTo(334, 428, 370, 452);
        QuadCurveTo corvo5 = new QuadCurveTo(401, 470, 432, 470);
        
        pataIz.getElements().addAll(movto9, corvo, corvo2, corvo3, corvo4, corvo5);
        pataIz.setStrokeWidth(2.3);
        
        Path pataD = new Path();
        MoveTo movto10 = new MoveTo(447, 469);
        QuadCurveTo qrva = new QuadCurveTo(478, 516, 538, 501);
        QuadCurveTo qrva2 = new QuadCurveTo(601, 478, 623, 420);
        QuadCurveTo qrva3 = new QuadCurveTo(644, 351, 597, 322);
        QuadCurveTo qrva4 = new QuadCurveTo(568, 313, 535, 317);
        QuadCurveTo qrva5 = new QuadCurveTo(491, 327, 460, 361);
        QuadCurveTo qrva6 = new QuadCurveTo(448, 379, 440, 402);
        QuadCurveTo qrva7 = new QuadCurveTo(429, 433, 447, 469);
        
        pataD.getElements().addAll(movto10, qrva, qrva2, qrva3, qrva4, qrva5, qrva6, qrva7);
        pataD.setStrokeWidth(2.3);
        
        Path brazoD = new Path();
        
        MoveTo movto3 = new MoveTo(599, 250);
        QuadCurveTo corve = new QuadCurveTo(636, 266, 641, 304);
        QuadCurveTo corve2 = new QuadCurveTo(645, 330, 618, 342);
        QuadCurveTo corve3 = new QuadCurveTo(610, 328, 597, 322);
        QuadCurveTo corve4 = new QuadCurveTo(606, 292, 599, 250);
        
        brazoD.getElements().addAll(movto3, corve, corve2, corve3, corve4);
        brazoD.setStrokeWidth(2.3);
        
        Path boca = new Path();
        
        MoveTo movto4 = new MoveTo(441, 251);
        QuadCurveTo carve = new QuadCurveTo(482, 242, 497, 280);
        QuadCurveTo carve2 = new QuadCurveTo(487, 314, 451, 305);
        QuadCurveTo carve3 = new QuadCurveTo(421, 286, 441, 251);
        
        boca.getElements().addAll(movto4, carve, carve2, carve3);
        boca.setStrokeWidth(2.3);
        
        Path mejillaIz = new Path();
        
        MoveTo movto5 = new MoveTo(376, 216);
        QuadCurveTo carves = new QuadCurveTo(357, 205, 382, 200);
        QuadCurveTo carves2 = new QuadCurveTo(398, 200, 409, 206);
        QuadCurveTo carves3 = new QuadCurveTo(428, 216, 403, 222);
        QuadCurveTo carves4 = new QuadCurveTo(387, 221, 376, 216);
        
        mejillaIz.getElements().addAll(movto5, carves, carves2, carves3, carves4);
        mejillaIz.setStrokeWidth(2.3);
        
        Path mejillaD = new Path();
        
        MoveTo movto6 = new MoveTo(533, 286);
        QuadCurveTo cerve = new QuadCurveTo(528, 269, 545, 274);
        QuadCurveTo cerve2 = new QuadCurveTo(558, 280, 565, 292);
        QuadCurveTo cerve3 = new QuadCurveTo(570, 309, 549, 302);
        QuadCurveTo cerve4 = new QuadCurveTo(537, 296, 533, 286);
        
        mejillaD.getElements().addAll(movto6, cerve, cerve2, cerve3, cerve4);
        mejillaD.setStrokeWidth(2.3);
        
        Ellipse ojo1 = new Ellipse(457, 185, 20, 50);
        ojo1.setRotate(15);
        ojo1.setStrokeWidth(2.3);
        
        Ellipse detalle1 = new Ellipse(466, 160, 10, 16);
        detalle1.setRotate(15);
        detalle1.setFill(WHITE);
        detalle1.setStrokeWidth(2.3);
        Ellipse detalle2 = new Ellipse(531, 191, 10, 16);
        detalle2.setRotate(15);
        detalle2.setFill(WHITE);
        detalle2.setStrokeWidth(2.3);
        
        Ellipse ojo2 = new Ellipse(522, 217, 20, 50);
        ojo2.setRotate(15);
            
        
        
        
        Button dibujar = new Button("Dibujar");
        dibujar.setLayoutX(766);
        dibujar.setLayoutY(533);
        
        Button pintar = new Button("Colorear");
        pintar.setLayoutX(129);
        pintar.setLayoutY(533);
        
      
        pintar.setOnMouseClicked((e) ->{
        
        try{
        cuerpo2.setFill(Color.web("FCA9DA"));
        pataD.setFill(Color.web("DC0E2A"));
        pataIz.setFill(Color.web("DC0E2A"));
        brazoIz.setFill(Color.web("FCA9DA"));
        brazoD.setFill(Color.web("FCA9DA"));
        mejillaD.setFill(Color.web("FB56A6"));
        mejillaIz.setFill(Color.web("FB56A6"));
        
        Stop[] stop = {new Stop(0, Color.web("FF0000")),  
                       new Stop(0.5, Color.web("B22222")),  
                       new Stop(1, Color.web("#8B0000"))}; 
 
        LinearGradient gradient = new LinearGradient(0, 0, 
                          1, 0, true, CycleMethod.NO_CYCLE, stop); 
        boca.setFill(gradient);
        } catch (Exception o){
            
                
                }
        
        });
        
        dibujar.setOnMouseClicked((e) ->{
            
            try{
            root.getChildren().addAll(cuerpo2, brazoIz, brazoD, 
                                boca, mejillaIz, mejillaD, pataIz, 
                                ojo1, ojo2, detalle1, detalle2, pataD);
            } catch (Exception a){
                
            }
            });
        
  
        
       
        root.getChildren().addAll(fondo2, pintar, dibujar);
        
        Scene scene = new Scene(root, 920, 600);
        
        primaryStage.setTitle("Kirby");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
