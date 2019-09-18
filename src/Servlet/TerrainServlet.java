package Servlet;

import Services.TerrainData;
import Util.OutList;
import com.google.gson.Gson;
//import jdk.nashorn.internal.parser.JSONParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/terrain")
public class TerrainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int start = 1;
        int end = 1;
        int substance = 4;




//        file = request.getParameter("file");
//        System.out.println(file);
        start = Integer.parseInt(request.getParameter("start"));
        end = Integer.parseInt(request.getParameter("end"));
        substance = Integer.parseInt(request.getParameter("sub"));
    System.out.println("======"+start);
 System.out.println(end);
        System.out.println(substance);
        TerrainData data = new TerrainData();

//        Type listType = new TypeToken<Person>() {}.getType();
        OutList list = data.getData(start, end, substance);
//        List<String> target = new LinkedList<String>();
//        target.add("blah");

        Gson gson=new Gson();
        String json = gson.toJson(list);
//        List<String> target2 = gson.fromJson(json, listType);

//        request.setAttribute("list", list);
//        request.getRequestDispatcher("home.jsp").forward(request, response);

        PrintWriter out = response.getWriter();
        out.print(json);
//        out.print("请求的数据");

    }
}
