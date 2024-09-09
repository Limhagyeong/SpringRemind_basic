package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // 요청이 들어오면 스프링컨테이너에 있는 컨트롤러를 먼저 뒤져서 "/" 매핑이 있는지 확인하고
    // 없으면 static에 있는 index.html (정적페이지) 를 돌려준다
@GetMapping("/")
    public String home(){
    return "home";
}
}
