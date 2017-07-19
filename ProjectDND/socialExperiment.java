package ProjectDND;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SuppressWarnings ("unused")

public class socialExperiment {
	
	/*	HOW TO CALL COMMAND MENU METHOD
	 	
	 	switch(INPUT)
		{case "commands": commandMenu();}
		
	 */
	public static void commandMenu()
	{	
		Scanner commandIn = new Scanner(System.in);
		String command = null;
		boolean commandList = true;
		
		COMMANDS:
			while(commandList){
				System.out.println("\n###COMMAND-MENU###");
				command = commandIn.nextLine();
		switch(command){
		case "quicksave":
			System.err.println("Data Saved!");
			//does not actually save, will implement quicksave feature soon
			continue COMMANDS;
		
		case "get":
			System.err.println("Where are your things?");
			//inventory menu, feature soon to come as well
			continue COMMANDS;
		
		case "install":
			System.err.println("To install upgrades you must have necessary neural nodes...");
			//upgrade system, soon to be implemented
			continue COMMANDS;
			
		case "help":
			System.err.println("Commands List:"
					+ "\n<install>"
					+ "\n<get>"
					+ "\n<quicksave>"
					+ "\nNOTE: These commands are to be entered without the arrows surrounding them.");
			continue COMMANDS;
		
		case "exit":
			break;
			}
		break;
		} //switch commands
	} //commandMenu method
	
	public static void exit()
	{
		System.out.println("Exit Successful!");
		//break checks for loops
	}
	public static void seperator()
	{
		System.out.println("---------------------------------------");
	}
	
	public static void timeDisplay()
	{
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date dobj = new Date();
	}
	
	public static void main(String[] args){
		
		//SCENARIOS
		boolean login = true;
		boolean beginning = true;
		boolean escapeRoom = true;
		
		Scanner kb = new Scanner(System.in);
		Random dice = new Random();
		Player1 player = null;
		String username = null;
		String action = null;
		
		
		//System.out.println(":VOICE: \n>Welcome, you are now in the Social Experiment."); //INTRO MESSAGE 
		//Progress Load after intro message
		
		LOGIN:
			while(login){
				System.out.println(":VOICE: \n>Welcome, you are now in the Social Experiment."); //INTRO MESSAGE
				System.out.println(">Is this your first visit?"
						+ "\n>If so, please enter 'newuser' below. "
						+ "\n>If not, enter your username.");
				username = kb.nextLine();
				
				switch(username){
				case "admin": 
					System.err.println("ADMIN PRIVELEGES ENABLED\n");
					//username = player.getUsername("admin");
					//special priveleges in-game
					break;
					
				case "guest":
					System.err.println("DATA IS NO LONGER BEING RECORDED\n");
					//username = player.getUsername("guest");
					//no data is saved 
					break;
				
				case "anonymous":
					System.err.println("YOUR DATA WILL NOW BE ENCRYPTED\n");
					//username = player.getUsername("anon");
					//encrypts user data
					break;
					
				case "username":
					System.err.println("WELCOME BACK\n");
					//LOAD DATA
					break;
	
				case "newuser":
					System.err.println("USER REGISTER PROCESS COMMNECED\n");
					//username = player.getUsername("n00b");
					//NEW GAME
					break;
					
				} //switch username
				break;
			} //while login
				
	
	
		BEGINNING:
			while(beginning){
				boolean questions = true;
				System.out.println(">Before we continue, please fill in the appropriate information.");
				QUESTIONS:	
				while(questions){
						System.out.println("+What is your gender? Male or female?");
						String gender = kb.nextLine();
						System.out.println("+What is your name?");
						String name = kb.nextLine();
						System.out.println("+How old are you?");
						int age = kb.nextInt();
						System.out.println("+What is your field of study?"
								+ "\n>Please use the abbreviation from the options below");
						seperator();
						System.out.println("-Computer Science = CS"
								+ "\n-Business = BUS"
								+ "\n-Economics = ECO"
								+ "\n-Physical Therapy = ATH"
								+ "\n-Nursing = NUR"
								+ "\n-Biology = BIO"
								+ "\n-Politics = POL");
							//choice of major will change the major of rival and bff
							//bff = complete opposite of your major
							//rival = "better" than your major
						String major = kb.next();
				
						player = new Player1(null, gender, name, age, major, null, null);
						System.out.println(">Below are your current stats.");
						player.major();
						seperator();
						System.out.println(":VOICE:"
								+ "\n>Quickly...");
						player.PrintInfo();
						
						System.out.println(">Is this information correct? [Y/N]");
						String begin = kb.next();
						switch(begin.toUpperCase()){
						case "Y":
							System.out.println("Thank you for answering the questions with honesty.");
							break;
						case "N":
							System.err.println("Please enter your correct information!");
							continue QUESTIONS;
						} //switch begin
						break;
						
				} //while questions
				//exit();
				break;
			} // while beginning
			
		DARKROOM:
			while(escapeRoom){
				seperator();
				System.out.println(":VOICE:\n"
						+ ">" + player.getName() + " it is time to get up!");
				timeDisplay();
				System.out.println("\nObjective:\nFigure out where you are.");
				System.err.println("Type in 'help' if you ever get lost");
				action = kb.next();
				switch(action.toLowerCase()){
				case "help":
					System.err.println("In the Social Experiment, the prefix-system is essential to survival. "
							+ "\nActions are based off what you do: "
							+ "\ni.e 'look for', 'feel for', 'walk to', etc\n");
					System.out.println(":VOICE:"
							+ "\n>Don't you have a phone?");
					action = kb.next();
				
				case "sudo apt init wakeup":
					System.out.println(":VOICE:\n>Wait how do you know that?!\n");
					kb.nextLine();
					System.err.println("Ending simulation before completion will result in full cerebral crash.");
					kb.nextLine();
					System.out.println(":VOICE: \n" + ">"+player.getName() + " are you sure you want to do this?\n");
					System.err.println("Wake up? [Y/N]");
					String again = kb.nextLine();
					switch(again.toUpperCase()){
					case "Y":
						System.err.println("Simulation Error(user_conscious-4011)"
								+ "\nExecute full wipe of system...\n");
						seperator();
						kb.nextLine();
						System.err.println("System wipe complete!");
						break;
					
					case "N":
						System.err.println("Restarting Scenario...");
						continue DARKROOM;
					} //switch again
				} //switch action
				break;
			} //while escapeRoom
	}
}

