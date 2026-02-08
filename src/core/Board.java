package core;
/**
 * @author mike802
 * 
 * product of - ???
 * 2017
 */

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import balogging.BALoggerUtil;
import highscores.HighScores;
import highscores.IBoardOutline;
import highscores.NameInput;
import highscores.hsProperties;

public class Board extends CommonBoard implements IBoardOutline{
	
	private ButtonHandler handler;
	private MenuListener menuListener;
	
	private final String PRODUCT_NAME = "identify_game";
	private String userDir;
	
	public Board(Properties prop, String usrDir){
		properties = prop;
		userDir = usrDir;
		properties.setBoard(this);
		balogger = new BALoggerUtil(properties.getRootDir(), PRODUCT_NAME, userDir);
		
		desktopPane = new JDesktopPane();
		blocks = new ArrayList<JButton>();
		handler = new ButtonHandler();
		menuListener = new MenuListener();
	}
	
	private void createBoard(){
		boardPage = new JFrame("identify_game");
		boardPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boardPage.setLocation(200, 100);
		String imageDir = properties.getImageDir();
		Image logo = Toolkit.getDefaultToolkit().getImage(imageDir + File.separator + "company.png");
		boardPage.setIconImage(logo);
		boardPage.setResizable(false);
		
		menuBar = new JMenuBar();
		fileMenu = new JMenu("file");
		optionsMenu = new JMenu("options");
		helpMenu = new JMenu("help");
		difficultyMenu = new JMenu("difficulty");
		
		exit = new JMenuItem("exit");
		exit.addActionListener(menuListener);
		quick = new JMenuItem("short");
		quick.addActionListener(menuListener);
		normal = new JMenuItem("normal");
		normal.addActionListener(menuListener);
		slow = new JMenuItem("long");
		slow.addActionListener(menuListener);
		/*load = new JMenuItem("import");
		load.addActionListener(menuListener);
		save = new JMenuItem("export");
		save.addActionListener(menuListener);
		delete = new JMenuItem("delete");
		delete.addActionListener(menuListener);*/
		about = new JMenuItem("about");
		about.addActionListener(menuListener);
		
		//fileMenu.add(save);
		//fileMenu.add(load);
		fileMenu.add(exit);
		optionsMenu.add(difficultyMenu);
		difficultyMenu.add(quick);
		difficultyMenu.add(normal);
		difficultyMenu.add(slow);
		helpMenu.add(about);
		
		menuBar.add(fileMenu);
		menuBar.add(optionsMenu);
		menuBar.add(helpMenu);
		boardPage.setJMenuBar(menuBar);
		
		calcTotalX();
		calcTotalY();
		
		boardPage.setPreferredSize(new Dimension(totalX, totalY));
		JLabel backgroundImage = new JLabel();
		backgroundImage.setIcon(new ImageIcon(properties.getBackground()));
		backgroundImage.setBounds(0, 0, totalX, totalY);
		
		currentX = (totalX / 2) - (LOGO_WIDTH / 2) - 15;
		ImageIcon title = new ImageIcon(properties.getLogoPath());
		JLabel titleLabel = new JLabel();
		titleLabel.setIcon(title);
		titleLabel.setBounds(currentX, 5, LOGO_WIDTH, LOGO_HEIGHT);
		
		currentY = 5 + LOGO_HEIGHT + 10;
		currentX = (totalX / 2) - ((START_BUTTON_WIDTH + 5 + STOP_BUTTON_WIDTH) / 2) - 10;
		
		startButton = new JButton("start");
		startButton.setBounds(currentX, currentY, START_BUTTON_WIDTH, START_BUTTON_HEIGHT);
		startButton.addActionListener(handler);
		
		currentX += 100 + 5;
		stop = new JButton("stop");
		stop.setBounds(currentX, currentY, STOP_BUTTON_WIDTH, STOP_BUTTON_HEIGHT);
		stop.addActionListener(handler);
		stop.setEnabled(false);
		currentY += 30 + 10;
		
		currentX = 15;
		JLabel levelLabel = new JLabel("level: ");
		levelLabel.setBounds(currentX, currentY, LEVEL_LABEL_WIDTH, LEVEL_LABEL_HEIGHT);
		currentX += LEVEL_LABEL_WIDTH + 5;
		levelDisplay = new JTextField();
		levelDisplay.setBounds(currentX, currentY, LEVEL_DISPLAY_WIDTH, LEVEL_DISPLAY_HEIGHT);
		levelDisplay.setText("--");
		levelDisplay.setEditable(false);
		
		
		currentX += LEVEL_DISPLAY_WIDTH + 5;
		JLabel previousLabel = new JLabel("previous: ");
		previousLabel.setBounds(currentX, currentY, PREVIOUS_LABEL_WIDTH, PREVIOUS_LABEL_HEIGHT);
		currentX += PREVIOUS_LABEL_WIDTH + 5;
		previous = new JTextField();
		previous.setBounds(currentX, currentY, PREVIOUS_DISPLAY_WIDTH, PREVIOUS_DISPLAY_HEIGHT);
		previous.setText("--");
		previous.setEditable(false);
		
		currentX += PREVIOUS_DISPLAY_WIDTH + 5;
		JLabel avgLabel = new JLabel("average: ");
		avgLabel.setBounds(currentX, currentY, AVERAGE_LABEL_WIDTH, AVERAGE_LABEL_HEIGHT);
		currentX += AVERAGE_LABEL_WIDTH + 5;
		avg = new JTextField();
		avg.setBounds(currentX, currentY, AVERAGE_DISPLAY_WIDTH, AVERAGE_DISPLAY_HEIGHT);
		avg.setText("--");
		avg.setEditable(false);
		
		
		currentX += AVERAGE_DISPLAY_WIDTH + 5;
		JLabel timerLabel = new JLabel("timer: ");
		timerLabel.setBounds(currentX, currentY, TIMER_LABEL_WIDTH, TIMER_LABEL_HEIGHT);
		currentX += TIMER_LABEL_WIDTH + 5;
		timer = new JTextField();
		timer.setBounds(currentX, currentY, TIMER_DISPLAY_WIDTH, TIMER_DISPLAY_HEIGHT);
		timer.setText("--");
		timer.setEditable(false);		
		currentY += LEVEL_DISPLAY_HEIGHT + 10;
		
		setLevel();
		
		int size = width * height;
		int position = (int) (Math.random() * size);
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				JButton block = new JButton();
				if(((x * width) + y) == position){
					block.setText(objective);
				}else{
					String display = selectBackground();
					block.setText(display);
				}
				block.addActionListener(handler);
				blocks.add(block);
			}
		}
		disableBoard();
		
		desktopPane.add(backgroundImage);
		desktopPane.add(titleLabel);
		desktopPane.add(startButton);
		desktopPane.add(stop);
		desktopPane.add(levelLabel);
		desktopPane.add(levelDisplay);
		desktopPane.add(previousLabel);
		desktopPane.add(previous);
		desktopPane.add(avgLabel);
		desktopPane.add(avg);
		desktopPane.add(timerLabel);
		desktopPane.add(timer);
		
		desktopPane.moveToFront(titleLabel);
		desktopPane.moveToFront(startButton);
		desktopPane.moveToFront(stop);
		desktopPane.moveToFront(levelLabel);
		desktopPane.moveToFront(levelDisplay);
		desktopPane.moveToFront(previousLabel);
		desktopPane.moveToFront(previous);
		desktopPane.moveToFront(avgLabel);
		desktopPane.moveToFront(avg);
		desktopPane.moveToFront(timerLabel);
		desktopPane.moveToFront(timer);
		
		
		int location = 0;
		int boardX = calcBoardX();
		currentX = (totalX / 2) - (boardX / 2) + 10;
		for(int x = 0; x < height; x++){
			for(int y = 0; y < width; y++){
				blocks.get(location).setBounds(currentX, currentY, BLOCK_BUTTON_WIDTH, BLOCK_BUTTON_HEIGHT);
				desktopPane.add(blocks.get(location));
				desktopPane.moveToFront(blocks.get(location));
				location++;
				currentX += BLOCK_BUTTON_WIDTH + 5;
			}
			currentX = (totalX / 2) - (boardX / 2) + 10;
			currentY += BLOCK_BUTTON_HEIGHT + 5;
		}
		
		boardPage.add(desktopPane);
		boardPage.pack();
		boardPage.setVisible(true);
	}
	
	private class MenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == exit){
				System.exit(0);
			}else if(event.getSource() == quick){
				try {
					repeated = 1;
					end = 2;
					doStop();
					startButton.setEnabled(true);
					stop.setEnabled(false);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(event.getSource() == normal){
				try {
					repeated = 1;
					end = 7;
					doStop();
					startButton.setEnabled(true);
					stop.setEnabled(false);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(event.getSource() == slow){
				try {
					repeated = 3;
					end = 7;
					doStop();
					startButton.setEnabled(true);
					stop.setEnabled(false);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			/*else if(event.getSource() == load){
				
			}else if(event.getSource() == save){
				
			}else if(event.getSource() == delete){
				
			}*/
			else if(event.getSource() == about){
				doAbout();
			}
		}
	}
	
	private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == startButton){
				doStart();
			}else if(event.getSource() == stop){
				try {
					doStop();
					startButton.setEnabled(true);
					stop.setEnabled(false);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				JButton button = (JButton) event.getSource();
				if(button.getText().compareTo(objective) == 0 &&
						level != 0){
					try {
						doIsFound();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(null, 
							"WRONG ANSWER", 
							"incorrect", 
							JOptionPane.PLAIN_MESSAGE, 
							new ImageIcon(properties.getCompany()));
				}
			}
		}
	}
	private final void doStart() {
		balogger.startTimer();
		level++;
		reset();
		levelDisplay.setText(level + "." + count);
		started = true;
		avg.setText("0");
		startButton.setEnabled(false);
		stop.setEnabled(true);
		enableBoard();
	}
	
	private final void doStop() throws IOException{
		if(started) {
			balogger.stopTimer();
			balogger.logScore("", avg.getText());
		}
		level = 0;
		count = 1;
		total = 0;
		levelDisplay.setText("--");
		previous.setText("--");
		avg.setText("--");
		timer.setText("--");
		started = false;
		startCount = 0;
		disableBoard();
		reset();
	}
	
	private final void doIsFound() throws IOException{
		Double elapsedTime = Double.parseDouble(timer.getText());
		previous.setText(elapsedTime + "");
		started = false;
		timer.setText("0");
					
		JOptionPane.showMessageDialog(null, 
				"CONGRATULATIONS, YOU WON!", 
				"correct", 
				JOptionPane.PLAIN_MESSAGE, 
				new ImageIcon(properties.getCompany()));
								
		int position = count + ((level - 1) * repeated);
		double average = (total + elapsedTime) / position;
		DecimalFormat df = new DecimalFormat(".##");
		avg.setText(df.format(average));
		total += elapsedTime;
				
		if(count == repeated){
			level++;
			count = 1;
			levelDisplay.setText(level + "." + count);
		}else{
			count++;
			levelDisplay.setText(level + "." + count);
		}
		if(level > end){
			levelEndReached(average);
		}else{
			reset();
			started = true;
			startCount = 0;
		}
	}
	
	private final void levelEndReached(double average) throws IOException{
		level = 0;
		count = 1;
		previous.setText("--");
		avg.setText("--");
		timer.setText("--");
		levelDisplay.setText("--");
		DecimalFormat df = new DecimalFormat(".##");
		balogger.stopTimer();
		balogger.logScore("", "" + average);
		started = false;
		
		try {
			NameInput nameInput = new NameInput(properties.getRootDir(), properties.getBoard(), PRODUCT_NAME, userDir);
			desktopPane.add(nameInput);
			desktopPane.moveToFront(nameInput);
			disable();
			nameInput.init(Double.parseDouble(df.format(average)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private final void disableBoard(){
		for(int x = 0; x < blocks.size(); x++){
			blocks.get(x).setEnabled(false);
		}
	}
	
	private final void enableBoard(){
		for(int x = 0; x < blocks.size(); x++){
			blocks.get(x).setEnabled(true);
		}
	}
	
	private final void reset(){
		int size = width * height;
		int position = (int) (Math.random() * size);
		setLevel();
		for(int x = 0; x < blocks.size(); x++){
			if(x == position){
				blocks.get(x).setText(objective);
			}else{
				String display = selectBackground();
				blocks.get(x).setText(display);
			}
		}
	}
	
	public synchronized void doMove(){
		if(started){
			if(startCount > 0){
				Long currentTime = System.currentTimeMillis();
				Long difference = currentTime - startTimer;
				Double seconds = difference * .001;
				DecimalFormat df = new DecimalFormat(".##");
				timer.setText(df.format(seconds) + "");
			}else{
				startTimer = System.currentTimeMillis();
				startCount++;
			}
		}
	}
	
	private final void setLevel(){
		if(level == 0){
			background = new ArrayList<String>();
			background.add(levels.getLevel0());
			objective = levels.getLevel0();
		}else if(level == 1){
			background = levels.getLevel1Background();
			objective = levels.getLevel1Objective();
		}else if(level == 2){
			background = levels.getLevel2Background();
			objective = levels.getLevel2Objective();
		}else if(level == 3){
			background = levels.getLevel3Background();
			objective = levels.getLevel3Objective();
		}else if(level == 4){
			background = levels.getLevel4Background();
			objective = levels.getLevel4Objective();
		}else if(level == 5){
			background = levels.getLevel5Background();
			objective = levels.getLevel5Objective();
		}else if(level == 6){
			background = levels.getLevel6Background();
			objective = levels.getLevel6Objective();
		}else if(level == 7){
			background = levels.getLevel7Background();
			objective = levels.getLevel7Objective();
		}
	}
	
	private final String selectBackground(){
		int size = background.size();
		String selected = "";
		int index = (int)(Math.random() * size);
		selected = background.get(index);
		
		return selected;
	}
	
	public final void init(){
		if(boardPage == null){
			levels = new Levels();
			createBoard();
		}else{
			restart();
		}
	}
	
	private void restart(){
		boardPage.setVisible(true);
		reset();
		startCount = 0;		
	}
	
	private final void doAbout() {
		JOptionPane.showMessageDialog(null, 
				"identify_game\nproduct of  - ???  -  2017"
				+ "\n\ncontact\nmike.drummond.802@hotmail.com\n\n", 
				"about", 
				JOptionPane.PLAIN_MESSAGE, 
				new ImageIcon(properties.getCompany()));
	}

	@Override
	public void enable() {
		startButton.setEnabled(true);
		stop.setEnabled(false);
	}
	
	private void disable() throws IOException{
		startButton.setEnabled(false);
		stop.setEnabled(false);
		doStop();
	}

	@Override
	public void initHighScores(hsProperties props) {
		HighScores highScores = new HighScores(this);
		try {
			highScores.setSmallBoard1();
			highScores.init(props);
			highScores.setSmallBoard2();
			desktopPane.add(highScores);
			desktopPane.moveToFront(highScores);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void initHighScores(String name, String rank, int score, hsProperties props) {
		HighScores highScores = new HighScores(this);
		try {
			highScores.setSmallBoard1();
			highScores.init(name, rank, score, props);
			highScores.setSmallBoard2();
			desktopPane.add(highScores);
			desktopPane.moveToFront(highScores);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getFrameHeight() {
		return totalY;
	}

	@Override
	public int getFrameWidth() {
		return totalX;
	}
}