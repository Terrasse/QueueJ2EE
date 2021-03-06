/**
 * @Copyright T.Dervaux, C.Guyomard, F.Rebaudo all licences
 * @Authors T.Dervaux, C.Guyomard, F.Rebaudo
 * @Version 1.0
 */
package eu.telecomnancy.webservice;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Named(value = "senderJSFManagedBean")
@RequestScoped
public class WorkSenderJSFManagedBean {

    @EJB
    SynchronizationSingleton sync;

    @Resource(mappedName = "jms/SenderQueue")
    private Queue senderQueue;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    private String message;

    private String result = "Waiting for task";

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Creates a new instance of SenderJSFManagedBean
     */
    public WorkSenderJSFManagedBean() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void send() {
        int expectedId = (int) (Math.random() * 100000);
        sendJMSMessageToSenderQueue(message + "%%" + expectedId + "%%" + System.currentTimeMillis() + "%%0");
        while (sync.getId() != expectedId) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.result = "Work(id=" + sync.getId() + ";workload=" + message + "ms) -> done in " + sync.getDuration() + " ms";
    }

    private void sendJMSMessageToSenderQueue(String messageData) {
        context.createProducer().send(senderQueue, messageData);
    }

}
