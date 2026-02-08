/**
 * 
 * @author mike802
 *
 * brand_aware
 * ??? - 2019
 * 
 */
package core;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;


public class CommonBoard extends ConfigBoard{
	
	protected Levels levels;
	protected JFrame boardPage = null;
	protected Properties properties;
	protected JDesktopPane desktopPane;
	
	protected JMenuBar menuBar;
	protected JMenu fileMenu, optionsMenu, helpMenu, difficultyMenu;
	protected JMenuItem exit, about, quick, normal, slow; 
	//protected JMenuItem  load, save, delete;
	// mixLevels, changeBkg, customize
	
	protected JButton startButton, stop;
	protected JTextField previous, avg, timer, levelDisplay;
	protected ArrayList<JButton> blocks;
	protected ArrayList<String> background;
	protected String objective;
	
	protected long startTimer = 0;
	protected int startCount = 0;
	protected double total;
	protected boolean started = false;
	
	protected int level = 0;
	protected int repeated = 1;
	protected int end = 2;
	protected int count = 1;

}
