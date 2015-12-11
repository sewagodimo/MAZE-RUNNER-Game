package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MazeRunner;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Maze Runner " + MazeRunner.VERSION;
		config.useGL30 = true;
		config.fullscreen =false;
		config.width = 1200;
		config.height = 800;
		new LwjglApplication(new MazeRunner(1), config);
	}
}
