package entities;

import com.mygdx.game.MazeRunner;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import entities.Entity;

public class Player extends Entity {
	
	//Texture texture = new Texture("hunter.png");
	Maze maze;
	public Player(MazeRunner game, float x, float y, int width, int height, float speed, Texture texture,Maze maze) {
		
		super(game, x, y, width, height, speed, texture);
		this.maze = maze;//check if new values will not change the maze
	}

	@Override
	public void update(float delta) {
		
		dx = 0;
		dy = 0;

		// move
		if(Gdx.input.isKeyPressed(Keys.UP)) {
			dy = speed *delta;
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			dy = -speed *delta;
		}
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			dx = -speed *delta;
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			dx = speed *delta;
		}
	}
	//@Override
/*	public void moveP(float newX,float newY){//y increases
	//	int playx = newX/tilesi
	//	Maze maze = super.maze;
		
		int blockY =((int) newY)/maze.tileSize;//where in the grid will the player now be in
		int blockX = (int)newX/maze.tileSize;
		int topY = (int)this.y+this.height;
		int topX =(int) this.x+this.height;
		//System.out.println(maze.map[blockX+(int)(this.texture.getWidth()/maze.tileSize)][blockY]);
		if(blockX<0||blockY<0||blockX>19||blockY>15){
			System.out.println("On the edge cannot move");
			return;//out of grid bounds
		}
		System.out.println(maze.map[blockX+(int)(this.texture.getWidth()/maze.tileSize)][blockY]);
			if(maze.map[blockX][blockY]==1
				|maze.map[blockX+(int)(this.texture.getWidth()/maze.tileSize)][blockY]==1//check if the sides do not collide
			|	maze.map[blockX][blockY+(int)(this.texture.getHeight()/maze.tileSize)]==1
			|	maze.map[blockX+(int)(this.texture.getWidth()/maze.tileSize)][blockY+(int)(this.texture.getWidth()/maze.tileSize)]==1)//check if the new position is avaible
			return;
		if(maze.map[blockY][blockX]==0)//check if the new position is avaible
			super.move((int)super.dx, newY);
		else if(maze.map[blockY][blockX]==3){//check if the new position is avaible
			super.move((int)super.dx, newY);
		maze.map[blockY][blockX]=0;//change this after going through itss	
		}
	}
	public void moveUpDown(float newY){//y increases
		//	int playx = newX/tilesi
		//	Maze maze = super.maze; only Y gets reduced
			
			int blockY =((int) newY)/maze.tileSize;//where in the grid will the player now be in
			int blockX = (int)this.x/maze.tileSize;
			//System.out.println(maze.map[blockX+(int)(this.texture.getWidth()/maze.tileSize)][blockY]);
			if(blockX<0||blockY<0||blockX>19||blockY>15){
				System.out.println("On the edge cannot move");
				return;//out of grid bounds
			}
			System.out.println(maze.map[blockX+(int)(this.texture.getWidth()/maze.tileSize)][blockY]);
				if(maze.map[blockX][blockY]==1
					|maze.map[blockX+(int)(this.texture.getWidth()/maze.tileSize)][blockY]==1//check if the sides do not collide
				|	maze.map[blockX][blockY+(int)(this.texture.getHeight()/maze.tileSize)]==1
				|	maze.map[blockX+(int)(this.texture.getWidth()/maze.tileSize)][blockY+(int)(this.texture.getWidth()/maze.tileSize)]==1)//check if the new position is avaible
				return;
			if(maze.map[blockY][blockX]==0)//check if the new position is avaible
				super.move((int)super.dx, newY);
			else if(maze.map[blockY][blockX]==3){//check if the new position is avaible
				super.move((int)super.dx, newY);
			maze.map[blockY][blockX]=0;//change this after going through itss	
			}
		}
	public void moveSide(float newX){//y increases
		//	int playx = newX/tilesi
		//	Maze maze = super.maze;
		//super.move(newX,(int)this.dy);
			int blockY =((int) this.y)/maze.tileSize;//where in the grid will the player now be in
			int blockX = (int)newX/maze.tileSize;
			int size = (int)(this.texture.getWidth()/maze.tileSize);//if you re going right, check the forefront
			if(newX>this.x){
				//move right, check from  the front of the sprite
				blockX=blockX+size+blockY+(int)(this.texture.getWidth()/maze.tileSize);
			}
			//System.out.println(blockX+" "+blockY);//correct locating
			if(blockX<0||blockY<0||blockX>19||blockY>15){
				System.out.println("On the edge cannot move");
				return;//out of grid bounds
			}
			System.out.println("found on the map "+maze.onMap(0,0));//incorrect mapping
				if(maze.onMap(blockX,blockY)==1//you map with Y,X
					|maze.onMap(blockX,blockY+1)==1//check if the sides do not collide
				//|	maze.map[blockX][blockY+(int)(this.texture.getHeight()/maze.tileSize)]==1
				)//check if the new position is avaible
				return;
			if(maze.map[blockY][blockX]==0)//check if the new position is avaible
				super.move(newX,(int)this.dy);
			else if(maze.map[blockY][blockX]==3){//check if the new position is avaible
				this.move(newX,(int)this.dy);
				super.game.alive++;//add newlife to the life count
			maze.map[blockY][blockX]=0;//change this after going through itss	
			}
		}*/
	
}
