package screens;

import javax.swing.JOptionPane;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MazeRunner;

import entities.Maze;

public class Settings implements Screen {
	public MazeRunner game;
	Texture background=new Texture("about.png");
	SpriteBatch batch = new SpriteBatch();
	BitmapFont font = new BitmapFont();
	int newLevel =0;
public Settings(MazeRunner game){
	this.game  = game;
	//background = new Texture("settings.png");
}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 0.2f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.input.getInputProcessor();
		batch.begin();//lets start this shit
		batch.draw(background, 0, 0);// originX, originY, width, height, scaleX, scaleY, rotation);.//
		font.setColor(Color.GOLD);
		int y =(int)Gdx.graphics.getHeight();
		int x = (int)Gdx.graphics.getWidth()/2;
		font.draw(batch, "WELCOME TO MAZE RUNNER SETTINGS \n\n"
				+ "Please look at the options on the left for more information.\n \nEnjoy the hunt", 100, y-100);
		font.setColor(Color.PINK);
		font.draw(batch,"SOUND: Press V(on) or X(mute)",x, y-150);
		font.setColor(Color.MAGENTA);
		font.draw(batch,"CLEAR HALL OF FAME: press H",x, y-200);
		font.setColor(Color.PURPLE);
		font.draw(batch,"NEW GAME: Press N",x, y-250);
		font.setColor(Color.CYAN);
		font.draw(batch,"CHANGE LEVEL: Press L",x, y-300);
		font.setColor(Color.GOLD);
		font.draw(batch,"MAIN MENU: Press M",x, y-350);
		batch.end();
	//game.font.setColor(Color.BLACK);
		Gdx.input.getInputProcessor();
		if(Gdx.input.isKeyPressed(Input.Keys.V)){//volume on
			game.themeSong.setVolume(game.themeSong.getVolume()+5);
			game.themeSong.play();
			game.themeSong.setLooping(true);
		}
		else	if(Gdx.input.isKeyPressed(Input.Keys.X)){//mute
			game.themeSong.pause();
			game.themeSong.setLooping(false);
		}
		else	if(Gdx.input.isKeyPressed(Input.Keys.N)){//new game
			game.setScreen(new PlayMode(new MazeRunner(newLevel)));
			
		}
		else	if(Gdx.input.isKeyPressed(Input.Keys.M)){
			game.setScreen(new MainMenu(game));
			
		}
		else	if(Gdx.input.isKeyPressed(Input.Keys.H)){
			game.clearHall();
			
		}
		else	if(Gdx.input.isKeyPressed(Input.Keys.L)){
			char level = JOptionPane.showInputDialog("Enter the level. 1:Easy 2: Middle 3: Hard").charAt(0);
			if((!Character.isDigit(level)) |Integer.parseInt(level+"")>3){
				JOptionPane.showMessageDialog(null, "The level you entered is not recognises\n"
						+ "Press L to view level options","INCORRECT Level",JOptionPane.ERROR_MESSAGE);
			}else{
			game.level = Integer.parseInt(level+"");
			newLevel =game.level;}
			
		}//and now we hope that shit works
		
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
