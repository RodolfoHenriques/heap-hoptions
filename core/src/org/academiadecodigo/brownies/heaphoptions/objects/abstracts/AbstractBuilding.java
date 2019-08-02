package org.academiadecodigo.brownies.heaphoptions.objects.abstracts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import org.academiadecodigo.brownies.heaphoptions.menus.Menu;
import org.academiadecodigo.brownies.heaphoptions.objects.interfaces.Building;

import java.util.LinkedList;

public abstract class AbstractBuilding extends AbstractObject implements Building {

    protected LinkedList<Menu> menus;

    private boolean open;

    @Override
    public void showStories() {
        for (Menu menu : menus) {
            menu.show();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.NUM_1)){

        }

    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setMenu(LinkedList<Menu> menus) {
        this.menus = menus;
    }
}
