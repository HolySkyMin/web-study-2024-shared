package hello.servlet.web.front_controller.v2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class View {
    private String _jspUrl;
    private HttpServletRequest _request;
    private HttpServletResponse _response;

    public View(String jspUrl, HttpServletRequest req, HttpServletResponse resp) {
        _jspUrl = jspUrl;
        _request = req;
        _response = resp;
    }

    public void render() throws ServletException, IOException {
        RequestDispatcher dispatcher = _request.getRequestDispatcher(_jspUrl);
        dispatcher.forward(_request, _response);
    }
}
