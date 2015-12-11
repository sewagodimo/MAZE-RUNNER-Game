package screens;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MazeRunner;
import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.java_cup.internal.runtime.Symbol;

import entities.Maze;

public class HallFame implements Screen{//all in one screen
	MazeRunner game;
	Texture background= new Texture("hall.png");
	SpriteBatch batch = new SpriteBatch();
	BitmapFont font = new BitmapFont();
	int task=1;
	ArrayList<String>  name= new ArrayList<String>();
	FileReader file ;
	Maze maze;
	public HallFame(MazeRunner game, int task){
		this.game = new MazeRunner(1);
		this.task = task;
		maze = new Maze(game);
//	batch = new SpriteBatch();
	//we output task based on the file contents
					if(task == 1){
				//	name = "board.txt";
				//file = new FileReader("board.txt");
						background= new Texture("about.png");
				}
				else if(task ==2){
				
			//		file = new FileReader("how.txt");
					background= new Texture("about.png");
				}
				else {
					//name = "about.txt";
					//file = new FileReader("about.txt");
					background= new Texture("about.png");
				}//is she the girl from the video
					
				
		//1 is hall
		//2 how to play
		//3 about
		//4
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		name = game.file(task);
	}
//	Scanner 	sc = new Scanner(file);;
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0.2f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//Gdx.input.getInputProcessor();
		// TODO Auto-generated method stub
		Gdx.input.getInputProcessor();
		font.setColor(Color.GOLD);
		int y =(int)Gdx.graphics.getHeight()-100;
		int x = (int)Gdx.graphics.getWidth()/2+100;
		batch.begin();
		batch.draw(background,0,0);
		for(int i = 0;i<name.size()/2;i++){
	 font.draw(batch, name.get(i), 100, y-i*20);//move down
	 }
		font.setColor(Color.BROWN);
		for(int i=name.size()/2;i<name.size();i++ ){
			font.draw(batch, name.get(i), x-100, y-(i-name.size()/2)*20);//move down	
		}
		batch.end();
		//}
		Gdx.input.getInputProcessor();
		if(Gdx.input.isKeyPressed(Input.Keys.M)){
			Gdx.gl.glClearColor(0, 0, 0, 0.2f);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			game.setScreen(new MainMenu(game));
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
	public void renderHall(){
		//draw up the hall of fame
	}

}
