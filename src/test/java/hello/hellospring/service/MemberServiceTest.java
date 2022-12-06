package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {

    MemberRepository memberRepository;
    MemberService memberService;


    // 테스트를
    @BeforeEach
    public  void beforeEach(){
        memberRepository= new MemoryMemberRepository();
        memberService= new MemberService(memberRepository);
    }

    @AfterEach
    public  void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("hello");


        // when
        Long saveId = memberService.join(member);

        //then
        Member findone =  memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findone.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member= new Member();
        member.setName("spring");

        Member member2= new Member();
        member2.setName("spring");
        //when
        memberService.join(member);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재한 회원 입니다.123123 ");

//        try{
//            memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e){
//        assertThat(e.getMessage()).isEqualTo("이미 존재한 회원 입니;당.!23123");
//        }



        //then
    }

    @Test
    void 맴버_찾기() {
    }

    @Test
    void 맴버_하나_찾기() {
    }
}