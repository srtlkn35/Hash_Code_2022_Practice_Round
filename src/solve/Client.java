package solve;

import java.util.ArrayList;
import java.util.List;

public class Client implements Comparable<Client>{

	public static ArrayList<Client> lClients = new ArrayList<Client>();
	public static int iTotalLikes = 0;
	public static int iTotalDislikes = 0;

	private List<String> lLikes;
	private List<String> lDislikes;
	private float iRank;
	
	public List<String> getlLikes() {
		return lLikes;
	}

	public void setlLikes(List<String> lLikes) {
		this.lLikes = lLikes;
	}

	public List<String> getlDislikes() {
		return lDislikes;
	}

	public void setlDislikes(List<String> lDislikes) {
		this.lDislikes = lDislikes;
	}

	public Client(List<String> lLikes, List<String> lDislikes) {
		super();
		this.lLikes = lLikes;
		this.lDislikes = lDislikes;
		this.iRank = 0;
		iTotalLikes += lLikes.size();
		iTotalDislikes += lDislikes.size();
	}
	
	@Override
	public int compareTo(Client o) {
		if (this.iRank > o.iRank) {
			return -1;
		}
		else if (this.iRank < o.iRank) {
			return 1;
		}
		return 0;
	}

	/**
	 * 
	 */
	public static void initialize() {
		
		lClients.clear();
		iTotalLikes = 0;
		iTotalDislikes = 0;
	}

	/**
	 * 
	 */
	public void calculateRank() {

		float iLikeRank = (float) this.lLikes.size() / iTotalLikes;
		float iDislikeRank = 1 - ((float) this.lDislikes.size() / iTotalDislikes);
		this.iRank = iLikeRank + iDislikeRank;
	}
}
