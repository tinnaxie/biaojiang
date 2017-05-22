/**
 * 
 */
package com.itinna.smalltool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itinna.smalltool.common.exception.ServiceException;
import com.itinna.smalltool.common.utils.StringUtils;
import com.itinna.smalltool.dao.mapper.UserAppMapper;
import com.itinna.smalltool.dao.mapper.UserMapper;
import com.itinna.smalltool.dao.mapper.UserTemplateMapper;
import com.itinna.smalltool.dao.model.User;
import com.itinna.smalltool.dao.model.UserApp;
import com.itinna.smalltool.dao.model.UserTemplate;
import com.itinna.smalltool.service.TemplateService;
import com.itinna.smalltool.service.UserService;
import com.itinna.smalltool.web.form.user.LoginForm;
import com.itinna.smalltool.web.view.LoginUserView;

/**
 * non-javadoc
 *
 * @author tinna.xie
 * @date : 2017年4月4日 下午4:32:49
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserAppMapper userAppMapper;

    @Autowired
    private UserTemplateMapper userTemplateMapper;

    @Autowired
    private TemplateService templateService;

    @Override
    @Transactional(value = "transactionManager", isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public LoginUserView login(LoginForm form) {
        String appUserId = form.getAppUserId();
        if (StringUtils.isEmpty(appUserId)) {
            throw new ServiceException("no app user ID");
        }
        Integer appTypeId = form.getAppTypeId();
        if (appTypeId == null) {
            throw new ServiceException("no app type");
        }
        String cellphone = form.getCellphone();
        if (StringUtils.isEmpty(cellphone)) {
            throw new ServiceException("no cellphone No.");
        }

        if (this.isNewBiaojiangUser(cellphone)) { // new biaojiang user
            // insert user
            String userId = this.createBiaojiangUser(cellphone);

            // insert user_app
            this.createAppUser(appUserId, userId, appTypeId);
        } else if (this.isNewAppUser(appUserId, appTypeId)) {// new app user
            // insert user_app

            this.createAppUser(appUserId, this.getUserIdByCellphoneNo(cellphone), appTypeId);
        }

        User user = this.userMapper.selectByCellphoneNo(cellphone);
        if (user == null) {
            throw new ServiceException("no user");
        }
        LoginUserView userView = this.getUserView(user);
        return userView;
    }

    private LoginUserView getUserView(User user) {
        LoginUserView userView = new LoginUserView();
        userView.setUserId(user.getId());
        return userView;
    }

    private String getUserIdByCellphoneNo(String cellphoneNo) {
        User user = this.userMapper.selectByCellphoneNo(cellphoneNo);
        if (user != null) {
            return user.getId();
        } else {
            return null;
        }
    }

    private String createBiaojiangUser(String cellphone) {
        User user = new User();
        String userId = User.generateID();
        user.setId(userId);
        user.setCellphone(cellphone);
        user.setCreator(userId);
        user.setModifier(userId);
        this.userMapper.insertSelective(user);
        return userId;
    }

    private void createAppUser(String appUserId, String userId, Integer appTypeId) {
        if (StringUtils.isEmpty(userId)) {
            throw new ServiceException("no user id");
        }
        UserApp userApp = new UserApp();
        userApp.setId(UserApp.generateID());
        userApp.setUserId(userId);
        userApp.setAppUserId(appUserId);
        userApp.setAppTypeId(appTypeId);
        userApp.setCreator(userId);
        userApp.setModifier(userId);
        this.userAppMapper.insertSelective(userApp);
    }

    private boolean isNewBiaojiangUser(String cellphoneNo) {
        return this.userMapper.selectByCellphoneNo(cellphoneNo) == null;
    }

    private boolean isNewAppUser(String appUserId, Integer appTypeId) {
        return this.userAppMapper.selectByAppUserIdAndAppTypeId(appUserId, appTypeId) == null;
    }

    @Override
    @Transactional(value = "transactionManager", isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public boolean delete(List<String> userIds) {
        if (userIds != null) {
            for (String userId : userIds) {
                this._delete(userId);
            }
        }
        return true;
    }

    private void deleteUser(String userId) {
        this.userMapper.deleteByPrimaryKey(userId);
    }

    private void deleteUserApp(String userId) {
        List<UserApp> userApps = this.userAppMapper.selectByUserId(userId);
        if (userApps != null) {
            for (UserApp userApp : userApps) {
                this.userAppMapper.deleteByPrimaryKey(userApp.getId());
            }
        }
    }

    private void deleteUserTemplate(String userId) {
        List<UserTemplate> userTemplates = this.userTemplateMapper.selectByUserId(userId);
        if (userTemplates != null) {
            for (UserTemplate userTemplate : userTemplates) {
                this.userTemplateMapper.deleteByPrimaryKey(userTemplate.getId());

                // delete template
                String templateId = userTemplate.getTemplateId();
                List<UserTemplate> _userTemplates = this.userTemplateMapper.selectByTemplateId(templateId);
                if (_userTemplates == null) {
                    this.templateService.delete(templateId);
                }
            }
        }
    }

    @Override
    @Transactional(value = "transactionManager", isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public boolean delete(String userId) {
        return this._delete(userId);
    }

    private boolean _delete(String userId) {
        // delete user_app
        this.deleteUserApp(userId);

        // delete user_template(contains : template, node, report, report_value, attachment)
        this.deleteUserTemplate(userId);

        // delete user
        this.deleteUser(userId);

        return true;
    }
}
