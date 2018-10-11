package icmit.dad.laborators.lab12;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class TestWebApp
{
    public  static Server server;
    public static void main( String[] args ) throws Exception
    {
        server = new Server(8090);

        ServletHandler handler = new ServletHandler();

        handler.addServletWithMapping(HelloServlet.class, "/hello");
        handler.addServletWithMapping(NextStepServlet.class, "/next");
        handler.addServletWithMapping(StopServlet.class, "/stop");

        server.setHandler(handler);

        server.start();
        server.join();
    }
}