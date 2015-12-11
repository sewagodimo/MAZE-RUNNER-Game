package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MazeRunner;

public class Welcom implements Screen {
Texture welcom = new Texture("hall.png");
SpriteBatch batch = new SpriteBatch();
MazeRunner game;
	
	public Welcom(MazeRunner game){
		this.game = game;
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		batch.begin();
		batch.draw(welcom,0,0,1000,1000);
		batch.end();
		Gdx.input.getInputProcessor();
		if(Gdx.input.isTouched()){
			game.setScreen(new MainMenu(game));
			this.dispose();
		}
		
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
