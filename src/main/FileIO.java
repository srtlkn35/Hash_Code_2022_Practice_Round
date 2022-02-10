package main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

	private static boolean FILEIO_PRINT_INPUT_FILELINES = false;
	private static boolean FILEIO_PRINT_OUTPUT_FILELINES = false;

	private String sInputFilename;
	private String sOutputFilename;
	private ArrayList<String> lInputFileLines;
	private ArrayList<String> lOutputFileLines;
	
	public String getsInputFilename() {
		return sInputFilename;
	}

	public void setsInputFilename(String sInputFilename) {
		this.sInputFilename = sInputFilename;
	}

	public String getsOutputFilename() {
		return sOutputFilename;
	}

	public void setsOutputFilename(String sOutputFilename) {
		this.sOutputFilename = sOutputFilename;
	}

	public ArrayList<String> getlInputFileLines() {
		return lInputFileLines;
	}

	public void setlInputFileLines(ArrayList<String> lInputFileLines) {
		this.lInputFileLines = lInputFileLines;
	}

	public ArrayList<String> getlOutputFileLines() {
		return lOutputFileLines;
	}

	public void setlOutputFileLines(ArrayList<String> lOutputFileLines) {
		this.lOutputFileLines = lOutputFileLines;
	}

	public FileIO(String sInputFilename, String sOutputFilename) {
		super();
		this.sInputFilename = sInputFilename;
		this.sOutputFilename = sOutputFilename;
		this.lInputFileLines = new ArrayList<String>();
		this.lOutputFileLines = new ArrayList<String>();
	}

	/**
	 * 
	 */
	public void readFile() {
		
        try {
    		List<String> fileContent = null;
    		fileContent = Files.readAllLines(Paths.get(this.sInputFilename), Charset.defaultCharset());
            this.lInputFileLines.clear();
            this.lInputFileLines = new ArrayList<String>(fileContent);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        
        if (FILEIO_PRINT_INPUT_FILELINES == true) {
			System.out.println("****** File: '" + this.sInputFilename + "'");
        	for (String s : this.lInputFileLines) {
				System.out.println(s);
			}
			System.out.println("******");
			System.out.println();
        }
	}
	
	/**
	 * 
	 */
	public void writeFile() {
		
        if (FILEIO_PRINT_OUTPUT_FILELINES == true) {
			System.out.println("****** File: '" + this.sOutputFilename + "'");
        	for (String s : this.lOutputFileLines) {
				System.out.println(s);
			}
			System.out.println("******");
			System.out.println();
        }

		try {
			Files.write(Paths.get(this.sOutputFilename), this.lOutputFileLines, Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
            System.exit(1);
		}
	}
}
