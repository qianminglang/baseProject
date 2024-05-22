package com.clear.ocean.controller;


import com.clear.ocean.domain.R;
import com.clear.ocean.domain.param.LoginParam;
import com.clear.ocean.domain.vo.UserLoginVO;
import com.clear.ocean.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author qml
 * @since 2024-05-22
 */
@Api(tags = "用户相关接口")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @ApiOperation("用户登录接口")
    @PostMapping("login")
    public R<UserLoginVO> login(@RequestBody LoginParam loginParam){
        return userService.login(loginParam);
    }

}
