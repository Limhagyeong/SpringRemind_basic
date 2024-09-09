package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberContorller {
    private final MemberService memberService;

    @Autowired // => 스프링컨테이너에 등록된 MemberService를 찾아서 bean을 자동 주입해줌 (membercontroller는 memberservice에 의존하고있는 상태)
               // => 의존성 주입! (생성자 방식) 
               // 스프링은 빈을 기본적으로 싱글톤 패턴으로 등록함 => 같은 인스턴스를 공유하게되는것 (메모리 절약 가능)
    public MemberContorller(MemberService memberService){
        this.memberService=memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "/members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member=new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members=memberService.findMembers();
        model.addAttribute("members",members);

        return "members/memberList";
    }
}
