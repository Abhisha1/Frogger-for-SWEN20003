//This program was written by Abhisha Nirmalathas for SWEN20003 Project 1
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Player extends Sprite {
	public Player(String imageSrc, float x, float y){
		super(imageSrc, x, y);
		
	}
	
	public void update(Input input, int delta, Player player) {
		// Updates the location of the player, moving one tile in the selected direction
		// whilst ensuring the update location is not outside the game container
		if (input.isKeyPressed(Input.KEY_UP) && ((this.getYLocation() - App.TILE_SIZE) >= 0 )) {
			this.setYLocation(this.getYLocation() - App.TILE_SIZE);
			player.getBoundingBox().setY(this.getYLocation());
		}
		
		else if (input.isKeyPressed(Input.KEY_DOWN) && ((this.getYLocation() + App.TILE_SIZE) < App.SCREEN_HEIGHT )) {
			this.setYLocation(this.getYLocation() + App.TILE_SIZE);
			player.getBoundingBox().setY(this.getYLocation());
		}
		
		else if (input.isKeyPressed(Input.KEY_LEFT) && ((this.getXLocation() - App.TILE_SIZE) >= 0 )) {
			this.setXLocation(this.getXLocation() - App.TILE_SIZE);
			player.getBoundingBox().setX(this.getXLocation());
		}
		
		else if (input.isKeyPressed(Input.KEY_RIGHT) && ((this.getXLocation() + App.TILE_SIZE) < App.SCREEN_WIDTH )) {
			this.setXLocation(this.getXLocation() + App.TILE_SIZE);
			player.getBoundingBox().setX(this.getXLocation());
		}
	}

}
