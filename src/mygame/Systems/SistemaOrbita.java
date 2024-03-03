/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygame.Systems;

import com.jme3.scene.Spatial;
import mygame.Components.Orbita;
import mygame.Entities.Celestial;

/**
 *
 * @author jt
 */
public class SistemaOrbita {
     
     public static void update(float deltaTime, Celestial rootNode) {
        Orbita orbita = rootNode.getOrbita();
            rootNode.rotate(deltaTime* orbita.getxSpeed() , 
                    deltaTime * orbita.getySpeed(), 
                    deltaTime * orbita.getzSpeed());
        for (Spatial elemento : rootNode.getChildren()){
            if(elemento instanceof Celestial){
                update(deltaTime, (Celestial) elemento);
            }
        }
    }
}
