/**
 * @author wontzer
 * 
 * product of - brand-aware
 * 2017
 */
import com.identify_game.core.Board;
import com.identify_game.core.Mover;
import com.identify_game.core.Properties;

public class driver {

	public static void main(String[] args) {
		Properties properties = new Properties();
		Board game = new Board(properties);
		properties.setBoard(game);
		Mover mover = new Mover(properties);
		Thread thread = new Thread(mover);
		thread.start();
		game.init();
	}
}
