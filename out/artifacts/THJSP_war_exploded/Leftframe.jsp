<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Leftframe.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		* {
			margin: 0;
			padding: 0;
		}
		.nav {
			height: 665px;
			background: url("images/leftEdge.png") 0 0/126px no-repeat;
		}
		img {
			width: 100%;
		}
	</style>
	<script>
		window.onload = function () {
			var modelImg = document.getElementsByTagName('img')[0];
			var checkImg = document.getElementsByTagName('img')[1];
			modelImg.onclick = function () {
				modelImg.src = 'images/waterQualityModelButton.png';
				checkImg.src = 'images/checkResults_lightGreen.png';
			}
			checkImg.onclick = function () {
				modelImg.src = 'images/waterQualityModelButton_light.png';
				checkImg.src = 'images/checkResults_darkGreen.png';
			}
		}
	</script>

  </head>
  
  <body>
    <div class="nav">
		<ul>
			<li><a href="UI/waterQuality.jsp" target="rightframe"><img src="images/waterQualityModelButton.png"></a></li>
			<li><a href="UI/checkResults.jsp" target="rightframe"><img src="images/checkResults_lightGreen.png"></a></li>
		</ul>
	</div>
  </body>
</html>
