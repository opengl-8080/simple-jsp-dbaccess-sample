package sample;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Map<String, Object>> list = DBAccess.instance.readList();
        System.out.println("list = " + list);
        
        req.setAttribute("list", list);
        req.getRequestDispatcher("jsp/hello.jsp").forward(req, resp);
    }
}
