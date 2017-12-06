package drivers;

import java.util.List;
import org.apache.log4j.Logger;
import com.TenPinBowling;
import util.DataParse;

/** BasicGameDriver
 * 
 * driver class for the adobe tenpin bowling challenge. All datasets are stored in the enum called Scores.
 * 
 * Per specification, the driver should be able to run the following code:
 * 
 * 	BowlingGame game = new BowlingGame();
	System.out.println(game.getScore());
	System.out.println(game.isFinished());
	
		for (int i = 0; i < 12; i++) {
			game.roll(10);
		} 
		
	System.out.println(game.getScore());
	System.out.println(game.isFinished());
	
	
	The result of this code per specification should be:
	
		0
		false
		300
		true
 * 
 * @author joel kass
 *
 */
public class BasicGameDriver {
	
	final static Logger logger = Logger.getLogger(BasicGameDriver.class);
	
	
	/** Scores
	 * 
	 * enum to hold all the scores for our driver. 
	 * Some of this sample data was provided as well as additional datasets
	 * 
	 *
	 */
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
		data15("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0")
	    ;

	    private final String text;

	    /**
	     * @param text
	     */
	    private Scores(final String text) {
	        this.text = text;
	    }

	    @Override
	    public String toString() {
	        return text;
	    }
	
	

}

	/**
	 * Driver
	 * 
	 * This is the driver to test the ten pin bowling application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		//load your dataset here by selecting a different set in the enum.
		List<Integer> list = DataParse.parse(Scores.data7.toString());
		logger.info("the bowling scores are: "+list.toString());
	
		
		
		TenPinBowling game = new TenPinBowling();
		game.getScore();
		game.isFinished();
		for (Integer i : list) {

			game.roll(i);

		}
		
		
		/*	uncomment this code to test for all strikes
		 * 
		 * for (int i = 0; i < 12; i++) {
			game.roll(10);
			}*/
		
		game.getScore();
		game.isFinished();

	}
	
	
	

			

}