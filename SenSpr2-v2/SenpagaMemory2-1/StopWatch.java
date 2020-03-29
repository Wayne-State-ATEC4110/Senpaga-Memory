//author: Ervin Colston


public class StopWatch {

	long begin; 
	double seconds;
	
	public void initialize() {
        begin = System.currentTimeMillis();
    } 
	
	 public void setTime() {
	        long now = System.currentTimeMillis();
	        //System.out.println((now - begin) / 1000.0 + " seconds");
	        double stopTime = (now - begin) / 1000.0;
	        this.seconds = stopTime;
	    }
	 
	
}
