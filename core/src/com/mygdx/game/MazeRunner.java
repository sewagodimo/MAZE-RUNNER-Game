package com.mygdx.game;

import com.badlogic.gdx.Game;

import screens.MainMenu;
import screens.PlayMode;
import screens.SplashScreen;
import screens.Welcom;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.utils.Array;
import com.sun.istack.internal.logging.Logger;
//import com.sun.java.util.jar.pack.Package.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import entities.Entity;
public class MazeRunner extends Game{
	public MazeRunner(int level){
		alive = 1;
		this.level = level;
		score = 100;
	}
	//Game manages screens
public	SpriteBatch batch;
	Texture img;
	 FileWriter fi;
	//int level;
//	public FileWriter writer= new FileWriter("board.txt") ;
	public int tileSize; 
     //   public int hallSize=5;
         public BitmapFont font;
         public int alive ;
	public static final String VERSION = "CSC2003S-2015 Maze Runner Elite Edition";
	public static final String LOG = "Maze Runner";
	public Music themeSong;
     public  HashMap<Integer,String> famers = new HashMap();
   //     public OrthographicCamera camera;
     // private  Rectangle rect;
      ShapeRenderer shape ;
      Array<Vector2> vect;//a 2d of vectors
      public int level=1,score;
//      private Square sqr;
  // ArrayList lies= this.file(3);
      // public int getHallSize(){
  public void clearHall(){
	
  }
   		
   		public ArrayList<Entity> entities = new ArrayList<Entity>();
   		
   		public enum Axis { X, Y };
   		public enum Direction { U, D, L, R };
      
        @Override
       
	public void create () { 
        font = new BitmapFont();
		
        setScreen(new Welcom(this));
		batch = new SpriteBatch();
                img = new Texture(Gdx.files.internal("life.png"));
      themeSong = Gdx.audio.newMusic(Gdx.files.internal("maze.mp3"));
      themeSong.setLooping(true);
      themeSong.play();
		
	}
        public ArrayList<String> file(int task){
        	ArrayList<String> output = new ArrayList<String>();
        	String info="";
      //Inside of the class Maze I used a textfile but for some reason
        	//FileReader could not load any files
				if(task == 1){
				//	name = "board.txt";
			//	sc= new Scanner((Gdx.files.internal("board.txt")));
					info = "...................MAZE RUNNER HALL OF FAME..................."
							+ "\nEdnecia 0\nNelisile 10\nWandile 20"
							+ "Aphindiwe 30\nNasonkwe 40\nLebo 50Khanyi 20\nOna 30\nKganya 30";
				}
				else if(task ==2){
			info=		"HOW TO PLAY MAZE RUNNER 1\nObjective\nTo collect all of the \nheart points and get to the skull face"
					+ "\nwith minimal interference with the enemies.\nMove around the maze locating \nyourself strategicaly away from the enemies"
					+ "\nHunter starts with a lifepoint of 100\n and it gets reduced every time he gets shot\nWhen his life points reach 0. The game ends,\nregardless of how many life points he has collected"
					+ "\nStoryLine\nHunter is the last human in the city of Rode\nHe wants to make his way to Mars, the New Home\nIn order for him to do that he has to collect enought heart entities\n and then return to Dr "
+ "Swade so that he can build the spaceship\nKillers\nThe killers are aliens from the unknown world\nWe know nothing of them, we do not know who they are\nwhere they are from or what they really can do.";
				//	name = "how.txt";
				//	sc =new Scanner( new FileReader("how.txt"));
				//	background= new Texture("about.png");
				}
				else {
			//	System.out.println("Why??");
				info =".....CSC2003S MAZE RUNNER 2015......\nDeveloper: Ednecia Sewagodimo Matlapeng\n			MTLEDN001\n09-2015"
						+ "\nAlmost all the info on the game\n"
	+ "\nFeatures:\n...........A welcome page................\n...........A menu screen............\n(Settings, about game, how to play, new game)\n................Settings........\n- Allows the user to alter gaming "
	+ "conditions\nthey can turn the sound on or off\nthey can restart a game\nthey can change the level\nthey can clear up the hall of fame\nand other things."
	+ "\n.............Enemies.................."
	+ "\n******Bullies******\nMove around systemitically"
	+ "\nLethal and will cost you 10 lifepoints"
	+ "\nAfter colliding with the player they will try to chase them but "
	+ "\nthey are blind so they give up easily"
	+ "\n********Dragon********"
	+ "\nBreathes fire as it changes direction"
	+ "\nBreaths fire into maze from top"
	+ "\nFire cools down, only 3 points lost"
	+ "\n*****Lava Fly*******\nIts basically poos green lava\nHas a random reaction period\nShoots out 3 lava poos at once"
	+ "\nIn exploding directions\n...........Multiple Stages..........\n************Level 1:************\n1 enemy appears, the bullies"
	+ "\n*********8Level 2:**********\nThe dragon enters the scenery"
	+ "\nplayer now has to watch out for the fire and bull collisions"
	+ "\n************Level 3:**********\nThe Lava Fly appears\n.......Sound.........\nA remix of On another love by Tom Odell."
	+ "\n...........HALL OF FAME..........\nA list of the best scoring players and their \nscores, and the levels they reached that score\n...........Scoring........................"
	+ "\nIn order to win the player has to reach the skull\nHaving collected all the items on the board\nWith a high score as possible.";
				//	background= new Texture("about.png");
				}
			Scanner sc = new Scanner(info).useDelimiter("\n");
				while(sc.hasNextLine()){
					output.add(sc.nextLine()+"\n");
							
				}
			sc.close();
        	output.add("Enter M to return to Main menu");
        return output;
        	
       // }
       
}}