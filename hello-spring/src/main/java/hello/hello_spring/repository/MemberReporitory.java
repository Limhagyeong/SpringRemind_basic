package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;
// 데이터 저장소 (DAO 생각)
// dto를 통해 객체를 만들고 (setter) vo를 통해 사용 (getter) 즉 vo는 불변성을 유지해야함
// entity는 jpa 사용 시 등장하는 개념 DB 테이블과 직접 매핑됨
public interface MemberReporitory {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
