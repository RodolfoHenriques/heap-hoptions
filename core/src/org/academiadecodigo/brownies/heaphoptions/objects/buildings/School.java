package org.academiadecodigo.brownies.heaphoptions.objects.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.brownies.heaphoptions.menus.Menu;
import org.academiadecodigo.brownies.heaphoptions.objects.abstracts.AbstractBuilding;

public class School extends AbstractBuilding {

    private Disco disco;
    private University university;
    private CallCenter callCenter;
    private CoffeeShop coffeeShop;

    @Override
    public void createImage() {
        texture = new Texture(Gdx.files.internal("rect.png"));

    }

    @Override
    public void create() {
        rectangle = new Rectangle();
        rectangle.x = 110;
        rectangle.y = 805;
        rectangle.width = 182;
        rectangle.height = 14;
    }

    @Override
    public void showStories() {

        for (Menu menu : menus) {

            menu.show();

        }

        //TODO: ATTENTION HERE
        changeStatesDisco();
        changeStateUniversity();
        changeStateWork();

    }

    @Override
    public void draw(Batch batch) {
        batch.draw(texture, getX(), getY(), 182, 14);
    }

    private void changeStatesDisco(){
        this.setOpen(false);
        disco.setOpen(true);
    }

    private void changeStateUniversity(){
        this.setOpen(false);
        university.setOpen(true);
    }

    private void changeStateWork(){
        this.setOpen(false);
        callCenter.setOpen(true);
        coffeeShop.setOpen(true);
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public void setCallCenter(CallCenter callCenter) {
        this.callCenter = callCenter;
    }

    public void setCoffeeShop(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }
}
