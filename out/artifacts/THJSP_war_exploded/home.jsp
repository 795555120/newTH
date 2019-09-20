<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>太湖水质平台</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html charset=gb2312">

    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
            font-size: 0;
        }

        body {
            background: #cefbb5;
            overflow: hidden;
        }

        ul {
            list-style: none;
        }

        .mainBox {
            position: relative;
            width: 1266px;
            height: 1080px;
        }

        .nav {
            width: 203px;
            height: 1080px;
            background: url("images/leftEdge.png") 0 0/203px no-repeat;
        }

        #waterModel {
            display: block;
            position: absolute;
            top: 0;
            left: 203px;
            width: 1691px;
            height: 1075px;
            margin: 10px;
            background: #f0fee9;
        }

        #checkResults {
            display: none;
            position: absolute;
            top: 0;
            left: 203px;
            width: 1691px;
            height: 1075px;
            margin: 10px;
            background: #f0fee9;
        }

        #waterMap, #checkMap {
            width: 601px;
            height: 557px;
            margin: 50px 10px;
            display: inline-block;
        }

        /*图表容器*/
        #line-container {
            position: absolute;
            top: 450px;
            left: 1170px;
            width: 460px;
            height: 300px;
        }

        /*饼图*/
        #pie-container {
            position: absolute;
            top: 420px;
            left: 500px;
            width: 690px;
            height: 360px;
        }

        /*输入框与按钮*/
        .btn {
            position: absolute;
            top: 51px;
            left: 650px;
            display: flex;
            width: 1000px;
            height: 350px;
            margin-top: 20px;
        }

        ul {
            flex: 1;
        }

        .btn li {
            font-size: 20px;
            margin: 20px 0;
        }

        input, select {
            width: 223px;
            height: 43px;
            border-radius: 5px;
            background-color: white;
        }

        input, select, option {
            font-size: 20px;
        }

        button {
            text-indent: 105px;
            background: none;
            border: none;
            outline: none;
        }

        #stop {
            width: 80px;
            height: 30px;
            font-size: 16px;
            background-color: #00bcd4;
        }

        /*遥感界面*/
        /*地形图*/
        #checkMap {
            width: 850px;
            height: 700px;
            margin: 30px 10px;
        }

        .checkBox {
            display: inline-block;;
            width: 600px;
            height: 800px;
            padding-top: 40px;
            padding-left: 40px;
            margin-left: 150px;
            vertical-align: top;
        }

        .checkBox span {
            font-size: 20px;
        }

        .checkBox input, .checkBox select {
            width: 250px;
            height: 40px;
            margin: 15px;
        }

        .checkBox button {
            width: 250px;
            height: 40px;
            margin-top: 20px;
        }

        .checkBox button img {
            width: 250px;
            height: 40px;
        }

        #check_circle_map {
            width: 300px;
            height: 300px;
            border: 1px solid black;
            margin-top: 30px;
            margin-left: 30px;
        }
        .north{
            position: absolute;
            top: 100px;
            left: 50px;
        }

    </style>
</head>
<body>
<header>
    <img src="images/aboveEdge.png" >
</header>
<div class="mainBox">
    <!-- 左侧菜单导航部分 -->
    <div class="nav">
        <ul>
            <li><img src="images/waterQualityModelButton_light.png"></li>
            <li><img src="images/checkResults_darkGreen.png"></li>
        </ul>
    </div>

    <!-- 右侧内容显示 -->
    <!-- 水质模型界面 -->
    <div id="waterModel">
        <img src="images/waterQualityModel.png">
        <img src="images/north.png" alt="404" class="north"/>
        <canvas id="waterMap" width="902" height="836"></canvas>
        <div class="btn">
            <ul>
                <li>
                    水质指标：
                    <select id="qualityIndex">
                        <option value="0">--请选择--</option>
                        <option value="1">氨氮NH3-N（mg/L）</option>
                        <option value="2">硝氮NO3-N（mg/L）</option>
                        <option value="3">无机磷MINP（mg/L）</option>
                        <option value="4">叶绿素Chla（mg/L）</option>
                        <option value="5">生化需氧量BOD（mg/L）</option>
                        <option value="6">溶解氧DO（mg/L）</option>
                        <option value="7">有机磷ORGP（mg/L）</option>
                        <option value="8">水温TEM(℃)</option>
                        <option value="9">总氮TN（mg/L）</option>
                        <option value="10">总磷TP（mg/L）</option>
                    </select>
                </li>
                <li>
                    起始时间：
                    <input type="text" id="qulityStartTime" placeholder="请输入起始时间">
                </li>
                <li>
                    结束时间：
                    <input type="text" id="qulityEndTime" placeholder="请输入结束时间">
                </li>
                <li>
                    <button id="water_startCount"><img src="images/startCalculate.png"></button>
                </li>
            </ul>
            <ul>
                <li>
                    起始时间：
                    <input id="staTime" type="text" placeholder="输入格式：YYYY MM DD">
                </li>
                <li>
                    结束时间：
                    <input id="finishTime" type="text" placeholder="输入格式：YYYY MM DD">
                </li>
                <li>
                    <button id="startCalculate"><img src="images/startCalculate.png"></button>
                </li>
                <li>
                    <button id="bay_Time"><img src="images/Bay_Time.png"></button>
                </li>
                <li>
                    <button id="startTimer"><img src="images/Timing.png"></button>
                </li>
            </ul>
        </div>
        <div id="line-container"></div>
        <div id="pie-container"></div>
    </div>
    <!-- 查看遥感反演结果 -->
    <div id="checkResults">
        <img src="images/remoteSensingIntersion.png">
        <img src="images/north.png" alt="404" class="north"/>
        <canvas id="checkMap" width="902" height="836"></canvas>
        <div class="checkBox">
            <ul>
                <li>
                    <span>遥感监测: </span>
                    <select id="check_select">
                        <option value="0">--请选择--</option>
                        <option value="1">叶绿素Chla（mg/L））</option>
                        <option value="2">透明度SD（cm）</option>
                        <option value="3">化学需氧量COD（mg/L）</option>
                        <option value="4">氨氮NH3-N（mg/L））</option>
                        <option value="5">总氮TN（mg/L）</option>
                        <option value="6">总磷TP（mg/L）</option>
                        <option value="7">溶解氧DO（mg/L）</option>
                        <option value="8">生化需氧量BOD（mg/L）</option>
                        <option value="9">水温TEM(℃)</option>
                        <option value="10">pH</option>
                    </select>
                </li>
                <li>
                    <span>起始时间: </span>
                    <input type="text" id="checkStartTime" placeholder="请输入起始时间">
                </li>
                <li>
                    <span>结束时间: </span>
                    <input type="text" id="checkEndTime" placeholder="请输入结束时间">
                </li>
                <li>
                    <button id="check_exe"><img src="images/check_exe.png"></button>
                </li>
                <li>
                    <button id="check_show"><img src="images/check_show.png"></button>
                </li>
            </ul>
            <div id="check_circle_map"></div>
        </div>
    </div>
</div>
</body>
<script src="http://lib.sinaapp.com/js/jquery/2.0.2/jquery-2.0.2.min.js"></script>
<script src="echarts.min.js"></script>
<script type="text/javascript">
    window.onload = function () {
        var modelImg = document.getElementsByTagName('img')[1];
        var checkImg = document.getElementsByTagName('img')[2];
        var waterModel = document.getElementById('waterModel');
        var checkResults = document.getElementById('checkResults');
        modelImg.onclick = function () {
            modelImg.src = 'images/waterQualityModelButton_light.png';
            checkImg.src = 'images/checkResults_darkGreen.png';
            waterModel.style.display = 'block';
            checkResults.style.display = 'none';
        }
        checkImg.onclick = function () {
            modelImg.src = 'images/waterQualityModelButton.png';
            checkImg.src = 'images/checkResults_lightGreen.png';
            waterModel.style.display = 'none';
            checkResults.style.display = 'block';
        }

        //水质模拟地形图数据
        let water_map = document.getElementById("waterMap");
        let water_ctx = water_map.getContext('2d');
        let check_map = document.getElementById("checkMap");
        let check_ctx = check_map.getContext('2d');
        let water_startCount = document.getElementById("water_startCount");
        let check_show = document.getElementById("check_show");
        let set;

        //水质———
        // ——设置水质监测点击函数，来封装ajax请求
        function sendRequestByPost() {
            clearInterval(set);
            //获取select和input的值
            let options=$("#qualityIndex option:selected");//获取当前选择项.
            let sub = +options.val();// options.val();//获取当前选择项的值.
            let qulityStartTime = $("#qulityStartTime").val();
            let qulityEendTime = $("#qulityEndTime").val();
            if (sub === 0 || qulityStartTime === '' || qulityEendTime === '') {
                alert("输入值有错误")
            }
            //封装发送的file对象
            let file = {sub: sub, start: qulityStartTime, end: qulityEendTime};
            console.log(file.sub, file.start, file.end);

            //进行起始时间的判断，确定发送几次请求
            if (qulityStartTime == qulityEendTime) {
                //相等，发送一次
                console.time("ajax");
                $.ajax({
                    type: "post",
                    dataType: "json",
                    url: "./terrain",
                    data: file,
                    success: function (msg) {
                        console.time("map")
                        let len = msg.terrainList.length;
                        for (var i = 0; i < len; i++) {
                            var x = msg.terrainList[i][0];
                            var y = 836 - msg.terrainList[i][1];
                            var r = msg.terrainList[i][2];
                            var g = msg.terrainList[i][3];
                            var b = msg.terrainList[i][4];
                            water_ctx.fillStyle = 'rgb(' + r + ', ' + g + ', ' + b + ')';
                            water_ctx.fillRect(x, y, 1, 1);
                        }
                        var dom = document.getElementById("pie-container");
                        var pieChart = echarts.init(dom);
                        var app = {};
                        option1 = null;
                        option1 = {
                            title: {
                                subtext: '各元素占比情况',
                                x: 'center'
                            },
                            tooltip: {
                                trigger: 'item',
                                formatter: "{a} <br/>{b} : {c} ({d}%)"
                            },
                            legend: {
                                orient: 'vertical',
                                left: '500px',
                                selectedMode: false,
                                data: ['一级', '二级', '三级', '四级', '五级']
                            },
                            color: [
                                'rgb(1, 144, 255)',
                                'rgb(0, 255, 221)',
                                'rgb(0, 255, 0, 447)',
                                'rgb(255, 143, 1)',
                                'rgb(251, 2, 1)',
                            ],
                            series: [
                                {
                                    name: '分布',
                                    type: 'pie',
                                    radius: '55%',
                                    center: ['50%', '50%'],
                                    data: [
                                        {value: msg.pieList[0][3], name: '一级'},
                                        {value: msg.pieList[1][3], name: '二级'},
                                        {value: msg.pieList[2][3], name: '三级'},
                                        {value: msg.pieList[3][3], name: '四级'},
                                        {value: msg.pieList[4][3], name: '五级'}
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
                        console.timeEnd("map")
                        if (option1 && typeof option1 === "object") {
                            pieChart.setOption(option1, true);
                        }

                    }
                });
                console.timeEnd("ajax");
            } else if (qulityStartTime < qulityEendTime) {
                //开始时间小于结束时间，设置定时器
                set = setInterval(() => {
                    console.log(file)
                    $.ajax({
                        /*
                            type: 请求的类型
                            dataType: 从服务端接收的数据类型 html, xml, text, json
                            url: 请求路径
                            data: 请求参数
                            success: 回调函数 msg: 从服务端接收过来的内容
                         */
                        type: "post",
                        dataType: "json",
                        url: "./terrain",
                        data: file,
                        async: false,
                        success: function (msg) {
                            let len = msg.terrainList.length;
                            for (var i = 0; i < len; i++) {
                                var x = msg.terrainList[i][0];
                                var y = 836 - msg.terrainList[i][1];
                                var r = msg.terrainList[i][2];
                                var g = msg.terrainList[i][3];
                                var b = msg.terrainList[i][4];
                                water_ctx.fillStyle = 'rgb(' + r + ', ' + g + ', ' + b + ')';
                                water_ctx.fillRect(x, y, 1, 1);
                            }
                            var dom = document.getElementById("pie-container");
                            var pieChart = echarts.init(dom);
                            var app = {};
                            option1 = null;
                            option1 = {
                                title: {
                                    subtext: '各元素占比情况',
                                    x: 'center'
                                },
                                tooltip: {
                                    trigger: 'item',
                                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                                },
                                legend: {
                                    orient: 'vertical',
                                    left: '500px',
                                    selectedMode: false,
                                    data: ['一级', '二级', '三级', '四级', '五级']
                                },
                                color: [
                                    'rgb(1, 144, 255)',
                                    'rgb(0, 255, 221)',
                                    'rgb(0, 255, 0, 447)',
                                    'rgb(255, 143, 1)',
                                    'rgb(251, 2, 1)',
                                ],
                                series: [
                                    {
                                        name: '分布',
                                        type: 'pie',
                                        radius: '55%',
                                        center: ['50%', '50%'],
                                        data: [
                                            {value: msg.pieList[0][3], name: '一级'},
                                            {value: msg.pieList[1][3], name: '二级'},
                                            {value: msg.pieList[2][3], name: '三级'},
                                            {value: msg.pieList[3][3], name: '四级'},
                                            {value: msg.pieList[4][3], name: '五级'}
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

                            if (option1 && typeof option1 === "object") {
                                pieChart.setOption(option1, true);
                                console.log("正在打印饼状图")
                            }

                        }
                    });
                    file.start++;
                    if (file.start == (+file.end + 1)) {
                        file.start = qulityStartTime;
                    }
                }, 2000)
            } else {
                alert("输入数据有误")
            }
        }

        water_startCount.onclick = sendRequestByPost;

        //水质————获取点击坐标，并传给后台
        water_map.addEventListener("click", function (event) {
            getMousePos(water_map, event);
        });

        function getMousePos(canvas, event) {
            //获取坐标
            let rect = canvas.getBoundingClientRect();
            let cx = (event.clientX - rect.left) * (canvas.width / rect.width);
            let cy = (event.clientY - rect.top) * (canvas.height / rect.height);
            let x = Math.floor(cx);
            let y = Math.floor(836 - cy);
            //获取索引
            let options = $("#qualityIndex option:selected");//获取当前选择项.
            let sub = +options.val();
            let qulityStartTime = $("#qulityStartTime").val();
            const location = {x: x, y: y, sub: sub, start: qulityStartTime};
            console.log(location)
            // 发送请求
            $.ajax({
                type: "post",
                dataType: "json",
                url: "./LineChartServlet",
                data: location,
                success: function (msg) {
                    console.log(msg)

                    // 折线图数据
                    var dom = document.getElementById("line-container");
                    var myChart = echarts.init(dom);
                    var app = {};
                    option = null;
                    option = {
                        title: {

                            subtext: '该点15天内的浓度变化',
                            x: 'center'
                        },
                        xAxis: {
                            type: 'category',
                            name: '(天)',
                            data: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15']
                        },
                        yAxis: {
                            type: 'value',
                            name: '浓度（mg/L）'

                        },
                        tooltip: {
                            trigger: 'axis',
                            formatter: "{c}mg/L"
                        },
                        series: [{
                            data: [msg[0],
                                msg[1],
                                msg[2],
                                msg[3],
                                msg[4],
                                msg[5],
                                msg[6],
                                msg[7],
                                msg[8],
                                msg[9],
                                msg[10],
                                -msg[11],
                                -msg[12],
                                -msg[13],
                                msg[14]
                            ],
                            type: 'line',
                            lineStyle: {
                                normal: {
                                    color: '#8cd5c2' //改变区域颜色
                                }
                            },
                            itemStyle: {
                                normal: {
                                    // label : {show: true},
                                    color: 'black'
                                }
                            }
                        }]
                    };

                    if (option && typeof option === "object") {
                        myChart.setOption(option, true);
                    }


                }
            });
        }
        //开始计算
        let startCalculate = document.getElementById('startCalculate');

        function startCal() {
            let startTime = $("#staTime").val();
            let endTime = $("#finishTime").val();
            let time = {"startTime": startTime, "endTime": endTime};
            $.ajax({
                type: "post",
                dataType: "json",
                url: "./InputServlet",
                data: time,
                success: function (msg) {
                    // console.log(msg);
                    alert(msg)
                }
            });
        }

        startCalculate.onclick = startCal;

        //运行Bay-Time
        let bay_Time = document.getElementById('bay_Time');

        function bayTime() {
            let startTime = $("#staTime").val();
            let time = {"startTime": startTime};
            $.ajax({
                    type: "post",
                    dataType: "json",
                    url: "./RunServlet",
                    data: time,
                    success: function (msg) {
                        console.log(msg);
                        // alert(msg[0]);
                        if (msg[0] != "1") {
                            alert("气象数据准备错误");
                        } else {
                            if (msg[1] == "0") {
                                alert("无遥感影像数据参与计算");
                            } else if (msg[1] == "1") {
                                alert("遥感影像数据参与计算");
                            }

                            if (msg[2] == "0") {
                                alert("BAY_TIME程序执行出错");
                            } else if (msg[2] == "1") {
                                // alert("BAY_TIME程序执行成功");
                                if (msg[3] == "0") {
                                    alert("INT_START程无法执行");
                                } else if (msg[3] == "1") {
                                    // alert("INT_START程序已执行");
                                    if (msg[4] == "0") {
                                        alert("BAY_TIME未执行");
                                    } else if (msg[4] == "1") {
                                        alert("BAY_TIME已执行");
                                    }

                                    if (msg[5] == "0") {
                                        alert("NT_START未执行");
                                    } else if (msg[5] == "1") {
                                        alert("NT_START已执行");
                                    }

                                    if (msg[4] == "1" && msg[5] == "1" && msg[6] == "1") {
                                        alert("WQM程序已执行")
                                    }
                                }
                            }
                        }
                    }
                }
            );
        }

        bay_Time.onclick = bayTime;

        //启动定时
        let beginTimer = document.getElementById('startTimer');

        function runTime() {
            let startTime = $("#staTime").val();
            let inputTime = prompt("请输入定时时间（HH:MM）：", "");
            // console.log(inputTime);
            let time = {"startTime": startTime, "time": inputTime};
            console.log(time);
            $.ajax({
                type: "post",
                dataType: "json",
                url: "./RunTimerServlet",
                data: time,
                success: function (msg) {
                    console.log(msg);
                    if (msg[0] != "1") {
                        alert("气象数据准备错误");
                    } else {
                        if (msg[1] == "0") {
                            alert("无遥感影像数据参与计算");
                        } else if (msg[1] == "1") {
                            alert("遥感影像数据参与计算");
                        }

                        if (msg[2] == "0") {
                            alert("BAY_TIME程序执行出错");
                        } else if (msg[2] == "1") {
                            // alert("BAY_TIME程序执行成功");
                            if (msg[3] == "0") {
                                alert("INT_START程无法执行");
                            } else if (msg[3] == "1") {
                                // alert("INT_START程序已执行");
                                if (msg[4] == "0") {
                                    alert("BAY_TIME未执行");
                                } else if (msg[4] == "1") {
                                    alert("BAY_TIME已执行");
                                }

                                if (msg[5] == "0") {
                                    alert("NT_START未执行");
                                } else if (msg[5] == "1") {
                                    alert("NT_START已执行");
                                }

                                if (msg[4] == "1" && msg[5] == "1" && msg[6] == "1") {
                                    alert("定时启动成功！")
                                }
                            }
                        }
                    }
                }
            });
        }

        beginTimer.onclick = runTime;


        //遥感————遥感界面的点击函数
        function check_btn() {
            //获取遥感input的值
            let options = $("#check_select option:selected");//获取当前选择项.
            let check_sub = +options.val();// options.val();//获取当前选择项的值.
            let check_startTime = $("#checkStartTime").val();
            let check_endTime = $("#checkEndTime").val();

            //封装遥感界面的参数
            let check_file = {sub: check_sub, start: check_startTime, end: check_endTime};
            console.log(check_file.sub, check_file.start, check_file.end)

            //进行起始时间的判断，确定发送几次请求
            if (check_startTime == check_endTime) {
                console.log(check_file)
                // 相等，发送一次
                $.ajax({
                    type: "post",
                    dataType: "json",
                    url: "./remote",
                    data: check_file,
                    success: function (msg) {
                        console.log("拿到数据成功");
                        console.log(msg)
                        console.time("draw");
                        let len = msg.terrainList.length;
                        for (var i = 0; i < len; i++) {
                            var x = msg.terrainList[i][0];
                            var y = 836 - msg.terrainList[i][1];
                            var r = msg.terrainList[i][2];
                            var g = msg.terrainList[i][3];
                            var b = msg.terrainList[i][4];
                            check_ctx.fillStyle = 'rgb(' + r + ', ' + g + ', ' + b + ')';
                            check_ctx.fillRect(x, y, 1, 1);
                        }


                    }
                });
            } else if (check_startTime < check_endTime) {
                //开始时间小于结束时间，设置定时器
                set = setInterval(() => {
                    console.log(check_file)
                    $.ajax({
                        /*
                            type: 请求的类型
                            dataType: 从服务端接收的数据类型 html, xml, text, json
                            url: 请求路径
                            data: 请求参数
                            success: 回调函数 msg: 从服务端接收过来的内容
                         */
                        type: "post",
                        dataType: "json",
                        url: "./remote",
                        data: check_file,
                        async: false,
                        success: function (msg) {
                            console.log(msg)
                            let len = msg.terrainList.length;
                            for (var i = 0; i < len; i++) {
                                var x = msg.terrainList[i][0];
                                var y = 836 - msg.terrainList[i][1];
                                var r = msg.terrainList[i][2];
                                var g = msg.terrainList[i][3];
                                var b = msg.terrainList[i][4];
                                check_ctx.fillStyle = 'rgb(' + r + ', ' + g + ', ' + b + ')';
                                check_ctx.fillRect(x, y, 1, 1);
                            }

                        }
                    });
                    check_file.start++;
                    if (check_file.start == (+check_file.end + 1)) {
                        check_file.start = check_startTime;
                    }
                }, 2000)
            } else {
                alert("输入数据有误")
            }
        }

        check_show.onclick = check_btn;


    }
</script>
</html>
