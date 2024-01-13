package hello.servlet.web.front_controller.v4;

import hello.servlet.domain.member.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class View {
    private Model _model;
    private String _path;

    public View(Model model) {
        _model = model;
        _path = "/view-m/" + _model.getViewName() + ".jsp";
    }

    public void render(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(_path);
        req.setAttribute("model", _model);
        dispatcher.forward(req, resp);
    }
}
