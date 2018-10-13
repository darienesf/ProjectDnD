package ProjectDND;

public class Majors {

	public String inputMaj;
	protected int INT;
	protected int STR;
	protected int CHR;
	protected int WSD;
	protected int DEX;
	protected int END;
	
	Majors(){
		INT = 5;
		STR = 5;
		CHR = 5;
		WSD = 5;
		DEX = 5;
		END = 5;
	}
	
	public void setInt(int newIntel)
	{
		INT += newIntel;	
	}
	public void setStr(int newStren)
	{
		STR += newStren;
	}
	public void setChari(int newChari)
	{
		CHR += newChari;
	}
	public void setWisdo(int newWisdo)
	{
		WSD += newWisdo;
	}
	public void setDexte(int newDexte)
	{
		DEX += newDexte;
	}
	public void setEndur(int newEndur)
	{
		END += newEndur;
	}
	public String getInputMaj(){
		return inputMaj;
	}
}
