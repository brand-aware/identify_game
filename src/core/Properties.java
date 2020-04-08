package core;
/**
 * @author mike802
 * 
 * product of - ???
 * 2017
 */
import java.io.File;

public class Properties {
	
	private String logo;
	private String imageDir;
	private String highScores;
	private Board board;
	private String rootDir;
	private String background;
	private String company;
	
	public Properties(String root){
		rootDir = root;
		imageDir = rootDir + File.separator + "img";
		logo = imageDir + File.separator + "logo.png";
		highScores = rootDir + File.separator + "bin" + File.separator + "highScores.txt";
		background = imageDir + File.separator + "background.png";
		company = imageDir + File.separator + "company.png";
	}
	
	public String getRootDir(){
		return rootDir;
	}
	public String getLogoPath(){
		return logo;
	}
	public String getBackground(){
		return background;
	}
	public String getCompany(){
		return company;
	}
	public String getHighScorePath(){
		return highScores;
	}
	public String getImageDir(){
		return imageDir;
	}
	public void setBoard(Board brd){
		board = brd;
	}
	public Board getBoard(){
		return board;
	}
}
