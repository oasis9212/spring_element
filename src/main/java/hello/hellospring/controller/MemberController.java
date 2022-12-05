package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//  스프링의 창고엔 크게 (컨트롤러), (서비스), (리포지토리) 보따리가 포함한다고 보면 편하다.
@Controller
public class MemberController {

    private final  MemberService memberService;

    // autowired
    // 컨트롤러와 서비스를 연결하는 매개체라고 생각하면 된다.
    // @Service  연결 해줘야한다.
    // 생성자에서 자동 주입 해주기도 한다.
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService=memberService;
    }


    @GetMapping("/members/new")
    public String createForm(){
        return "/members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm form){
        System.out.println("asd?aS?Dasd");
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members= memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
