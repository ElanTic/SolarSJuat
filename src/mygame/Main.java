package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Sphere;
import mygame.Components.Orbita;
import mygame.Components.Rotacion;
import mygame.Entities.Celestial;
import mygame.Systems.SistemaOrbita;
import mygame.Systems.SistemaRotacion;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        AppSettings settings = new AppSettings(true);
        settings.setTitle("Chinchilla\'s rampart");
        app.setSettings(settings);
        settings.setFrameRate(60);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        Celestial sol =    new CelestialBuilder("sol")
                .orbita(new Orbita(0, 1, 0))
                .build();

        Celestial tierra = new CelestialBuilder("tierra")
                .body(createPlanetGeometry(ColorRGBA.Blue)) 
                .rotacion(new Rotacion(0, 5, 0))
                .orbita(new Orbita(0, 2, 0))
                .parent(sol) 
                .build();

        Celestial luna = new CelestialBuilder("luna")
                .body(createLunaGeometry(ColorRGBA.Red)) 
                .rotacion(new Rotacion(0, 2, 0))
                .parent(tierra) 
                .build();
        
        tierra.move(4, 0, 0);
        luna.move(5, 2, 2);

        rootNode.attachChild(sol);
    }
    
    private Spatial createPlanetGeometry(ColorRGBA color) {
        Sphere planetMesh = new Sphere(32, 32, 1); 
        Geometry planetGeometry = new Geometry("Planet", planetMesh);
        Material planetMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        planetMaterial.setColor("Color", color); 
        planetMaterial.setTexture("ColorMap", assetManager.loadTexture("Textures/pixelated_image.png"));
        planetGeometry.setMaterial(planetMaterial);
        return planetGeometry;
    }

    private Spatial createLunaGeometry(ColorRGBA color) {
        Box b = new Box(.2f, .2f, .2f);
        Geometry lunaGeom = new Geometry("lunaGeom", b);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", color);
        mat.setTexture("ColorMap", assetManager.loadTexture("Textures/pixelated_image.png"));
        lunaGeom.setMaterial(mat);
        lunaGeom.rotate(0, 0, FastMath.HALF_PI);

        return lunaGeom;
    }

    @Override
    public void simpleUpdate(float tpf) {
        SistemaOrbita.update(tpf, (Celestial) rootNode.getChild("sol"));
        SistemaRotacion.update(tpf, (Celestial)rootNode.getChild("sol"));  
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
}
