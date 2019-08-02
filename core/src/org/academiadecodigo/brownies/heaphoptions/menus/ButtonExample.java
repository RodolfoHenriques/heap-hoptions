package org.academiadecodigo.brownies.heaphoptions.menus;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public class ButtonExample extends Game {





        Stage stage;
        TextButton button;
        TextButton.TextButtonStyle textButtonStyle;
        BitmapFont font;
        Skin skin;
        TextureAtlas buttonAtlas;

        @Override
        public void create() {
            stage = new Stage();
            Gdx.input.setInputProcessor(stage);
            font = new BitmapFont();
            skin = new Skin();
            buttonAtlas = new TextureAtlas(
                    Gdx.files.internal("/Users/codecadet/Desktop/hackathon/core/assets/desperation/pack.atlas"));
            skin.addRegions(buttonAtlas);
            textButtonStyle = new TextButton.TextButtonStyle();
            textButtonStyle.font = font;
            textButtonStyle.up = skin.getDrawable("blue_sliderUp");
            textButtonStyle.down = skin.getDrawable("blue_sliderUp");
            textButtonStyle.checked = skin.getDrawable("blue_sliderUp");
            button = new TextButton("blue_sliderUp", textButtonStyle);
            stage.addActor(button);
        }

        @Override
        public void render() {
            super.render();
            stage.draw();
        }
    }
