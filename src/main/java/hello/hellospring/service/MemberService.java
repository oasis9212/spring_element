package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


//@Service
public class MemberService {

    private final MemberRepository memberRepository;

    // 서비스에서 직접 MemberRepository 안넣음.
    // 외부에서 넣음
    // 의존성 주입이걸 뜻함.


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        validateDuplicateMember(member); // 값이 있다면
        memberRepository.save(member);

        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원 입니다.");
                });
    }


    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
