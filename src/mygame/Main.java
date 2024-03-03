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

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    //Geometry luna;
    public Spatial spatial_var = null;
    public Spatial s2 = null;
    public Spatial s3 = null;
    public Spatial s4 = null;
    public Spatial[] objects;

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
        Node sol = new Node("sol");
        Node terra = new Node ("terra");
        Box b = new Box(.2f, .2f, .2f);
        Geometry luna = new Geometry("luna", b);
        
        Box b2 = new Box(1, 1, 1);
        Geometry tierra = new Geometry ("tierra", b2);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Red);
        mat.setTexture("ColorMap", assetManager.loadTexture("Textures/pixelated_image.png"));
        luna.setMaterial(mat);
        
        luna.rotate(0, 0, FastMath.HALF_PI);
        tierra.setMaterial(mat);
        tierra.rotate(0,0, FastMath.HALF_PI/2);
                
        
        sol.attachChild(terra);
        
        //sol.attachChild(tierra);
        
        terra.attachChild(tierra);
        terra.attachChild(luna);
        
        
        //sol.move(1.5f,0,0);
        terra.move(4,0,0);
        luna.move(5,2,2);
        

        
        rootNode.attachChild(sol);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
        //luna.rotate(0, 0, FastMath.HALF_PI/2);
        spatial_var = rootNode.getChild("sol");
        spatial_var.rotate(0, tpf,0);
        s2 = rootNode.getChild("terra");
        s2.rotate(0,5*tpf,0);
        s3 = rootNode.getChild("luna");
        s3.rotate(0, 2 * tpf,0);
        Spatial tierra = rootNode.getChild("tierra");
        tierra.rotate(0,2 * tpf,0);
        
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
