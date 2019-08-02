package org.academiadecodigo.brownies.heaphoptions.objects.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.brownies.heaphoptions.objects.abstracts.AbstractBuilding;
import org.academiadecodigo.brownies.heaphoptions.options.SchoolMenu;

public class Home extends AbstractBuilding {

    private School school;
    SchoolMenu schoolMenu;

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

        schoolMenu = new SchoolMenu();
        schoolMenu.setBatch(batch);

        /*while (!(Gdx.input.isKeyPressed(Input.Keys.NUM_1)) && (!(Gdx.input.isKeyPressed(Input.Keys.NUM_2)))) {


            //Game.setState(Game.State.GAME);
        }
        */
        changeStates();
    }

    @Override
    public void handle(int key) {
        switch (key) {
            case Input.Keys.NUM_1:
                System.out.println("1");
                return;
            case Input.Keys.NUM_2:
                System.out.println("2");
        }
    }

    @Override
    public void draw(Batch batch) {
        batch.draw(texture, getX(), getY(), 64, 100);

        if (schoolMenu != null) {
            schoolMenu.show();
        }
    }

    private void changeStates() {
        this.setOpen(false);
        school.setOpen(true);

    }

    public void setSchool(School school) {
        this.school = school;
    }
}