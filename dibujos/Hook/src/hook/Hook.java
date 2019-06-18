       
package hook;


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
import javafx.scene.paint.Paint;
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
 * @author Ismael Moreno
 */
public class Hook extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Image imagen = new Image("/king.jpg");
       ImageView fondo = new ImageView();
       fondo.setImage(imagen);
       fondo.setFitHeight(640);
       fondo.setFitWidth(1000);
       fondo.setOpacity(0.7);
       
       fondo.setLayoutX(-50);
       fondo.setLayoutY(-15);
       
       Pane root = new Pane();
       root.setOnMouseClicked(evt->{
           double x = evt.getX();
           double y = evt.getY();
           System.out.println("Coordenadas " + "X: "+ x + " Y: "+ y);
           
       });
       
       Path cuerpo = new Path();
        
       MoveTo moveTo = new MoveTo(336, 484);
       QuadCurveTo curva1 = new QuadCurveTo(296, 391, 344, 295);
       QuadCurveTo curva2 = new QuadCurveTo(200, 243, 226, 100);
       QuadCurveTo curva3 = new QuadCurveTo(247, 120, 263, 147);
       QuadCurveTo curva4 = new QuadCurveTo(275, 121, 294, 101);
       QuadCurveTo curva5 = new QuadCurveTo(298, 129, 290, 158);
       QuadCurveTo curva6 = new QuadCurveTo(308, 189, 321, 227);
       QuadCurveTo curva7 = new QuadCurveTo(347, 245, 374, 255);
       QuadCurveTo curva8 = new QuadCurveTo(451, 178, 528, 185);
       QuadCurveTo curva9 = new QuadCurveTo(543, 152, 571, 144);
       QuadCurveTo curva10 = new QuadCurveTo(568, 77, 599, 39);
       QuadCurveTo curva11 = new QuadCurveTo(602, 59, 600, 79);
       QuadCurveTo curva12 = new QuadCurveTo(621, 57, 652, 45);
       QuadCurveTo curva13 = new QuadCurveTo(672, 85, 640, 162);
       QuadCurveTo curva14 = new QuadCurveTo(614, 191, 578, 201);
       QuadCurveTo curva15 = new QuadCurveTo(607, 221, 635, 224);
       QuadCurveTo curva16 = new QuadCurveTo(657, 221, 683, 252);
       QuadCurveTo curva17 = new QuadCurveTo(713, 286, 712, 333);
       QuadCurveTo curva18 = new QuadCurveTo(711, 357, 690, 372);
       QuadCurveTo curva19 = new QuadCurveTo(679, 400, 648, 417);
       QuadCurveTo curva20 = new QuadCurveTo(632, 528, 532, 561);
       QuadCurveTo curva21 = new QuadCurveTo(503, 573, 457, 562);
       QuadCurveTo curva22 = new QuadCurveTo(407, 559, 371, 526);
       QuadCurveTo curva23 = new QuadCurveTo(345, 502, 336, 484);
       
       
       
     cuerpo.getElements().addAll(moveTo, curva1, curva2, curva3, curva4,curva5, curva6, curva7, 
                            curva8, curva9, curva10, curva11, curva12, curva13, curva14,
                                    curva15, curva16, curva17, curva18, curva19, curva20, curva21, curva22, curva23);
       cuerpo.setStrokeWidth(2.7);
     
       
       Path pata1 = new Path();
       
       MoveTo movto2 = new MoveTo(370,524);
       QuadCurveTo curva = new QuadCurveTo(356, 531, 338, 536);
       QuadCurveTo curvita = new QuadCurveTo(330, 524, 323, 515);
       QuadCurveTo curvita2 = new QuadCurveTo(327, 491, 333, 480);
       QuadCurveTo curvita3 = new QuadCurveTo(346, 502, 370,524);
       
       pata1.getElements().addAll(movto2, curva, curvita, curvita2, curvita3);
       pata1.setStrokeWidth(2.3);
       
      Path pesuña1 = new Path();
      
      MoveTo movto3 = new MoveTo(338, 536);
      LineTo line1 = new LineTo(327, 540);
      LineTo line2 = new LineTo(327, 530);
      LineTo line3 = new LineTo(320, 527);
      LineTo line4 = new LineTo(323, 515);
      QuadCurveTo curve2 = new QuadCurveTo(323, 515, 338, 536);
      
      pesuña1.getElements().addAll(movto3, line1, line2, line3, line4, curve2);
      pesuña1.setStrokeWidth(2.3);
      
      Path pata2 = new Path();
      
      MoveTo movto4 = new MoveTo(604, 518);
      QuadCurveTo curvi = new QuadCurveTo(633, 522, 657, 521);
      QuadCurveTo curvi2 = new QuadCurveTo(655, 507, 673, 502);
      QuadCurveTo curvi3 = new QuadCurveTo(659, 484, 637, 464);
      QuadCurveTo curvi4 = new QuadCurveTo(625, 490, 604, 518);
      
      pata2.getElements().addAll(movto4, curvi, curvi2, curvi3, curvi4);
      pata2.setStrokeWidth(2.3);
      
      Path pesuña2 = new Path();
              
      MoveTo movto5 = new MoveTo(657, 521);
      LineTo lini = new LineTo(670, 523);
      LineTo lini2 = new LineTo(670, 513);
      LineTo lini3 = new LineTo(681, 512);
      LineTo lini4 = new LineTo(673, 502);
      QuadCurveTo cur = new QuadCurveTo(655, 507, 657, 521); 
      
      pesuña2.getElements().addAll(movto5, lini, lini2, lini3, lini4, cur);
      pesuña2.setStrokeWidth(2.3);
      
      Path pesuña3 = new Path();
      
      MoveTo movto6 = new MoveTo(494, 563);
      LineTo lineas = new LineTo(507, 572);
      LineTo lineas2 = new LineTo(512, 561);
      LineTo lineas3 = new LineTo(524, 562);
      LineTo lineas4 = new LineTo(517, 547);
      QuadCurveTo curli = new QuadCurveTo(499, 549, 494, 563);
       
      pesuña3.getElements().addAll(movto6, lineas, lineas2, lineas3, lineas4, curli);
      pesuña3.setStrokeWidth(2.3);
      
      Path nariz = new Path();
      
      MoveTo movto7 = new MoveTo(634, 388);
      QuadCurveTo corve = new QuadCurveTo(602, 401, 589, 372);
      QuadCurveTo corve2 = new QuadCurveTo(570, 326, 593, 270);
      QuadCurveTo corve3 = new QuadCurveTo(607, 240, 633, 225);
      QuadCurveTo corve4 = new QuadCurveTo(649, 215, 665, 233);
      QuadCurveTo corve5 = new QuadCurveTo(710, 271, 713, 329);
      QuadCurveTo corve6 = new QuadCurveTo(711, 361, 688, 370);
      QuadCurveTo corve7 = new QuadCurveTo(662, 376, 634, 388);

      nariz.getElements().addAll(movto7, corve, corve2, corve3, corve4, corve5, corve6, corve7);
      nariz.setStrokeWidth(2.3);
      
               
      Path boca = new Path();
      
      MoveTo movto8 = new MoveTo(627, 424);
      QuadCurveTo carve = new QuadCurveTo(616, 447, 603, 465);
      QuadCurveTo carve2 = new QuadCurveTo(585, 487, 566, 463);
      QuadCurveTo carve3 = new QuadCurveTo(556, 445, 564, 417);
      QuadCurveTo carve4 = new QuadCurveTo(571, 412, 575, 405);
      QuadCurveTo carve5 = new QuadCurveTo(593, 422, 627, 424);
      
      boca.getElements().addAll(movto8, carve, carve2, carve3, carve4, carve5);
      boca.setStrokeWidth(2.3);
      
      Ellipse ojo = new Ellipse(473, 316, 11.7, 35);
      Ellipse detalleojo = new Ellipse(474, 290, 5, 12);
      detalleojo.setFill(Color.WHITE);
      
      Ellipse mejilla = new Ellipse(471, 373, 30, 20);
      mejilla.setFill(Color.AZURE);
      
      Path lengua = new Path();
      
      MoveTo movto9 = new MoveTo(598, 419);
      QuadCurveTo corva = new QuadCurveTo(610, 433, 608, 456);
      QuadCurveTo corva2 = new QuadCurveTo(589, 488, 567, 464);
      QuadCurveTo corva3 = new QuadCurveTo(556, 446, 562, 420);
      QuadCurveTo corva4 = new QuadCurveTo(571, 412, 575, 405);
      QuadCurveTo carva5 = new QuadCurveTo(582, 417, 598, 419);
      
      lengua.getElements().addAll(movto9, corva, corva2, corva3, corva4, carva5);
      lengua.setStrokeWidth(2.3);
      
      //Detalles
      QuadCurve raya = new QuadCurve(600, 479, 593, 495, 574, 501);
      raya.setStrokeWidth(0.2);
      raya.setStroke(Paint.valueOf("#030201"));
      raya.setFill(Paint.valueOf("#74646c"));
      QuadCurve raya2 = new QuadCurve(493, 563, 457, 555, 425, 532);
      raya.setStrokeWidth(0.3);
      Line rayita = new Line(516, 546, 502, 504);
      rayita.setStrokeWidth(2.3);
      QuadCurve raya3 = new QuadCurve(634, 353, 617, 324, 631, 256);
      raya3.setStrokeWidth(2.3);
      QuadCurve raya4 = new QuadCurve(676, 339, 656, 318, 664, 253);
      raya4.setStrokeWidth(2.3);
      Line xx = new Line(375, 255,396,255);
      xx.setStrokeWidth(2.3);
      Line ww = new Line(600, 80, 591, 97);
      ww.setStrokeWidth(2.3);
      Line ee = new Line(263, 148, 273, 178);
      ee.setStrokeWidth(2.3);
      
      Path rayi = new Path();
      MoveTo rayito = new MoveTo(528, 185);
      QuadCurveTo qrva = new QuadCurveTo(551, 189, 578, 201);
      rayi.getElements().addAll(rayito, qrva);
      rayi.setStrokeWidth(2.3);
      
      Path raye = new Path();
      MoveTo rayite = new MoveTo(553, 422);
      QuadCurveTo qrva2 = new QuadCurveTo(575, 418, 579, 393);
      rayi.getElements().addAll(rayite, qrva2);
      rayi.setStrokeWidth(2.3); 
      
      Path rayu = new Path();
      MoveTo rayitu = new MoveTo(344, 295);
      QuadCurveTo qrva3 = new QuadCurveTo(370, 296, 396, 281);
      rayi.getElements().addAll(rayitu, qrva3);
      rayi.setStrokeWidth(2.3);


      Button pintar = new Button("Pintar");
      pintar.setLayoutX(148);
      pintar.setLayoutY(551);
      
      Button dibujar = new Button("dibujar");
      dibujar.setLayoutX(767);
      dibujar.setLayoutY(551);
      dibujar.setOnMouseClicked((e) ->{
        try{
          root.getChildren().addAll(cuerpo, pata1, pesuña1, pata2, 
                                pesuña2, pesuña3, nariz, ojo, detalleojo, 
                                lengua, boca, mejilla, raya, raya2, rayita, 
                                raya3, raya4, rayi,raye,rayu, xx, ww, ee); 
          
        } catch (Exception o){
            System.out.println("Primero dibuja antes de colorear");
        }
      });
      
      pintar.setOnMouseClicked((e) ->{
          try{
          cuerpo.setFill(Color.web("f779ad")); // f9b6d7
          pata1.setFill(Color.web("f779ad"));
          pata2.setFill(Color.web("f779ad"));
          pesuña1.setFill(Color.web("974203"));
          pesuña2.setFill(Color.web("974203"));
          pesuña3.setFill(Color.web("974203"));
          //boca.setFill(Color.web("5a2701"));
          lengua.setFill(Color.web("bf0350"));
          nariz.setFill(Color.web("fba3c7"));
          mejilla.setFill(Color.web("fabfd7"));
          } catch (Exception a){
               System.out.println("Primero dibuja antes de colorear");
          }
        
    });

       
       Scene scene = new Scene(root , 920, 600);
       root.getChildren().addAll(fondo,pintar, dibujar);
       primaryStage.setTitle("Dibujito");
       primaryStage.setScene(scene);
       primaryStage.show(); 
       
       
    }
        

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
