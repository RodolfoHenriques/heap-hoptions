package org.academiadecodigo.brownies.heaphoptions;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.brownies.heaphoptions.objects.Player;

public class Game extends ApplicationAdapter {

    public static final int GAME_WIDTH = 2239;
    public static final int GAME_HEIGHT = 2235;

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
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.position.set(player.getX(), player.getY(), 0);
        camera.update();

        if (player.getX() >= 1366/2 - player.getWidth() / 2) {
            batch.setProjectionMatrix(camera.combined);
        }

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
