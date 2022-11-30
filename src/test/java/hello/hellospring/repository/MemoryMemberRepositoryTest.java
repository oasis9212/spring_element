package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemberRepository repo = new MemoryMemberRepository();
    // 테스트를 전체 실행 했을 경우 순서의 보장은 절때 안된다.
    // 또한 하나의 매소드를 발휘할때 선언한 데이터가 그대로 남아 있다. 메소드 돌릴때마다 제거를 해야한다.
    @AfterEach
    // 테스트를 거친후의 콜백
    public void afterEacch(){
        repo.clearStore();
    }

    @Test
    public void save(){
        Member member= new Member();
        member.setName("spring");

        repo.save(member);

        Member result=repo.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName(){
        Member member1= new Member();
        member1.setName("spring1");
        repo.save(member1);

        Member member2= new Member();
        member2.setName("spring2");
        repo.save(member2);

       Member result =repo.findByName("spring1").get();

       assertThat(result).isEqualTo(member1);
    }


    @Test
    public void findAll(){

        Member member1= new Member();
        member1.setName("spring1");
        repo.save(member1);

        Member member2= new Member();
        member2.setName("spring2");
        repo.save(member2);

        List<Member> list = repo.findAll();

        assertThat(list.size()).isEqualTo(2);

    }


}
