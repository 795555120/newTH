package Servlet;

import Util.FilePath;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
 System.out.println("==="+startTime);
System.out.println("==="+endTime);
        String inputString = "60.    0.     15.  " + startTime + " 24  " + endTime + " 24\t\\INT\\INT.DAT\n" +
                "           当有遥感数据时，起始时间为遥感数据生成时间";

        File DT_STR_END = new File(FilePath.DT_STR_ENDPath);
        Gson gson = new Gson();

        BufferedWriter bufferedWriter = null;
        PrintWriter out=response.getWriter();
        String outcome=null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DT_STR_END), "GBK"));
            bufferedWriter.write(inputString);
            outcome="写入成功";
            out.write(new Gson().toJson(outcome));
// System.out.println(new Gson().toJson(outcome));
//System.out.println("=====成功");
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            outcome="写入失败，请重新尝试";
            out.write(new Gson().toJson(outcome));
        } catch (IOException e1) {
            e1.printStackTrace();
            e1.printStackTrace();
            outcome="写入失败，请重新尝试";
            out.write(new Gson().toJson(outcome));
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
