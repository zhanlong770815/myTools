package net.imwork.zhanlong.test;

import net.imwork.zhanlong.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginServlet",urlPatterns = "/loginServlet")
public class loginServlet extends BaseServlet
{
    public String login(HttpServletRequest request, HttpServletResponse response)
    {
        String verifyCode = request.getParameter("verifyCode");

        String verifyCodeOfSession = (String) request.getSession().getAttribute("verifyCode");

        System.out.println(verifyCode.equalsIgnoreCase(verifyCodeOfSession));

        return null;
    }


}
