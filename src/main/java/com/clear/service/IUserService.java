package com.clear.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clear.domain.R;
import com.clear.domain.dto.LoginFormDTO;
import com.clear.domain.po.User;
import com.clear.domain.vo.UserLoginVO;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author qml
 * @since 2024-05-22
 */
public interface IUserService extends IService<User> {

    /***
     * 登录
     * @author qml
     * @date 2024-5-22 15:23
     * @param loginFormDTO
     * @return com.clear.ocean.domain.vo.UserLoginVO
     **/
    R<UserLoginVO> login(LoginFormDTO loginFormDTO);
}
