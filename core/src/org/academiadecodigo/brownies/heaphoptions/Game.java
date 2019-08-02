package org.academiadecodigo.brownies.heaphoptions;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import org.academiadecodigo.brownies.heaphoptions.menus.MainMenu;
import org.academiadecodigo.brownies.heaphoptions.menus.Synopsys;
import org.academiadecodigo.brownies.heaphoptions.objects.Player;
import org.academiadecodigo.brownies.heaphoptions.objects.abstracts.AbstractBuilding;
import org.academiadecodigo.brownies.heaphoptions.objects.abstracts.AbstractObject;
import org.academiadecodigo.brownies.heaphoptions.objects.buildings.CallCenter;
import org.academiadecodigo.brownies.heaphoptions.objects.buildings.CoffeeShop;
import org.academiadecodigo.brownies.heaphoptions.objects.interfaces.Building;

import java.util.LinkedList;

public class Game extends ApplicationAdapter {

    enum State {
        MENU,
        GAME,
        SYNOPSYS,
        WIN,
        LOSE
    }

    public static final int BG_WIDTH = 2239;
    public static final int BG_HEIGHT = 2235;
    public static final int SCREEN_WIDTH = 1366;
    public static final int SCREEN_HEIGHT = 768;

    private SpriteBatch batch;
    private Player player;
    private OrthographicCamera camera;
    private Texture bg;
    private ObjectFactory objectFactory = new ObjectFactory();

    private LinkedList<AbstractBuilding> buildings;

    private AbstractBuilding currentBuilding;

    private Music music;

    private State state = State.MENU;

    private MainMenu mainMenu;
    private Synopsys synopsys;

    @Override
    public void create() {
        batch = new SpriteBatch();

        bg = new Texture(Gdx.files.internal("background.png"));

        buildings = objectFactory.createBuildings();
        createObjects();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1366, 768);

        music = Gdx.audio.newMusic(Gdx.files.internal("music/game-song.mp3"));

        music.setLooping(true);

        music.play();

        mainMenu = new MainMenu();
        mainMenu.createImage();
        mainMenu.create();
        mainMenu.setBatch(batch);

        synopsys = new Synopsys();
        synopsys.createImage();
        synopsys.create();
        synopsys.setBatch(batch);

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (state == State.SYNOPSYS) {
            batch.begin();
            synopsys.draw(batch);
            batch.end();

            if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
                state = State.MENU;
            }

            return;
        }

        if (state != State.MENU) {
            camera.position.set(player.getX() + player.getWidth() / 2, player.getY() + player.getHeight() / 2, 0);

            camera.position.x = MathUtils.clamp(camera.position.x, SCREEN_WIDTH / 2f, BG_WIDTH - SCREEN_WIDTH / 2f);
            camera.position.y = MathUtils.clamp(camera.position.y, SCREEN_HEIGHT / 2f, BG_HEIGHT - SCREEN_HEIGHT / 2f);

            camera.update();
            batch.setProjectionMatrix(camera.combined);

            batch.begin();
            batch.draw(bg, 0, 0);
            drawObjects();
            batch.end();

            verifyInput();
            return;
        }

        batch.begin();
        mainMenu.show();
        batch.end();

        chooseMenuOption();

    }

    private void chooseMenuOption() {
        if (Gdx.input.isKeyPressed(Input.Keys.NUM_1)) {
            state = State.GAME;
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.NUM_2)) {
            state = State.SYNOPSYS;
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.NUM_3)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        player.dispose();
        bg.dispose();
        for (AbstractBuilding building : buildings) {
            building.dispose();
        }
        if (state != State.MENU) {
            mainMenu.dispose();
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

            if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
                state = State.MENU;
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
