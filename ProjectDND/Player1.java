package ProjectDND;

public class Player1 {

	private String name;
	private int age;
	private String gender;
	private String majName;
	private Majors major;
	private String lifeline1;
	private String lifeline2;
	
	Player1(String Pgen, String Pnam, int Page, String Pmaj, String life1, String life2){
	
		gender = Pgen;
		name = Pnam;
		age = Page;
		lifeline1 = life1;
		lifeline2 = life2;
		majName = Pmaj;
		
		
		chooseMajor();
	}
	
	//switch method for user entries when inputing major 
	public void chooseMajor()
	{
		switch(majName) {
		case "CS":
		case "cs":
			major = new compSci();
		}
		
		switch(majName) {
		case "BUS":
		case "bus":
			major = new business();
		}
		
		switch(majName) {
		case "ECO":
		case "eco":
			major = new economics();
		}
		
		switch(majName) {
		case "ATH":
		case "ath":
			major = new physTher();
		}
		
		switch(majName) {
		case "POL":
		case "pol":
			major = new politics();
		}
		
		switch(majName) {
		case "NUR":
		case "nur":
			major = new nursing();
		}
		
		switch(majName) {	
		case "BIO":
		case "bio":
			major = new biology();
		}
	}
	
	//GETTERS
	public String getLifeline2(String impPers2)
	{
		return lifeline2;
	}
	public String getLifeline1(String impPers1)
	{
		return lifeline1;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public String getGender()
	{
		return gender;
	}
	public String getMajor()
	{
		return majName;
	}
	public void major()
	{
		System.out.println("INT is " + major.INT 
				+ "\nSTR is " + major.STR
				+ "\nCHR is " + major.CHR
				+ "\nWSD is " + major.WSD
				+ "\nDEX is " + major.DEX
				+ "\nEND is " + major.END);
		
	}
	public void PrintInfo()
	{
		System.out.println("You are a " + this.gender+"."
				+ "\nYour name is " + this.name+"."
				+ "\nYou are " + this.age+"."
				+ "\nYour major is " + majName+".");
	}
}
	

