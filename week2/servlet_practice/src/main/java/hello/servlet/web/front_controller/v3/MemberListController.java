package hello.servlet.web.front_controller.v3;

import hello.servlet.domain.member.MemberRepository;
import hello.servlet.domain.member.Model;

import java.util.Map;

public class MemberListController implements Controller {
    MemberRepository repository = MemberRepository.getInstance();

    @Override
    public Model control(Map<String, String> params) {
        Model model = new Model("members");
        for (var member : repository.findAll()) {
            model.setModel(member.getUsername(), member);
        }
        return model;
    }
}
