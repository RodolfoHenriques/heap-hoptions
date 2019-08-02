package org.academiadecodigo.brownies.heaphoptions.objects.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.brownies.heaphoptions.menus.Menu;
import org.academiadecodigo.brownies.heaphoptions.objects.abstracts.AbstractBuilding;

public class Home extends AbstractBuilding {

    private School school;

    @Override
    public void createImage() {
        texture = new Texture(Gdx.files.internal("rect.png"));

    }

    @Override
    public void create() {
        rectangle = new Rectangle();
        rectangle.x = 1000;
        rectangle.y = 590;
        rectangle.width = 64;
        rectangle.height = 100;
    }

    @Override
    public void showStories() {

        for (Menu menu : menus) {

            menu.show();

        }

        changeStates();
    }

    @Override
    public void draw(Batch batch) {
        batch.draw(texture, getX(), getY(), 64, 100);
    }

    private void changeStates(){
        this.setOpen(false);
        school.setOpen(true);

    }

    public void setSchool(School school) {
        this.school = school;
    }
}