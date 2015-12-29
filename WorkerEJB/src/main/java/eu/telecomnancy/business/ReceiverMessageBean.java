/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author Terry
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/SenderQueue")
})
public class ReceiverMessageBean implements MessageListener {

    @EJB
    protected WorkerSessionBean worker;

    public ReceiverMessageBean() {
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
