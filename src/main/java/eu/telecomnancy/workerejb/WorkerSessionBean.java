/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy.workerejb;

import eu.telecomnancy.beans.Task;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Terry
 */
@Stateless
@LocalBean
public class WorkerSessionBean {

    public void doWork(Task task) {
        Thread.sleep(task.getTime()*1000);
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
