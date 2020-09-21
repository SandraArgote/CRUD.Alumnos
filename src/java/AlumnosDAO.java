/**
 *
 * @author Sandi Argote
 */

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.*;  
import java.sql.*;  
  
public class AlumnosDAO {  
  
    public static Connection getConnection(){  
        Connection con=null; 
        String url = "jdbc:derby://localhost:1527/ListaAlumno";
        String user = "argote";
        String pass = "1234";
        
        Driver driver = new org.apache.derby.jdbc.ClientDriver();
        
        try{  
            DriverManager.registerDriver(driver);
            //Class.forName("org.apache.derby.jdbc.ClientDriver");  
            con=DriverManager.getConnection(url,user,pass);  
        
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    
    //Guardar nuevo alumno
    public static int save(Alumnos e){  
        int status=0;  
        try{  
            Connection con = AlumnosDAO.getConnection();  
            PreparedStatement ps = con.prepareStatement(  
            "insert into ALUMNO(NUMEROCONTROL,NOMBREALUMNO,CURSO,SEMESTRE) values (?,?,?,?)");  
            ps.setString(1,e.getNumeroControl());  
            ps.setString(2,e.getNombre());  
            ps.setString(3,e.getCurso());  
            ps.setString(4,e.getSemestre());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
            return status;  
    }  
    
    //Actualizar datos alumno
    public static int update(Alumnos e){  
        int status=0;  
        try{  
            Connection con = AlumnosDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
            "update ALUMNO set NOMBREALUMNO=?,CURSO=?,SEMESTRE=? where NUMEROCONTROL=?");  
            ps.setString(1,e.getNombre());  
            ps.setString(2,e.getCurso());  
            ps.setString(3,e.getSemestre());  
            ps.setString(4,e.getNumeroControl());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
            return status;  
    }  
    
    //Eliminar alumno
    public static int delete(String numeroControl){  
        int status=0;  
        try{  
            Connection con = AlumnosDAO.getConnection();  
            PreparedStatement ps = con.prepareStatement("delete from ALUMNO where NUMEROCONTROL=?");  
            ps.setString(1, numeroControl);  
            status = ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
            return status;  
    }
    
    //Ver todos los alumnos
    public static List<Alumnos> getAllAlumnos(){  
        List<Alumnos> list = new ArrayList<Alumnos>();  
          
        try{  
            Connection con = AlumnosDAO.getConnection();  
            PreparedStatement ps = con.prepareStatement("select * from ALUMNO");  
            ResultSet rs=ps.executeQuery();  
            
            while(rs.next()){  
                Alumnos e = new Alumnos();  
                e.setNumeroControl(rs.getString(1));  
                e.setNombre(rs.getString(2));  
                e.setCurso(rs.getString(3));  
                e.setSemestre(rs.getString(4)); 
                list.add(e);  
            }  
            con.close();  
        
        }catch(Exception e){e.printStackTrace();}  
            return list;  
    }
    
        
    //Almunos por numero de control
    public static Alumnos getAlumnosNumeroC(String numeroControl){  
        Alumnos e=new Alumnos();  
          
        try{  
            Connection con = AlumnosDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from ALUMNO where NUMEROCONTROL=?");  
            ps.setString(1, numeroControl);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setNumeroControl(rs.getString(1));  
                e.setNombre(rs.getString(2));  
                e.setCurso(rs.getString(3));  
                e.setSemestre(rs.getString(4));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }       
}  
