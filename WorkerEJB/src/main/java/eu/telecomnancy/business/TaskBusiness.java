/**
 * @Copyright  T.Dervaux, C.Guyomard, F.Rebaudo all licences
 * @Authors T.Dervaux, C.Guyomard, F.Rebaudo
 * @Version 1.0
 */
package eu.telecomnancy.business;

import eu.telecomnancy.beans.Task;

/**
 *
 * @author Terry
 */
public class TaskBusiness {

    /**
     * Business methode that compute the processing time of a Task
     *
     * @param t Task
     * @return duration in ms
     */
    public static long processingTime(Task t) {
        return t.getTime_end() - t.getTime_start();
    }

    public static String toString(Task t) {
        return t.getWorkload() + "&&" + t.getId() + "&&" + t.getTime_start() + "&&" + t.getTime_end();
    }
}
