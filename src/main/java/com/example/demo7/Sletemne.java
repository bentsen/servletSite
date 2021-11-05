package com.example.demo7;



import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "Sletemne", value = "/Sletemne")
public class Sletemne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String s = request.getParameter("emne");

        HttpSession session = request.getSession();

        Set<String> stringList = (Set<String>)session.getAttribute("emneListe");

        if(stringList == null)
        {
            stringList = new HashSet<>();
        }
        if(stringList.contains(s))
        {
            stringList.remove(s);
            Bruger bruger = (Bruger) session.getAttribute("bruger");
            bruger.setBrugerHuskeliste(stringList);
        }
        else if(stringList.contains(s))
        {

        }

        session.setAttribute("emneListe", stringList);
        request.getRequestDispatcher("/WEB-INF/BrugerSide.jsp").forward(request,response);

    }
}
