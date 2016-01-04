/**
 * @Copyright T.Dervaux, C.Guyomard, F.Rebaudo all licences
 * @Authors T.Dervaux, C.Guyomard, F.Rebaudo
 * @Version 1.0
 */
package eu.telecomnancy.business;

import eu.telecomnancy.beans.Task;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/SenderQueue")
})
public class WorkReceiverMessageBean implements MessageListener {

    @EJB
    protected WorkerSessionBean worker;

    public WorkReceiverMessageBean() {
    }

    @Override
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            System.out.println("message receive : " + tm.getText());
            worker.doWork(new Task(tm.getText()));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
