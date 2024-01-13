package hello.servlet.web.front_controller.v1;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveController implements Controller {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void control(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MemberSaveController.service");
        String username = request.getParameter("username"); // 파라미터를 꺼내서
        int age = Integer.parseInt(request.getParameter("age")); // 파라미터를 꺼내서
        Member member = new Member(username, age);
        memberRepository.save(member); // 저장하고

        // Viewer
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/members/save.jsp?id=" + member.getId().toString());
        dispatcher.forward(request, response);
    }
}
