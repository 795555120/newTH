package Servlet;

import Services.GetLineChartData;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LineChartServlet")
public class LineChartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int x=150;
            int y=150;
            int substance=9;
            int start=1;
            x=Integer.parseInt(request.getParameter("x"));
            y=Integer.parseInt(request.getParameter("y"));
            substance=Integer.parseInt(request.getParameter("sub"));
            start=Integer.parseInt(request.getParameter("start"));
        System.out.println(x+"  y:"+y);

            GetLineChartData data=new GetLineChartData();
        System.out.println("data");
            float [] lineChartDatas=  data.getData(start,x,y,substance);

 System.out.println(lineChartDatas[3]);
        PrintWriter writer = response.getWriter();
        writer.write(new Gson().toJson(lineChartDatas));
    }
}
