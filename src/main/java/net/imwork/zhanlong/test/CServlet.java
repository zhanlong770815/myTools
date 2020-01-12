package net.imwork.zhanlong.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "CServlet", urlPatterns = "/CServlet")
public class CServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String username = request.getParameter("username");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> strings = parameterMap.keySet();
        for (String s : strings)
        {
            System.out.println(parameterMap.get(s)[0]);
            response.getWriter().println(parameterMap.get(s)[0]);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String name = request.getParameter("name");
        System.out.println(name);
        response.getWriter().println("GET --> name = " + name);
        System.out.println("-----------------------------");
        name = request.getParameterValues("name")[0];
        System.out.println(name);
        response.getWriter().println("<br>GET --> name = " + name);

    }
}

