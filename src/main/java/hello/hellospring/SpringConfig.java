package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }


    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }

    /*
    * 구현체를 알맞게끔 맞춰서 설정하게 해준다.
      스프링의 DI (Dependencies Injection)을 사용하면 기존 코드를 전혀 손대지 않고, 설정만으로 구현
      클래스를 변경할 수 있다.
     어플리케이션 조립이 유용하기 때문에 spring 을 쓰는 것이다.
    * */
    // @Bean
    //public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
       // return new JdbcMemberRepository(dataSource);
       // return  new JdbcTemplateMemberRepository(dataSource);
       // return new JpaMemberRepository(em);
    //}
}
