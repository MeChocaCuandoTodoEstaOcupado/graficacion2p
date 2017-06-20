#version 3.7;
#include "colors.inc"
#include "textures.inc" 
#include "woods.inc"  
#include "glass.inc"   
#include "metals.inc"
camera {
        location <-5,10,-15>
        look_at <0,3.1,0>
        }

light_source {< -50, 25, -5> color White } 

light_source {< 0, 15, -6> color White }
//sphere {<0,0,0>,1 texture {pigment {Red}} }   
#declare glass=    
 material {
        texture {
          pigment { color rgbf <0.98, 1.0, 0.99, 0.75> }
          finish { F_Glass7 }
          }
        interior {I_Glass caustics 5}
        }

cylinder{<0,0,1>,<0,0.6,1>,1 finish {F_MetalB}} 
cylinder{<0,0.6,1>,<0,2.8,1>,0.5 finish {F_MetalB}}
cylinder{<0,2.8,1>,<0,3.3,1>,0.7 finish {F_MetalB}}
box{<0.3,4.5,1.2>,<-0.3,3.3,0.8> finish {F_MetalB}} 
box{<0.6,4.1,1.2>,<-0.6,3.6,0.8> finish {F_MetalB}}  

//background {White} 
//plane { y,-1 texture{pigment{White}}}    
#declare M_Wood18B =
colour_map {
    [0.00 0.25   color rgbf < 0.50, 0.26, 0.12, 0.10>
                 color rgbf < 0.54, 0.29, 0.13, 0.20>]
    [0.25 0.40   color rgbf < 0.54, 0.29, 0.13, 0.20>
                 color rgbf < 0.55, 0.28, 0.10, 0.70>]
    [0.40 0.50   color rgbf < 0.55, 0.28, 0.10, 0.70>
                 color rgbf < 0.50, 0.23, 0.15, 0.95>]
    [0.50 0.70   color rgbf < 0.50, 0.23, 0.15, 0.95>
                 color rgbf < 0.56, 0.29, 0.17, 0.70>]
    [0.70 0.98   color rgbf < 0.56, 0.29, 0.17, 0.70>
                 color rgbf < 0.54, 0.29, 0.13, 0.20>]
    [0.98 1.00   color rgbf < 0.54, 0.29, 0.13, 0.20>
                 color rgbf < 0.50, 0.26, 0.12, 0.10>]
}


#declare Floor_Texture =
    texture { pigment { P_WoodGrain18A color_map { M_Wood18A }}}
    texture { pigment { P_WoodGrain12A color_map { M_Wood18B }}}
    texture {
        pigment { P_WoodGrain12B color_map { M_Wood18B }}
        finish { reflection 0.25 }
    }

//#declare Floor =
plane { y,0
    texture { Floor_Texture
        scale 0.5
        rotate y*90
        rotate <10, 0, 15>
        translate z*4
    }
}  