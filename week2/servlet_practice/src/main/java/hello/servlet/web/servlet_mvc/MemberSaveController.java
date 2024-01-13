package hello.servlet.web.servlet_mvc;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "memberSaveController", urlPatterns = "/servlet-mvc/members/save")
public class MemberSaveController extends HttpServlet {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MemberSaveServlet.service");
        String username = request.getParameter("username"); // 파라미터를 꺼내서
        int age = Integer.parseInt(request.getParameter("age")); // 파라미터를 꺼내서
        Member member = new Member(username, age);
        memberRepository.save(member); // 저장하고

        // Viewer
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/members/save.jsp?id=" + member.getId().toString());
        dispatcher.forward(request, response);
    }
}
