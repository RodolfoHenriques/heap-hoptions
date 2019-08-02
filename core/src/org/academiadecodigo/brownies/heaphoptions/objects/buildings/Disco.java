package org.academiadecodigo.brownies.heaphoptions.objects.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.brownies.heaphoptions.menus.Menu;
import org.academiadecodigo.brownies.heaphoptions.objects.abstracts.AbstractBuilding;

public class Disco extends AbstractBuilding {

    private School school;

    @Override
    public void createImage() {
        texture = new Texture(Gdx.files.internal("rect.png"));

    }

    @Override
    public void create() {
        rectangle = new Rectangle();
        rectangle.x = 173;
        rectangle.y = 624;
        rectangle.width = 12;
        rectangle.height = 27;
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
        batch.draw(texture, getX(), getY(), 12, 27);
    }

    private void changeStates() {
        this.setOpen(false);
        school.setOpen(true);
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
