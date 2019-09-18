package Servlet;

import Services.TerrainData_Remote;
import Util.OutList;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/remote")
public class RemoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("textml;charset=UTF-8");

        int start;
        int end;
        int substance = 4;

        TerrainData_Remote data = new TerrainData_Remote();

        start = Integer.parseInt(request.getParameter("start"));
        end = Integer.parseInt(request.getParameter("end"));
        substance = Integer.parseInt(request.getParameter("sub"));
        System.out.println(start);
        System.out.println(end);
        System.out.println(substance);

        OutList list = data.getData(start, end, substance);

        Gson gson=new Gson();
        String json = gson.toJson(list);

        PrintWriter out = response.getWriter();
        out.print(json);
    }
}
