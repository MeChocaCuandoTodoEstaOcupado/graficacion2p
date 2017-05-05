/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficacion2p;


import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author ASUS PC
 */
public class Controlador implements Initializable {
    Rellenador rell= new Rellenador();
    ArrayList<Pixel> puntos;
    Circulo cir = new Circulo();
    Linea lin = new Linea();
    @FXML private ColorPicker colorCuad,colortri,colorcir,colorlin;
    @FXML private TextField x1lin,y1lin,x2lin,y2lin;
    @FXML private TextField ladoCuad,yCuad,xCuad,cx,cy,r;
    @FXML private TextField x1tri,y1tri,x2tri,y2tri,x3tri,y3tri;
    @FXML private Pane paneCuad,paneCir,paneTri,paneLin;
    @FXML private ImageView imageView,imageView1,imageView2,imageView3;
    
    @FXML
    private void dCirculo(ActionEvent event) {
        int cx = Integer.parseInt(this.cx.getText());
        int cy = Integer.parseInt(this.cy.getText());
        int r = Integer.parseInt(this.r.getText());
        paneCir.getChildren().clear();
        puntos = new ArrayList<>();
        puntos.addAll(cir.bresenham(r, cx, cy));
        for( Pixel pixel :puntos){
            Rectangle rec = new Rectangle(pixel.x, pixel.y, 1, 1);
            rec.setFill(colorcir.getValue());
            paneCir.getChildren().add(rec);
        }
        
    }
    @FXML
    private void pCirculo(ActionEvent event) {
        int x = Integer.parseInt(cx.getText());
        int y = Integer.parseInt(cy.getText());
        for( Pixel pixel :rell.vecinos4(new Pixel(x,y), puntos)){
            Rectangle rec = new Rectangle(pixel.x, pixel.y, 1, 1);
            rec.setFill(colorcir.getValue());
            paneCir.getChildren().add(rec);
        }
        
    }
    @FXML
    private void dtriangulo(ActionEvent event) {
        int x1 = Integer.parseInt(x1tri.getText());
        int y1 = Integer.parseInt(y1tri.getText());
        int x2 = Integer.parseInt(x2tri.getText());
        int y2 = Integer.parseInt(y2tri.getText());
        int x3 = Integer.parseInt(x3tri.getText());
        int y3 = Integer.parseInt(y3tri.getText());
        paneTri.getChildren().clear();
        puntos = new ArrayList<>();
        puntos.addAll(lin.dda(x1, y1, x2, y2));
        puntos.addAll(lin.dda(x1, y1, x3,y3));
        puntos.addAll(lin.dda(x2, y2, x3, y3));
        for ( Pixel pixel :puntos){
            Rectangle rec = new Rectangle(pixel.x, pixel.y, 1, 1);
            rec.setFill(colortri.getValue());
            paneTri.getChildren().add(rec);
        }        
    }
    @FXML
    private void pTriangulo(ActionEvent event) {
        int x1 = Integer.parseInt(x1tri.getText());
        int y1 = Integer.parseInt(y1tri.getText());
        int x2 = Integer.parseInt(x2tri.getText());
        int y2 = Integer.parseInt(y2tri.getText());
        int x3 = Integer.parseInt(x3tri.getText());
        int y3 = Integer.parseInt(y3tri.getText());
        ArrayList<Pixel> a=lin.dda(x1, y1, x2, y2);
        int x=a.get((a.size()-1)/2).x;
        int y=a.get((a.size()-1)/2).y;
        if (Math.abs(x1-x2)<Math.abs(y1-y2)){
            if(x<x3){
                x++;
            }else{
                x--;
            }
        }else{
            if(y<y3){
                y++;
            }else{
                y--;
            }
        }
        for( Pixel pixel :rell.vecinos4(new Pixel(x,y), puntos)){
            Rectangle rec = new Rectangle(pixel.x, pixel.y, 1, 1);
            rec.setFill(colortri.getValue());
            paneTri.getChildren().add(rec);
        }
        
    }
    @FXML
    private void dCuadrado(ActionEvent event) {
        int x = Integer.parseInt(xCuad.getText());
        int y = Integer.parseInt(yCuad.getText());
        int lado = Integer.parseInt(ladoCuad.getText());
        paneCuad.getChildren().clear();
        puntos = new ArrayList<>();
        puntos.addAll(lin.dda(x, y, x+lado, y));
        puntos.addAll(lin.dda(x+lado, y, x+lado,y+lado));
        puntos.addAll(lin.dda(x+lado, y+lado, x, y+lado));
        puntos.addAll(lin.dda(x, y+lado, x, y));
        for ( Pixel pixel :puntos){
            Rectangle rec = new Rectangle(pixel.x, pixel.y, 1, 1);
            rec.setFill(colorCuad.getValue());
            paneCuad.getChildren().add(rec);
        }
        
    }
    @FXML
    private void pCuadrado(ActionEvent event) {
        int x = Integer.parseInt(xCuad.getText());
        int y = Integer.parseInt(yCuad.getText());
        for( Pixel pixel :rell.vecinos4(new Pixel(x+1,y+1), puntos)){
            Rectangle rec = new Rectangle(pixel.x, pixel.y, 1, 1);
            rec.setFill(colorCuad.getValue());
            paneCuad.getChildren().add(rec);
        }
        
    }
    @FXML
    private void dLinea(ActionEvent event) {
        int x1 = Integer.parseInt(x1lin.getText());
        int y1 = Integer.parseInt(y1lin.getText());
        int x2 = Integer.parseInt(x2lin.getText());
        int y2 = Integer.parseInt(y2lin.getText());
        paneLin.getChildren().clear();
        puntos = new ArrayList<>();
        puntos.addAll(lin.dda(x1, y1, x2, y2));
        for ( Pixel pixel :puntos){
            Rectangle rec = new Rectangle(pixel.x, pixel.y, 1, 1);
            rec.setFill(colorlin.getValue());
            paneLin.getChildren().add(rec);
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File file = new File("src/imagen/cuadrados.jpg");
        Image image = new Image(file.toURI().toString());
        File file1 = new File("src/imagen/circulos.jpg");
        Image image1 = new Image(file1.toURI().toString());
        File file2 = new File("src/imagen/triangulos.jpg");
        Image image2 = new Image(file2.toURI().toString());
        File file3 = new File("src/imagen/lineas.jpg");
        Image image3 = new Image(file3.toURI().toString());
        imageView.setImage(image);
        imageView1.setImage(image1);
        imageView2.setImage(image2);
        imageView3.setImage(image3);
        paneCuad.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        paneCir.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        paneTri.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        paneLin.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }    
    
}
