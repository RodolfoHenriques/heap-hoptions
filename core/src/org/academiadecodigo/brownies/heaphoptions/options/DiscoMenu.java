package org.academiadecodigo.brownies.heaphoptions.options;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.brownies.heaphoptions.Game;
import org.academiadecodigo.brownies.heaphoptions.menus.AbstractMenu;

public class DiscoMenu extends AbstractMenu {
    @Override
    public void updatePlayer(int influence) {

    }

    @Override
    public void createImage() {
        texture = new Texture(Gdx.files.internal("menu-images/disco.jpg"));
    }

    @Override
    public void create() {
        rectangle = new Rectangle();
        rectangle.x = 0;
        rectangle.y = 0;
        rectangle.width = Game.SCREEN_WIDTH;
        rectangle.height = Game.SCREEN_HEIGHT;
    }
}
