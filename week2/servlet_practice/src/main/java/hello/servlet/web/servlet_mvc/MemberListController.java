package hello.servlet.web.servlet_mvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "memberListController", urlPatterns = "/servlet-mvc/members")
public class MemberListController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Viewer
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/members.jsp");
        dispatcher.forward(request, response);
    }
}
