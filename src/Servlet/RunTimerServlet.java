package Servlet;

import Util.FilePath;
import Util.MyTimerTask;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

@WebServlet("/RunTimerServlet")
public class RunTimerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String startTime = request.getParameter("startTime");

        String time=request.getParameter("time");

System.out.println(startTime);
System.out.println("time"+time);

        String[] clientInputSplit = startTime.trim().split("\\s+");
        String client = startTime.replaceAll(" ", "");

        String[] outcome = new String[7];


        File file = new File(FilePath.FAR_TIMEPath);
        BufferedReader bufferedReader = null;
        String[] lineSplit = null;
        boolean WQFileIsExist = false;
        File WQFile = null;
        String path = FilePath.WQPath + "WQ_2D_FIG" + client + ".DAT";

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            lineSplit = bufferedReader.readLine().trim().split("\\s+");
            WQFile = new File(path);
            //判断遥感文件WQ是否存在，不存在，WQFileIsExist为false;
            if (WQFile.exists()) {
                WQFileIsExist = true;
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
//        System.out.println("用户输入："+clientInputSplit[0]+" "+clientInputSplit[1]+" "+clientInputSplit[2]+" "+"文件"+lineSplit[2]+" "+lineSplit[3]+" "+lineSplit[4]);

        //判断用户输入使用和far文件中是否相等（目前已存为2019年4月6日）
        if (Integer.parseInt(clientInputSplit[0]) == Integer.parseInt(lineSplit[2]) && Integer.parseInt(clientInputSplit[1]) == Integer.parseInt(lineSplit[3]) && Integer.parseInt(clientInputSplit[2]) == Integer.parseInt(lineSplit[4])) {
            outcome[0] = "1";
            if (WQFileIsExist) {
                outcome[1] = "1";
            } else {
                outcome[1] = "0";
//                JOptionPane.showMessageDialog(null, "无遥感影像数据参与计算");
            }

            //运行BAY_Time程序
            String cmd = "cmd /c start D:\\RSM_TH\\BAY_TIME.exe";
            try {
                Runtime.getRuntime().exec(cmd);
                outcome[2] = "1";
//                JOptionPane.showMessageDialog(null,"BAY_TIME程序执行成功");


                String cmd2 = "cmd /c start D:\\RSM_TH\\INT_START.exe";
                try {
                    Runtime.getRuntime().exec(cmd2);
                    outcome[3] = "1";
//                JOptionPane.showMessageDialog(null,"INT_START程序执行成功");
//                System.out.println("INT_START程已执行");
                    File file1 = new File(FilePath.RUN_CONTROLFilePath);
                    BufferedReader bufferedReader1 = null;
                    String[] line1 = null;
                    String[] line2 = null;
                    try {
                        bufferedReader1 = new BufferedReader(new FileReader(file1));
                        line1 = bufferedReader1.readLine().trim().split("\\s+");
                        line2 = bufferedReader1.readLine().trim().split("\\s+");
                        System.out.println("line1+line2" + line1.toString() + line2.toString());
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } finally {
                        if (bufferedReader1 != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                    if (line1.length != 0 && line1.length != 0) {
                        if ("1".equals(line1[0])) {
                            outcome[4] = "1";
//                    JOptionPane.showMessageDialog(null, "BAY_TIME已执行");
                        } else {
                            outcome[4] = "0";
//                    JOptionPane.showMessageDialog(null, "BAY_TIME未执行", "警告",JOptionPane.WARNING_MESSAGE);
                        }
                        if ("1".equals(line2[0])) {
                            outcome[5] = "1";
//                    JOptionPane.showMessageDialog(null, "INT_START已执行");
                        } else {
                            outcome[5] = "0";
//                    JOptionPane.showMessageDialog(null,"INT_START未执行","警告",JOptionPane.WARNING_MESSAGE);
                        }
                        if ("1".equals(line2[0]) && "1".equals(line1[0])) {


                            String[] timers=time.split(":");
                            int hour=Integer.parseInt(timers[0]);
                            int min=Integer.parseInt(timers[1]);

                            //设定自主启动的时间
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(Calendar.HOUR_OF_DAY, hour); //设定小时
                            calendar.set(Calendar.MINUTE, min);
                            calendar.set(Calendar.SECOND, 0);
                            Date date=calendar.getTime(); //第一次执行定时任务的时间

                            //如果第一次执行定时任务的时间 小于当前的时间
                            //此时要在 第一次执行定时任务的时间加一天，以便此任务在下个时间点执行。如果不加一天，任务会立即执行。
                            if (date.before(new Date())) {
                                date = this.addDay(date, 1);
                            }
                            Timer timer = new Timer();
                            MyTimerTask task = new MyTimerTask();
                            //安排指定的任务在指定的时间开始进行重复的固定延迟执行。
                            timer.schedule(task,date);
                            outcome[6] = "1";
                        }
                    } else {
                        outcome[6] = "0";
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                    outcome[3] = "0";
//                System.out.println("INT_START程序无法执行");
                }

            } catch (IOException e1) {
                outcome[2] = "0";
//                System.out.println("BAY_TIME程序执行出错");
                e1.printStackTrace();
            }


        } else {
            outcome[0] = "0";
        }
        PrintWriter out = response.getWriter();
        out.write(new Gson().toJson(outcome));
    }

    public Date addDay(Date date, int num) {
        Calendar startDT = Calendar.getInstance();
        startDT.setTime(date);
        startDT.add(Calendar.DAY_OF_MONTH, num);
        System.out.println("Calendar.DAY_OF_MONTH:"+Calendar.DAY_OF_MONTH);
        return startDT.getTime();
    }
}
