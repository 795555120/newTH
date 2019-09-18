<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'checkResults.jsp' starting page</title>
    
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
		  #line-container{
			  width: 460px;
			  height: 300px;
			  margin: 80px 600px;
			  background-color: #00bcd4;
		  }
		  #pie-container{
			  width: 460px;
			  height: 240px;
			  margin: 30px 600px;
			  background-color: #00bcd4;
		  }
	  </style>
  </head>

  <body style="height: 100%; margin: 0">
  <div id="line-container"></div>
  <div id="pie-container"></div>
  </body>
  <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
  <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js"></script>
  <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
  <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
  <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
  <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
  <script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=xfhhaTThl11qYVrqLZii6w8qE5ggnhrY&__ec_v__=20190126"></script>
  <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
  <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/simplex.js"></script>
  <script type="text/javascript">
	  // 折线图数据
	  var dom = document.getElementById("line-container");
	  var myChart = echarts.init(dom);
	  var app = {};
	  option = null;
	  option = {
		  title : {

			  subtext: '该点15天内的浓度变化',
			  x:'center'
		  },
		  xAxis: {
			  type: 'category',
			  name:'(天)',
			  data: ['1', '2', '3', '4', '5', '6', '7','8', '9', '10', '11', '12', '13', '14','15']
		  },
		  yAxis: {
			  type: 'value',
			  name:'浓度（mg/L）'

		  },
		  tooltip : {
			  trigger: 'axis',
			  formatter: "{c}mg/L"
		  },
		  series: [{
			  data: [13, 25, -30, 49, 52, -62, 73,-80, 92, 100, -114, -120, 130, -140,-150],
			  type: 'line',
			  lineStyle:{
				  normal: {
					  color: '#8cd5c2' //改变区域颜色
				  }
			  },
			  itemStyle : {
				  normal: {
					  label : {show: true},
					  color: 'black'
				  }
			  }
		  }]
	  };

	  if (option && typeof option === "object") {
		  myChart.setOption(option, true);
	  }

	  // 饼图数据
	  var pieDom = document.getElementById("pie-container");
	  var pieChart = echarts.init(pieDom);
	  var pieApp = {};
	  option = null;
	  option = {
		  title : {

			  subtext: '各元素占比情况',
			  x:'center'
		  },
		  tooltip : {
			  trigger: 'item',
			  formatter: "{a} <br/>{b} : {c} ({d}%)"
		  },
		  legend: {
			  orient: 'vertical',
			  left: 'right',
			  data: ['一级','二级','三级','四级','五级']

		  },
		  color:['rgb(0,255,255)', 'rgb(0,0,255)','rgb(255,0,0)','rgb(136,136,136)','rgb(0,255,0)'],
		  series : [
			  {
				  name: '分布',
				  type: 'pie',
				  radius : '55%',
				  center: ['50%', '50%'],
				  data:[
					  {value:335, name:'一级'},
					  {value:310, name:'二级'},
					  {value:234, name:'三级'},
					  {value:135, name:'四级'},
					  {value:1548, name:'五级'}
				  ],
				  itemStyle: {
					  emphasis: {
						  shadowBlur: 10,
						  shadowOffsetX: 0,
						  shadowColor: 'rgba(0, 0, 0, 0.5)'
					  }
				  }
			  }
		  ]
	  };

	  if (option && typeof option === "object") {
		  pieChart.setOption(option, true);
	  }
  </script>
</html>