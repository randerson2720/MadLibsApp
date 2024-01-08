package andersonMadLibs;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;



public class AndersonMadLibs {
	// initialize global array lists to be used in multiple functions
	static ArrayList<String>adj1 = new ArrayList<String>();
	static ArrayList<String>adv = new ArrayList<String>();
	static ArrayList<String>noun = new ArrayList<String>();
	static ArrayList<String>nouns = new ArrayList<String>();
	static ArrayList<String>verb = new ArrayList<String>();
	static ArrayList<String>verbed = new ArrayList<String>();
	static ArrayList<String>verbs = new ArrayList<String>();
	
	public static void printWelcome() {            // prints welcome banner
		System.out.println("************************************************************");
		System.out.println("*                  Welcome to Madlibs V1.0                 *");
		System.out.println("************************************************************");
	}
	public static void printInstructions() {           // prints instructions
		System.out.println("");
		System.out.println("This program generates random stories using wordlists you\nsupply. "
				+ "It starts from a base story that contains place\n-holders, which appear in <angle brackets>. "
				+ "The allowed\nplaceholders are singnoun, plunoun, singverb, pluverb,\npastverb, adj, and adv. "
				+ "The base stories come from files\nnamed story#.txt, where # would be replaced by 1, 2, etc. "
				+ "\nSubstituting for the placeholders would be words that come\nfrom wordlists. "
				+ "The wordlists must be named noun.txt (for\nsingular nouns), nouns.txt (for plural nouns), verb.txt\n(for singular verbs), "
				+ "verbs.txt (for plural verbs),\nverbed.txt (for past-tense verbs), adj.txt (for adjectives)\nand adv.txt (for adverbs)."
				+ "All these files - the story files\nand the word lists, must be located in the same folder. "
				+ "You\nwill begin by selecting a story number, and then I'll take\nit from there, generating a random story for you to enjoy.");
				
	}
	          // function that chooses the story
	public static ArrayList<String> storyChoicePrint(String storyPrint) {
		try {
			Scanner fscan = new Scanner(new File("story" + storyPrint + ".txt"));
			ArrayList<String> story = new ArrayList<String>();
			String line;
			while(fscan.hasNextLine()) {
				line = fscan.nextLine().trim();
				if (line != "") {
					story.add(line);
				}
					fscan.close();
				return story;
			}
			
		} catch (Exception ex) {
			System.out.println("Invalid File.");
			
		}
		return null;
	}
	
	// uses the other function loadWordList to load the name of the file
	public static void fileLoad() {
		try {
			Scanner fscan = new Scanner(new File("adj.txt"));	
			loadWordList(fscan, adj1);
			fscan = new Scanner(new File("adv.txt"));
			loadWordList(fscan, adv);
			fscan = new Scanner(new File("noun.txt"));
			loadWordList(fscan, noun);
			fscan = new Scanner(new File("nouns.txt"));
			loadWordList(fscan, nouns);
			fscan = new Scanner(new File("verb.txt"));
			loadWordList(fscan, verb);
			fscan = new Scanner(new File("verbed.txt"));
			loadWordList(fscan, verbed);
			fscan = new Scanner(new File("verbs.txt"));
			loadWordList(fscan, verbs);
		} catch (Exception ex) {
			System.out.println("Invalid.");
		}
	}  
		// function that uses file load 
	public static void loadWordList(Scanner fscan, ArrayList<String> ranList) {
		String line;
		
		while(fscan.hasNextLine()) {
			line = fscan.nextLine().trim();
			if (line != "")
				ranList.add(line);
			
		}
	}
	// function that uses the array to print out the story with the place holders filled in?????
	public static void printStory(ArrayList<String>story) {
		String placeholder;
		
	}
	
	public static void main(String[] args){
		String choice;
		Scanner scan = new Scanner(System.in);
		printWelcome();
		printInstructions();
		fileLoad();
		ArrayList<String>story = new ArrayList<String>();
		 
		do {   //  selects the story and prints out the correct option through user input
			System.out.print("\nEnter a story number, i to see instructions, or q to quit: ");
			choice = scan.nextLine();
			
			if (choice.equals("i")) {
				printInstructions();
			} else if (choice.equals ("1")) {
				System.out.println("\nHere is your MadLib!");
				story = storyChoicePrint(choice);
			} else if (choice.equals("2")) {
				System.out.println("\n Here is your MadLib!");
				story = storyChoicePrint(choice);
			} 
			
		} while (!choice.equals("q"));
			System.out.println("\nThank you for using this program.");
	}
}
		