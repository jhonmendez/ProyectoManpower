/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.test;

import edu.cecar.controladores.ControladorExample;
import edu.cecar.modelos.Empleado;
import edu.cecar.modelos.Example;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 92531165
 */
public class TestControladorExample {
    
    public static void main(String[] args) {
        
        try {
            ControladorExample controladorExample =
                    new ControladorExample();
            TreeSet<Example> examples =
                    controladorExample.
                            consultarEmpleados();
            
            examples.stream().filter(
              
                    e -> e.getGender().equals("M") &&
                         e.getFatal().equals("Yes")
                    
            ).sorted(
                    Comparator.
                            comparing(Example::
                                    getDate_of_stop)).forEach( e ->
                                    
                                     System.out.println("Date" +
                    e.getDate_of_stop() + 
                    " Gender:" +
                     e.getGender()));
                    
            

                    
        
        } catch (SQLException ex) {
            Logger.getLogger(TestControladorExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
              /*  examples.stream().filter(
                e -> 
                    e.getGender().equals("F") && e.getFatal().e
            ).sorted(Comparator.comparing(Example::getDate_of_stop).reversed()).
                    forEach(e -> 
                    System.out.println("Date" +
                    e.getDate_of_stop() + 
                    " Gender:" + e.getGender())
              */
    
}




  