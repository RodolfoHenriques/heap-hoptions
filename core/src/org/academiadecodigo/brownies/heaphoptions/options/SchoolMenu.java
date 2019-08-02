package org.academiadecodigo.brownies.heaphoptions.options;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.brownies.heaphoptions.Game;
import org.academiadecodigo.brownies.heaphoptions.menus.AbstractMenu;

public class SchoolMenu extends AbstractMenu {
    private DiscoMenu discoMenu;
    private CampingMenu campingMenu;

    @Override
    public void updatePlayer(int influence) {

        if (Gdx.input.isKeyPressed(Input.Keys.NUM_1)) {
            campingMenu = new CampingMenu();
            campingMenu.setBatch(batch);
            campingMenu.createImage();
            campingMenu.create();
            campingMenu.draw(batch);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.NUM_2)) {
            discoMenu = new DiscoMenu();
            discoMenu.setBatch(batch);
            discoMenu.createImage();
            discoMenu.create();
            discoMenu.draw(batch);
        }
    }

    @Override
    public void createImage() {
        texture = new Texture(Gdx.files.internal("menu-images/school.jpg"));
    }

    @Override
    public void create() {
        rectangle = new Rectangle();
        rectangle.x = 0;
        rectangle.y = 0;
        rectangle.width = Game.SCREEN_WIDTH;
        rectangle.height = Game.SCREEN_HEIGHT;
    }

    @Override
    public void show() {
        super.show();
        updatePlayer(0);
    }
}
