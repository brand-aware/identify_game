/**
 * 
 * @author mike802
 *
 * brand_aware
 * ??? - 2019
 * 
 */
package core;

public class ConfigBoard {
	
	protected final int LOGO_WIDTH = 327;
	protected final int LOGO_HEIGHT = 85;
	
	protected final int START_BUTTON_WIDTH = 100;
	protected final int START_BUTTON_HEIGHT = 30;
			
	protected final int STOP_BUTTON_WIDTH = 100;
	protected final int STOP_BUTTON_HEIGHT = 30;
	
	protected final int LEVEL_LABEL_WIDTH = 37;
	protected final int LEVEL_LABEL_HEIGHT = 30;
	
	protected final int LEVEL_DISPLAY_WIDTH = 75;
	protected final int LEVEL_DISPLAY_HEIGHT = 30;
	
	protected final int PREVIOUS_LABEL_WIDTH = 65;
	protected final int PREVIOUS_LABEL_HEIGHT = 30;
	
	protected final int PREVIOUS_DISPLAY_WIDTH = 75;
	protected final int PREVIOUS_DISPLAY_HEIGHT = 30;
	
	protected final int AVERAGE_LABEL_WIDTH = 65;
	protected final int AVERAGE_LABEL_HEIGHT = 30;
	
	protected final int AVERAGE_DISPLAY_WIDTH = 75;
	protected final int AVERAGE_DISPLAY_HEIGHT = 30;
	
	protected final int TIMER_LABEL_WIDTH = 40;
	protected final int TIMER_LABEL_HEIGHT = 30;
	
	protected final int TIMER_DISPLAY_WIDTH = 75;
	protected final int TIMER_DISPLAY_HEIGHT = 30;
	
	//game display board ( 10 x 10 )
	protected final int BLOCK_BUTTON_WIDTH = 47;
	protected final int BLOCK_BUTTON_HEIGHT = 25;
	
	//game navigation components
	protected int currentX, currentY, totalX, totalY;

	protected int width = 10;
	protected int height = 10;
	
	protected void calcTotalX(){
		totalX = 15;
		totalX += LEVEL_DISPLAY_WIDTH + 5;
		totalX += LEVEL_LABEL_WIDTH + 5;
		totalX += PREVIOUS_DISPLAY_WIDTH + 5;
		totalX += PREVIOUS_LABEL_WIDTH + 5;
		totalX += AVERAGE_DISPLAY_WIDTH + 5;
		totalX += AVERAGE_LABEL_WIDTH + 5;
		totalX += TIMER_DISPLAY_WIDTH + 5;
		totalX += TIMER_LABEL_WIDTH + 5;
		totalX += 25;
	}
	
	protected int calcBoardX(){
		int boardX = width * BLOCK_BUTTON_WIDTH;
		boardX += (width - 1) * 5;
		boardX += 15 * 2;
		return boardX;
	}
	
	protected void calcTotalY(){
		totalY = 5;
		totalY += LOGO_HEIGHT;
		totalY += 10;
		totalY += START_BUTTON_HEIGHT + 10;
		totalY += LEVEL_LABEL_HEIGHT + 10;
		totalY += (BLOCK_BUTTON_HEIGHT * height) + (10 * (height - 1));
		totalY += 15;
	}

}
