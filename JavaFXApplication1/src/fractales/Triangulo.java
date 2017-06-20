/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractales;

/**
 *
 * @author Nicolás
 */
public class Triangulo {
    private Punto[] puntos;
    private Triangulo[] triangulos;
    public String pos;
    public Punto[] getPuntos(){
        return puntos;
    }
    public void setIzq(Triangulo t){
        if(triangulos==null){
            triangulos=new Triangulo[3];
        }
        triangulos[0]=t;
    }
    public void setDer(Triangulo t){
        if(triangulos==null){
            triangulos=new Triangulo[3];
        }
        triangulos[2]=t;
    }
    public void setArr(Triangulo t){
        if(triangulos==null){
            triangulos=new Triangulo[3];
        }
        triangulos[1]=t;
    }
    public Triangulo[] getTriangulos() {
        return triangulos;
    }
    public Triangulo(Punto [] puntos,Triangulo[] triangulos,String pos){
        this.puntos = puntos;
        this.triangulos = triangulos;
        this.pos = pos;
    }
    public void escalar(){
        double x=puntos[0].x;double y=puntos[0].y;
        double xa=puntos[1].x;double ya=puntos[1].y;
        double xd=puntos[2].x;double yd=puntos[2].y;
        for(Punto a:puntos){
            a.x = a.x - x;
            a.y = a.y - y;
            a.x = a.x/2;
            a.y = a.y/2;
            a.x = a.x + x;
            a.y = a.y + y;
        }
        if (pos.equals("arr")){
            mover(puntos[1].x-xa, puntos[1].y-ya);
        }
        if (pos.equals("der")){
            mover(puntos[2].x-xd, puntos[2].y-yd);
        }
        if(triangulos !=null){
            for(Triangulo t:triangulos){
                if (t!=null){
                    t.escalar();
                }               
            }
        }
        
    }
    public void mover(double x,double y){
        for(Punto a:puntos){
            a.x = a.x + x;
            a.y = a.y + y;
        }
        if(triangulos!=null){
            for(Triangulo t : triangulos){
                if(t!=null){
                    t.mover(x, y);
                }
            }    
        }
    }
    public Triangulo(Triangulo t){
        if (t!=null){
            puntos = new Punto[3];
            pos = t.pos;
            for(int i=0;i<3;i++){
                puntos[i]=new Punto(0,0);
                puntos[i].x=t.puntos[i].x;
                puntos[i].y=t.puntos[i].y;
                
            }
            if (t.triangulos!=null){            
                triangulos = new Triangulo[3];
                for(int i=0;i<3;i++){
                    triangulos[i]=new Triangulo(t.triangulos[i]);
                 }
            }
        }
    }
}
