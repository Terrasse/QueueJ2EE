package eu.telecomnancy.beans;

/**
 * @Copyright T.Dervaux, C.Guyomard, F.Rebaudo all licences
 * @Authors T.Dervaux, C.Guyomard, F.Rebaudo
 * @Version 1.0
 */
/**
 * Class Task reprent a Task
 *
 * @author T.Dervaux, C.Guyomard, F.Rebaudo
 */
public class Task {

    /**
     * execution workload in sec
     */
    private int workload;

    /**
     * unique identifier
     */
    private int id;

    /**
     * starting time
     */
    private long time_start;

    /**
     * ending time
     */
    private long time_end;

    /**
     * Constructor to create a new Task (execution workload = 0)
     *
     */
    public Task() {
        this.workload = 0;
    }

    /**
     * Constructor to create a new Task with a int
     *
     * @param duration workload in sec
     */
    public Task(int id, int duration, int time_start, int time_end) {
        this.workload = duration;
        this.id = id;
        this.time_end = time_end;
        this.time_start = time_start;
    }

    /**
     * Constructor to create a new Task with a String(UTF-8)
     *
     * @param newTimeString String formatted workload%%id%%time_start%%time_end
     */
    public Task(String task_string) {

        String[] r = task_string.split("%%");

        this.workload = Integer.parseInt(r[0]);
        this.id = Integer.parseInt(r[1]);
        this.time_start = Long.parseLong(r[2]);
        this.time_end = Long.parseLong(r[3]);

        System.out.println("eu.telecomnancy.business.WorkerSessionBean.doWork() : TOTOTOOTOTOTOTO");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter workload of the Task
     *
     * @return workload in ms
     */
    public int getWorkload() {
        return workload;
    }

    /**
     * Setter workload of the Task
     *
     * @param time in ms
     */
    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public long getTime_start() {
        return time_start;
    }

    public void setTime_start(long time_start) {
        this.time_start = time_start;
    }

    public long getTime_end() {
        return time_end;
    }

    public void setTime_end(long time_end) {
        this.time_end = time_end;
    }
}
