package solve;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static ArrayList<Client> lClients = new ArrayList<Client>();
	public static Set<String> lIngredients = new HashSet<String>();
	public static Set<String> lLikedIngredients = new HashSet<String>();
	public static Set<String> lDisikedIngredients = new HashSet<String>();

	/**
	 * 
	 * @return
	 */
	public static ArrayList<String> exec() {
						
		ArrayList<String> output = new ArrayList<String>();
		String tmpStr = "";
		

		for (Client c : Solution.lClients) {
			c.calculateRank();
		}
		
		Collections.sort(Solution.lClients);

		for (Client c : Solution.lClients) {
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
