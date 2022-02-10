package main;

import java.util.ArrayList;
import solve.Parse;
import solve.Solution;

public class Main {

	private static ArrayList<String> lInputFilenames = new ArrayList<String>();
	
	public static void main(String args[]) {
		
		long startTime = System.currentTimeMillis();

		lInputFilenames.add("input/a_an_example.in.txt");
		lInputFilenames.add("input/b_basic.in.txt");
		lInputFilenames.add("input/c_coarse.in.txt");
		lInputFilenames.add("input/d_difficult.in.txt");
		lInputFilenames.add("input/e_elaborate.in.txt");
		
		for (String s : lInputFilenames) {
			
			FileIO fileio = new FileIO(s, s.replace("input/", "output/").replace(".txt", "_report.txt"));
			fileio.readFile();
			Parse.exec(fileio.getlInputFileLines());
			fileio.setlOutputFileLines(Solution.exec());
			fileio.writeFile();
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("ExecutionTime in ms: '" + (endTime - startTime) + "' ...");
	}
}
