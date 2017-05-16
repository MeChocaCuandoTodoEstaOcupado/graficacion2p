/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficacion2p;

import java.util.ArrayList;

/**
 *
 * @author ASUS PC
 */
public class Transformador {
    public ArrayList<Pixel> escalar(ArrayList<Pixel> puntos,int s){
        int x0 = puntos.get(0).x;
        int y0 = puntos.get(0).y;
        Linea lin=new Linea();
        ArrayList<Pixel> p = new ArrayList<>();
        for (Pixel pixel:puntos){
            pixel.x = ((pixel.x-x0)*s)+x0;
            pixel.y = ((pixel.y-y0)*s)+y0;
        }
        p.addAll(lin.dda(puntos.get(0).x, puntos.get(0).y, puntos.get(puntos.size()-1).x, puntos.get(puntos.size()-1).y));
        for (int i=0;i<puntos.size();i++){
            if(i+1<puntos.size()){
                p.addAll(lin.dda(puntos.get(i).x, puntos.get(i).y, puntos.get(i+1).x, puntos.get(i+1).y));
            }
        }
        return p;
    }
    public ArrayList<Pixel> trasladar(ArrayList<Pixel> puntos,Pixel punto){
        for (Pixel pixel:puntos){
            pixel.x=pixel.x+punto.x;
            pixel.y=pixel.y+punto.y;
        }
        return puntos;
    }
     public ArrayList<Pixel> rotar(ArrayList<Pixel> puntos,double grado){
        int x0 = puntos.get(0).x;
        int y0 = puntos.get(0).y;
        double cos = Math.cos(grado);
        double sen = Math.sin(grado);
        for (Pixel pixel:puntos){
            pixel.x = ((int)Math.round(((pixel.x-x0)*cos)-((pixel.y-y0)*sen))+x0);
            pixel.y = ((int)(((pixel.y-y0)*cos)+((pixel.x-x0)*sen))+y0);
        }
        return puntos;
    }
}
