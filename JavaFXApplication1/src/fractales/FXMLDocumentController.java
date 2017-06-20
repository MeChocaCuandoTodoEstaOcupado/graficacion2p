/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractales;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;

/**
 *
 * @author Nicolás
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Pane p;
    @FXML
    private Pane p2;
    Sierpinski s;
    @FXML
    private void cuadradoS(ActionEvent event) {
        
        ObservableList<Node> objects = p.getChildren();
        //double a = objects.get(0).getTranslateX();
        //objects.get(0).setTranslateX(a+20);
        
        s.Cuadrado(objects);
        
    }
    @FXML
    private void trianguloS(ActionEvent event) {
        
        ObservableList<Node> objects = p2.getChildren();
        s.tri(objects);
        
    }
    @FXML
    private void CuadradoR(ActionEvent event) {
        p.getChildren().clear();
        Punto[] pts={new Punto(50,350),new Punto(350,350),new Punto(50,50),new Punto(350,50)};
        Cuadrado c=new Cuadrado(pts, "00");
        s.setCuadrado(c);
        Polyline pl1=new Polyline(new double[]{50,350,50,50,350,50,350,350,50,350});
        p.getChildren().add(pl1);       
    }
    @FXML
    private void trianguloR(ActionEvent event) {
        p2.getChildren().clear();
        Punto[] ps={new Punto(100,300),new Punto(250,50),new Punto(400,300)};
        Triangulo t= new Triangulo(ps,null,"izq");
        s.settri(t);
        Polyline pl=new Polyline(new double[]{100,300,250,50,400,300,100,300});
        pl.setStroke(Color.YELLOW);
        p2.getChildren().add(pl);        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Punto[] ps={new Punto(100,300),new Punto(250,50),new Punto(400,300)};
        Triangulo t= new Triangulo(ps,null,"izq");
        s = new Sierpinski(t);
        Punto[] pts={new Punto(50,350),new Punto(350,350),new Punto(50,50),new Punto(350,50)};
        Cuadrado c=new Cuadrado(pts, "00");
        s.setCuadrado(c);
        p.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        Polyline pl1=new Polyline(new double[]{50,350,50,50,350,50,350,350,50,350});
        p.getChildren().add(pl1);
        p2.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        Polyline pl=new Polyline(new double[]{100,300,250,50,400,300,100,300});
        pl.setStroke(Color.YELLOW);
        p2.getChildren().add(pl);
    }    
    
}
