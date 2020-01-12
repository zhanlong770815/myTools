<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="<c:url value='/CServlet?name=张三' />">GET</a>

  <form action="<c:url value="/CServlet" />" method="post">
    username: <input type="text" name="username" value="李四"/><br>
    <input type="submit" value="submit" />
  </form>
  </body>
</html>