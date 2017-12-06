package com;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import validation.FrameValidation;


/**
 * 
 * @author joel kass
 * @date 12/5/2017
 *
 */
public class TestAll {
	
	final static Logger logger = Logger.getLogger(TestAll.class);	
	

	 
	@BeforeAll 
	static void setUp() throws Exception {

	logger.info("starting tests");

	}

	@AfterEach
	void tearDown() throws Exception {
		
		logger.info("ending tests");
	}
	
	

	@Test
	public void testGetScore() {
		
		TenPinBowling bowl = new TenPinBowling();
		List<Integer> list =util.DataParse.parse(Scores.data2.toString());
	
		int result=bowl.getScore();

		assert result==0;
		
		
	}
	
	@Test
	public void testIsFinished() {
		
		TenPinBowling bowl = new TenPinBowling();
		List<Integer> list =util.DataParse.parse(Scores.data2.toString());
	
		bowl.getScore();
		boolean result =bowl.isFinished();

		assert result==false;
		
		
	}
	
	@Test
	public void testValidateStrike() {
		List<Integer> list = Arrays.asList(10, 0 ,7, 1 ,8 ,0 ,0 ,0, 0, 0, 0,0 ,0, 0, 0, 0, 0,0, 0, 0);	
		boolean result =FrameValidation.validateStrike(3, list);

		assert result==false;
		
		
	}
	
	@Test
	public void testValidateSpare() {
		List<Integer> list = Arrays.asList(10, 0 ,7, 1 ,8 ,0 ,0 ,0, 0, 0, 0,0 ,0, 0, 0, 0, 0,0, 0, 0);	
		boolean result =FrameValidation.validateSpare(3, list);

		assert result==false;
		
		
	}
	
	
	@Test
	public void testBonusSpare() {
		List<Integer> list = Arrays.asList(10, 0 ,7, 1 ,8 ,0 ,0 ,0, 0, 0, 0,0 ,0, 0, 0, 0, 0,0, 0, 0);	
		int result =FrameValidation.bonusForSpare(3, list);

		assert result==0;
		
		
	}
	
	@Test
	public void testBonusStrike() {
		List<Integer> list = Arrays.asList(10, 0 ,7, 1 ,8 ,0 ,0 ,0, 0, 0, 0,0 ,0, 0, 0, 0, 0,0, 0, 0);	
		int result =FrameValidation.bonusForStrike(1, list);

		assert result!=0;
		
		
	}
	
	public enum Scores {
		data1("10 0 7 1 8 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0"),
		data2("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 9 1 10"),
		data3("5 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 9 1 10"),
		data4("4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4"),
		data5("10 10 10 0 0 0 0 0 0 0 0 0 0 0 0 0 0"),
		data6("10 9 1 9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0"),
		data7("10 10 10 10 10 10 10 10 10 10 10 10"),
		data8("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 9 1 10"),
		data9("10 10 10 0 0 0 0 0 0 0 0 0 0 0 0 0 0"),
		data10("10 10 9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0"),
		data11("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 10 8 1"),
		data12("10 10 9 1 5 2 0 0 0 0 0 0 0 0 0 0 0 0"),
		data13("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 9 1 9"),
		data14("10 9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0"),
		data15("10 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0")
	    ;

	    private final String text;

	    /**
	     * @param text
	     */
	    private Scores(final String text) {
	        this.text = text;
	    }

	    /* (non-Javadoc)
	     * @see java.lang.Enum#toString()
	     */
	    @Override
	    public String toString() {
	        return text;
	    }
	
	

}
	
	

}
