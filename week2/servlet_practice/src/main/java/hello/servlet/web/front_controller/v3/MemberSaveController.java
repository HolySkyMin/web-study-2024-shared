package hello.servlet.web.front_controller.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.domain.member.Model;

import java.util.Map;

public class MemberSaveController implements Controller {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public Model control(Map<String, String> params) {
        String username = params.get("username"); // 파라미터를 꺼내서
        int age = Integer.parseInt(params.get("age")); // 파라미터를 꺼내서
        Member member = new Member(username, age);
        memberRepository.save(member); // 저장하고

        Model model = new Model("save-result");
        model.setParameter("id", member.getId().toString());
        model.setParameter("username", member.getUsername());
        model.setParameter("age", String.valueOf(member.getAge()));
        return model;
    }
}
