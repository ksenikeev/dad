package icmit.dad.laborators.lab13.webdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

//@WebServlet("/write")
public class WriteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name;
        String value;
        String result = "notOk";
        HttpSession session = req.getSession(false);
        if(session!=null){
            name = req.getParameter(  "name");
            value = req.getParameter("value");
            if(name != null && value!=null){
                session.setAttribute (name,value);
                result = "ok";
                System.out.println("attribute saved");
            }
            else {
                System.err.println("Parameter is invalid");
            }
        }
        else {
            System.err.println("Session not found");
        }

        PrintWriter pw = resp.getWriter();
        pw.println(result);
//        try(OutputStream os = resp.getOutputStream()){
//            os.write((result).getBytes("UTF-8"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

}
