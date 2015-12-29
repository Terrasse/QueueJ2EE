/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy.web;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author Terry
 */
@Named(value = "senderJSFManagedBean")
@RequestScoped
public class SenderJSFManagedBean {

    @Resource(mappedName = "jms/SenderQueue")
    private Queue senderQueue;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    private String message;

    /**
     * Creates a new instance of SenderJSFManagedBean
     */
    public SenderJSFManagedBean() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void send() {
        sendJMSMessageToSenderQueue(this.message);
        System.out.println("Message : " + this.message);
    }

    private void sendJMSMessageToSenderQueue(String messageData) {
        context.createProducer().send(senderQueue, messageData);
    }

}
