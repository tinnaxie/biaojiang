/**
 * 
 */
package com.itinna.smalltool.service.impl;

import org.springframework.stereotype.Service;

import com.itinna.smalltool.service.UserService;
import com.itinna.smalltool.web.vo.LoginUserVO;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月4日 下午4:32:49
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Override
    public Long getUserIdByBizUserId(String bizUserId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long createNewUser(String bizUserId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LoginUserVO getUser(Long userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LoginUserVO login(String bizUserId) {
        // TODO Auto-generated method stub
        return null;
    }

}
