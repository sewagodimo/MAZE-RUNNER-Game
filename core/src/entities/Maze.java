package entities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.MazeRunner;

public class Maze {
//creates the maze
	
	 public int[][] map= {
			 	{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1} ,
	   			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 
	   			{0,0,0,0,1,1,0,0,0,0,0,0,1,1,1,0,1,1,1,1},//bully u 3x14
	   			{1,1,1,0,1,1,0,1,1,1,0,0,0,0,0,0,0,0,1,1}, 
	   			{1,1,1,0,1,1,0,1,1,1,0,1,1,1,1,1,1,3,1,1}, 
	   			{1,1,3,0,0,0,0,1,1,1,0,1,1,1,1,1,1,0,1,1}, //
	   			{1,1,1,0,1,1,1,1,1,1,3,0,0,0,0,0,1,0,1,1}, //dragon 0x10
	   			{1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,0,1,3,1,1}, //bullyu 15 5
	   			{1,1,1,0,0,1,1,0,1,1,1,1,1,1,1,0,1,0,1,1}, 
	   			{1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,0,1,0,0,2}, //7y from bottom
	   			{1,1,0,0,0,1,1,0,3,0,0,0,0,1,1,0,1,0,1,1}, 
	   			{1,1,1,0,1,1,1,1,1,1,1,1,0,1,0,3,0,0,0,1}, //bully 14 5
	   			{1,1,1,1,1,0,0,0,0,0,0,0,0,1,1,0,0,1,1,1}, 
	   			{1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,1}, 
	   			{1,1,1,1,1,0,0,0,0,0,3,0,0,0,0,0,1,1,1,1}, // bu 15x2
	   			{0,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1}, 
	   			
	   				};
	public enum Axis { X, Y };
	public enum Direction { U, D, L, R };
	//public int[][] map;//this is a 16 by twenty
	public int mapWidth;public int tileSize=50, mapHeight;
	public Texture tileTexture,pathTexture,winTexture,lifeTexture;//textures for the wall, the path and the winning point
	int screenWidth;
	int screenHeight;
	SpriteBatch batch ;
	MazeRunner game;
	long time;

	public ArrayList<Entity> entities = new ArrayList<Entity>();
	public ArrayList<Entity> collidingTiles = new ArrayList<Entity>();
	Entity win;
	Player player;
	public Maze(MazeRunner game){
		this.game = game;
		this.player = player;
	
//	 map2 = map;//dunno why its acting up like this
	   		mapWidth = 20;
	   		 mapHeight = 16;
	   			  batch = new SpriteBatch();
	   		 tileSize = 50;//each tile is a 50x50
	   		 tileTexture = new Texture("brick.png"); 
	   		 pathTexture = new Texture("block.png");
	   		 winTexture = new Texture("win.png");
	   		 lifeTexture = new Texture("life2.png");
	   		 screenWidth = Gdx.graphics.getWidth();
	   	  screenHeight = Gdx.graphics.getHeight();
	   	//	public Texture tileTexture;
	/*   	  for(int y =0;y<mapHeight-1;y++){
	   		  for (int x=0;x<mapWidth-1;x++){
	   			 if(map[y][x] == 0) {
					  Entity e = new Entity(game, x, Math.abs(15-y), tileSize, tileSize, 0.0f, lifeTexture);//make that tile an entity
					  //batch.draw(e.texture, e.x* tileSize, e.y* tileSize);
					e.sprite.setSize(50f, 50f);
	   			 int addLife= (int)Math.random()*10;
				 if(addLife>4 & entities.size()>=6){
					 entities.add(e);
					
					 map[y][x]= 3;//make the one you added a heart to a three
				 }
	   		  }
	   		  }
	   	  }*/
	}
	public void render(){//draw map, do not clear as there are other parts of the screen
	//	  Gdx.gl.glClearColor(0, 0, 0, 1);
	//	  Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		  batch.begin();
		    
		  // draw tile map
		  // go over each row bottom to top
		  for(int y = 0; y < mapHeight; y++) {
			  // go over each column left to right		
			  for(int x = 0; x < mapWidth; x++) {
				  // tile
				//  System.out.println(map[0][0]);
				  if(map[y][x] == 1) {
					//  batch.draw(tileTexture, x * tileSize, y * tileSize);
					  Entity e = new Entity(game, x, Math.abs(15-y), tileSize, tileSize, 0.0f, tileTexture);//make that tile an entity
					  batch.draw(e.texture, e.x* tileSize, e.y* tileSize);
					//  if(map[x][y] == 1)
				  }
				  else if(map[y][x] == 0|map[y][x] == 3) {
					  Entity e = new Entity(game, x, Math.abs(15-y), tileSize, tileSize, 0.0f, pathTexture);//make that tile an entity
					  batch.draw(e.texture, e.x* tileSize, e.y* tileSize);
					 
					//  batch.draw(pathTexture, x * tileSize, Math.abs(15-y) * tileSize);//do not place brick in this area
				  } if(map[y][x] == 3){
					  Entity e = new Entity(game, x, Math.abs(15-y), tileSize, tileSize, 0.0f, lifeTexture);//make that tile an entity
					  //e.sprite.setSize(50, 50);
					  batch.draw(e.texture, e.x* tileSize, e.y* tileSize);
					  //batch.draw(e.texture, e.x* tileSize, e.y* tileSize);
					  
				  }
				  else if(map[y][x] == 2) {
					//  batch.draw(winTexture, x * tileSize, y * tileSize);
					  win = new Entity(game, x, Math.abs(15-y), tileSize, tileSize, 0.0f, winTexture);
					  batch.draw(win.texture, win.x* tileSize, win.y* tileSize);
				  }
				  // draw other types here...
			  }
		  }
	    
		  
		  
		 	
		 batch.end();
		//while(){
		// renderBullies();
		  
	}
	public int onMap(int x, int y){
		y=Math.abs(15-y);
		//x=Math.abs(15-x);
		if(x<0)x=0;
		return map[y][x];
	}
	public void life(int x,int y){
		y=Math.abs(15-y);
		map[y][x]=0;//life found no
		game.alive++;
	}
    public ArrayList<String> file(int task){
    	ArrayList<String> output = new ArrayList<String>();
   // 	output.add(".......SCS2003F MAZE RUNNER 1......");
    	FileReader file;
    	try {
			if(task == 1){
			//	name = "board.txt";
			file = new FileReader("board.txt");
			}
			else if(task ==2){
			//	name = "how.txt";
				file = new FileReader("how.txt");
			//	background= new Texture("about.png");
			}
			else {
			System.out.println("Why??");
				file = new FileReader("about.txt");
			//	background= new Texture("about.png");
			}
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()){
				output.add(sc.nextLine()+"\n");
						
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("The file was not found,dont fit");
		}
    	output.add("Enter M to return to Main menu");
    return output;
    	
    }
}
