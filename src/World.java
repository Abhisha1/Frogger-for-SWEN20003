//This program was written by Abhisha Nirmalathas for SWEN20003 Project 1
import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import utilities.BoundingBox;

import org.newdawn.slick.Image;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class World {
	public static final int TILE_SIZE = 48;
	private Sprite sprite;
	private Player player;
	private Level level1;
	
	private ArrayList<String[]> levelData;
	ArrayList<Sprite> dangerSprites = new ArrayList<Sprite>();
	
	private BoundingBox playerBox;
	
	
	public World() {
		readCSV("assets/levels/0.lvl");
		buildPlayer();
		level1 = new Level(levelData, player);
	}
	
	private void readCSV(String fileAddress) {
		
		try (BufferedReader br =
	            new BufferedReader(new FileReader(fileAddress))) {
				String text;
				
				levelData = new ArrayList<String[]>();
	            while ((text = br.readLine()) != null) {
	            	String[] textArr = text.split(",");
	            	levelData.add(textArr);
	                
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
	
	
	private void buildPlayer() {
		//Builds a frog player onto game
		player = new Player("assets/frog.png", 512, 720);
		player.createBoundingBox(player);
		playerBox = player.getBoundingBox();
	}
	
	public void update(Input input, int delta) {
		// Update all of the sprites in the game
		player.update(input, delta, player);
		
	}

	public boolean isCollision() {
		//Checks if the player has hit a sprite that causes the game to exit (bus or water)
		for (Sprite a:dangerSprites) {
			if (a.hasBoundingBox(a.getBoundingBox())) {
				
				if (playerBox.intersects(a.getBoundingBox())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void render(Graphics g) {
		// Draw all of the sprites in the game
		level1.render(g);
		
	
	}
}
