/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MazeRunner;

/**
 *
 * @author Sewagodimo
 */
public class Enemy_Bully  extends Entity {
     int bullyX, bullyY, bullyDirection;//position of bully
    public Enemy_Bully(MazeRunner game, float x, float y, int width,int height,float speed,Texture texture) {
    	super(game, x, y, width, height, speed, texture);
     //   super(game, bullyX, bullyDirection, bullyY, bullyX, bullyDirection, texture)//there is only one type of bully
        bullyX =300;
        bullyY=300;
        bullyDirection = 1;
}
    public void bullyDown(){
      //  super("bullydown.png");
    }
   
    public void horizMove(){
        //the left snd right movement of the bully
        for(int i =0;i<4;i++){
            //move four times to the left and then four times back
      //      super.sprite;
        }
        {
            
        }
    }
}