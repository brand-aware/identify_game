/**
 * @author wontzer
 * 
 * product of - brand-aware
 * 2017
 */
import core.Board;
import core.Mover;
import core.Properties;

public class driver {

	public static void main(String[] args) {
		String currentDir = System.getProperty("user.dir");
		Properties properties = new Properties(currentDir);
		Board game = new Board(properties);
		properties.setBoard(game);
		Mover mover = new Mover(properties);
		Thread thread = new Thread(mover);
		thread.start();
		game.init();
	}
}
