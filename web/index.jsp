<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/15
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>太湖水质平台—登录</title>
  <style>
    *{
      margin: 0;
      padding: 0;
    }
    .body{
      overflow: hidden;
      background-color: #cefbb5;
    }
    .bg{
      position: relative;
      width: 800px;
      height: 600px;
      border-radius: 10px;
      margin: 150px auto;
      background: url("images/index.png") 0 0/100% 100% no-repeat;
    }
    .name,.psd{
      width: 240px;
      height:60px;
      background-color: transparent;
      border: 0;
      text-align: center;
      font-size: 24px;
      outline: none;
    }
    .name{
      position: absolute;
      top: 350px;
      left: 290px;
    }
    .psd{
      position: absolute;
      top: 417px;
      left: 290px;
    }
    .jump{
      position: absolute;
      top: 510px;
      left: 263px;
      width: 280px;
      height: 50px;
      border-radius: 30px;
      /*background: url("images/jump.png") 0 0/100% 100% no-repeat;*/
    }
  </style>
  <script></script>
</head>
<body>
<div class="bg">
  <form>
    <input class="name"/>
    <input class="psd" type="password"/>
  </form>
  <a href="home.jsp"><img src="images/jump.png" alt="404" class="jump"/> </a>
</div>
</body>
</html>
