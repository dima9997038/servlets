package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MainServlet extends HttpServlet {
    private final static String index = "/WEB-INF/view/index.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> allStudents = new StudentRepository().findAllStudents();
        allStudents.forEach(System.out::println);

        req.getRequestDispatcher(index).forward(req,resp);
    }
}
