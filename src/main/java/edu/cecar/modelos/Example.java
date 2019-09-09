/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.modelos;

import java.sql.Date;

/**
 *
 * @author 92531165
 */
public class Example {
    
    private Date date_of_stop;
    private String fatal;
    private String alcohol;
    private String gender;

    public Example(Date date_of_stop, String fatal, 
            String alcohol, String gender) {
        
        this.date_of_stop = date_of_stop;
        this.fatal = fatal;
        this.alcohol = alcohol;
        this.gender = gender;
    }

    public Date getDate_of_stop() {
        return date_of_stop;
    }

    public void setDate_of_stop(Date date_of_stop) {
        this.date_of_stop = date_of_stop;
    }

    public String getFatal() {
        return fatal;
    }

    public void setFatal(String fatal) {
        this.fatal = fatal;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
    
    
    
}
