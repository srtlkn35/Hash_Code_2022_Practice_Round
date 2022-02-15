package solve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parse {

	public static void exec(ArrayList<String> lines) {

		List<String> likes;
		List<String> dislikes;
		
		int numOfClient = Integer.parseInt(lines.get(0));
		
		Solution.initialize();
		Client.initialize();

		for (int i = 0; i < numOfClient; i++) {
			
			likes = Arrays.asList(lines.get((2 * i) + 1).substring(lines.get((2 * i) + 1).indexOf(" ") + 1).split(" "));
			if (lines.get((2 * i) + 2).contains(" ")) {
				dislikes = Arrays.asList(lines.get((2 * i) + 2).substring(lines.get((2 * i) + 2).indexOf(" ") + 1).split(" "));
			}
			else {
				dislikes = new ArrayList<String>();
			}

			Client.lClients.add(new Client(likes, dislikes));
			Solution.lIngredients.addAll(likes);
			Solution.lIngredients.addAll(dislikes);
		}		
	}
}
