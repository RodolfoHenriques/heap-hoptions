package org.academiadecodigo.brownies.heaphoptions.menus;

import org.academiadecodigo.brownies.heaphoptions.objects.Player;

public abstract class AbstractMenu implements Menu {

    protected Player player;

    @Override
    public void show() {

    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
