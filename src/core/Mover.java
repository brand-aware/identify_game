package core;
/**
 * @author mike802
 * 
 * product of - ???
 * 2017
 */
public class Mover implements Runnable{
	
	Properties properties;
	
	public Mover(Properties p){
		properties = p;
	}
	
	@Override
	public void run(){
		while(true){
			try {
				Thread.sleep(75);
				properties.getBoard().doMove();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
