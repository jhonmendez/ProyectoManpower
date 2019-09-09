
/**
 * Clase: ControladorEmpleado
 * 
 * @version: 0.1
 *  
 * @since: 12/08/2019
 * 
 * Fecha de ModificaciÃ³n:
 * 
 * @author: Frank Camilo Atencio Loreth
 * 
 * Copyrigth: CECAR
 */
package edu.cecar.controladores;
import static edu.cecar.componentes.singletons.SingletonConexionBD.getInstance;
import edu.cecar.modelos.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * Clase que controla las operaciones CRUD de los empleados
 * 
 */
public class ControladorEmpleado {

    
    /**
    * 
    * Función que permite consultar los empleados en la base de datos.    
    * @param codigo
    * @return empleado
    **/
    public Empleado consultar(String codigo) {
        Empleado e = null;
        try {                    
            PreparedStatement ps = getInstance().prepareStatement(
                    "select nombres, apellidos, fechaNacimiento from empleados where cedula = ?"
            );
            ps.setString(1, codigo);
            ResultSet r = ps.executeQuery();
            if(r.next()){
                e = new Empleado(codigo, r.getString(1), r.getString(2), r.getString(3));
            }                            
        } catch (SQLException ex) {
            System.err.println("Error al consultar en la base de datos - Descripción del error: " + ex.getMessage());
        }finally{
            return e;
        }
    }       
            
    /**
    * 
    * Función que permite insertar los empleados en la base de datos.
    * @param e    
    **/
    public void guardar(Empleado e){
        try {
            PreparedStatement ps = getInstance().prepareStatement(
                    "Insert into empleados values (?,?,?,?)"
            );
            ps.setString(1, e.getCodigo());
            ps.setString(2, e.getNombres());
            ps.setString(3, e.getApellidos());
            ps.setString(4, e.getFechaNacimiento());
            ps.execute(); 
        } catch (SQLException ex) {
            System.err.println("Error al insertar en la base de datos - Descripción del error: " + ex.getMessage());
        }
    }
    
    /**
    * 
    * Función que permite eliminar empleados en la base de datos.
    * @param codigo        
    * @return empleado
    **/
    public Empleado eliminar(String codigo){
        Empleado e = null;
        try {            
            PreparedStatement ps = getInstance().prepareStatement(
                    "select nombres, apellidos, fechaNacimiento from empleados where cedula=?"
            );
            ps.setString(1, codigo);
            ResultSet r = ps.executeQuery();
            if(r.next()){
                e = new Empleado(codigo, r.getString(1), r.getString(2), r.getString(3));
            }   
            
            if(e==null && e.getCodigo()==null || e.getCodigo().equals("")){
                System.err.println("El objeto no ha sido creado");
            }else{
                PreparedStatement ps1 = getInstance().prepareStatement(
                        "Delete from empleados where cedula = '"+e.getCodigo()+"'"
                );
                ps1.execute();
                return e;
            }                        
        } catch (SQLException ex) {
            System.err.println("Error al eliminar en la base de datos - Descripción del error: " + ex.getMessage());
        }
        return null;
    }
    
    /**
    * 
    * Función que permite actualizar los empleados en la base de datos.
    * @param codigo
    * @param a      
    * @return empleado
    **/
    public Empleado actualizar(String codigo, Empleado a){
        Empleado e = null;
        try {
            PreparedStatement ps = getInstance().prepareStatement(
                    "select nombres, apellidos, fechaNacimiento from empleados where cedula=?"
            );
            ps.setString(1, codigo);
            ResultSet r = ps.executeQuery();
            if(r.next()){
                e = new Empleado(codigo, r.getString(1), r.getString(2), r.getString(3));
            }   
            
            if(e==null && e.getCodigo()==null || e.getCodigo().equals("")){
                System.err.println("El objeto no ha sido creado");
            }else{
                PreparedStatement ps1 = getInstance().prepareStatement(
                        "Update empleados set nombres=?, apellidos=?, fechaNacimiento=? where cedula = '"+e.getCodigo()+"'"
                );               
                ps1.setString(1, a.getNombres());
                ps1.setString(2, a.getApellidos());
                ps1.setString(3, a.getFechaNacimiento());
                ps1.executeUpdate();
                return e;
            }          
        } catch (SQLException ex) {
            System.err.println("Error al actualizar en la base de datos - Descripción del error: " + ex.getMessage());
        }
        return null;
    }
    
    
    
    
}
