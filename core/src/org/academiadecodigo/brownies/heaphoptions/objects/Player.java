package org.academiadecodigo.brownies.heaphoptions.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public class Player extends AbstractObject implements Movable {

    private final float SPEED = 200;

    @Override
    public void moveUp() {
        float newY = this.getY() + SPEED;

        setY(newY);
    }

    @Override
    public void moveLeft() {
        float newX = this.getX() - SPEED;

        setX(newX);
    }

    @Override
    public void moveDown() {
        float newY = this.getY() - SPEED;

        setY(newY);
    }

    @Override
    public void moveRight() {
        float newX = this.getX() + SPEED;

        setX(newX);

    }

    @Override
    public void createImage() {
        texture = new Texture(Gdx.files.internal("rectangle.png")); //TODO: Change image path
    }

    @Override
    public void create() { //TODO: Change this too
        rectangle = new Rectangle();
        rectangle.x = 800 / 2 - 64 / 2;
        rectangle.y = 20;
        rectangle.width = 64;
        rectangle.height = 64;
    }

    @Override
    public void draw(Batch batch) {
        batch.draw(texture, getX(), getY()); //TODO: Add width and height in this arguments
    }
}
