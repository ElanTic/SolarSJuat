/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygame;

import com.jme3.scene.Spatial;
import mygame.Components.Orbita;
import mygame.Components.Rotacion;
import mygame.Entities.Celestial;

/**
 *
 * @author jt
 */
public class CelestialBuilder {
    private String name;
    private Spatial body;
    private Rotacion rotacion;
    private Orbita orbita;
    private Celestial parent;

    public CelestialBuilder(String name) {
        this.name = name;
    }

    public CelestialBuilder body(Spatial body) {
        this.body = body;
        return this;
    }

    public CelestialBuilder rotacion(Rotacion rotacion) {
        this.rotacion = rotacion;
        return this;
    }

    public CelestialBuilder orbita(Orbita orbita) {
        this.orbita = orbita;
        return this;
    }
    
    public CelestialBuilder parent(Celestial parent) {
        this.parent = parent;
        return this;
    }

    public Celestial build() {
        Celestial celestial = new Celestial(name);
        if (body != null) {
            celestial.setBody(body);
        }
        if (rotacion != null) {
            celestial.setRotacion(rotacion);
        }
        if (orbita != null) {
            celestial.setOrbita(orbita);
        }
        if (parent != null) {
            parent.attachChild(celestial);
        }
        return celestial;
    }
}