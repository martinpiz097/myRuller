/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.myRuller.model;

import java.io.Serializable;
import org.joda.time.DateTime;


/**
 *
 * @author martin
 */
public class Menstruation implements Serializable{
    private static final long MILLIS_X_DAY = 24*60000;

    private int id;
    private final DateTime startDay;
    private final DateTime[] ovulationDays;
    private DateTime endDay;
    private int sexDays;
    private boolean isFinished;
    private int idClient;
    
    public Menstruation(int id, int idClient) {
        this(id, DateTime.now(), idClient);
    }

    public Menstruation(int id, DateTime startDay, int idClient) {
        this.id = id;
        this.startDay = startDay;
        ovulationDays = new DateTime[3];
        long millisOvulation = startDay.getMillis()+(MILLIS_X_DAY*13);
        ovulationDays[0] = new DateTime(millisOvulation);
        ovulationDays[1] = new DateTime(ovulationDays[0].getMillis()+MILLIS_X_DAY);
        ovulationDays[2] = new DateTime(ovulationDays[0].getMillis()+(MILLIS_X_DAY*2));
        endDay = null;
        isFinished = false;
        this.idClient = idClient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DateTime getStartDay() {
        return startDay;
    }

    public DateTime[] getOvulationDays() {
        return ovulationDays;
    }
    
    public void finalize(DateTime finishDate){
        endDay = finishDate;
        isFinished = true;
    }

    public DateTime getEndDay() {
        return endDay;
    }

    public void setEndDay(DateTime endDay) {
        this.endDay = endDay;
    }

    public int getSexDays() {
        return sexDays;
    }

    public void setSexDays(int sexDays) {
        this.sexDays = sexDays;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public int getIdClient() {
        return idClient;
    }
    
}
