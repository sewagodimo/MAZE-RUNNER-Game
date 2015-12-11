package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.MazeRunner;

public class MainMenu implements Screen{
	MazeRunner game;
	Texture background;// = new Texture("mainmenu.png");
	SpriteBatch batch;// = new SpriteBatch();
	Texture setture = new Texture("settingsmenu.png");
	Texture hallture = new Texture("hallmenu.png");
	Texture abouture = new Texture("aboutgame.png");
	Texture howture = new Texture("howtoplay.png");
	Texture play = new Texture("win.png");
	Stage stage ;
	Table table;
	Skin skin ;
	TextureRegion setButtonR = new TextureRegion(setture)
			,hallButtonR= new TextureRegion(hallture),
			howButtonR= new TextureRegion(howture),
			aboutButtonR= new TextureRegion(abouture),
			playButtonR = new TextureRegion(play);
	ImageButtonStyle  setButtonS,hallButtonS,howButtonS,aboutButtonS,playButtonS;
	ImageButton  setButton,hallButton,howButton,aboutButton, playButton;
BitmapFont font;
public MainMenu(MazeRunner game){
	this.game = game;
	batch = new SpriteBatch();
	background = new Texture("welcome.jpg");
	font = new BitmapFont();
	setButtonR = new TextureRegion(setture);
			hallButtonR= new TextureRegion(hallture);
			howButtonR= new TextureRegion(howture);
			aboutButtonR= new TextureRegion(abouture);
			playButtonR= new TextureRegion(play);
}
@Override
public void show() {
	// TODO Auto-generated method stub
/*	skin = new Skin();
	skin.add("MAZE RUNNER 1",new Texture("dragon.png"));
	skin.add("Settings", setture);
	skin.add("How", howture);
	skin.add("About", abouture);
	skin.add("Hall", hallture);*/
	setButtonS = new ImageButtonStyle(new TextureRegionDrawable(setButtonR), new TextureRegionDrawable(setButtonR)
			, new TextureRegionDrawable(setButtonR), new TextureRegionDrawable(setButtonR), new TextureRegionDrawable(setButtonR), new TextureRegionDrawable(setButtonR));
	hallButtonS=new ImageButtonStyle(new TextureRegionDrawable(hallButtonR),new TextureRegionDrawable(hallButtonR)
			,new TextureRegionDrawable(hallButtonR),new TextureRegionDrawable(hallButtonR),new TextureRegionDrawable(hallButtonR),new TextureRegionDrawable(hallButtonR));
	howButtonS=new ImageButtonStyle(new TextureRegionDrawable(howButtonR),new TextureRegionDrawable(howButtonR)
			,new TextureRegionDrawable(howButtonR),new TextureRegionDrawable(howButtonR),new TextureRegionDrawable(howButtonR),new TextureRegionDrawable(howButtonR));
;
	aboutButtonS=new ImageButtonStyle(new TextureRegionDrawable(aboutButtonR),new TextureRegionDrawable(aboutButtonR)
			,new TextureRegionDrawable(aboutButtonR),new TextureRegionDrawable(aboutButtonR),new TextureRegionDrawable(aboutButtonR),new TextureRegionDrawable(aboutButtonR));
;
playButtonS=new ImageButtonStyle(new TextureRegionDrawable(playButtonR),new TextureRegionDrawable(playButtonR)
		,new TextureRegionDrawable(playButtonR),new TextureRegionDrawable(playButtonR),new TextureRegionDrawable(playButtonR),new TextureRegionDrawable(playButtonR));
;
setButton=new ImageButton( setButtonS);
setButton.addListener(new ClickListener(){
	public void clicked(InputEvent event, float x, float y){
		game.setScreen(new Settings(game));}
	});


hallButton=new ImageButton( hallButtonS);
hallButton.addListener(new ClickListener(){
	public void clicked(InputEvent event, float x, float y){
		game.setScreen(new HallFame(game,1));}
	});
howButton=new ImageButton( howButtonS);
howButton.addListener(new ClickListener(){
	public void clicked(InputEvent event, float x, float y){
		game.setScreen(new HallFame(game,2));
		dispose();}
	});
aboutButton=new ImageButton( aboutButtonS);
aboutButton.addListener(new ClickListener(){
	public void clicked(InputEvent event, float x, float y){
		game.setScreen(new HallFame(game,3));}
	});
playButton=new ImageButton( playButtonS);
playButton.addListener(new ClickListener(){
	public void clicked(InputEvent event, float x, float y){
		//game = new MazeRunner();
		game.setScreen(new PlayMode(game));
		
		}
	});
//adding listeners dones
//add to table
int x = Gdx.graphics.getWidth()/2;
int y= Gdx.graphics.getHeight()/6;
table = new Table();
stage = new Stage();
table.add(setButton).size(x,y).align(y).padBottom(10).row();
table.add(aboutButton).size(x,y).align(y).padBottom(10).row();
table.add(howButton).size(x,y).align(y).padBottom(10).row();
table.add(playButton).size(x,y).align(y).padBottom(10).row();
table.add(hallButton).size(x,y).align(y).padBottom(10).row();
table.setFillParent(true);
stage.addActor(table);
	
}
@Override
public void render(float delta) {
	// TODO Auto-generated method stub
	Gdx.gl.glClearColor(0, 0, 0, 0.2f);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	
	batch.begin();
	//stage.draw();
	batch.draw(background,100,0);
	game.font.draw(batch, "MAIN MENU", 600, 700);
	//stage.
	stage.draw();
	batch.end();
	Gdx.input.setInputProcessor(stage);
	//if(stage.dispose();)
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
