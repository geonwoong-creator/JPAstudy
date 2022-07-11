package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //JSON 형태 결과값을 반환해줌 (@ResponseBody가 필요없음)
@RequiredArgsConstructor //final 객체를 constructor Injection 해줌. (Autowired 역활)
@RequestMapping("/v1")
public class UserController {

    private  final UserRepository userRepository;

    /**
     * 멤버 조회
     * @return
     */
    @GetMapping("user")
    public List<UserEntity> findAllUser(){

        return userRepository.findAll();
    }

    /**
     * 회원가입
     * @return
     */
    @PostMapping("user")
    public UserEntity signUp() {
        final UserEntity user = UserEntity.builder()
                .userid("rjsdnd0420")
                .name("test")
                .build();
        return userRepository.save(user);
    }
}
