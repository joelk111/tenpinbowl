package validation;

import java.util.List;

/**
 * FrameValidationInt
 * 
 * Interface for FrameValidations
 * 
 *  Validation         Bonus Generation
 * ===========        =================
 * validateStrike     bonusForStrike
 * validateSpare      bonusForSpare
 * 
 * @author joel kass
 *
 */
public interface FrameValidationInt {

	/**
	 * validateStrike
	 * 
	 * validates if a strike has occurred by computing the current framevalue that
	 * is equal to 10.
	 * 
	 * @param frameValue
	 * @return
	 */
	static boolean validateStrike(int frameValue, List<Integer> totalThrows) {
		return false;
	}

	/**
	 * validateSpare
	 * 
	 * validates if a spare has occurred by computing the current frame and the
	 * frameValue+1 that should be equal to ten.
	 * 
	 * @param frameValue
	 * @return
	 */
	static boolean validateSpare(int frameValue, List<Integer> totalThrows) {
		return false;
	}

	/**
	 * bonusForStrike
	 * 
	 * provides the bonus for a strike
	 * 
	 * @param frameValue
	 * @return
	 */
	static int bonusForStrike(int frameValue, List<Integer> totalThrows) {
		return 0;
	}

	/**
	 * bonusForSpare
	 * 
	 * provides a bonus for a spare
	 * 
	 * @param frameValue
	 * @return
	 */

	static int bonusForSpare(int frameValue, List<Integer> totalThrows) {
		return 0;
	}

	/**
	 * totalThrows
	 * 
	 * the total throws of the frame value and frame value+1
	 * 
	 * @param frameValue
	 * @return
	 */
	static int totalThrows(int frameValue, List<Integer> totalThrows) {
		return frameValue;

	}

}
