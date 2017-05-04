/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficacion2p;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
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
    Circulo cir = new Circulo();
    Linea lin = new Linea();
    @FXML private TextField ladoCuad;
    @FXML private TextField yCuad;
    @FXML private TextField xCuad;
    @FXML private Pane paneCuad;
    @FXML private Pane paneCir;
    @FXML private Pane paneTri;
    @FXML private Pane paneLin;
    @FXML private ImageView imageView;
    @FXML private ImageView imageView1;
    @FXML private ImageView imageView2;
    @FXML private ImageView imageView3;
    
    @FXML
    private void dCirculo(ActionEvent event) {
        
        for ( Pixel pixel :cir.bresenham(20, 50, 40)){
            Rectangle rec = new Rectangle(pixel.x, pixel.y, 1, 1);
            paneCir.getChildren().add(rec);
        }
        
    }
    
    @FXML
    private void dtriangulo(ActionEvent event) {
        
        for ( Pixel pixel :lin.dda(10, 20, 50, 40)){
            Rectangle rec = new Rectangle(pixel.x, pixel.y, 1, 1);
            paneTri.getChildren().add(rec);
        }
        for ( Pixel pixel :lin.dda(10, 20, 10, 40)){
            Rectangle rec = new Rectangle(pixel.x, pixel.y, 1, 1);
            paneTri.getChildren().add(rec);
        }
        for ( Pixel pixel :lin.dda(10, 40, 50, 40)){
            Rectangle rec = new Rectangle(pixel.x, pixel.y, 1, 1);
            paneTri.getChildren().add(rec);
        }
        
    }
    
    @FXML
    private void dCuadrado(ActionEvent event) {
        int x = Integer.parseInt(xCuad.getText());
        int y = Integer.parseInt(yCuad.getText());
        int lado = Integer.parseInt(ladoCuad.getText());
        paneCuad.getChildren().clear();
        for ( Pixel pixel :lin.dda(x, y, x+lado, y)){
            Rectangle rec = new Rectangle(pixel.x, pixel.y, 1, 1);
            paneCuad.getChildren().add(rec);
        }
        for ( Pixel pixel :lin.dda(x+lado, y, x+lado,y+lado)){
            Rectangle rec = new Rectangle(pixel.x, pixel.y, 1, 1);
            paneCuad.getChildren().add(rec);
        }
        for ( Pixel pixel :lin.dda(x+lado, y+lado, x, y+lado)){
            Rectangle rec = new Rectangle(pixel.x, pixel.y, 1, 1);
            paneCuad.getChildren().add(rec);
        }
        for ( Pixel pixel :lin.dda(x, y+lado, x, y)){
            Rectangle rec = new Rectangle(pixel.x, pixel.y, 1, 1);
            paneCuad.getChildren().add(rec);
        }
        
    }
    
    @FXML
    private void dLinea(ActionEvent event) {
        
        for ( Pixel pixel :lin.bresenham(10,20, 301, 40)){
            Rectangle rec = new Rectangle(pixel.x, pixel.y, 1, 1);
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
