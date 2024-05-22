package com.clear.ocean.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clear.ocean.config.JwtProperties;
import com.clear.ocean.domain.R;
import com.clear.ocean.domain.param.LoginParam;
import com.clear.ocean.domain.po.User;
import com.clear.ocean.domain.vo.UserLoginVO;
import com.clear.ocean.enums.UserStatus;
import com.clear.ocean.exception.BizIllegalException;
import com.clear.ocean.mapper.UserMapper;
import com.clear.ocean.service.IUserService;
import com.clear.ocean.util.JwtTool;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author qml
 * @since 2024-05-22
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    private final JwtTool jwtTool;

    private final JwtProperties jwtProperties;

    @Override
    public R<UserLoginVO> login(LoginParam loginParam) {
        //1.查询用户是否存在
        User user = lambdaQuery().eq(User::getUsername, loginParam.getUsername()).one();
        if(Objects.isNull(user)){
            throw new BizIllegalException("用户名错误");
        }
        //2.用户被冻结
        if(UserStatus.FROZEN==user.getStatus()){
            throw new BizIllegalException("用户被冻结");
        }
        String encode = passwordEncoder.encode(loginParam.getPassword());
        System.out.println(encode);
        //3.校验密码
        if(!passwordEncoder.matches(loginParam.getPassword(),user.getPassword())){
            throw new BizIllegalException("用户名或密码错误");
        }

        // 4.生成TOKEN
        String token = jwtTool.createToken(user.getId(), jwtProperties.getTokenTTL());
        // 6.封装VO返回
        UserLoginVO vo = new UserLoginVO();
        vo.setUserId(user.getId());
        vo.setUsername(user.getUsername());
        vo.setToken(token);
        return R.ok(vo);
    }
}
