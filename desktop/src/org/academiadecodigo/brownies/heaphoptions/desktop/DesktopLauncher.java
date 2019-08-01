package org.academiadecodigo.brownies.heaphoptions.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.brownies.heaphoptions.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Heap Hoptions";
		config.width = 1366;
		config.height = 768;
		new LwjglApplication(new Game(), config);
	}
}
