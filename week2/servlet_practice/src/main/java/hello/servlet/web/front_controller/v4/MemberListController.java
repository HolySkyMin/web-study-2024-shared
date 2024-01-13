package hello.servlet.web.front_controller.v4;

import hello.servlet.domain.member.MemberRepository;

import java.util.Map;

public class MemberListController implements Controller {
    MemberRepository repository = MemberRepository.getInstance();

    @Override
    public String control(Map<String, String> params, Map<String, Object> models) {
        for (var member : repository.findAll()) {
            models.put(member.getUsername(), member);
        }
        return "members";
    }
}
