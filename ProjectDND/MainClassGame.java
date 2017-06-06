package ProjectDND;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MainClassGame {
	public static void exit(){
		System.out.println("exit successful");
	}
	public static void seperator(){
		System.out.println("----------------------------------------");
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
		INTRO:
		while(intro){
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
		INTRO2:
		while(intro2){
		seperator();
		System.out.println(player.getName() + " it is time to get up...");
		System.out.println(df.format(dateobj));
		System.out.println("\nObjective:\nCheck your phone.\nType in 'help' for help.");
		boolean exit = true;
		if(exit){break;}
		else{continue INTRO2;}
		}
		
		ESCAPEROOM:
		while(escaping){
		int chance = dice.nextInt(20);
		String impPers1 = null;
		boolean convo1 = false;
		String escapeRoom = kb.nextLine();
		
		switch(escapeRoom){
		 case "help":
			 System.out.println("type in 'get phone'");
		}
		
		switch(escapeRoom){
			case "get phone":
			 System.out.println("You take your phone out of your pocket... You have 47 missed calls from..."
					 + "\n(enter the name of the first person that comes to mind)");
			 impPers1 = kb.nextLine();
			 player.getLifeline1(impPers1);
			 System.out.println("Are you going to call " + impPers1 + " back?"
					 + "\n1. Yes"
					 + "\n2. No");
			int callPers = kb.nextInt();
			if(callPers==1){
 			 
			if (chance>=15){
 				 System.out.println(impPers1+": Hey, " + player.getName() + " where have you been?\nYou've been gone since Sunday!");
 				 break;
 			 } //chance If
 			 else if(chance<14 && chance>9){
 				 System.out.println(impPers1+": H%$#, *&(@, 18zaa, Mnz19000");
 				 System.out.println("Voice: The signal seems bad, try moving around.(Type in 'move' to see what happens)");
 				 String enterMove = kb.next();
				System.out.println("Good job, the signal is getting stronger!");
				System.out.println(impPers1+": Hey, " + player.getName() + " where have you been?\nYou've been gone since Sunday!");
				break;
 			 } //chance elseIf 
 			 else { 
 				System.out.println("Voice: You actually have no service... what are the odds!");
				 break;
 			 } //chance else
			 } //callpers If
			 } //getphoneCase switch
		if(!convo1 == true){
			int impPers1convo1;
			System.out.println(">Voice:What is your response?"
					+ "\n1. My phone has been dead since, I'm sorry!"
					+ "\n2. None of your business, why did you call me so much?"
					+ "\n3. I was studying for exams."
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
				System.out.println(impPers1 + ": What? Stop playing games" + player.getName() + ".");
				break;
			}
			else 
				System.err.println("Error, please enter a digit from 1-4");
		}
		
		} //while escaping
}	
}