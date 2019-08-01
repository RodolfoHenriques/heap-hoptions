package org.academiadecodigo.brownies.heaphoptions.objects.interfaces;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface Object {

    void createImage();

    void create();

    void draw(Batch batch);

    void dispose();

}
