package org.academiadecodigo.brownies.heaphoptions.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.brownies.heaphoptions.Game;
import org.academiadecodigo.brownies.heaphoptions.objects.abstracts.AbstractObject;
import org.academiadecodigo.brownies.heaphoptions.objects.interfaces.Movable;

public class Player extends AbstractObject implements Movable {

    private final float SPEED = 10;
    private int influence;


    @Override
    public void moveUp() {

        if (getY() >= Game.GAME_HEIGHT - rectangle.getHeight()) {
            setY(Game.GAME_HEIGHT - rectangle.getHeight());
            return;
        }

        float newY = this.getY() + SPEED;
        setY(newY);
    }

    @Override
    public void moveLeft() {

        if (getX() < 0) {
            setX(0);
            return;
        }

        float newX = this.getX() - SPEED;
        setX(newX);
    }

    @Override
    public void moveDown() {

        if (getY() < 0) {
            setY(0);
            return;
        }

        float newY = this.getY() - SPEED;
        setY(newY);
    }

    @Override
    public void moveRight() {

        if (getX() >= Game.GAME_WIDTH - rectangle.getWidth()) {
            setX(Game.GAME_WIDTH - rectangle.getWidth());
            return;
        }

        float newX = this.getX() + SPEED;

        setX(newX);

    }

    @Override
    public void createImage() {
        texture = new Texture(Gdx.files.internal("Idle (1).png")); //TODO: Change image path

    }

    @Override
    public void create() { //TODO: Change this too
        rectangle = new Rectangle();
        rectangle.x = 800 / 2 - 64 / 2;
        rectangle.y = 20;
        rectangle.width = 16;
        rectangle.height = 16;
    }

    @Override
    public void draw(Batch batch) {
        batch.draw(texture, getX(), getY(), 86,86);
    }

    public int getInfluence() {
        return influence;
    }

    public void setInfluence(int influence) {
        this.influence = influence;
    }
}
