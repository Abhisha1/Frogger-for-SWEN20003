import java.util.ArrayList;
import java.util.Arrays;

import org.newdawn.slick.Graphics;

public class Level {
	public static final int INITIAL_LIVES = 3;
	private boolean isComplete = false;
	
	private Tile tile;
	
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	
	private Player player;
	
	public Level(ArrayList<String[]> levelInstructions, Player player) {
		this.player = player;
		
		for (String[] a: levelInstructions) {
			//System.out.println(Arrays.toString(a));
			if (isTile(a[0])){
				tile = createTile(a);
				sprites.add(tile);
			}
		}
		sprites.add(player);
	}
	private boolean isLevelComplete(Player player) {
		return false;
	}
	public void render(Graphics g) {
		// Draw all of the sprites in the game
		for (Sprite a:sprites) {
			a.render();
		}
	}
	public boolean isTile(String spriteName) {
		if (spriteName.equals("water") || spriteName.equals("tree") || spriteName.equals("grass")) {
			return true;
		}
		return false;
	}
	public Tile createTile(String[] objectInstructions) {
		float xPos = Float.parseFloat(objectInstructions[1]);
		float yPos = Float.parseFloat(objectInstructions[2]);
		if (objectInstructions[0].equals("water")) {
			return Tile.createWaterTile(xPos, yPos);
		}
		if (objectInstructions[0].equals("grass")) {
			return Tile.createGrassTile(xPos, yPos);
		}
		else {
			return Tile.createTreeTile(xPos, yPos);
		}
	}
	
}
