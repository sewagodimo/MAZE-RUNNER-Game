package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.TweenAccessors.SpriteTween;
import com.mygdx.game.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import java.awt.event.ActionListener;
public class SplashScreen implements Screen{
Texture splashTexture;//image
Sprite splashSprite;//access to image manuulation, fades in and out
SpriteBatch batch;//sends bound images, speeds up game performance
MazeRunner game;
Music theme;
//TweenM
public void create(){
}
public SplashScreen(MazeRunner game) {
	// TODO Auto-generated constructor stub
	this.game = game;
}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		splashTexture = new Texture(Gdx.files.internal("tetris.jpeg" ));//else png
		splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		splashSprite = new Sprite(splashTexture);
                splashSprite.setColor(1, 1, 1, 0);
		splashSprite.setOrigin(splashSprite.getWidth()/2, splashSprite.getHeight()/2);
		splashSprite.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);//put image in the center ofscreen
		batch  = new SpriteBatch();
                batch.begin();
                batch.draw(splashTexture, 0, 0);
                   batch.draw(splashTexture, 500, 200);
                    batch.draw(splashTexture, 700, 300);
                batch.end();
                 Gdx.audio.newMusic(Gdx.files.internal("tetrissong.mp3"
           ));
                if (Gdx.input.isTouched()) {
        //    game.setScreen(new MainMenu(game));
          
            dispose();
	}
        }     
//float stateTime=0f;   
	@Override
	public void render(float delta) {
		// A lloop
     //       stateTime += Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		splashSprite.draw(batch);//need to begin before drawing
                       batch.enableBlending();
//batch.enableBlending();
batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
              //   batch.draw(splashTexture, 700, 500);
                 for(int i = 0;i<10;i++){
                     int x = (int)(300);
                  int y =    (int)(300);
                 batch.draw(splashTexture,x,y );
                   batch.draw(splashTexture, x+200,  y+100);
                    batch.draw(splashTexture,  x+400,  y+150);
                 }
           Texture     splashHome = new Texture(Gdx.files.internal("welcome.jpg" ));
           //     Gdx.app.log(Tetris15.LOG,"Rendering.... ");
              batch.draw(splashHome, 0,  0);
		batch.end();
                  if (Gdx.input.isTouched()) {
            game.setScreen(new PlayMode(game));
          
            dispose();
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
