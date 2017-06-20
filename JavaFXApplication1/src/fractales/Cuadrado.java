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
public class Cuadrado {
    private Punto[] puntos;
    private Cuadrado[] cuadrados;
    public String pos;
    public Cuadrado(Punto [] puntos,String pos){
        this.puntos = puntos;
        this.cuadrados = null;
        this.pos = pos;
    }
    public Punto[] getPuntos(){
        return puntos;
    }
    public Cuadrado[] getCuadrados(){
        return cuadrados;
    }
    public void setElem(Cuadrado c){
        if(cuadrados==null){
            cuadrados=new Cuadrado[8];
        }
        if(c.pos.equals("00")){
            cuadrados[0]=c;
        }
        if(c.pos.equals("01")){
            cuadrados[1]=c;
        }
        if(c.pos.equals("02")){
            cuadrados[2]=c;
        }
        if(c.pos.equals("10")){
            cuadrados[3]=c;
        }
        if(c.pos.equals("12")){
            cuadrados[4]=c;
        }
        if(c.pos.equals("20")){
            cuadrados[5]=c;
        }
        if(c.pos.equals("21")){
            cuadrados[6]=c;
        }
        if(c.pos.equals("22")){
            cuadrados[7]=c;
        }
    }
    public void mover(double x,double y){
        for(Punto a:puntos){
            a.x = a.x + x;
            a.y = a.y + y;
        }
        if(cuadrados!=null){
            for(Cuadrado c : cuadrados){
                if(c!=null){
                    c.mover(x, y);
                }
            }    
        }
    }
    public void escalar(){
        double x=puntos[0].x;double y=puntos[0].y;
        double xa=puntos[3].x;double ya=puntos[3].y;
        for(Punto a:puntos){
            a.x = a.x - x;
            a.y = a.y - y;
            a.x = a.x/3;
            a.y = a.y/3;
            a.x = a.x + x;
            a.y = a.y + y;
        }
        if (pos.equals("01")){
            mover(-Math.abs(puntos[3].x-xa), 0);
        }
        if (pos.equals("02")){
            mover(-2*Math.abs(puntos[3].x-xa), 0);
        }
        if (pos.equals("10")){
            mover(0, Math.abs(puntos[3].y-ya));
        }
        if (pos.equals("20")){
            mover(0, 2*Math.abs(puntos[3].y-ya));
        }
        if (pos.equals("22")){
            mover(-2*Math.abs(puntos[3].x-xa), 2*Math.abs(puntos[3].y-ya));
        }
        if (pos.equals("12")){
            mover(-2*Math.abs(puntos[3].x-xa), Math.abs(puntos[3].y-ya));
        }
        if (pos.equals("21")){
            mover(-Math.abs(puntos[3].x-xa), 2*Math.abs(puntos[3].y-ya));
        }
        if(cuadrados !=null){
            for(Cuadrado t:cuadrados){
                if (t!=null){
                    t.escalar();
                }               
            }
        }
        
    }
    public Cuadrado(Cuadrado c){
        if (c!=null){
            puntos = new Punto[4];
            pos = c.pos;
            for(int i=0;i<4;i++){
                puntos[i]=new Punto(0,0);
                puntos[i].x=c.puntos[i].x;
                puntos[i].y=c.puntos[i].y;
                
            }
            if (c.cuadrados!=null){            
                cuadrados = new Cuadrado[8];
                for(int i=0;i<8;i++){
                    cuadrados[i]=new Cuadrado(c.cuadrados[i]);
                 }
            }
        }
    }
}
