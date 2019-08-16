package ProjectDND;

import java.util.*;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SuppressWarnings ("unused")


//MAKE SOME FUNCTIONS FOR YOUR PRINTS

public class socialExperiment extends Canvas implements Runnable {	
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH  = 160;
	public static final int HEIGHT = WIDTH/12*9;
	public static final int SCALE  = 3;
	public static final String NAME = "SocialExperiment";

	static Player1 Hero = new Player1(null, null, null, 0, null);
	String action;
	
	
	private JFrame frame;

	public socialExperiment(){
		setMinimumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		setMaximumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		
		frame = new JFrame(NAME);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	/*	HOW TO CALL COMMAND MENU METHOD
	 	
	 	switch(INPUT)
		{case "commands": commandMenu();}
		
	 */
	private static void commandMenu()
	{	
		Scanner commandIn   = new Scanner(System.in);
		String command      = null;
		boolean commandList = true;
		
		COMMANDS:
		while(commandList){
			System.out.print("\\[cmdmod]");
				command = commandIn.nextLine();
		switch(command)
		{
		case "sudo apt init wakeup":
			wipe();
			break;
			
		case "save":
			System.err.println("Data Saved!\n");
			//does not actually save, will implement quicksave feature soon
			continue COMMANDS;
		
		case "inventory":
			System.err.println("Where are your things?\n");
			//inventory menu, feature soon to come as well
			continue COMMANDS;
		
		case "install":
			System.err.println("To install upgrades you must have necessary neural nodes...\n");
			//upgrade system, soon to be implemented
			continue COMMANDS;
			
		case "help":
			System.err.println("Commands List:"
					+ "\n<save>"
					+ "\n<inventory>"
					+ "\n<install>"
					+ "\nNOTE: These commands are to be entered without the arrows surrounding them.\n");
			continue COMMANDS;
		
		case "exit":
			commandIn.close();
			exit();
			break;
			}	
		break;
		} //switch commands
	} //commandMenu method
	
	private static void wipe()
	{	
		Scanner wipeIn = new Scanner(System.in);
		System.out.println(":VOICE:\n>Wait how do you know that?!\n");
		wipeIn.nextLine();
		System.err.println("Ending simulation before completion will result in full cerebral crash.");
		wipeIn.nextLine();
		System.out.println(":VOICE: \n" + ">Are you sure you want to do this?\n");
		System.err.println("Wake up? [Y/N]");
		String again = wipeIn.nextLine();
		switch(again.toUpperCase()){
		case "Y":
			System.err.println("Simulation Error(user_conscious-4011)"
					+ "\nExecute full wipe of system...\n");
			seperator();
			wipeIn.nextLine();
			System.err.println("System wipe complete!");
			break;
		}
	}
	
	public static String userName()
	{
		Scanner kb = new Scanner(System.in);
		String username = null;
		boolean login = true;
		
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
					username = "admin";
					
					//special priveleges in-game
					
				case "guest":
					System.err.println("DATA IS NO LONGER BEING RECORDED\n");
					
					//no data is saved 
				
				case "anonymous":
					System.err.println("YOUR DATA WILL NOW BE ENCRYPTED\n");
					username = "";
					//encrypts user data
					
					
				case "username":
					System.err.println("WELCOME BACK\n");
					//dataLoad();
					break;
					
				case "newuser":
					System.err.println("USER REGISTER PROCESS COMMENCED\n");
					username = "n00b";
					//NEW GAME
					break;
				} //switch username
				kb.close();
				break;
			} //while login
		return username;
	}//intro method
	
	private static void userDataInput()
	{
		boolean beginning = true;
		Scanner kb = new Scanner(System.in);
		
		BEGINNING:
			//Player object contains username, gender, name, age, major variables
			while(beginning){
				boolean questions = true;
				kb.nextLine();
				seperator();
				System.out.println(">Before we continue, please fill in the appropriate information.");
				QUESTIONS:	
				while(questions){
						System.out.println("+What is your gender? Male or female?"
								+ "\n#Note: if you wish to not identify, simply press enter.");
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
					
						String major = kb.next();
						Player1 player = new Player1(null, gender, name, age, major);
						
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
							Hero = player;
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
	}
	
	private static void dream(){
		boolean escapeRoom = true;
		Scanner kb = new Scanner(System.in);
		Random dice = new Random();
		String action;
		
		DARKROOM:
			while(escapeRoom){
				int chance = dice.nextInt(20);
				//String[] inventory = new String[10];
				boolean choice = true;
				String continueOn;
				seperator();
				System.out.println(":VOICE:\n"
						+ ">" + Hero.getName() + " it is time to get up!");
				timeDisplay();
				System.out.println("\nObjective:\nFigure out where you are.");
				System.err.println("Type in 'help' if you ever get lost");
				
				WHATTODO:
					while(choice) {
						
				int actionCheck = 0;
				action = kb.nextLine();
				switch(action.toLowerCase()){
				case "help":
					System.err.println("In the Social Experiment, the prefix-system is essential to survival. "
							+ "\nActions are based off what you do: "
							+ "\ni.e 'look for', 'feel for', 'walk to', etc\n"
							+ "");
					continue WHATTODO;
				
				case "commands":
					commandMenu();
					continue WHATTODO;
				
				case "check pockets":
					int count = 0;
					if(count>=1){
						System.err.println("You already checked your pockets!");
						continue WHATTODO;
					}
					else if(count<=0){
					System.err.println("You scramble through your pockets...");
					kb.nextLine();
					String[] inventory = new String[5];
					while(actionCheck <= 1) 
						
					if(chance>=15){ //different inventory based on chance var roll
						System.err.println(":VOICE:"
								+ "\n>You found your phone, what will you do with it?");
						inventory [1] = "Charged Phone";
						System.err.println(inventory[1]);
						System.out.print("has been added to your inventory");
						count++;
						continue WHATTODO;
					}
					else if(chance<=14 && chance>=7){
						System.out.println(":VOICE:"
								+ "\nYou found your phone, the battery is very low...");
						inventory[1] = "Dying Phone";
						System.err.println(inventory[1]); 
						System.out.print("has been added to your inventory");
						count++;
						continue WHATTODO;
						}
					else if(chance<=6); {
						System.out.println(":VOICE:"
								+ "\nYou found a box of matches, good luck...");
						inventory[1] = "Matches";
						System.err.println(inventory[1]); 
						System.out.println("have been added to your inventory");
						count++;
						continue WHATTODO;
					} //esle if chance<6
					
					}	
				} 
					}
			} //while escapeRoom */
			
	}
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
		System.out.println(df.format(dobj));
	}
	
	public static void main(String[] args){
		userName();
		userDataInput();
		dream();
		
			
		
			
			System.err.println("######################");
			System.err.println("Thank you for playing!");
			System.err.println("######################");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
