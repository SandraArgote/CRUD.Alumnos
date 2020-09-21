/**
 *
 * @author Sandi Argote
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>Editar Alumno</h1>");
        String numeroC = request.getParameter("NUMEROCONTROL"); 

        Alumnos e = AlumnosDAO.getAlumnosNumeroC(numeroC);

        out.print("<form action='Editar2Servlet' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='NUMEROCONTROL' value='" + e.getNumeroControl() + "'/></td></tr>");
        out.print("<tr><td>Nombre:</td><td><input type='text' name='NOMBREALUMNO' value='" + e.getNombre() + "'/></td></tr>");
        out.print("<tr><td>Curso:</td><td><input type='text' name='CURSO' value='" + e.getCurso() + "'/> </td></tr>");
        out.print("<tr><td>Semestre:</td><td><input type='text' name='SEMESTRE' value='" + e.getSemestre() + "'/> </td></tr>");

        out.print("<tr><td colspan='2'><input type='submit' value='Guardar cambio'/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.close();
    }
}