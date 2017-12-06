package com;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import exceptions.CustomException;
import validation.FrameValidation;

/**
 * TenPinBowling
 * 
 * This class contains the primary methods of this application:
 * 
 * roll()
 * isFinished()
 * getScore()
 * 
 * validation for specific bowling types is located in validation.FrameValidation
 * 
 * totalThrows - holds all of the bowling data
 * frameIdx -the specific frame index
 * 
 * @author joel kass
 * @date 12/5/2017
 *
 */

public class TenPinBowling implements TenPinBowlingInt {
	
	final static Logger logger = Logger.getLogger(TenPinBowling.class);
	private static List<Integer> totalThrows = new ArrayList<Integer>();
    private static int frameIdx;

	
	static {
		//tear down the pins and start a new game.
		totalThrows.clear();
		frameIdx=0;
	}
	
	
	
	
	
	/**
	 * roll
	 * 
	 * Simulates the rolling of the ball. The method checks for non valid throws that are over 10
	 * by throwing an error, invalidating the game.
	 * 
	 * 
	 * @param rollData
	 */
	
	@Override
	public void roll(int rollData) {

		if (rollData > 10) {

			try {
				throw new CustomException("a valid throw has to be <=10. The current throw was: " + rollData);
			} catch (CustomException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}



		else {
			totalThrows.add(rollData);
		

		}

	}

	/**
	 * isFinished
	 * 
	 * verifies if the game is over or not.
	 * 
	 * @return
	 */
	
	@Override
	public boolean isFinished() {

		if (totalThrows.size() == 0) {

			System.out.println(false);

			return false;
		}


		
		else {
			System.out.println(true);
			return true;
			
		}
		
		}

	

	/**
	 * getScore
	 * 
	 * retrieves the score of the frame
	 * 
	 * @return
	 */
	@Override
	public  int getScore() {

		
		
		//if the the totalThrows are 0, we have not started yet and thus no score.
		if (totalThrows.size() == 0) {

			System.out.println(0);
			return 0;
		}

		else if (totalThrows.size() > 21) {

			System.out.println("invalid game: too many throws");
			try {
				throw new CustomException("a valid game has 10 frames. The frame size was: " + totalThrows.size());
			} catch (CustomException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		
		
		
		//frameScore is the score of an individual frame.
		int frameScore = 0;

		for (int i = 0; i < 10; i++) {

			//check if it is a spare
			if (FrameValidation.validateSpare(frameIdx,totalThrows)) {
				
				//apply the bonus if its a spare and increment the frameIdx
				frameScore += 10 + FrameValidation.bonusForSpare(frameIdx,totalThrows);
				frameIdx += 2;
			}

			
			//check if it is a strike
			else if (FrameValidation.validateStrike(frameIdx,totalThrows)) {
				
				//apply the bonus if it is a strike and increment the frameIdx.
				frameScore += 10 + FrameValidation.bonusForStrike(frameIdx,totalThrows);
				frameIdx++;

				
			//no bonus
			} else {
				frameScore += FrameValidation.totalThrows(frameIdx,totalThrows);
				frameIdx += 2;
			}
		}
		System.out.println(frameScore);
		return frameScore;
	}






}
