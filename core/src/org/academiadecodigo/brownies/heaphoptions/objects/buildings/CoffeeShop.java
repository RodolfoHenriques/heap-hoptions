package org.academiadecodigo.brownies.heaphoptions.objects.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.brownies.heaphoptions.menus.Menu;
import org.academiadecodigo.brownies.heaphoptions.objects.abstracts.AbstractBuilding;

public class CoffeeShop extends AbstractBuilding {

    private boolean available;

    @Override
    public void createImage() {
        texture = new Texture(Gdx.files.internal("rect.png"));

    }

    @Override
    public void create() {
        rectangle = new Rectangle();
        rectangle.x = 80;
        rectangle.y = 20;
        rectangle.width = 64;
        rectangle.height = 100;
    }

    @Override
    public void showStories() {

        for (Menu menu : menus) {

            menu.show();

        }
    }

    @Override
    public void draw(Batch batch) {
        batch.draw(texture, getX(), getY(), 64, 100);
    }

    public boolean isAvailable() {
        return available;
    }
}
