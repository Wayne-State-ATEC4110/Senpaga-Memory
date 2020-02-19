
public class StopWatch {

	long begin; 
	
	public void initialize() {
        begin = System.currentTimeMillis();
    } 
	
	 public void setTime() {
	        long now = System.currentTimeMillis();
	        //System.out.println((now - begin) / 1000.0 + " seconds");
	        double stopTime = (now - begin) / 1000.0;
	    }
}
