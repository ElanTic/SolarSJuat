/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygame.Systems;

import com.jme3.scene.Spatial;
import com.jme3.util.SafeArrayList;
import mygame.Components.Rotacion;
import mygame.Entities.Celestial;

/**
 *
 * @author jt
 */
public class SistemaRotacion {
    
     //SafeArrayList<Celestial> elementos;
    
     public static void update(float deltaTime, Celestial rootNode) {
        Spatial body = rootNode.getBody();
        if(body != null){
            Rotacion rotacion = rootNode.getRotacion();
                body.rotate(deltaTime* rotacion.getxSpeed() , 
                        deltaTime * rotacion.getySpeed(), 
                        deltaTime * rotacion.getzSpeed());
        }
        for (Spatial elemento : rootNode.getChildren()){
            if(elemento instanceof Celestial){
                update(deltaTime, (Celestial) elemento);
            }
        }
    }
    
}
