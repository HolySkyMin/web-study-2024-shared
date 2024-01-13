package hello.servlet.web.front_controller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {
    void control(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
