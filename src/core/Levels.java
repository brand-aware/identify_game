package core;
/**
 * @author mike802
 * 
 * product of - ???
 * 2017
 */
import java.util.ArrayList;

public class Levels {
	
	private String level0 = "?";
	
	private String level1_1 = "7";
	private String level1_2 = "1";
	
	private String level2_1 = "9";
	private String level2_2 = "8";
	
	private String level3_1 = "8";
	private String level3_2 = "3";
	
	private String level4_1 = "7";
	private String level4_2 = "V";
	private String level4_3 = "W";
	
	private String level5_1 = "5";
	private String level5_2 = "C";
	private String level5_3 = "3";
	
	private String level6_1 = "6";
	private String level6_2 = "O";
	private String level6_3 = "8";
	private String level6_4 = "G";
	
	private String level7_1 = "t";
	private String level7_2 = "l";
	private String level7_3 = "I";
	private String level7_4 = "1";
	
	
	public Levels(){
		
	}
	
	public String getLevel0(){
		return level0;
	}
	
	public ArrayList<String> getLevel1Background(){
		ArrayList<String> level = new ArrayList<String>();
		level.add(level1_1);
		return level;
	}
	
	public String getLevel1Objective(){
		return level1_2;
	}

	public ArrayList<String> getLevel2Background(){
		ArrayList<String> level = new ArrayList<String>();
		level.add(level2_1);
		return level;
	}
	
	public String getLevel2Objective(){
		return level2_2;
	}
	
	public ArrayList<String> getLevel3Background(){
		ArrayList<String> level = new ArrayList<String>();
		level.add(level3_1);
		return level;
	}
	
	public String getLevel3Objective(){
		return level3_2;
	}
	
	public String getLevel4Objective(){
		return level4_1;
	}
	
	public ArrayList<String> getLevel4Background(){
		ArrayList<String> level = new ArrayList<String>();
		level.add(level4_2);
		level.add(level4_3);
		return level;
	}
	
	public String getLevel5Objective(){
		return level5_1;
	}
	
	public ArrayList<String> getLevel5Background(){
		ArrayList<String> level = new ArrayList<String>();
		level.add(level5_2);
		level.add(level5_3);
		return level;
	}
	
	public String getLevel6Objective(){
		return level6_1;
	}
	
	public ArrayList<String> getLevel6Background(){
		ArrayList<String> level = new ArrayList<String>();
		level.add(level6_2);
		level.add(level6_3);
		level.add(level6_4);
		return level;
	}
	
	public String getLevel7Objective(){
		return level7_1;
	}
	
	public ArrayList<String> getLevel7Background(){
		ArrayList<String> level = new ArrayList<String>();
		level.add(level7_2);
		level.add(level7_3);
		level.add(level7_4);
		return level;
	}
}
