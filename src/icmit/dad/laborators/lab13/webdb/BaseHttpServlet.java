package icmit.dad.laborators.lab13.webdb;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/basehttp")
public class BaseHttpServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter pw = response.getWriter();
            pw.println("<html><body>");
            pw.println("Hello from basehttp servlet!");
            pw.println("<body></html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
