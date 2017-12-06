package validation;

import java.util.List;

/**
 * FrameValidation
 * 
 * the following class provides all the methods to verify the type that is
 * bowled as well as the associated bonus scores.
 * 
 * 
 * Validation         Bonus Generation
 * ===========        =================
 * validateStrike     bonusForStrike
 * validateSpare      bonusForSpare
 * 
 * @author joel kass
 * 
 * 
 * 
 *
 */

public class FrameValidation implements FrameValidationInt {

	public enum BonusTypes {

		STRIKE(2), SPARE(1), NONE(0);

		private final int levelCode;

		BonusTypes(int levelCode) {
			this.levelCode = levelCode;
		}

		public int getLevelCode() {
			return this.levelCode;
		}

	}

	/**
	 * validateStrike
	 * 
	 * When all ten pins are knocked down with the first ball (called a strike and typically rendered 
	 * as an "X" on a scoresheet), a player is awarded ten pins, plus a bonus of whatever 
	 * is scored with the next two balls. In this way, the pinfall scored for the two balls 
	 * after the strike are counted twice
	 * 
	 * validates if a strike has occurred by computing the current framevalue that
	 * is equal to 10.
	 * 
	 * @param frameValue
	 * @return
	 */

	public static boolean validateStrike(int frameValue, List<Integer> totalThrows) {

		boolean result = totalThrows.get(frameValue) == 10;

		return result;
	}

	/**
	 * validateSpare
	 * 
	 * A "spare" is awarded when no pins are left standing after the second ball of a frame; 
	 * i.e., a player uses both balls of a frame to clear all ten pins. A player achieving 
	 * a spare is awarded ten pins, plus a bonus of whatever is scored with the next ball 
	 * (only the first ball is counted). It is typically rendered as a slash on scoresheets 
	 * in place of the second pin count for a frame.
	 * 
	 * validates if a spare has occurred by computing the current frame and the
	 * frameValue+1 that should be equal to ten.
	 * 

	 * 
	 * @param frameValue
	 * @return
	 */

	public static boolean validateSpare(int frameValue, List<Integer> totalThrows) {

		// handle cases where one of the frames is a 10 and the other is a zero and should return false.

		if (((totalThrows.get(frameValue) == 10 || totalThrows.get(frameValue + 1) == 10))
				&& ((totalThrows.get(frameValue) == 10 || totalThrows.get(frameValue + 1) == 10))) {

			return false;
		}

		else {

			boolean result = totalThrows.get(frameValue) + totalThrows.get(frameValue + 1) == 10;
			return result;
		}
	}

	/**
	 * bonusForStrike
	 * 
	 * provides the bonus for a strike
	 * 
	 * Algorithm
	 * 
	 * 1. obtain the total for the current frame +1
	 * 2. obtain the total for the current frame +2
	 * 3. return the result
	 * 
	 * @param frameValue
	 * @return
	 */

	public static int bonusForStrike(int frameValue, List<Integer> totalThrows) {

		int result = totalThrows.get(frameValue + 1) + totalThrows.get(frameValue + 2);
		return result;
	}

	/**
	 * bonusForSpare
	 * 
	 * provides a bonus for a spare by taking the totalThrows of the framevalue +2.
	 * 
	 * @param frameValue
	 * @return
	 */

	public static int bonusForSpare(int frameValue, List<Integer> totalThrows) {

		int result = totalThrows.get(frameValue + 2);

		return result;
	}

	/**
	 * totalThrows
	 * 
	 * the total throws of the frame value and frame value+1
	 * 
	 * @param frameValue
	 * @return
	 */
	public static int totalThrows(int frameValue, List<Integer> totalThrows) {

		int result = totalThrows.get(frameValue) + totalThrows.get(frameValue + 1);

		return result;
	}

}
