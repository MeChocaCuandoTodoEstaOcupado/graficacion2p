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
public class Linea {
    public ArrayList<Pixel> dda(float x1,float y1,float x2,float y2){
        ArrayList<Pixel> pixeles = new ArrayList<>();
        float dx=x1-x2;
        float dy=y1-y2;
        float m=(y1-y2)/(x1-x2);
        if(Math.abs(dx)<Math.abs(dy)){
            if(y1>y2){
                float ax=y1;
                y1=y2;
                y2=ax;
                ax=x1;
                x1=x2;
                x2=ax;
            }
            while(y1<=y2){
                pixeles.add(new Pixel(Math.round(x1),Math.round(y1)));
                
                y1=y1+1;
                x1=x1+(1/m);               
            }
        }else{
            if(x1>x2){
                float ax=y1;
                y1=y2;
                y2=ax;
                ax=x1;
                x1=x2;
                x2=ax;
            }
            while(x1<=x2){
                pixeles.add(new Pixel(Math.round(x1),Math.round(y1)));
                
                x1=x1+1;
                y1=y1+m;               
            }
        }
        return pixeles;
        
    }
    public ArrayList<Pixel> bresenham(int x0, int y0, int x1, int y1) {
        ArrayList<Pixel> pixeles = new ArrayList<>();
        int x, y, dx, dy, p, incE, incNE, stepx, stepy;
        dx = (x1 - x0);
        dy = (y1 - y0);
        if (dy < 0) { 
            dy = -dy; 
            stepy = -1; 
        } 
        else {
            stepy = 1;
        }

        if (dx < 0) {  
            dx = -dx;  
            stepx = -1; 
        } 
        else {
            stepx = 1;
        }

        x = x0;
        y = y0;
        pixeles.add(new Pixel(Math.round(x0),Math.round(y0)));
        if(dx>dy){
            p = 2*dy - dx;
            incE = 2*dy;
            incNE = 2*(dy-dx);
            while (x != x1){
                x = x + stepx;
                if (p < 0){
                    p = p + incE;
                }
                else {
                    y = y + stepy;
                    p = p + incNE;
                }
                pixeles.add(new Pixel(Math.round(x),Math.round(y)));
            }
        }
        else{
            p = 2*dx - dy;
            incE = 2*dx;
            incNE = 2*(dx-dy);
            while (y != y1){
                y = y + stepy;
                if (p < 0){
                    p = p + incE;
                }
                else {
                    x = x + stepx;
                    p = p + incNE;
                }
                pixeles.add(new Pixel(Math.round(x),Math.round(y)));
            }
        }
        return pixeles;    
    }
}
