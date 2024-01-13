package hello.servlet.web.front_controller.v4;

import hello.servlet.domain.member.Model;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public interface Controller {
    String control(Map<String, String> params, Map<String, Object> models);
}
