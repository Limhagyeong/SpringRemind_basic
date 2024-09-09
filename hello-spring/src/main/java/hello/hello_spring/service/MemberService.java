package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberReporitory;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberReporitory memberReporitory;

    public MemberService(MemberReporitory memberReporitory){
        this.memberReporitory=memberReporitory;
    } // 인터페이스의 구현체를 주입해주는것임 (MemoryMemberRepository)
    // 회원가입
    public Long join(Member member){

        // 같은 이름을 가진 중복 회원에 대한 유효성 검사
        validateDuplicateMember(member);

        memberReporitory.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberReporitory.findByName(member.getName())
                .ifPresent(m -> {
                             throw new IllegalStateException("이미 존재하는 회원 입니다");
                });
    }

    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberReporitory.findAll();
    }
    
    // 특정 회원 조회
    public Optional<Member> findOne(Long memberId){
        return memberReporitory.findById(memberId);
    }
}
