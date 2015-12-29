/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy.web;

import javax.annotation.Resource;
import javax.ejb.EJB;
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

    @EJB
    Synchronization sync;

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
    public SenderJSFManagedBean() {
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
