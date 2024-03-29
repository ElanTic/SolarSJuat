/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygame.Entities;

import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import mygame.Components.Orbita;
import mygame.Components.Rotacion;

/**
 *
 * @author jt
 */
public class Celestial extends Node {
    Orbita orbita;
    Rotacion rotacion;
    Spatial body;

    public Celestial(String name) {
        super(name);
        orbita = new Orbita(0,0,0);
        rotacion = new Rotacion(0,0,0);
    }

    public Orbita getOrbita() {
        return orbita;
    }

    public void setOrbita(Orbita orbita) {
        this.orbita = orbita;
    }

    public Rotacion getRotacion() {
        return rotacion;
    }

    public void setRotacion(Rotacion rotacion) {
        this.rotacion = rotacion;
    }

    public Spatial getBody() {
        return body;
    }

    public void setBody(Spatial body) {
         if (this.body != null) {
            this.detachChild(this.body); 
        }
        this.body = body;
        this.attachChildAt(body, 0);
    }
}
