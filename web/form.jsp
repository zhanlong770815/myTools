<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>验证码</title>
    <script src="jquery/jquery-3.4.0.js" type="text/javascript"></script>
    <script type="text/javascript">

        $(function ()
        {
            $("#name").blur(function ()
            {
                $("label").text("用户名。");
            });
        });

        function hyz()
        {
            var img = document.getElementsByTagName("img")[0];
            img.src = "<c:url value='/VerifyCodeServlet'/>?p=" + new Date().getTime();
        }

    </script>
</head>
<body>
<form action="<c:url value='/loginServlet'/>" method="post">
    <input type="hidden" name="method" value="login"/>
    用户名：<input type="text" name="name" id="name"/><label style="color:red;"></label> <br>
    密　码：<input type="password" name="password"/><br>
    验证码：<input type="text" name="verifyCode" size="4"/>
    <img src="<c:url value='/VerifyCodeServlet'/>"/>
    <a href="javascript:hyz();">换一张</a><br>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
