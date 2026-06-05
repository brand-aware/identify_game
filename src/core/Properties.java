package core;
/**
 * @author wontzer
 * 
 * product of - brand-aware
 * 2017
 */
import java.io.File;
import java.net.URL;

public class Properties {
	
	private URL logo;
	private String imageDir;
	private String highScores;
	private Board board;
	private String rootDir;
	private URL background;
	private URL company;
	
	/**
	 * Set locations of game images
	 * 
	 * @param String root
	 */
	public Properties(String root){
		rootDir = root;
		imageDir = rootDir + File.separator + "img";
		//logo = imageDir + File.separator + "logo.png";
		logo = getClass().getResource("/img/logo.png");
		highScores = rootDir + File.separator + "bin" + File.separator + "highScores.txt";
		//background = imageDir + File.separator + "background.png";
		background = getClass().getResource("/img/background.png");
		//company = imageDir + File.separator + "company.png";
		company = getClass().getResource("/img/company.png");
	}
	
	public String getRootDir(){
		return rootDir;
	}
	public URL getLogoPath(){
		return logo;
	}
	public URL getBackground(){
		return background;
	}
	public URL getCompany(){
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
