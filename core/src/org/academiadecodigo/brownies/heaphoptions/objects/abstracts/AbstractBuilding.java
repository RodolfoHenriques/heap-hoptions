package org.academiadecodigo.brownies.heaphoptions.objects.abstracts;

import org.academiadecodigo.brownies.heaphoptions.menus.Menu;

import java.util.LinkedList;

public abstract class AbstractBuilding extends AbstractObject implements Building {

    protected LinkedList<Menu> menus;

    private boolean open;

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
