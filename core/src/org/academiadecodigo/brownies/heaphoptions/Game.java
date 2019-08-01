package org.academiadecodigo.brownies.heaphoptions;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.brownies.heaphoptions.objects.Player;

public class Game extends ApplicationAdapter {

    public static final int GAME_WIDTH = 2239;
    public static final int GAME_HEIGHT = 2235;




    public static final int BG_WIDTH = 2239;
    public static final int BG_HEIGHT = 2235;
    public static final int SCREEN_WIDTH = 1366;
    public static final int SCREEN_HEIGHT = 768;

    private SpriteBatch batch;
    private Player player;
    private OrthographicCamera camera;

    private Texture bg;

    @Override
    public void create() {
        batch = new SpriteBatch();

        bg = new Texture(Gdx.files.internal("background.png"));

        player = new Player();
        player.createImage();
        player.create();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1366, 768);



    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.position.set(player.getX()+player.getWidth()/2, player.getY()+player.getHeight()/2, 0);

        camera.position.x = MathUtils.clamp(camera.position.x, SCREEN_WIDTH/2f, BG_WIDTH-SCREEN_WIDTH/2f);
        camera.position.y = MathUtils.clamp(camera.position.y, SCREEN_HEIGHT/2f, BG_HEIGHT-SCREEN_HEIGHT/2f);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(bg, 0, 0);
        player.draw(batch);
        batch.end();

        verifyInput();
    }

    @Override
    public void dispose() {
        batch.dispose();
        player.dispose();
        bg.dispose();
    }

    private void verifyInput() {

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
    }

}
