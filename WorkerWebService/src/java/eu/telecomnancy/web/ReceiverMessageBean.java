/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy.web;

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
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/CallbackQueue"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/CallbackQueue"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/CallbackQueue")
})

public class ReceiverMessageBean implements MessageListener {

    @EJB
    Synchronization sync;

    public ReceiverMessageBean() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage tm = (TextMessage) message;
            System.out.println("Task (" + tm.getText() + ") : done ! ");
            String[] message_parsed = tm.getText().split("%%");
            sync.setId(Integer.valueOf(message_parsed[0]));
            sync.setDuration(Long.valueOf(message_parsed[1]));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
