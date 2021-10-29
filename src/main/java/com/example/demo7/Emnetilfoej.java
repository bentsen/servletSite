package com.example.demo7;

import javax.management.ListenerNotFoundException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "Emnetilfoej", value = "/Emnetilfoej")
public class Emnetilfoej extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String emne = request.getParameter("emne");
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();

        Set<String> emneListeContext = (Set<String>) context.getAttribute("emneListeContext");

        if(emneListeContext == null)
        {
            emneListeContext = new HashSet<>();
        }
        emneListeContext.add(emne);


        Set<String> emneListe = (Set<String>) session.getAttribute("emneListe");

        if (emneListe == null) {
         emneListe = new HashSet<>();
        }

        if(!emneListe.contains(emne))
        {
         emneListe.add(emne);
         Bruger bruger = (Bruger) session.getAttribute("bruger");
         bruger.setBrugerHuskeliste(emneListe);
        }
        else if(emneListe.contains(emne))
        {

        }

        context.setAttribute("emneListeContext",emneListeContext);
        session.setAttribute("emneListe",emneListe);


        request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
