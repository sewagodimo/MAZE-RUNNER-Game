package entities;
import com.mygdx.game.MazeRunner.Direction;
import com.mygdx.game.MazeRunner;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
//import missiontoMarsGame.MissiontoMarsGame.Direction;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class Entity {
	public MazeRunner game;
	public float x;
	public float y;
	public float dx;
	public float dy;
	public int width;
	public int height;  
	public Sprite sprite;
	public float speed;
	public Texture texture;
	
	public Entity(MazeRunner game, float x, float y, int width, int height, float speed, Texture texture) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.texture = texture;
		sprite = new Sprite(texture);
		sprite.setPosition(x, y);
	}

	public void update(float delta) {

	}
	
	public void move(float newX, float newY) {
		x = newX;
		y = newY;	
		sprite.setPosition(newX, newY);
	}
	
	public void render() {
		
	}

	public void tileCollision(int tile, int tileX, int tileY, float newX, float newY, Direction direction) {
		System.out.println("tile collision at: " + tileX + " " + tileY);
		
		if(direction == Direction.U) {
			y = tileY * game.tileSize + game.tileSize;
		}
		else if(direction == Direction.D) {
			y = tileY * game.tileSize - height;
		}
		else if(direction == Direction.L) {
			x = tileX * game.tileSize + game.tileSize;
		}
		else if(direction == Direction.R) {
			x = tileX * game.tileSize - width;
		}	//checks the tiles that collide	
	}

	public boolean entityCollision(Entity e2, float newX, float newY) {
		Rectangle rect1=	this.sprite.getBoundingRectangle();
		Rectangle rect2=	e2.sprite.getBoundingRectangle();
		Rectangle intersect= new Rectangle();
		if(Intersector.intersectRectangles(rect1, rect2, intersect)==true){
			System.out.println("Collosion with player");
			return true;
		}
			//1 improvement
		else if (Intersector.intersectRectangles(rect1, rect2, intersect)==false) return false;
		//you will never really ge here but you never know
	//	move(newX, newY);
		boolean collide = true;//assume two entities collide
		//create a new block that is the overlap of block one and two
		int xmin = (int)Math.max(this.x, e2.x);
		int ymin = (int)Math.max(this.y,e2.y);
		int ymax = (int)Math.min(this.y+height,(e2.y+e2.height));
		int xmax = (int)Math.min(this.x+width,(e2.x+e2.width));
		//possible collision box
	
		//check if there is a collision
		if(xmax<xmin||ymax<ymin){
			System.out.println("No collision at this point");
			return true ;//they do not collide
		// could also resolve entity collisions in the same we do tile collision resolution
		// as shown in class
	}
		//System.out.println("entity collision around: " + newX + " " + newY);
		return false;
		}
	public void flip(boolean t) {
        sprite.setFlip(t, true);//so we can flip a sprite
        // This does not work for pixel perfect collision
        // Would need to generate a mask for flipped sprite
        // Final game will not use pixel perfect collision
    }
}
