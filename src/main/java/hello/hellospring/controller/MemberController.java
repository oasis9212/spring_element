package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
}
