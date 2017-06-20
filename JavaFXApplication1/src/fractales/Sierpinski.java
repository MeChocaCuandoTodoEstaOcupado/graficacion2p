/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractales;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;

/**
 *
 * @author Nicolás
 */
public class Sierpinski {
    private Triangulo tri;
    private Cuadrado cuad;
    public Sierpinski(Triangulo tri){
        this.tri = tri;
    }
    public void setCuadrado(Cuadrado cuad){
        this.cuad = cuad;
    }
    public void settri(Triangulo tri){
        this.tri = tri;
    }
    public void Cuadrado(ObservableList<Node> lista){
        lista.clear();
        Cuadrado c00=new Cuadrado(cuad);
        c00.pos="00";
        c00.escalar();
        Cuadrado c01=new Cuadrado(c00);
        c01.pos="01";
        c01.mover(100, 0);
        Cuadrado c02=new Cuadrado(c00);
        c02.pos="02";
        c02.mover(200, 0);
        Cuadrado c10=new Cuadrado(c00);
        c10.pos="10";
        c10.mover(0, -100);
        Cuadrado c20=new Cuadrado(c00);
        c20.pos="20";
        c20.mover(0, -200);
        Cuadrado c22=new Cuadrado(c00);
        c22.pos="22";
        c22.mover(200, -200);
        Cuadrado c12=new Cuadrado(c00);
        c12.pos="12";
        c12.mover(200, -100);
        Cuadrado c21=new Cuadrado(c00);
        c21.pos="21";
        c21.mover(100, -200);
        cuad.setElem(c00);
        cuad.setElem(c01);
        cuad.setElem(c02);
        cuad.setElem(c10);
        cuad.setElem(c12);
        cuad.setElem(c20);
        cuad.setElem(c21);
        cuad.setElem(c22);
        addCuadrado(lista,cuad);
    }
    public void addCuadrado(ObservableList<Node> lista,Cuadrado c){
        double[] ps = new double[10];
        ps[0]=c.getPuntos()[0].x;
        ps[1]=c.getPuntos()[0].y;
        ps[2]=c.getPuntos()[2].x;
        ps[3]=c.getPuntos()[2].y;
        ps[4]=c.getPuntos()[3].x;
        ps[5]=c.getPuntos()[3].y;
        ps[6]=c.getPuntos()[1].x;
        ps[7]=c.getPuntos()[1].y;
        ps[8]=c.getPuntos()[0].x;
        ps[9]=c.getPuntos()[0].y;
        Polyline pl = new Polyline(ps);
        lista.add(pl);
        if (c.getCuadrados()!=null){
            for(Cuadrado cd:c.getCuadrados()){
                if(cd!=null){
                    addCuadrado(lista,cd);
                }
                
            }
        }
    }
    public void tri(ObservableList<Node> lista){
        lista.clear();
        Triangulo izq=new Triangulo(tri);
        izq.pos="izq";
        izq.escalar();
        Triangulo der=new Triangulo(izq);
        der.pos="der";
        Triangulo arr=new Triangulo(izq);
        arr.pos="arr";
        arr.mover(75, -125);
        der.mover(150, 0);
        tri.setArr(arr);
        tri.setIzq(izq);
        tri.setDer(der);
        addTriangulo(lista,tri);
    }
    public void addTriangulo(ObservableList<Node> lista,Triangulo t){
        double[] ps = new double[8];
        ps[0]=t.getPuntos()[0].x;
        ps[1]=t.getPuntos()[0].y;
        ps[2]=t.getPuntos()[1].x;
        ps[3]=t.getPuntos()[1].y;
        ps[4]=t.getPuntos()[2].x;
        ps[5]=t.getPuntos()[2].y;
        ps[6]=t.getPuntos()[0].x;
        ps[7]=t.getPuntos()[0].y;
        Polyline pl = new Polyline(ps);
        pl.setStroke(Color.YELLOW);
        lista.add(pl);
        if (t.getTriangulos()!=null){
            for(Triangulo tr:t.getTriangulos()){
                if(tr!=null){
                    addTriangulo(lista,tr);
                }
                
            }
        }
    }
}
