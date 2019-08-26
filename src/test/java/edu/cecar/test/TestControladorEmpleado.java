package edu.cecar.test;

import edu.cecar.controladores.ControladorEmpleado;
import edu.cecar.modelos.Empleado;
import org.junit.Test;
import org.junit.Assert;


/**
* 
* Clase que realiza los test de las operaciones CRUD.
* 
**/
public class TestControladorEmpleado {
           
    //Información que se inserta de primero.
    Empleado e1 = new Empleado("11028821247", "Melty", "Melromarc", "1999-8-25");;
    Empleado e2 = new Empleado("98041670860", "Mirai", "Sarutobi", "2015-5-16");
    Empleado e3 = new Empleado("12587988568", "Asuna", "Yuki", "2012-10-7");
    Empleado e4 = new Empleado("78798525478", "Naofumi", "Iwatami", "2019-4-12");
    Empleado e5 = new Empleado("78954587455", "Gray", "Fullbuster", "2019-4-12");
    //Información que se utiliza para actualizar.
    Empleado eu1 = new Empleado("11028821247", "María Alejandra", "Atencio Pinto", "1997-6-3");
    Empleado eu2 = new Empleado("98041670860", "Karolay", "Atencio Loreth", "2009-2-4");
    Empleado eu3 = new Empleado("12587988568", "Ailin", "Loreth Galvis", "1980-4-18");
    Empleado eu4 = new Empleado("78798525478", "Juan David", "Atencio Urieta", "1991-10-15");
    Empleado eu5 = new Empleado("78954587455", "Dana Paola", "Granados Loreth", "2006-12-25");
    
    /**
    * 
    * Función que permite testear la conexión a la base de datos.
    * 
    **/
    @Test
    public void testConexionBaseDatos(){
        try {
            ControladorEmpleado c = new ControladorEmpleado();
            System.out.println("Conexión exitosa.");
        } catch (Exception ex) {
            System.err.println("TEST - Error al conectar con la base de datos - Descripción del error: " + ex.getMessage());
        }
    }            
    
    /**
    * 
    * Función que testea la eliminación de todos los registros de la base de datos antes de insertar. 
    * 
    **/
    @Test
    public void testEliminar(){
        ControladorEmpleado c = new ControladorEmpleado();                                                    
        
        c.eliminar(e1.getCodigo());
        c.eliminar(e2.getCodigo());
        c.eliminar(e3.getCodigo());
        c.eliminar(e4.getCodigo());
        c.eliminar(e5.getCodigo());                
        
        testGuardar();
        
        Empleado cep1 = c.consultar(e1.getCodigo());
        Empleado cep2 = c.consultar(e2.getCodigo());
        Empleado cep3 = c.consultar(e3.getCodigo());
        Empleado cep4 = c.consultar(e4.getCodigo());
        Empleado cep5 = c.consultar(e5.getCodigo());  
        
        Assert.assertEquals("El empleado 1 no ha sido eliminado", e1.getCodigo(), cep1.getCodigo());
        Assert.assertEquals("El empleado 2 no ha sido eliminado", e2.getCodigo(), cep2.getCodigo());
        Assert.assertEquals("El empleado 3 no ha sido eliminado", e3.getCodigo(), cep3.getCodigo());
        Assert.assertEquals("El empleado 4 no ha sido eliminado", e4.getCodigo(), cep4.getCodigo());
        Assert.assertEquals("El empleado 5 no ha sido eliminado", e5.getCodigo(), cep5.getCodigo());         
    }
    
    /**
    * 
    * Función que permite testear la inserción después de eliminar los registros.
    * 
    **/
    @Test
    public void testGuardar(){
        ControladorEmpleado c = new ControladorEmpleado();                        
            
        if(c.consultar(e1.getCodigo())==null ||
           c.consultar(e2.getCodigo())==null ||
           c.consultar(e3.getCodigo())==null ||
           c.consultar(e4.getCodigo())==null ||
           c.consultar(e5.getCodigo())==null){
            
            c.guardar(e1);
            c.guardar(e2);
            c.guardar(e3);
            c.guardar(e4);
            c.guardar(e5);            

           Empleado eP1 = c.consultar(e1.getCodigo());
           Empleado eP2 = c.consultar(e2.getCodigo());
           Empleado eP3 = c.consultar(e3.getCodigo());
           Empleado eP4 = c.consultar(e4.getCodigo());
           Empleado eP5 = c.consultar(e5.getCodigo());

           Assert.assertEquals("El codigo no coincide con el insertado",e1.getCodigo(), eP1.getCodigo());
           Assert.assertEquals("El nombre no coincide con el insertado",e1.getNombres(), eP1.getNombres());
           Assert.assertEquals("El apellido no coincide con el insertado",e1.getApellidos(), eP1.getApellidos());
           Assert.assertEquals("La fecha no coincide con la insertada",e1.getFechaNacimiento(), eP1.getFechaNacimiento());
           Assert.assertEquals("El codigo no coincide con el insertado",e2.getCodigo(), eP2.getCodigo());
           Assert.assertEquals("El nombre no coincide con el insertado",e2.getNombres(), eP2.getNombres());
           Assert.assertEquals("El apellido no coincide con el insertado",e2.getApellidos(), eP2.getApellidos());
           Assert.assertEquals("La fecha no coincide con la insertada",e2.getFechaNacimiento(), eP2.getFechaNacimiento());           
           Assert.assertEquals("El codigo no coincide con el insertado",e3.getCodigo(), eP3.getCodigo());
           Assert.assertEquals("El nombre no coincide con el insertado",e3.getNombres(), eP3.getNombres());
           Assert.assertEquals("El apellido no coincide con el insertado",e3.getApellidos(), eP3.getApellidos());
           Assert.assertEquals("La fecha no coincide con la insertada",e3.getFechaNacimiento(), eP3.getFechaNacimiento());           
           Assert.assertEquals("El codigo no coincide con el insertado",e4.getCodigo(), eP4.getCodigo());
           Assert.assertEquals("El nombre no coincide con el insertado",e4.getNombres(), eP4.getNombres());
           Assert.assertEquals("El apellido no coincide con el insertado",e4.getApellidos(), eP4.getApellidos());
           Assert.assertEquals("La fecha no coincide con la insertada",e4.getFechaNacimiento(), eP4.getFechaNacimiento());           
           Assert.assertEquals("El codigo no coincide con el insertado",e5.getCodigo(), eP5.getCodigo());
           Assert.assertEquals("El nombre no coincide con el insertado",e5.getNombres(), eP5.getNombres());
           Assert.assertEquals("El apellido no coincide con el insertado",e5.getApellidos(), eP5.getApellidos());
           Assert.assertEquals("La fecha no coincide con la insertada",e5.getFechaNacimiento(), eP5.getFechaNacimiento());  
        }        
    }
    
    /**
    * 
    * Función que testea las actualizaciones de los registros después de que estos se inserten.
    * 
    **/
    @Test
    public void testEditar(){
        ControladorEmpleado c = new ControladorEmpleado();
        c.actualizar(e1.getCodigo(), eu1);
        c.actualizar(e2.getCodigo(), eu2);
        c.actualizar(e3.getCodigo(), eu3);
        c.actualizar(e4.getCodigo(), eu4);
        c.actualizar(e5.getCodigo(), eu5);
                
        Empleado ceup1 = c.consultar(e1.getCodigo());
        Empleado ceup2 = c.consultar(e1.getCodigo());
        Empleado ceup3 = c.consultar(e1.getCodigo());
        Empleado ceup4 = c.consultar(e1.getCodigo());
        Empleado ceup5 = c.consultar(e1.getCodigo());
                
        Assert.assertNotEquals("El nombre del empleado 1 no ha sido actualizado", e1.getNombres(), ceup1.getNombres());
        Assert.assertNotEquals("El apellido del empleado 1 no ha sido actualizado", e1.getApellidos(), ceup1.getApellidos());
        Assert.assertNotEquals("La fecha de nacimiento del empleado 1 no ha sido actualizado", e1.getFechaNacimiento(), ceup1.getFechaNacimiento());
        Assert.assertNotEquals("El nombre del empleado 2 no ha sido actualizado", e2.getNombres(), ceup2.getNombres());
        Assert.assertNotEquals("El apellido del empleado 2 no ha sido actualizado", e2.getApellidos(), ceup2.getApellidos());
        Assert.assertNotEquals("La fecha de nacimiento del empleado 2 no ha sido actualizado", e2.getFechaNacimiento(), ceup2.getFechaNacimiento());
        Assert.assertNotEquals("El nombre del empleado 3 no ha sido actualizado", e3.getNombres(), ceup3.getNombres());
        Assert.assertNotEquals("El apellido del empleado 3 no ha sido actualizado", e3.getApellidos(), ceup3.getApellidos());
        Assert.assertNotEquals("La fecha de nacimiento del empleado 3 no ha sido actualizado", e4.getFechaNacimiento(), ceup3.getFechaNacimiento());
        Assert.assertNotEquals("El nombre del empleado 4 no ha sido actualizado", e4.getNombres(), ceup4.getNombres());
        Assert.assertNotEquals("El apellido del empleado 4 no ha sido actualizado", e4.getApellidos(), ceup4.getApellidos());
        Assert.assertNotEquals("La fecha de nacimiento del empleado 4 no ha sido actualizado", e4.getFechaNacimiento(), ceup4.getFechaNacimiento());
        Assert.assertNotEquals("El nombre del empleado 5 no ha sido actualizado", e5.getNombres(), ceup5.getNombres());
        Assert.assertNotEquals("El apellido del empleado 5 no ha sido actualizado", e5.getApellidos(), ceup5.getApellidos());
        Assert.assertNotEquals("La fecha de nacimiento del empleado 5 no ha sido actualizado", e5.getFechaNacimiento(), ceup5.getFechaNacimiento());
    }    
}
