package main;

import java.io.File;
import java.util.ArrayList;
import solve.Parse;
import solve.Solution;

public class Main {

	private static ArrayList<String> lInputFilenames = new ArrayList<String>();
	
	public static void main(String args[]) {
		
		long startTime = System.currentTimeMillis();

		File folder = new File("input/");
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			lInputFilenames.add(file.getParentFile().getName() + "/" + file.getName());
		}
		
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
