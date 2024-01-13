package hello.servlet.web.front_controller.v2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "FrontController v2", urlPatterns = "/front-controller/v2/*")
public class FrontController extends HttpServlet {
    Controller controller;
    Map<String, Controller> controllerMap = Map.of(
            "/front-controller/v2/members", new MemberListController(),
            "/front-controller/v2/members/new-form", new MemberFormController(),
            "/front-controller/v2/members/save", new MemberSaveController()
    );

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        controller = controllerMap.getOrDefault(req.getRequestURI(), null);
        if(controller == null)
            throw new ServletException("Invalid path!");

        View view = controller.control(req, resp);
        view.render();
    }
}
