package hello.servlet.web.front_controller.v3;

import hello.servlet.domain.member.Model;

import java.util.Map;

public class MemberFormController implements Controller {
    @Override
    public Model control(Map<String, String> params) {
        Model model = new Model("new-form");
        model.setParameter("type", "front-controller/v3");
        return model;
    }
}
