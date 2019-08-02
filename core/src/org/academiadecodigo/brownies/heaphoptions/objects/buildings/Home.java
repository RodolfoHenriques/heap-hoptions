package org.academiadecodigo.brownies.heaphoptions.objects.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.brownies.heaphoptions.menus.MainMenu;
import org.academiadecodigo.brownies.heaphoptions.menus.Menu;
import org.academiadecodigo.brownies.heaphoptions.objects.Player;
import org.academiadecodigo.brownies.heaphoptions.objects.abstracts.AbstractBuilding;
import org.academiadecodigo.brownies.heaphoptions.options.CampingMenu;
import org.academiadecodigo.brownies.heaphoptions.options.DiscoMenu;
import org.academiadecodigo.brownies.heaphoptions.options.SchoolMenu;

import java.util.HashMap;
import java.util.Map;

public class Home extends AbstractBuilding {

    private School school;
    private Menu current;
    private Map<Class<? extends Menu>, Menu> menus = new HashMap<>();

    @Override
    public void createImage() {
        texture = new Texture(Gdx.files.internal("rect.png"));
    }


    @Override
    public void setBatch(Batch batch) {
        super.setBatch(batch);
        current = menus.get(SchoolMenu.class);
    }

    @Override
    public void create() {

        rectangle = new Rectangle();
        rectangle.x = 230;
        rectangle.y = 238;
        rectangle.width = 31;
        rectangle.height = 20;

        SchoolMenu schoolMenu = new SchoolMenu();
        schoolMenu.createImage();
        schoolMenu.create();
        schoolMenu.setBatch(batch);

        menus.put(SchoolMenu.class, schoolMenu);

        CampingMenu campingMenu = new CampingMenu();
        campingMenu.setBatch(batch);
        campingMenu.createImage();
        campingMenu.create();

        menus.put(CampingMenu.class, campingMenu);

        DiscoMenu discoMenu = new DiscoMenu();
        discoMenu.setBatch(batch);
        discoMenu.createImage();
        discoMenu.create();

        menus.put(DiscoMenu.class, discoMenu);

    }

    @Override
    public void showStories() {



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
                current = menus.get(CampingMenu.class);
                System.out.println("1");
                return;
            case Input.Keys.NUM_2:
                current = menus.get(DiscoMenu.class);
                return;
            case Input.Keys.NUM_3:
                current = null;

                //Texture texture = new Texture(Gdx.files.internal("background.png"));
                return;
        }
    }

    @Override
    public void draw(Batch batch) {
        batch.draw(texture, getX(), getY(), 31, 20);

        if (current != null) {
            current.show();

        }

    }

    private void changeStates() {
        this.setOpen(false);
        school.setOpen(true);

    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}