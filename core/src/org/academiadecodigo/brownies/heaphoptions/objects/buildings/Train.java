package org.academiadecodigo.brownies.heaphoptions.objects.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.brownies.heaphoptions.menus.Menu;
import org.academiadecodigo.brownies.heaphoptions.menus.Win;
import org.academiadecodigo.brownies.heaphoptions.objects.abstracts.AbstractBuilding;

public class Train extends AbstractBuilding {

    private Win win;

    @Override
    public void createImage() {
        texture = new Texture(Gdx.files.internal("rect.png"));

    }

    @Override
    public void create() {
        rectangle = new Rectangle();
        rectangle.x = 150;
        rectangle.y = 700;
        rectangle.width = 64;
        rectangle.height = 100;
    }

    @Override
    public void showStories() {

        for (Menu menu : menus) {

            menu.show();

        }

        win.show();
    }

    @Override
    public void draw(Batch batch) {
        batch.draw(texture, getX(), getY(), 64, 100);
    }

    public void setWin(Win win) {
        this.win = win;
    }
}
