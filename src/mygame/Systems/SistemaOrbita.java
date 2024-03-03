/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygame.Systems;

import com.jme3.util.SafeArrayList;
import mygame.Components.Orbita;
import mygame.Entities.Celestial;

/**
 *
 * @author jt
 */
public class SistemaOrbita {
        
     SafeArrayList<Celestial> elementos;
    
     void update(float deltaTime) {
        for (Celestial elemento : elementos) {
            Orbita orbita = elemento.getOrbita();
            elemento.rotate(deltaTime* orbita.getxSpeed() , 
                    deltaTime * orbita.getySpeed(), 
                    deltaTime * orbita.getzSpeed());
        }
    }
}
