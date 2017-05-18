/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficacion2p;


import java.io.File;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
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
    Transformador t = new Transformador();
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
    @FXML private MenuButton menu,menu1,menu2;
    
    @FXML
    private void dCirculo(ActionEvent event) {
        int cx = Integer.parseInt(this.cx.getText());
        int cy = Integer.parseInt(this.cy.getText());
        int r = Integer.parseInt(this.r.getText());
        paneCir.getChildren().clear();
        puntos = new ArrayList<>();
        puntos.addAll(cir.bresenham(r, cx, cy));
        for( Pixel pixel :puntos){
            Rectangle rec = new Rectangle(pixel.x*5, pixel.y*5, 5, 5);
            rec.setFill(colorcir.getValue());
            paneCir.getChildren().add(rec);
        }
        
    }
    @FXML
    private void pCirculo(ActionEvent event) {
        int x = Integer.parseInt(cx.getText());
        int y = Integer.parseInt(cy.getText());
        for( Pixel pixel :rell.vecinos4(new Pixel(x,y), puntos)){
            Rectangle rec = new Rectangle(pixel.x*5, pixel.y*5, 5, 5);
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
            Rectangle rec = new Rectangle(pixel.x*5, pixel.y*5, 5, 5);
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
                x+=1;
            }else{
                x-=1;
            }
        }else{
            if(y<y3){
                y+=1;
            }else{
                y-=1;
            }
        }
        for( Pixel pixel :rell.vecinos4(new Pixel(x,y), puntos)){
            Rectangle rec = new Rectangle(pixel.x*5, pixel.y*5, 5, 5);
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
            Rectangle rec = new Rectangle(pixel.x*5, pixel.y*5, 5, 5);
            rec.setFill(colorCuad.getValue());
            paneCuad.getChildren().add(rec);
        }
        
    }
    @FXML
    private void pCuadrado(ActionEvent event) {
        int x = Integer.parseInt(xCuad.getText());
        int y = Integer.parseInt(yCuad.getText());
        for( Pixel pixel :rell.vecinos4(new Pixel(x+1,y+1), puntos)){
            Rectangle rec = new Rectangle(pixel.x*5, pixel.y*5, 5, 5);
            rec.setFill(colorCuad.getValue());
            paneCuad.getChildren().add(rec);
        }
        
    }
    @FXML
    private void dLinea(ActionEvent event) throws InterruptedException {
        int x1 = Integer.parseInt(x1lin.getText());
        int y1 = Integer.parseInt(y1lin.getText());
        int x2 = Integer.parseInt(x2lin.getText());
        int y2 = Integer.parseInt(y2lin.getText());
        paneLin.getChildren().clear();
        puntos = new ArrayList<>();
        puntos.addAll(lin.dda(x1, y1, x2, y2));
        for ( Pixel pixel :puntos){
            Rectangle rec = new Rectangle(pixel.x*5, pixel.y*5, 5, 5);
            rec.setFill(colorlin.getValue());
            paneLin.getChildren().add(rec);
            
        }
        
    }
    public void transladar(Pane pane,ColorPicker color){
        TextInputDialog dialog = new TextInputDialog("0");
	dialog.setTitle("transladar");
	dialog.setHeaderText("mover en x:");
	Optional<String> result = dialog.showAndWait();
	String entered = "none.";
	if (result.isPresent()) {	 
	    entered = result.get();
	}
        int x = Integer.parseInt(entered);
        TextInputDialog dialog1 = new TextInputDialog("0");
	dialog.setTitle("transladar");
	dialog.setHeaderText("mover en y:");
	Optional<String> result1 = dialog.showAndWait();
	String entered1 = "none.";
	if (result1.isPresent()) {	 
	    entered1 = result.get();
	}
        int y = Integer.parseInt(entered);
        pane.getChildren().clear();
        t.trasladar(puntos, new Pixel(x,y));
        for ( Pixel pixel :puntos){
            Rectangle rec = new Rectangle(pixel.x*5, pixel.y*5, 5, 5);
            rec.setFill(color.getValue());
            pane.getChildren().add(rec);
            
        }
    }
    public void rotar(Pane pane,ColorPicker color){
        TextInputDialog dialog = new TextInputDialog("180");
	dialog.setTitle("rotar");
	dialog.setHeaderText("angulo grados:");
	Optional<String> result = dialog.showAndWait();
	String entered = "none.";
	if (result.isPresent()) {	 
	    entered = result.get();
	}
	//actionStatus.setText("Text entered: " + entered);
        double gr = Integer.parseInt(entered);
        double rad = (gr*Math.PI)/180; //convertimos a rad
        pane.getChildren().clear();
        t.rotar(puntos,rad);
        for ( Pixel pixel :puntos){
            Rectangle rec = new Rectangle(pixel.x*5, pixel.y*5, 5, 5);
            rec.setFill(color.getValue());
            pane.getChildren().add(rec);
        }
    }
    public void escalar(Pane pane,ColorPicker color){
        TextInputDialog dialog = new TextInputDialog("100");
	dialog.setTitle("escalar");
	dialog.setHeaderText("S en %:");
	Optional<String> result = dialog.showAndWait();
	String entered = "none.";
	if (result.isPresent()) {	 
	    entered = result.get();
	}
	//actionStatus.setText("Text entered: " + entered);
        int s = Integer.parseInt(entered);
        pane.getChildren().clear();
        puntos=t.escalar(puntos, s);
        for ( Pixel pixel :puntos){
            Rectangle rec = new Rectangle(pixel.x*5, pixel.y*5, 5, 5);
            rec.setFill(color.getValue());
            pane.getChildren().add(rec);
            
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
        MenuItem item = new MenuItem("transladar");
        item.setOnAction(a->{ 
            transladar(paneCuad,colorCuad);
        });
        menu.getItems().add(item);
        MenuItem item2 = new MenuItem("rotar");
        item2.setOnAction(a->{ 
            rotar(paneCuad,colorCuad);
        });
        menu.getItems().add(item2);
        MenuItem item3 = new MenuItem("escalar");
        item3.setOnAction(a->{
            int x = Integer.parseInt(xCuad.getText());
            int y = Integer.parseInt(yCuad.getText());
            int lado = Integer.parseInt(ladoCuad.getText());
            puntos.clear();
            puntos.add(new Pixel(x, y));
            puntos.add(new Pixel(x+lado, y));
            puntos.add(new Pixel(x+lado, y+lado));
            puntos.add(new Pixel(x, y+lado));
            escalar(paneCuad,colorCuad);
        });
        menu.getItems().add(item3);
        MenuItem itemt = new MenuItem("transladar");
        itemt.setOnAction(a->{ 
            transladar(paneTri,colortri);
        });
        menu1.getItems().add(itemt);
        MenuItem itemt2 = new MenuItem("rotar");
        itemt2.setOnAction(a->{ 
            rotar(paneTri,colortri);
        });
        menu1.getItems().add(itemt2);
        MenuItem itemt3 = new MenuItem("escalar");
        itemt3.setOnAction(a->{
            int x1 = Integer.parseInt(x1tri.getText());
            int y1 = Integer.parseInt(y1tri.getText());
            int x2 = Integer.parseInt(x2tri.getText());
            int y2 = Integer.parseInt(y2tri.getText());
            int x3 = Integer.parseInt(x3tri.getText());
            int y3 = Integer.parseInt(y3tri.getText());
            puntos.clear();
            puntos.add(new Pixel(x1,y1));
            puntos.add(new Pixel(x2,y2));
            puntos.add(new Pixel(x3,y3));
            escalar(paneTri,colortri);
        });
        menu1.getItems().add(itemt3);
        MenuItem itemc = new MenuItem("transladar");
        itemc.setOnAction(a->{ 
            transladar(paneCir,colorcir);
        });
        menu2.getItems().add(itemc);
        MenuItem itemc2 = new MenuItem("rotar");
        itemc2.setOnAction(a->{ 
            rotar(paneCir,colorcir);
        });
        menu2.getItems().add(itemc2);
        MenuItem itemc3 = new MenuItem("escalar");
        itemc3.setOnAction(a->{ 
            int r=Integer.parseInt(this.r.getText())*5;
            this.r.setText(Integer.toString(r));
            dCirculo(new ActionEvent());
        });
        menu2.getItems().add(itemc3);
    }    
    
}

