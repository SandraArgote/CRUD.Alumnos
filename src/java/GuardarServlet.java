/**
 *
 * @author Sandi Argote
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GuardarServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String numeroControl = request.getParameter("NUMEROCONTROL");
        String nombre        = request.getParameter("NOMBREALUMNO");
        String curso         = request.getParameter("CURSO");
        String semestre      = request.getParameter("SEMESTRE");

        Alumnos e = new Alumnos();
        e.setNumeroControl(numeroControl);
        e.setNombre(nombre);
        e.setCurso(curso);
        e.setSemestre(semestre);

        int status = AlumnosDAO.save(e);
        if (status > 0) {
            out.print("<p>¡Alumno registrado correctamente!</p>");
            request.getRequestDispatcher("index.jsp").include(request, response);
        } else {
            out.println("No se registro alumno");
        }
        out.close();
    }
}
