package org.academiadecodigo.brownies.heaphoptions.menus;

import org.academiadecodigo.brownies.heaphoptions.objects.Player;
import org.academiadecodigo.brownies.heaphoptions.objects.abstracts.AbstractObject;

public abstract class AbstractMenu extends AbstractObject implements Menu {

    protected Player player;

    @Override
    public void show() {
        //createImage();
       // create();
        draw(batch);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
