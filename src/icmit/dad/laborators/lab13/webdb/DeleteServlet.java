package icmit.dad.laborators.lab13.webdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("delete do post");
        String name;
        HttpSession session = req.getSession(false);
        if(session!=null){
            name = req.getParameter(  "name");
            if(name != null){
                System.out.println("remove attr name="+name);
                session.removeAttribute(name);
                return;
            }
            else {
                System.err.println("parameter not found");
            }
        }
        else {
            System.err.println("session not found");
        }
    }
}
