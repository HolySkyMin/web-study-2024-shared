package hello.servlet.web.front_controller.v1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormController implements Controller {
    @Override
    public void control(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Viewer
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/members/new-form.jsp?type=front-controller/v1");
        dispatcher.forward(request, response);
    }
}
