package icmit.dad.laborators.lab13.webdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet(urlPatterns = {"/start"})
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("start do post");
        if (req.getSession(false)==null){
            System.out.println("session not found.");
        }
        else {
            System.out.println("session found!");
        }

        HttpSession session = req.getSession(true);
        System.out.println("now session id = "+session.getId());
    }
}
