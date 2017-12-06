package util;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/** DataParse
 * 
 * This class contains the parsing method for bowling data.
 * 
 * @author joel kass
 * @date 12/5/2017
 *
 */
public class DataParse {
	
	
	/**
	 * parse
	 * 
	 * utility method to parse the bowling data in the form of:
	 * 
	 * 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 9 1 10
	 * 
	 * returns a List of integers
	 * 
	 * @param data
	 * @return
	 */
	public static List<Integer> parse(String data) {

		
		Pattern pattern = Pattern.compile(" "); //split the bowling data for a space
		
		List<Integer> list = pattern.splitAsStream(data)
				.map(Integer::valueOf)
				.collect(Collectors.toList());

		return list;
	}

}
