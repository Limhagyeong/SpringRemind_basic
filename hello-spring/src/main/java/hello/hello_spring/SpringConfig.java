package hello.hello_spring;

import hello.hello_spring.repository.MemberReporitory;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// 자바코드로 의존성 주입하기
// 컴포넌트 스캔 방식응로 하면 여러 어노테이션을 바꿔줘야하지만 여기서 return 인스턴스만 바꿔주면 되기 때문에 훨씬 편할 수 있음
// 보통 Repository, Service, Controller는 컴포넌트 스캔 방식, AOP 같은 특수한 경우는 Config파일을 사용함
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberReporitory memberRepository(){
        return new MemoryMemberRepository();
    }
}
