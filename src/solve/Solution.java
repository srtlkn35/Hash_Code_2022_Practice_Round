package solve;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static Set<String> lIngredients = new HashSet<String>();
	public static Set<String> lLikedIngredients = new HashSet<String>();
	public static Set<String> lDisikedIngredients = new HashSet<String>();

	/**
	 * 
	 */
	public static void initialize() {
		
		lIngredients.clear();
		lLikedIngredients.clear();
		lDisikedIngredients.clear();
	}

	/**
	 * 
	 * @return
	 */
	public static ArrayList<String> exec() {
						
		ArrayList<String> output = new ArrayList<String>();
		String tmpStr = "";
		

		for (Client c : Client.lClients) {
			c.calculateRank();
		}
		
		Collections.sort(Client.lClients);

		for (Client c : Client.lClients) {
			addClientChoice(c);
		}
		
		tmpStr += lLikedIngredients.size();
		for (String s : lLikedIngredients) {
			tmpStr += " " + s;
		}

		output.add(tmpStr);
		
		return output;
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static boolean addClientChoice(Client c) {
		
		for (String s : c.getlLikes()) {
			if (lDisikedIngredients.contains(s)) {
				return false;
			}
		}
		lLikedIngredients.addAll(c.getlLikes());
		lDisikedIngredients.addAll(c.getlDislikes());
		return true;
	}
}
