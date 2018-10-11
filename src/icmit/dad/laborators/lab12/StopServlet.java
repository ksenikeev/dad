package icmit.dad.laborators.lab12;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StopServlet extends HttpServlet
{
    @Override
    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response ) throws ServletException,
            IOException
    {
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().println("<h1>Попытка отстановить сервер ...</h1>");
        response.setStatus(HttpServletResponse.SC_OK);

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    TestWebApp.server.stop();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }.start();

    }
}