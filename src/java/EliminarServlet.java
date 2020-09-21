
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
import javax.servlet.http.HttpSession;

public class EliminarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            if (session != null) {
                if (session.getAttribute("user") != null) {
                    String name = (String) session.getAttribute("user");
                    //out.print("Hello, " + name + "  Welcome to ur Profile");
                } else {
                    response.sendRedirect("index.jsp");
                }
            }
       
            String numeroControl = request.getParameter("NUMEROCONTROL");
            AlumnosDAO.delete(numeroControl);
            response.sendRedirect("VistaServlet");

        } catch (Exception exc) {
            System.out.println(exc);
        }

    }
}
