package org.academiadecodigo.brownies.heaphoptions.objects.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.brownies.heaphoptions.menus.Menu;
import org.academiadecodigo.brownies.heaphoptions.objects.abstracts.AbstractBuilding;

public class CallCenter extends AbstractBuilding {
    @Override
    public void createImage() {
        texture = new Texture(Gdx.files.internal("call_center.png"));

    }

    @Override
    public void create() {
        rectangle = new Rectangle();
        rectangle.x = 800 / 2 - 64 / 2;
        rectangle.y = 20;
        rectangle.width = 64;
        rectangle.height = 64;
    }


    @Override
    public void showStories() {

        for (Menu menu : menus) {

            menu.show();

        }

    }
}
