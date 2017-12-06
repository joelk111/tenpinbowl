package com;


/**
 * Interface for adobe ten  pin bowling
 * 
 *
 */
public interface TenPinBowlingInt {
	
	/**roll
	 * 
	 * rolls the ball
	 * 
	 * @param rollData
	 */
	 void roll(int rollData);
	 
	 
	 
	 /** isFinished
	  * 
	  * @return
	  */
	 boolean isFinished();
	 
	 
	 
	 /** getScore
	  * 
	  * @return
	  */
	 int getScore();

}