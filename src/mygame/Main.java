package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
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
        Celestial sol = new Celestial("sol");
        
        Celestial tierra = new Celestial ("tierra");
        Sphere planetMesh = new Sphere(32, 32, 1); // Adjust segments and radius as needed
        Geometry planetGeometry = new Geometry("Planet", planetMesh);
        Material planetMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        planetMaterial.setColor("Color", ColorRGBA.Blue); // Adjust color as needed
        planetGeometry.setMaterial(planetMaterial);
        
        Celestial luna = new Celestial("luna");
        Box b = new Box(.2f, .2f, .2f);
        Geometry lunaGeom = new Geometry("lunaGeom", b);
        
        Box b2 = new Box(1, 1, 1);
        Geometry tierraGeom = new Geometry ("tierraGeom", b2);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Red);
        mat.setTexture("ColorMap", assetManager.loadTexture("Textures/pixelated_image.png"));
        lunaGeom.setMaterial(mat);
        lunaGeom.rotate(0, 0, FastMath.HALF_PI);
        
        tierraGeom.setMaterial(mat);
        tierraGeom.rotate(0,0, FastMath.HALF_PI/2);
                
        sol.setOrbita(new Orbita(0,1,0));
        sol.attachChild(tierra);
        tierra.setBody(tierraGeom);
        luna.setBody(lunaGeom);
        luna.setRotacion(new Rotacion(0,2,0));
        tierra.attachChild(luna);
        tierra.setRotacion(new Rotacion(0,5,0));
        tierra.setOrbita(new Orbita(0,2,0));
        tierra.move(4,0,0);
        luna.move(5,2,2);
        rootNode.attachChild(sol);
        tierra.setBody(planetGeometry);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
        SistemaOrbita.update(tpf, (Celestial) rootNode.getChild("sol"));
        SistemaRotacion.update(tpf, (Celestial)rootNode.getChild("sol"));  
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
}
