/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygame.Systems;

import com.jme3.util.SafeArrayList;
import mygame.Components.Rotacion;
import mygame.Entities.Celestial;

/**
 *
 * @author jt
 */
public class SistemaRotacion {
    
     SafeArrayList<Celestial> elementos;
    
     void update(float deltaTime) {
        for (Celestial elemento : elementos) {
            Rotacion rotacion = elemento.getRotacion();
            elemento.rotate(deltaTime* rotacion.getxSpeed() , 
                    deltaTime * rotacion.getySpeed(), 
                    deltaTime * rotacion.getzSpeed());
        }
    }
    
}
