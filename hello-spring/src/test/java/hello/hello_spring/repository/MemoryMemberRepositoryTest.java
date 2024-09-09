package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 메소드 실행이 끝날 때 마다 동작하는 어노테이션
    public void afterEach(){
        repository.clearStore();
    }
    // 각 Test메소드 실행이 끝난 후 데이터를 비워준다
    // Test는 의존관계가 없이 설계되어야하기때문 (실행순서를 보장하지않는다) 그래서 저장소나 공용 데이터를 비워줘야함

    @Test
    public void save(){
        Member member=new Member();
        member.setName("하경");

        repository.save(member);
        Member result=repository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);

        //Assertions.assertEquals(member, result);
        //System.out.println((result==member));
    }
    @Test
    public void findByName(){
        Member member1=new Member();
        member1.setName("하경2");
        repository.save(member1);

        Member member2=new Member();
        member2.setName("하경3");
        repository.save(member2);

 //       System.out.println(repository.findByName("하경2").get());

        Member result1 = repository.findByName("하경2").get();
        Assertions.assertThat(result1).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member=new Member();
        member.setName("하경2");
        repository.save(member);

        Member member2=new Member();
        member2.setName("하경3");
        repository.save(member2);

        List<Member> result= repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
