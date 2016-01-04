/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy.webservice;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 *
 * @author Terry
 */
@Singleton
@LocalBean
public class SynchronizationSingleton {

    private int id;
    private long duration;

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
