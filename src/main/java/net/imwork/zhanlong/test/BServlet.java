package net.imwork.zhanlong.test;

import net.imwork.zhanlong.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BServlet",urlPatterns = "/BServlet")
public class BServlet extends BaseServlet
{
    public String add(HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println("add().....");
        System.out.println("hello");
        return "f:/index.jsp";
    }

    public String update(HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println("update().....");
        //response.sendRedirect(request.getContextPath() + "/index.jsp");
        return "r:/index.jsp";
        //return null;
    }

}
