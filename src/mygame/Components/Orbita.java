/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygame.Components;

/**
 *
 * @author jt
 */
public class Orbita {
    float xSpeed;
    float ySpeed;
    float zSpeed;

    public Orbita(float xSpeed, float ySpeed, float zSpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.zSpeed = zSpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float getzSpeed() {
        return zSpeed;
    }

    public void setzSpeed(float zSpeed) {
        this.zSpeed = zSpeed;
    }
    
}
