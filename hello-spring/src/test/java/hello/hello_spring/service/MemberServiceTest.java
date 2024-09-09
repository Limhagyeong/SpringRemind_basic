package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberReporitory;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {
    MemberService memberservice;
    MemoryMemberRepository repository;

    @BeforeEach
    public void beforeEach(){
        repository = new MemoryMemberRepository();
        memberservice = new MemberService(repository);
    }

    @AfterEach // 메소드 실행이 끝날 때 마다 동작하는 어노테이션
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    void 회원가입(){
        // given
        Member member=new Member();
        member.setName("하위~");

        // when
        Long saveId=memberservice.join(member);

        // then
        Member findMember = memberservice.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        // given
        Member member1=new Member();
        member1.setName("하위~");

        Member member2=new Member();
        member2.setName("하위~");

        //when
        memberservice.join(member1);

        assertThrows(IllegalStateException.class, () -> memberservice.join(member2));

        //then
       /* try {
            memberservice.join(member2);

        }catch (IllegalStateException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원 입니다");
        }*/

    }

    @Test
    void findMembers(){

    }

    @Test
    void findOne(){

    }
}
