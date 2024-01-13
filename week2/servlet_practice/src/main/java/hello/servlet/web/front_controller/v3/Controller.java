package hello.servlet.web.front_controller.v3;

import hello.servlet.domain.member.Model;

import java.util.Map;

public interface Controller {
    Model control(Map<String, String> params);
}
