package org.academiadecodigo.brownies.heaphoptions.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class MainMenu extends AbstractMenu {

    @Override
    public void updatePlayer(int influence) {
        player.setInfluence(player.getInfluence() + influence);
    }

    @Override
    public void createImage() {
        texture = new Texture(Gdx.files.internal("main_menu.jpg")); //TODO: Change image path
    }

    @Override
    public void create() {
        rectangle = new Rectangle();
        rectangle.x = 800 / 2 - 64 / 2;
        rectangle.y = 20;
        rectangle.width = 64;
        rectangle.height = 64;
    }
}
