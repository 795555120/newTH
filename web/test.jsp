<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/21
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>尝试</title>
</head>
<body>
<h>${sessionScope.name}</h>
<%request.setAttribute("count",0);%>
<a href="TestServlet?count=${sessionScope.count}">这是链接</a>
<p>${sessionScope.count}</p>
</body>
</html>
