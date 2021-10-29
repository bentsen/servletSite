package com.example.demo7;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();

        String name = request.getParameter("name");
        String password = request.getParameter("pass1");

        List<Bruger> brugerList = (List<Bruger>) context.getAttribute("brugerliste");

        if(brugerList == null)
        {
            brugerList = new ArrayList<>();
        }

        Bruger bruger = new Bruger(name,password);

        brugerList.add(bruger);



        context.setAttribute("brugerliste", brugerList);
        session.setAttribute("bruger",bruger);

        String sessionid = session.getId();
        session.setAttribute("name",name);
        session.setAttribute("sessionid",sessionid);

        request.setAttribute("name", name);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
