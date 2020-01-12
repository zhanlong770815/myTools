package net.imwork.zhanlong.test;

import net.imwork.zhanlong.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/AServlet")
public class AServlet extends BaseServlet
{
    public String login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        System.out.println("login invoked.");

        return "f:/index.jsp";
    }

    public String regist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        System.out.println("regist invoked.");
        System.out.println("hello");
        return "r:/index.jsp";
    }
}
