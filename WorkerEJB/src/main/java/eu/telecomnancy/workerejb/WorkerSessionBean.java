package eu.telecomnancy.workerejb;

/**
 * @Copyright T.Dervaux, C.Guyomard, F.Rebaudo all licences
 * @Authors T.Dervaux, C.Guyomard, F.Rebaudo
 * @Version 1.0
 */
import eu.telecomnancy.beans.Task;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Topic;

/**
 * Stateless EJB without interface Represent a Worker that execute a Task
 *
 * @author TODO
 */
@Stateful
@LocalBean
public class WorkerSessionBean {

    @Resource(mappedName = "jms/CallbackQueue")
    private Topic callbackQueue;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    /**
     * Business methode that execute a Task
     *
     * @param task
     */
    public void doWork(Task task) {
        try {
            System.out.println("Start executing Task");

            Thread.sleep(task.getTime() * 1000);
            sendJMSMessageToCallbackQueue("" + task.getId());
            System.out.println("Task done !");
        } catch (InterruptedException e) {
            System.out.println("eu.telecomnancy.workerejb.WorkerSessionBean.doWork()");
            e.printStackTrace();
        }

    }

    private void sendJMSMessageToCallbackQueue(String messageData) {
        context.createProducer().send(callbackQueue, messageData);
    }

}
