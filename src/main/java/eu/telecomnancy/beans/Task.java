package eu.telecomnancy.beans;

/**
 * Class Task reprent a Task
 * 
 * @author Terry
 */
public class Task {
    /** execution time in sec */
    private int time;
    /**
     * Constructor to create a new Task (execution time = 0)
     * 
     */
    public Task(){
        this.time=0;
    }
    
    /**
     * Constructor to create a new Task
     * 
     * @param newTime time in sec
     */
    public Task(int newTime) {
        this.time=newTime;
    }
    
    /**
     * Getter time of the Task
     * 
     * @return time in sec
     */
    public int getTime() {
        return time;
    }

    /**
     * Setter time of the Task
     * 
     * @param time in sec 
     */ 
    public void setTime(int time) {
        this.time = time;
    }
    
}
