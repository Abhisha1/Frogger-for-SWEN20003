
public class Movable extends Sprite{
	private boolean isVehicle;
	private float rate;
	private boolean moveToRight;
	
	public Movable(boolean isVehicle, float rate, boolean isDanger, boolean isSolid, float x, float y, String imageAddress, boolean moveRight) {
		super(imageAddress, x, y, isDanger, isSolid);
		this.isVehicle = isVehicle;
		this.rate = rate;
		this.moveToRight = moveRight;
	}
	
	public void move(int delta) {
		// Obstacle's speed updated
		this.setXLocation(this.getXLocation() + this.rate*delta*moveDirection(this.moveToRight));
		this.getBoundingBox().setX(this.getXLocation());
	}
	
	private int moveDirection(boolean moveRight) {
		if (moveRight) {
			return 1;
		}
		return -1;
	}
	
	public void setXLocation(float x) {
		// Updates the location of obstacle to newly computed value or either end of game container
		super.setXLocation(x);
		if (x > 0 && x <= App.SCREEN_WIDTH) {
			super.setXLocation(x);
		}
		else if (x - this.spritePhoto.getWidth() >= App.SCREEN_WIDTH) {
			super.setXLocation(0.0f);
		}
		
		else if (x  + this.spritePhoto.getWidth() <= 0.0f) {
			super.setXLocation(App.SCREEN_WIDTH);
		}
	}
}
