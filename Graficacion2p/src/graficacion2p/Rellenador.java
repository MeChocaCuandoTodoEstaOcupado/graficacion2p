/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficacion2p;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author ASUS PC
 */
public class Rellenador {
    byte[][]mat;
    ArrayList<Pixel> relleno;
    public ArrayList<Pixel> vecinos4(Pixel pixel, ArrayList<Pixel> puntos){
        relleno = new ArrayList<>();
        mat=new byte[300][300];
        for(Pixel pix:puntos){
            if(0<=pix.x && pix.x<300 && 0<=pix.y && pix.y<300){
                mat[pix.x][pix.y]=1;
            }
        }
        mat[pixel.x][pixel.y]=2;
        vecinos4(pixel);
        return relleno;
    }
    private void vecinos4(Pixel p){
        if(p.x-1>=0 && p.x+1<300 && p.y-1>=0 && p.y+1<300){
            if(mat[p.x][p.y-1]==0){
                mat[p.x][p.y-1]=2;
                relleno.add(p);
                vecinos4(new Pixel(p.x,p.y-1));
            }
            if(mat[p.x-1][p.y]==0){
                mat[p.x-1][p.y]=2;
                relleno.add(p);
                vecinos4(new Pixel(p.x-1,p.y));
            }
            if(mat[p.x][p.y+1]==0){
                mat[p.x][p.y+1]=2;
                relleno.add(p);
                vecinos4(new Pixel(p.x,p.y+1));
            }
            if(mat[p.x+1][p.y]==0){
                mat[p.x+1][p.y]=2;
                relleno.add(p);
                vecinos4(new Pixel(p.x+1,p.y));
            }
        }
    }
}
