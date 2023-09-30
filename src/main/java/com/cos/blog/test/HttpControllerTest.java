package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//  @Controller 사용자가 요청 -> 응답(view)
//  @RestController 사용자가 요청 -> 응답(Data)
// 인터넷 브라우저 요청은 get 요청만 가능하다
@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest : ";

    @GetMapping("/http/lombok")
    public String lombokTest() {
        Member m = Member.builder().username("ssar").password("1234").email("ssar@mate.com").build();
        System.out.println(TAG + "getter : " + m.getUsername());
        m.setUsername("cos");
        System.out.println(TAG + "setter : " + m.getUsername());
        return "lombok test 완료";
    }

    // http://localhost:8080/http/get (select)
    @GetMapping("/http/get")
    public String getTest(Member m) { // 매개변수가 클래스면 자동적으로 바인딩해주네... 편하다.
        return "get 요청 : " + m.getId() + ", username : " + m.getUsername() + ", password : " + m.getPassword()
                + ", email :" + m.getEmail();
    }

    // http://localhost:8080/http/post (insert)
    @PostMapping("/http/post")
    public String postTest(@RequestBody Member m) { // MessageConverter (스프링 부트)
        return "post 요청 : " + m.getId() + ", username : " + m.getUsername() + ", password : " + m.getPassword()
                + ", email :" + m.getEmail();

    }

    // http://localhost:8080/http/put (update)
    @PutMapping("/http/put")
    public String putTest() {
        return "put 요청";
    }

    // http://localhost:8080/http/delete (delete)
    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }

}
