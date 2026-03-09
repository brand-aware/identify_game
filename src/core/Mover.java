package core;
/**
 * @author wontzer
 * 
 * product of - brand-aware
 * 2017
 */
public class Mover implements Runnable{
	
	Properties properties;
	
	public Mover(Properties p){
		properties = p;
	}
	
	@Override
	public void run(){
		// always check for possible animation while application is running
		while(true){
			try {
				// break to make movements visible to the human eye
				Thread.sleep(75);
				// if an animation is needed it is performed here
				properties.getBoard().doMove();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
