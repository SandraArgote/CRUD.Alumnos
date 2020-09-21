/**
 *
 * @author Sandi Argote
 */

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  


public class VistaServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
        response.setContentType("text/html;charset=UTF-8");  
        PrintWriter out = response.getWriter();  
        out.println("<a href='index.jsp'>Añadir alumno</a>");  
        out.println("<h1>Lista de alumnos</h1>");  
          
        List<Alumnos> list= AlumnosDAO.getAllAlumnos();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Numero de control</th><th>Nombre</th><th>Curso</th><th>Semestre</th>"
                + "<th>Editar</th><th>Eliminar</th></tr>");  
        
        for(Alumnos e:list){  
         out.print("<tr><td>"+e.getNumeroControl()+"</td><td>"+e.getNombre()+"</td><td>"+e.getCurso()+"</td><td>"+e.getSemestre()+"</td>"
                 + "<td><a href='EditarServlet?NUMEROCONTROL="+e.getNumeroControl()+"'>Editar</a></td>"
                 + "<td><a href='EliminarServlet?NUMEROCONTROL="+e.getNumeroControl()+"'>Eliminar</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  
