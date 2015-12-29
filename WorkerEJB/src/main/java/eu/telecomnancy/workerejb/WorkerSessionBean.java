package eu.telecomnancy.workerejb;

/**
 * @Copyright  T.Dervaux, C.Guyomard, F.Rebaudo all licences
 * @Authors T.Dervaux, C.Guyomard, F.Rebaudo
 * @Version 1.0
 */


import eu.telecomnancy.beans.Task;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Stateless EJB without interface Represent a Worker that execute a Task
 *
 * @author TODO
 */
@Stateless
@LocalBean
public class WorkerSessionBean {

    /**
     * Business methode that execute a Task
     *
     * @param task
     */
    public void doWork(Task task) {
        try {
            System.out.println("Start executing Task");
            Thread.sleep(task.getTime() * 1000);
            System.out.println("Task done !");
        } catch (InterruptedException e) {
            System.out.println("eu.telecomnancy.workerejb.WorkerSessionBean.doWork()");
            e.printStackTrace();
        }

    }

}
