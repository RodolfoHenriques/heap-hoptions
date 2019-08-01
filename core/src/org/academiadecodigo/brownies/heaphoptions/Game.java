package org.academiadecodigo.brownies.heaphoptions;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.brownies.heaphoptions.objects.Player;

public class Game extends ApplicationAdapter {

    public static final int GAME_WIDTH = 1366;
    public static final int GAME_HEIGHT= 768;

    SpriteBatch batch;
    Texture img;

    private Player player;

    //TODO: CAMERA SOMEWHERE

    @Override
    public void create() {
        batch = new SpriteBatch();

        player = new Player();
        player.createImage();
        player.create();

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        player.draw(batch);
        batch.end();

        verifyInput();
    }

    @Override
    public void dispose() {
        batch.dispose();
        player.dispose();
    }

    private void verifyInput(){

        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            player.moveUp();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            player.moveLeft();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            player.moveDown();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            player.moveRight();
        }
    }

}
