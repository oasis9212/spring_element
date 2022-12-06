package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

//  @Transactional 인서트 쿼리를 실행한 뒤에 롤백을 시켜버린다.
// 테스트 케이스만 적용함.
@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;

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



        //then
    }


}