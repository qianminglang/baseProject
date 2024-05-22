package com.clear;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest(classes = BaseProjectApplication.class)
@RequiredArgsConstructor
class BaseProjectApplicationTests {
    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        String encode = passwordEncoder.encode(String.valueOf(123));
        System.out.println(encode);
    }

}
