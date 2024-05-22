package com.clear.ocean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clear.ocean.domain.R;
import com.clear.ocean.domain.param.LoginParam;
import com.clear.ocean.domain.po.User;
import com.clear.ocean.domain.vo.UserLoginVO;

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
     * @param loginParam
     * @return com.clear.ocean.domain.vo.UserLoginVO
     **/
    R<UserLoginVO> login(LoginParam loginParam);
}
