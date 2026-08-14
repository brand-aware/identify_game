package com.identify_game.core;
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
	private Board board;
	private URL background;
	private URL company;
	
	/**
	 * Set locations of game images
	 * 
	 * @param String root
	 */
	public Properties(){
		imageDir = "/com/identify_game/img/";
		logo = getClass().getResource(imageDir + "logo.png");
		background = getClass().getResource(imageDir + "background.png");
		String companyPath = imageDir + "company.png";
		System.out.println(companyPath);
		company = getClass().getResource(companyPath);
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
