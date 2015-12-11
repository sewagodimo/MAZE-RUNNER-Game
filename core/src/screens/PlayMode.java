package screens;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.MazeRunner;

import entities.Entity;
import entities.Maze;
import entities.Player;

public class PlayMode implements Screen{
	MazeRunner game ;//= new MazeRunner();
	Player player ;
	SpriteBatch batch ;
	Maze maze;
	String name="PLayer1";
	BitmapFont font = new BitmapFont();
//}
	Texture bullyU = new Texture("bullydown.png");
	Texture bully = new Texture("bully.png");
	Texture dragon = new Texture("dragon.png");
	Texture bullet = new Texture("fire.png");
	Texture spiture = new Texture("spit.png");
	Texture flyture = new Texture("fly.png");
//Sprite	spriteU3 = new Sprite(bullyU);
//	bully u 1 3
	int tileSize = 50;
	Entity bullyU3 = new Entity(game, 3*tileSize, 13*tileSize, bullyU.getWidth(), bullyU.getHeight(), 1.0f, bullyU);
Entity bullyU1 = new Entity(game, 15*tileSize, 8*tileSize, bullyU.getWidth(), bullyU.getHeight(), 1.0f, bullyU);
Entity bully2 = new Entity(game, 10*tileSize, 4*tileSize, bully.getWidth(), bully.getHeight(), 1.0f, bully);
Entity dragon1 = new Entity(game, 20, 9*tileSize, dragon.getWidth(), dragon.getHeight(), 1.0f, dragon);
Entity fire = new Entity(game, 1*tileSize, 10*tileSize, bullet.getWidth(), bullet.getHeight(), 1.0f, bullet);
Entity fire2 = new Entity(game, 1*tileSize, 11*tileSize, bullet.getWidth(), bullet.getHeight(), 1.0f, bullet);
Entity fly = new Entity(game, 12*tileSize, 10*tileSize, flyture.getWidth(), flyture.getHeight(), 1.0f, flyture);
Entity spit1 = new Entity(game, 10*tileSize, 9*tileSize, spiture.getWidth(), spiture.getHeight(), 1.0f, spiture);
Entity spit2 = new Entity(game, 10*tileSize, 9*tileSize, spiture.getWidth(), spiture.getHeight(), 1.0f, spiture);
Entity spit3 = new Entity(game, 10*tileSize, 9*tileSize, spiture.getWidth(), spiture.getHeight(), 1.0f, spiture);
int move = 1;
int scoreX=1000;	
int score =10000;
int alive = 0;
ArrayList< Entity> enemies = new ArrayList<Entity>();
	public PlayMode(MazeRunner game){
		this.game = game;
		maze = new Maze(game);
		player= new Player(game, 1*50, 13*tileSize, 35, 50, 120.0f, new Texture("hunter.png"),maze);
		batch = new SpriteBatch();
		//game.alive=1;
		score = 100;
		int scoreX=1000;	
		alive =0;
	if(game.level ==1){
		move =1;
	}
		//level 2
		dragon1.sprite.setFlip(true, false);
		fire.sprite.setFlip(true, false);
		fire2.sprite.setFlip(true, false);
	//	fire2.sprite.setRotation((float)90);
		//level 3
		spit3.sprite.setFlip(true,false);
		spit2.sprite.rotate(45f);
	}
	public void show() {
		// TODO Auto-generated method stub
		
	}
	public int moveEnemies = 0;
	public int tripleSpit = 5;
	@Override
	
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//splashSprite.draw(batch);//need to begin before drawing
		//batch.begin();
		font.draw(batch,name+" in Maze",20*20,5*50);
		 delta = Gdx.graphics.getDeltaTime();
                       batch.enableBlending();//s
                       maze.render();         
                       Gdx.input.getInputProcessor();
                      batch.end();
                       if(moveEnemies==59){//going up
                    	   
                    	   moveEnemies =-1;    
                    	   tripleSpit+=5;
                    		bullyU3.sprite.setFlip(false, true);
            				bullyU1.sprite.setFlip(false, true);
            				bully2.sprite.setFlip(true, false);
            				if(game.level>1){//controlling the levels #Bars
            				 fire2 = new Entity(game, dragon1.x+30, dragon1.y+25, bullet.getWidth(), bullet.getHeight(), 1000.0f, bullet);
                      	   fire.sprite.setPosition(fire.x,fire.y);
            				dragon1.sprite.setFlip(true, false);
            				fire2.sprite.setFlip(true, false);
            				}
            				if(game.level>2){
            				//level 3 do as done to fire2
            				 spit1 = new Entity(game, fly.x+87, fly.y+9, spiture.getWidth(), spiture.getHeight(), 1000.0f, spiture);
            				 spit2 = new Entity(game, fly.x+87, fly.y+9, spiture.getWidth(), spiture.getHeight(), 1000.0f, spiture);
            				 spit3 = new Entity(game, fly.x+87, fly.y+9, spiture.getWidth(), spiture.getHeight(), 1000.0f, spiture);
            				 spit3.sprite.setFlip(true,false);
            					spit2.sprite.rotate(45f);
            					}
                       }
                       if(moveEnemies==-60){
                    	   moveEnemies =0;//going down
                    	   
                        	   bullyU3 = new Entity(game, 3*tileSize, 13*tileSize, bullyU.getWidth(), bullyU.getHeight(), 1.0f, bullyU);
                        	   bullyU1 = new Entity(game, 15*tileSize, 8*tileSize, bullyU.getWidth(), bullyU.getHeight(), 1.0f, bullyU);
                        	   bully2 = new Entity(game, 10*tileSize, 4*tileSize, bully.getWidth(), bully.getHeight(), 1.0f, bully);
                          // }
                    	  tripleSpit+=5;
            				bullyU1.sprite.setFlip(false, false);
            				bully2.sprite.setFlip(false, false);
            				//level 2
            				if(game.level>1){
            				 fire = new Entity(game, dragon1.x+32, dragon1.y+25, bullet.getWidth(), bullet.getHeight(), 1000.0f, bullet);
                      	   fire2.sprite.setPosition(fire2.x,fire2.y);}
                 			//dragon1.sprite.draw(batch);
                      		bullyU3.sprite.setFlip(false, false);
              			//	dragon1.sprite.setFlip(true, true);
                      		fire.sprite.setFlip(true, false);
                      		//level 3 do as fire2
                      		if(game.level>2){
                      		spit2.sprite.setPosition(spit2.x,spit2.y);
                     		spit3.sprite.setPosition(spit3.x,spit3.y);
                     		spit1.sprite.setPosition(spit1.x,spit1.y);}
                       }
                       if (moveEnemies>=0){
                    	  
                       renderBullies();
                       moveEnemies++;
                       tripleSpit +=5;
                       //level 2
                       if(game.level>1){
                       fire.move(fire.x+25,fire.y-15);
                       if(player.entityCollision(fire,fire.x, fire.y)){
           				score--;
                       }
           			//	fire.sprite.setSize(1f, 1f);//make it disappear
                       }
                       }
                       else if(moveEnemies<0){
                    	   
                    	   returnBullies();
                           moveEnemies--;
                           //level 2
                           fire2.move(fire2.x+25,fire2.y-15);
                           if(player.entityCollision(fire2,fire2.x, fire2.y)){
                  				score-=3;//lose three points for the fire
                  				fire2.sprite.setSize(1f, 1f);//make it disappear
                       }
                           //level 3
                          
                           spit2.move(spit2.x-25,spit2.y-15);//moddle spit
                           if(player.entityCollision(spit2,spit2.x, spit2.y)){
                  				score-=3;
                  			spit2.sprite.setSize(1f, 1f);//make it disappear
                       }
                           spit1.move(spit1.x,spit1.y-15);//left spit
                           if(player.entityCollision(spit1,spit1.x, spit1.y)){
                  				score-=3;
                  				spit1.sprite.setSize(1f, 1f);//make it disappear
                       }
                           spit3.move(spit3.x+25,spit3.y-15);//right spit
                           if(player.entityCollision(spit3,spit3.x, spit3.y)){
                  				score-=3;
                  				spit3.sprite.setSize(1f, 1f);//make it disappear
                       }
                       }
                       
                       //daw the entities/life
                       
//	batch.begin();
	
	//player.update(delta);
//	batch.end();
                       playerCollision();
	batch.begin();
	player.sprite.draw(batch);
	font.setColor(Color.GOLD);
	font.draw(batch,name+" in Maze",1000,700);
	font.draw(batch," Score: "+scoreX,1000,650);
	font.draw(batch," Lives Collected: "+alive,950,600);
	font.draw(batch,"The hunter can move anywhere in path\n"
			+ "Becareful not to run into enemies"
			+"\nPress Q to exit",950,450);
	font.draw(batch," Press M or Enter to exit: ",950,400);
	batch.end();
                           Gdx.input.getInputProcessor();
                           int trick=5;
                           if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                        	   player.sprite.setFlip(false, false);
                        	   if(maze.onMap((int)player.x/50,(int)player.y/50)==0
                        			   |maze.onMap((int)player.x/50,(int)player.y/50)==3){
                        		   if(player.x/50>0)//else you are already at the edge
                            	   player.move(player.x-trick,player.y);//check if it is allowed to move first
                        		   if(  maze.onMap((int)(player.x)/50,(int)(player.y+trick)/50)==3){
                             		  maze.life((int)player.x/50, (int)player.y/50);
                             		 alive++;
                             	   }
                                  // tetris.rightClick();
                           }
                            		//System.out.println("cannot movesideways game ");
                            	   }
                               
                           else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                        	   player.sprite.setFlip(true, false);
                        	   if(maze.onMap((int)(player.x+player.texture.getWidth()+trick)/50,(int)player.y/50)==0
                        			   |maze.onMap((int)(player.x+player.texture.getWidth()+trick)/50,(int)player.y/50)==3){
                        		   if(player.x/50<19)
                        	   player.move(player.x+trick,player.y);//check if it is allowed to move first
                        		   if(  maze.onMap((int)(player.x)/50,(int)(player.y+trick)/50)==3){
                             		  maze.life((int)player.x/50, (int)player.y/50); 
                             		  alive++;
                             	   }
                              // tetris.rightClick();
                        	//	System.out.println("cannot movesideways game ");
                        	   }   }
                           else if (Gdx.input.isKeyPressed(Input.Keys.UP)){
                        //	   player.sprite.setFlip(true, false);
                        	   //if;
                         if(maze.onMap((int)(player.x)/50,(int)(player.y+player.texture.getHeight()+trick)/50)==0
                        	|	 maze.onMap((int)(player.x)/50,(int)(player.y+player.texture.getHeight()+trick)/50)==3)
                        	   player.move(player.x,player.y+trick);
                         if(  maze.onMap((int)(player.x)/50,(int)(player.y+trick)/50)==3){
                   		  maze.life((int)player.x/50, (int)player.y/50); 
                   		 alive++;
                   	   }
                         }
                           else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
                        	//   player.sprite.setFlip(true, false);
                        	   if(maze.onMap((int)(player.x)/50,(int)(player.y-trick)/50)==0
                        		|	   maze.onMap((int)(player.x)/50,(int)(player.y-trick)/50)==3 ){
                        		 
                        		   if(player.y/50>0)
                        		   player.move(player.x,player.y-trick);
                        	   if(  maze.onMap((int)(player.x)/50,(int)(player.y+trick)/50)==3){
                        		  maze.life((int)player.x/50, (int)player.y/50); 
                        		  alive++;
                        	   }
                        	   }
                           }
                            else if (Gdx.input.isKeyPressed(Input.Keys.Q)){
                                game = new MazeRunner(1);
								maze = new Maze(game);	
                                }
                           else    if (Gdx.input.isKeyPressed(Input.Keys.ENTER)|Gdx.input.isKeyPressed(Input.Keys.M)){
                               //     Gdx.graphics.
                                  game.setScreen(new MainMenu(game));
                                  }
								//	@Override
                           
                                
							if(game.score<0){	
								//game over
								game = new MazeRunner(1);//start again
								game.setScreen(new MainMenu(game));
							}
						    if(  maze.onMap((int)(player.x+trick)/50,(int)(player.y+trick)/50)==2
						    		& game.alive>=6){
						    	//you have won
						    	name = JOptionPane.showInputDialog("Enter your name Hunter");
						    	try {
									FileWriter writer = new FileWriter("board.txt", true);//appends file
									writer.append(name+" "+score+" at level "+game.level);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						    }
                           
                       //}
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
	int step = tileSize/10;
	public long time;
	
	public void renderBullies(){
		/// bu 15x13
		//to move the bullies
			//batch.begin();
	//	for(int i=0;i<10;i++){//bullyU3 3-14
		//	 bullyU3.sprite.draw(batch);	
		//	  bullyU1.sprite.draw(batch);	
		//	  bully2.sprite.draw(batch);
			batch.begin();
			time = TimeUtils.nanoTime();
			
			bullyU3.y=bullyU3.y-step;//slow mover
			bullyU3.sprite.setPosition(bullyU3.x, bullyU3.y);
			bullyU3.sprite.draw(batch);
			//  batch.draw(bullyU3.texture, bullyU3.x, bullyU3.y);
		//batch.end();	
			if(player.entityCollision(bullyU3, bullyU3.x, bullyU3.y)){//collision check
			score-=10;//batch.end(); //return;
			}
			
			bullyU1.y=bullyU1.y-step;//slow mover
			bullyU1.sprite.setPosition(bullyU1.x, bullyU1.y);
			bullyU1.sprite.draw(batch);
		//batch.end();	
			if(player.entityCollision(bullyU1, bullyU1.x, bullyU1.y)){
				score-=10;//batch.end(); //return;
			}
			//bully2
			bully2.x=bully2.x+step;//slow mover
			bully2.sprite.setPosition(bully2.x+step, bully2.y);
			bully2.sprite.draw(batch);
			
			if(player.entityCollision(bully2, bully2.x, bully2.y)){
			score-=10;//batch.end(); //return;
			}
			//level 2
			if(game.level>1){
			dragon1.y=dragon1.y-step;//slow mover
			dragon1.sprite.setPosition(dragon1.x, dragon1.y);
			dragon1.sprite.draw(batch);
			fire.sprite.draw(batch);
			//level 3
			}
			if(game.level>1){
			fly.sprite.draw(batch);}
			//bullyU1
		while(TimeUtils.nanoTime()-time<10000000f){}//basically pause
		batch.end();
		//}//end of round1
//		batch.dispose();
//		batch.end();
	
		//after flipping return to original position
		
	
		}
		//batch.dispose();
		public void returnBullies(){
		//	for(int i=0;i<10;i++){//bullyU3 3-14
				batch.begin();
				time=TimeUtils.nanoTime();
				//int step = tileSize/5;
				bullyU3.y=bullyU3.y+step;//slow mover
				bullyU3.sprite.setPosition(bullyU3.x, bullyU3.y+step);
				bullyU3.sprite.draw(batch);	
				if(player.entityCollision(bullyU3, bullyU3.x, bullyU3.y)){//collision check
				score-=10;//batch.end(); //return;
				}
				//bullyU1
				bullyU1.y=bullyU1.y+step;//slow mover
				bullyU1.sprite.setPosition(bullyU1.x, bullyU1.y+step);
				bullyU1.sprite.draw(batch);
				 
				if(player.entityCollision(bullyU1, bullyU1.x, bullyU1.y)){
			score-=10;//batch.end();// return;
				}
				//bully2
			//	System.out.println("did you move? "+bully2.x+tileSize);
				bully2.x=bully2.x-step;//slow mover
				bully2.sprite.setPosition(bully2.x-step, bully2.y);
				bully2.sprite.draw(batch);
				if(player.entityCollision(bully2, bully2.x, bully2.y)){
				score-=10; //batch.end();//return;
				}
				//level 2
				if(game.level>1){
				fire2.sprite.draw(batch);
				dragon1.y=dragon1.y+step;//slow mover
				dragon1.sprite.setPosition(dragon1.x, dragon1.y);
				dragon1.sprite.draw(batch);
				}
				//level 3
				if(game.level>2){
				fly.sprite.draw(batch);
				spit1.sprite.draw(batch);
				spit2.sprite.draw(batch);
				spit3.sprite.draw(batch);
				}
				batch.end();
			
				while(TimeUtils.nanoTime()-time<10000000f){}//basically pause
				

		}
	
		public synchronized void playerCollision(){
			//check who shoots at the enemy
			//how to make them stop after colliding
			if(player.entityCollision(bully2, player.x, player.y)){
				scoreX-=10;
				bully2.move(bully2.x-step, bully2.y-step);
			}
			else if(player.entityCollision(bullyU3, player.x, player.y)){
				scoreX-=10;
				bullyU3.move(bullyU3.x-step, bullyU3.y-step);
			}
			else if(player.entityCollision(bullyU1, player.x, player.y)){
				scoreX-=10;
				bullyU1.move(bullyU1.x-step, bullyU1.y-step);
			}
			if(game.level>2){
				if(player.entityCollision(spit1, player.x, player.y)){
					scoreX-=5;
				}
				else if(player.entityCollision(spit2, player.x, player.y)){
					score-=5;
				}
				else if(player.entityCollision(spit3, player.x, player.y)){
					score-=5;
				}
			}
			if(game.level>1){//level two or three
				if(player.entityCollision(fire, player.x, player.y)){
					scoreX-=3;
				}
				else if(player.entityCollision(fire2, player.x, player.y)){
					score-=3;
				}
			}
			
		}

}//