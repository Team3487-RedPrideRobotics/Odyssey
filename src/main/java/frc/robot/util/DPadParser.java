package frc.robot.util;

public class DPadParser {
	public DPadParser() {
	
	}
	
	/**
	 * Takes a POV angle and returns a list giving the values in the verticle and horizontal "axes"
	 *
	 * @param angle the POV angle to parse
	 * @return a list where the first value represents the horizontal value and the second value represents the verticle value (0 for no input, 1 for positive, -1 for negative)
	 */
	public static int[] Parse(int angle) {
		switch (angle) {
			case 0:
				return new int[] {0, 1};
			case 45:
				return new int[] {1, 1};
			case 90:
				return new int[] {1, 0};
			case 135:
				return new int[] {1, -1};
			case 180:
				return new int[] {0, -1};
			case 225:
				return new int[] {-1, -1};
			case 270:
				return new int[] {-1, 0};
			case 315:
				return new int[] {-1, 1};
			default:
				return new int[] {0, 0};
		}
	}
}
