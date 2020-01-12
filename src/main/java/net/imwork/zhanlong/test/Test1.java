package net.imwork.zhanlong.test;

import net.imwork.zhanlong.commons.CommonUtils;
import net.imwork.zhanlong.jdbc.JdbcUtils;

import net.imwork.zhanlong.mail.Mail;
import net.imwork.zhanlong.mail.MailUtils;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import javax.mail.Session;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test1
{
    public static void main(String[] args) throws SQLException
    {
        Connection connection = JdbcUtils.getConnection();

        PreparedStatement ps = connection.prepareStatement("select * from users");

        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            System.out.println(rs.getObject(1) + "," + rs.getObject(2)+ "," + rs.getObject(3));
        }

        String uuid = CommonUtils.uuid();
        System.out.println("uuid = " + uuid);

    }

    @Test
    public void fun1() throws IOException, MessagingException
    {
        //发送成功
//        Session session = MailUtils.createSession("smtp.163.com", "zl20050302", "zhanlong113592");
//        Mail mail = new Mail("zl20050302@163.com","120769563@qq.com","测试邮件","<a href='http://www.baidu.com'>百度</a>");
//        MailUtils.send(session, mail);

        //发送不成功
        Session session = MailUtils.createSession("smtp.qq.com", "120769563", "zl113592zl");
        Mail mail = new Mail("120769563@qq.com","zl20050302@163.com","测试邮件","<a href='http://www.baidu.com'>百度</a>");
        MailUtils.send(session, mail);

    }

}
