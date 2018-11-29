package icmit.dad.laborators.lab13.webdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

//@WebServlet("/read")
public class ReadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("read do post");
        String value;
        HttpSession session = req.getSession(false);
        if(session!=null){
            value = req.getParameter(  "name");
            if(value != null){
                System.out.println("get attr name="+value);
                value = (String) session.getAttribute(value);
                System.out.println(value);
                if(value==null){
                    value = "attribute not found";
                }
            }
            else {
                value = "parameter not found";
            }
        }
        else {
            value = "session not found";
        }

        try(OutputStream os = resp.getOutputStream()){
            os.write((value).getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
