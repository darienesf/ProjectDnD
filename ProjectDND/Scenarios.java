package ProjectDND;

public class Scenarios {

	private int scenarioNum;
	private Scenarios scenario;
	Player1 player;
	private Scenarios(int newScenario){
		scenarioNum = newScenario;
		SceneChoice();
	}
	
	public void SceneChoice()
	{
		switch(scenarioNum){
		case 1: 
			System.out.println(player.getName()+ "You wake up in a dark room");
		}
	}
	
}
