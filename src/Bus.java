
public class Bus extends Movable{
	private static boolean isVehicle = true;
	private static boolean isDanger = true;
	private static boolean isSolid = true;
	private static float rate = 0.15f;
	private static String imageAddress = "assets/bus.png";
	
	public Bus(float x, float y, boolean moveRight) {
		super(isVehicle, rate, isDanger, isSolid, x, y, imageAddress, moveRight);
	}
}
