package org.academiadecodigo.brownies.heaphoptions.menus;

public class MainMenu extends AbstractMenu {

    @Override
    public void show() {

    }

    @Override
    public void updatePlayer(int influence) {
        player.setInfluence(player.getInfluence() + influence);
    }

}
