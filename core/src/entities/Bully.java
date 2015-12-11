package entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MazeRunner;

public class Bully {
	MazeRunner game;
	Maze maze;
	Entity bullyU3, bullyU1,bully2;
	SpriteBatch sprite;
public Bully(MazeRunner game, Maze maze){
	this.maze = maze;
	this.game  = game;
	Texture bullyU = new Texture("bullydown.png");
	Texture bully = new Texture("bully.png");
	 bullyU3 = new Entity(game, 3*game.tileSize, 14*game.tileSize, bullyU.getWidth(), bullyU.getHeight(), 100.0f, bullyU);
	bullyU1 = new Entity(game, 15*game.tileSize, 10*game.tileSize, bullyU.getWidth(), bullyU.getHeight(), 100.0f, bullyU);
	 bully2 = new Entity(game, 14*game.tileSize, 5*game.tileSize, bully.getWidth(), bully.getHeight(), 100.0f, bully);

}
}
