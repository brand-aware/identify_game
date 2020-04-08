/**
 * @author mike802
 * 
 * product of - ???
 * 2017
 */
import core.Board;
import core.Mover;
import core.Properties;

public class driver {

	public static void main(String[] args) {
		if(args.length != 1){
			System.exit(0);
		}
		Properties properties = new Properties(args[0]);
		Board game = new Board(properties);
		properties.setBoard(game);
		Mover mover = new Mover(properties);
		Thread thread = new Thread(mover);
		thread.start();
		game.init();
	}
}
