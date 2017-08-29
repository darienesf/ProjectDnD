package ProjectDND;

public class Playgame<Story> {

	private Story story1;

	public Story getStory() {
		return story1;
	}

	public void setStory(Story story1) {
		this.story1 = story1;
	}
	
	public static String printCampaign(){
		String s = "You wake up in a dark room..." + System.currentTimeMillis();
		return s;
		
	}
	
}
system.out.println("hello");
