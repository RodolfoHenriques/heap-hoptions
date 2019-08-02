package org.academiadecodigo.brownies.heaphoptions.objects.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.brownies.heaphoptions.menus.Lost;
import org.academiadecodigo.brownies.heaphoptions.menus.Menu;
import org.academiadecodigo.brownies.heaphoptions.objects.abstracts.AbstractBuilding;

public class LostCubicle extends AbstractBuilding {

    private Lost lost;

    @Override
    public void createImage() {
        texture = new Texture(Gdx.files.internal("rect.png"));

    }

    @Override
    public void create() {
        rectangle = new Rectangle();
        rectangle.x = 1590;
        rectangle.y = 406;
        rectangle.width = 444;
        rectangle.height = 145;
    }

    @Override
    public void showStories() {

        for (Menu menu : menus) {

            menu.show();

        }

        lost.show();

    }

    @Override
    public void draw(Batch batch) {
        batch.draw(texture, getX(), getY(), 444, 145);
    }

    public void setLost(Lost lost) {
        this.lost = lost;
    }
}