package com.cos.blog.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDTO;
import com.cos.blog.model.User;

@RestController
public class UserApiController {
    

    @PostMapping("/api/user")
    public ResponseDTO<Integer> save(@RequestBody User user) {
        System.out.println("UserApiController : save 호출됨");

        // 실제로 DB에 insert를 하고 아래에서 return 이 되면 되요.
        return new ResponseDTO<Integer>(HttpStatus.OK, 1);
    }
}
