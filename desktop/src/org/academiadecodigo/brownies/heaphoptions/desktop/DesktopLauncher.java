package org.academiadecodigo.brownies.heaphoptions.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.brownies.heaphoptions.Game;

public class DesktopLauncher {

	public static final int GAME_WIDTH = 1366;
	public static final int GAME_HEIGHT= 768;

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Heap Hoptions";
		config.width = GAME_WIDTH;
		config.height = GAME_HEIGHT;
		new LwjglApplication(new Game(), config);
	}
}
