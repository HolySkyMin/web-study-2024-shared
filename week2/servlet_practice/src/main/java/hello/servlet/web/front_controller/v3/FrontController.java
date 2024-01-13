package hello.servlet.web.front_controller.v3;

import hello.servlet.domain.member.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "FrontController v3", urlPatterns = "/front-controller/v3/*")
public class FrontController extends HttpServlet {
    Controller controller;
    Map<String, Controller> controllerMap = Map.of(
            "/front-controller/v3/members", new MemberListController(),
            "/front-controller/v3/members/new-form", new MemberFormController(),
            "/front-controller/v3/members/save", new MemberSaveController()
    );

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        controller = controllerMap.getOrDefault(req.getRequestURI(), null);
        if(controller == null)
            throw new ServletException("Invalid path!");

        Map<String, String> params = new HashMap<>();
        req.getParameterNames()
                .asIterator()
                .forEachRemaining(paramName -> params.put(paramName, req.getParameter(paramName)));
        Model model = controller.control(params);
        View view = new View(model);
        view.render(req, resp);
    }
}
