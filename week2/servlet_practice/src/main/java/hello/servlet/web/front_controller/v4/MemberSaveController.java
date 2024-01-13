package hello.servlet.web.front_controller.v4;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import java.util.Map;

public class MemberSaveController implements Controller {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String control(Map<String, String> params, Map<String, Object> models) {
        String username = params.get("username"); // 파라미터를 꺼내서
        int age = Integer.parseInt(params.get("age")); // 파라미터를 꺼내서
        Member member = new Member(username, age);
        memberRepository.save(member); // 저장하고

        params.put("id", member.getId().toString());
        return "save-result";
    }
}
