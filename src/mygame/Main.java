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
import com.jme3.scene.shape.Dome;
import com.jme3.scene.shape.Sphere;
import com.jme3.util.SkyFactory;
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
        settings.setTitle("Sistema solar");
        app.setSettings(settings);
        settings.setFrameRate(60);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        Celestial sol =    new CelestialBuilder("sol")
                .body(createPlanetGeometry(ColorRGBA.Yellow,1,"Textures/plasma.png"))
                .orbita(new Orbita(0, 1, 0))
                .build();

        Celestial tierra = new CelestialBuilder("tierra")
            .body(createPlanetGeometry(ColorRGBA.Cyan, 0.25f, "Textures/pixelated_image.png")) // Double the radius
            .rotacion(new Rotacion(0, 5, 0))
            .orbita(new Orbita(0, 2.5f, 0))
            .poss(6, 0, 0)
            .parent(sol)
            .build();

        
        Celestial luna = new CelestialBuilder("luna")
                .body(createPlanetGeometry(ColorRGBA.White, 0.07f, "Textures/pixelated_image.png")) // Double the radius
                .rotacion(new Rotacion(0, 2, 0))
                .parent(tierra)
                .poss(1.0f, 0.4f, 0.4f)
                .build();

        Celestial venus = new CelestialBuilder("venus")
                .body(createPlanetGeometry(ColorRGBA.Cyan, 0.08f, "Textures/pixelated_image.png")) // Double the radius
                .rotacion(new Rotacion(2, 2, 0))
                .orbita(new Orbita(0, 4, 9))
                .poss(-4, 2, 2)
                .parent(sol)
                .build();

        Celestial lunaVenus = new CelestialBuilder("luna_venus")
                .body(createPlanetGeometry(ColorRGBA.Gray, 0.03f, "Textures/pixelated_image.png")) // Double the radius
                .rotacion(new Rotacion(0, 2, 0))
                .parent(venus)
                .poss(.7f, 1f, 0)
                .build();
        
        Celestial lunaVenus2 = new CelestialBuilder("luna_venus2")
                .body(createPlanetGeometry(ColorRGBA.Gray, 0.04f, "Textures/pixelated_image.png")) // Double the radius
                .rotacion(new Rotacion(0, 1, 0))
                .parent(venus)
                .poss(.4f, 1, 0)
                .build();


        Celestial mercurio = new CelestialBuilder("mercurio")
                .body(createPlanetGeometry(ColorRGBA.Green, 0.06f, "Textures/pixelated_image.png")) // Double the radius
                .rotacion(new Rotacion(2, 0, 1))
                .orbita(new Orbita(0, 0, 8))
                .poss(3, -1, 3)
                .parent(sol)
                .build();

        Celestial lunaMercurio = new CelestialBuilder("luna_mercurio")
                .body(createPlanetGeometry(ColorRGBA.Gray, 0.02f, "Textures/pixelated_image.png")) // Double the radius
                .rotacion(new Rotacion(0, 1, 0))
                .parent(mercurio)
                .poss(0.4f, 0.4f, 0.4f)
                .build();

        Celestial marte = new CelestialBuilder("marte")
                .body(createMarteGeometry(ColorRGBA.Red))
                .rotacion(new Rotacion(2, 0, 1))
                .poss(7, -1, 7)
                .parent(sol)
                .build();

        Celestial jupiter = new CelestialBuilder("jupiter")
                .body(createPlanetGeometry(ColorRGBA.Green, 0.8f, "Textures/pixelated_image.png")) // Double the radius
                .rotacion(new Rotacion(1, 1, 0))
                .orbita(new Orbita(2, 3, 2))
                .poss(10, 2, -10)
                .parent(sol)
                .build();

        Celestial lunaJ = new CelestialBuilder("lunaj")
                .body(createPlanetGeometry(ColorRGBA.Magenta, 0.4f, "Textures/pixelated_image.png")) // Double the radius
                .rotacion(new Rotacion(0, 5, 0))
                .poss(2, 0, 0)
                .parent(jupiter)
                .build();
        
        rootNode.attachChild(sol);
        
        Celestial amlo = new CelestialBuilder("amlo")
                .body(createPlanetGeometry(ColorRGBA.Yellow,1.5f,"Textures/amlo.JPG"))
                .rotacion(new Rotacion(0, 1.5f, .7f))
                //.orbita(new Orbita(2, 3, 2))
                .poss(-13, 1, -5)
                .parent(sol) 
                .build();      
        
        
    }
    
    private Spatial createPlanetGeometry(ColorRGBA color, float size, String texture) {
        Sphere planetMesh = new Sphere(32, 32, size); 
        Geometry planetGeometry = new Geometry("Planet", planetMesh);
        Material planetMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        planetMaterial.setColor("Color", color); 
        planetMaterial.setTexture("ColorMap", assetManager.loadTexture(texture));
        planetGeometry.setMaterial(planetMaterial);
        return planetGeometry;
    }

    private Spatial createMarteGeometry(ColorRGBA color) {
        
        Box b = new Box(.14f, .14f, .14f);
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
        //rootNode.rotate(0,0.001f,0);
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
}
