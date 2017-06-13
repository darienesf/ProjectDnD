package ProjectDND;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MainClassGame {
	public static void exit()
	{
		System.out.println("exit successful");
	}
	public static void seperator()
	{
		System.out.println("----------------------------------------");
	}
	public static void errMsg()
	{
		System.err.println("Please enter a number based on the choices given!");
	}
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date dateobj = new Date();
	    
	    //TIME CALLER->
	    System.out.println(df.format(dateobj));

	    /*getting current date time using calendar class 
	     * * An Alternative of above*/
	    //Calendar calobj = Calendar.getInstance();
	    //System.out.println(df.format(calobj.getTime()));
		
	    boolean intro = true;
	    boolean intro2 = true;
	    boolean main = true;
	    boolean graduation = true;
	    boolean escaping = true;
	    
		Scanner kb = new Scanner(System.in);
		Random dice = new Random();
		Player1 player = null;
		Scenarios scenario; 
		
		System.out.println(">Voice: Welcome to the Social Experiment.");
		
		INTRO:
		while(intro){
		//USER INPUTS
		System.out.println(">Are you Male or Female?"); 
		String gender = kb.next(); //gender
		System.out.println(">What is your name?");
		String name = kb.next(); //name
		System.out.println(">What is your age?");
		int age = kb.nextInt(); //age
		
		//CHOOSE MAJOR
		System.out.println(">Please choose your major from the options below:");
		System.out.println("+Computer Science = CS"
				+ "\n+Business = BUS"
				+ "\n+Economics = ECO"
				+ "\n+Physical Therapy = ATH"
				+ "\n+Nursing = NUR"
				+ "\n+Biology = BIO"
				+ "\n+Politics = POL");
		String majorN = kb.next();
		player = new Player1(gender,name,age,majorN,null,null);
		seperator();
		
		//INFO CHECK
		System.out.println("Your stats are as follows");
		player.major();
		seperator();
		player.PrintInfo();
		System.out.println("\nIs this information correct?"
				+ "\n1. Yes, it is."
				+ "\n2. No, it is not.");
		int areUsure = kb.nextInt();
		if (areUsure == 1)
		{break;}
		else if (areUsure == 2){
			System.out.println("Please enter your correct information.");
			continue INTRO;
		}
		}
		/*
		*Characters who will go to your graduation referenced OFTEN
		*Converts user input into object for easier reference
		*/
		System.out.println(">Voice: Enter the name of someone who is always by your side.");
		String impPers1 = kb.next();
				player.getLifeline1(impPers1);
				Player1 bff = new Player1(null,impPers1,0,"none",null,null); 
		System.out.println(">Enter the name of your worst enemy!"
				+ " 'Dinkleberg'(Recommended)");
		String impPers2 = kb.next(); 
				player.getLifeline2(impPers2);
				Player1 rival = new Player1(null,impPers1,0,"none",null,null);
		System.out.println(">Voice: Thank you for cooperating, I have saved your answers as we may need to refer back to them later..."
				+ "\nLet us begin!");
		kb.nextLine();
		
		INTRO2:
		while(intro2){
		seperator();
		System.out.println("***"+player.getName() + " it is time to get up!***");
		System.out.println(df.format(dateobj));
		System.out.println("\nObjective:\nCheck your phone.\n>Type in 'help' for help.");
		boolean exit = true;
		if(exit){break;}
		else{continue INTRO2;}
		}
		
		ESCAPEROOM:
		while(escaping){
		int chance = dice.nextInt(20);
		boolean convo1 = false;
		String escapeRoom = kb.nextLine();
		
		/*possible if-elseif statement for user inputs
		 * NOT CONCRETE
		 
		if(escapeRoom == "pickuphone"){
		System.out.println();
		}
		
		*/
		
		switch(escapeRoom){
		case "wake up":
			System.out.println(">Voice: Wait how do you know that?!");
			kb.nextLine();
			System.err.println("Ending simulation before completion will result in full cerebral crash.");
			kb.nextLine();
			System.out.println(player.getName() + " stop!!!!");
			System.err.println("Wake up?");
			String oneMoreTime = kb.nextLine();
			switch(oneMoreTime){
			case "wake up":
				System.err.println("Simulation Error(user_conscious-4011)"
						+ "\nExecute full wipe of system...\n");
				seperator();
				kb.nextLine();
				System.err.println("System wipe complete!");
				break;
			}
			exit();
			break;
		}
		switch(escapeRoom){
		 case "help":
			 System.err.println("type in 'get phone'");
		}
		
		switch(escapeRoom){
			case "get phone":
				seperator();
			 System.out.println(">You take your phone out of your pocket... "
			 		+ "\nYou have 47 missed calls from " + bff.getName());
			 System.out.println("Are you going to call " + bff.getName() + " back?"
					 + "\n1. Yes"
					 + "\n2. No");
			int callPers = kb.nextInt();
			if(callPers==1){ 
			if (chance>=15){
 				 System.out.println(impPers1+": Hey, " + player.getName() + " where have you been?\nYou've been gone since Sunday!");
 				 convo1 = true;
 				 break;
 			 } //chance If
 			 else if(chance<14 && chance>9){
 				System.out.println(impPers1+": H%$#, *&(@, 18zaa, Mnz19000");
 				System.out.println("Voice: The signal seems bad, try moving around.(Type in 'move' to see what happens)");
 				String enterMove = kb.next();
				System.out.println("Good job, the signal is getting stronger!");
				System.out.println(impPers1+": Hey, " + player.getName() + " where have you been?\nYou've been gone since Sunday!");
				convo1 = true;
				break;
 			 } //chance elseIf 
 			 else { 
 				System.out.println("Voice: You actually have no service... what are the odds!"
						   +"\nMaybe you can try again later");
 				player.callFail();
 				break;
 			 } //chance else
			 } //callpers If
				else if(callPers==2){
					System.out.println("Good idea..");
					//STAT CHANGE
					break;
				}
				else if (callPers!=1 && callPers!=2){
					errMsg();
					System.out.println("Call back " + bff.getName() +"?");
					callPers = kb.nextInt();
				}
			 } //getphoneCase switch
		
		/*
		SWITCH FOR CONVERSATION WITH FIRST IMPORTANT PERSON
		IFF
		callPers = 1
		chance > 9 
		*/
		if(convo1==true && chance>=9){
			int impPers1convo1;
			seperator();
			System.out.println(">Voice:What is your response?"
					+ "\n1. My phone has been acting up, I'm sorry!"
					+ "\n2. None of your business, why did you call me so much?"
					+ "\n3. I was studying for my final."
					+ "\n4. I have no clue, I wish I knew...");
			impPers1convo1 = kb.nextInt();
			if(impPers1convo1 == 1){
				System.out.println(impPers1 + ": Hmmm... sounds fishy to me...");
				break;
			}
			
			else if(impPers1convo1 ==2){
				System.out.println(impPers1 + ": HEY, no need to be rude!!!");
				break;
			}
			
			else if(impPers1convo1 ==3){
				System.out.println(impPers1 + ": Jeez, Kramer has you beat huh?");
				break;
			}
			
			else if(impPers1convo1 ==4){
				System.out.println(impPers1 + ": What? Stop joking around " + player.getName() + "!");
				break;
			}
			else 
				errMsg();
				impPers1convo1 = kb.nextInt();
		}
		
		} //while escaping
		System.out.println("######################");
		System.out.println("Thank you for playing!");
		System.out.println("######################");
}	
}
