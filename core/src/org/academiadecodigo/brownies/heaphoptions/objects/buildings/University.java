package org.academiadecodigo.brownies.heaphoptions.objects.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.brownies.heaphoptions.menus.Menu;
import org.academiadecodigo.brownies.heaphoptions.menus.Win;
import org.academiadecodigo.brownies.heaphoptions.objects.abstracts.AbstractBuilding;

public class University extends AbstractBuilding {

    private CallCenter callCenter;
    private CoffeeShop coffeeShop;
    private Win win;

    @Override
    public void createImage() {
        texture = new Texture(Gdx.files.internal("rect.png"));
    }

    @Override
    public void create() {
        rectangle = new Rectangle();
        rectangle.x = 80;
        rectangle.y = 200;
        rectangle.width = 64;
        rectangle.height = 100;
    }

    @Override
    public void showStories() {

        for (Menu menu : menus) {

            menu.show();

        }
        //TODO ATTENTION HERE - WINNING SCENARIO POSSIBILITY
        changeStates();
        win.show();
    }

    @Override
    public void draw(Batch batch) {
        batch.draw(texture, getX(), getY(), 64, 100);
    }

    private void changeStates() {
        this.setOpen(false);

        if (callCenter.isAvailable()) {
            callCenter.setOpen(true);
        }
        if (coffeeShop.isAvailable()) {
            coffeeShop.setOpen(true);
        }

    }


    public void setCallCenter(CallCenter callCenter) {
        this.callCenter = callCenter;
    }

    public void setCoffeeShop(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }

    public void setWin(Win win) {
        this.win = win;
    }
}
