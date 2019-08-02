package org.academiadecodigo.brownies.heaphoptions;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.brownies.heaphoptions.objects.Player;
import org.academiadecodigo.brownies.heaphoptions.objects.abstracts.AbstractBuilding;
import org.academiadecodigo.brownies.heaphoptions.objects.abstracts.AbstractObject;
import org.academiadecodigo.brownies.heaphoptions.objects.buildings.CallCenter;
import org.academiadecodigo.brownies.heaphoptions.objects.buildings.CoffeeShop;
import org.academiadecodigo.brownies.heaphoptions.objects.interfaces.Building;

import java.util.LinkedList;

public class Game extends ApplicationAdapter {

    public static final int BG_WIDTH = 2064;
    public static final int BG_HEIGHT = 1152;
    public static final int SCREEN_WIDTH = 1366;
    public static final int SCREEN_HEIGHT = 768;

    private SpriteBatch batch;
    private Player player;
    private OrthographicCamera camera;
    private Texture bg;
    private ObjectFactory objectFactory = new ObjectFactory();

    private LinkedList<AbstractBuilding> buildings;

    private AbstractBuilding currentBuilding;

    //Collisions
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private MapLayer collision;
    private MapObjects objects;

    @Override
    public void create() {
        batch = new SpriteBatch();

        bg = new Texture(Gdx.files.internal("background.png"));

        buildings = objectFactory.createBuildings();
        createObjects();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1366, 768);

        //For Collisions
        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load("collisions/collisions.tmx");
        collision = map.getLayers().get(0);
        objects = collision.getObjects();
        renderer = new OrthogonalTiledMapRenderer(map);

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.position.set(player.getX() + player.getWidth() / 2, player.getY() + player.getHeight() / 2, 0);

        camera.position.x = MathUtils.clamp(camera.position.x, SCREEN_WIDTH / 2f, BG_WIDTH - SCREEN_WIDTH / 2f);
        camera.position.y = MathUtils.clamp(camera.position.y, SCREEN_HEIGHT / 2f, BG_HEIGHT - SCREEN_HEIGHT / 2f);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        renderer.setView(camera);
        renderer.render();

        batch.begin();
        batch.draw(bg, 0, 0);
        drawObjects();
        batch.end();

        verifyInput();




    }

    @Override
    public void dispose() {
        batch.dispose();
        player.dispose();
        bg.dispose();
        for (AbstractBuilding building : buildings) {
            building.dispose();
        }
    }

    private void verifyInput() {

        verifyCollision();

        if (player.canWalk()) {
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                player.moveUp();
            }

            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                player.moveLeft();
            }

            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                player.moveDown();
            }

            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                player.moveRight();
            }
            return;
        }

        if (currentBuilding != null && currentBuilding.isOpen()) {
            currentBuilding.showStories();

            if (currentBuilding instanceof CoffeeShop) {
                buildings.remove(currentBuilding);
            }
            if (currentBuilding instanceof CallCenter) {
                buildings.remove(currentBuilding);
            }

            player.setCanWalk(true);
        }

    }

    private void createObjects() {
        player = new Player();
        player.createImage();
        player.create();

        for (AbstractBuilding building : buildings) {
            building.createImage();
            building.create();
        }

    }

    private void drawObjects() {
        for (AbstractBuilding building : buildings) {
            building.draw(batch);
        }
        player.draw(batch);
    }

    private void verifyCollision() {

        for (RectangleMapObject rectangleMapObject : objects.getByType(RectangleMapObject.class)) {
            Rectangle rectangle = rectangleMapObject.getRectangle();

            if(player.getRectangle().overlaps(rectangle)){
                System.out.println("Bateu");
            }

        }


        for (AbstractBuilding building : buildings) {
            if (player.getRectangle().overlaps(building.getRectangle())) {
                if (building.isOpen()) {
                    player.setCanWalk(false);
                    currentBuilding = building;
                }
            }
        }
        currentBuilding = null;
    }

}
