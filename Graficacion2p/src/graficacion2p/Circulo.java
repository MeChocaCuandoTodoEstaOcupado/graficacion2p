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
public class Circulo {
    
    public ArrayList<Pixel> bresenham(int r, int cx, int cy){
        ArrayList<Pixel> pixeles = new ArrayList<>();
        boolean pintar=true;
        int cont=0;
        int x=r,y=0,e=0;
        while(y<=x){
            if(pintar){
                pixeles.add(new Pixel((x+cx),(y+cy)));
                pixeles.add(new Pixel((-x+cx),(y+cy)));
                pixeles.add(new Pixel((x+cx),(-y+cy)));
                pixeles.add(new Pixel((-x+cx),(-y+cy)));
                pixeles.add(new Pixel((y+cx),(x+cy)));
                pixeles.add(new Pixel((-y+cx),(x+cy)));
                pixeles.add(new Pixel((y+cx),(-x+cy)));
                pixeles.add(new Pixel((-y+cx),(-x+cy)));
            }
            e=e+2*y+1;
            y=y+1;
            if(2*e>(2*x-1)){
                x=x-1;
                e=e-2*x+1;
            }
            
        }
        return pixeles;
    }
}
