package hello.servlet.web.front_controller.v2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormController implements Controller {
    @Override
    public View control(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new View("/view/members/new-form.jsp?type=front-controller/v2", request, response);
    }
}
