package eu.telecomnancy.beans;

/**
 * @Copyright  T.Dervaux, C.Guyomard, F.Rebaudo all licences
 * @Authors T.Dervaux, C.Guyomard, F.Rebaudo
 * @Version 1.0
 */


import java.io.Serializable;

/**
 * Class Task reprent a Task
 *
 * @author Terry
 */
public class Task implements Serializable {

    /**
     * execution time in sec
     */
    private int time;

    /**
     * Constructor to create a new Task (execution time = 0)
     *
     */
    public Task() {
        this.time = 0;
    }

    /**
     * Constructor to create a new Task with a int
     *
     * @param newTime time in sec
     */
    public Task(int newTime) {
        this.time = newTime;
    }

    /**
     * Constructor to create a new Task with a String(UTF-8)
     *
     * @param newTimeString String time in sec
     */
    public Task(String newTimeString) {
        this.time = Integer.parseInt(newTimeString);
    }

    /**
     * Constructor to create a new Task with an other Task
     *
     * @param otherTask
     */
    public Task(Task otherTask) {
        this.time = otherTask.getTime();
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
