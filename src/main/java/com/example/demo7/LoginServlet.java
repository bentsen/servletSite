package com.example.demo7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();

        String pass1 = request.getParameter("pass1");
        String inputNavn = request.getParameter("name");

        List<Bruger> brugerList = (List<Bruger>) context.getAttribute("brugerliste");
        if(brugerList == null)
        {
            brugerList = new ArrayList<>();
        }
        for (Bruger bruger : brugerList) {

            if(bruger.getName().equals(inputNavn) && bruger.getPassword().equals(pass1))
            {
                System.out.println("du er inde");
                session.setAttribute("bruger", bruger);
                session.setAttribute("emneListe", bruger.getBrugerHuskeliste());

                String sessionid = session.getId();
                session.setAttribute("name", inputNavn);
                session.setAttribute("sesstionid",sessionid);

                request.getRequestDispatcher("/WEB-INF/BrugerSide.jsp").forward(request,response);

            }
        }
        request.setAttribute("borderColor","1px solid #EA3B4E");
        request.setAttribute("wrongUsername","visible");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    public void destroy()
    {
    }
}