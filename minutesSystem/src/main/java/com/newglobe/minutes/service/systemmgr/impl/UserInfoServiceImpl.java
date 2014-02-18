package com.newglobe.minutes.service.systemmgr.impl;

import com.newglobe.minutes.dao.systemmgr.UserInfoMapper;
import com.newglobe.minutes.model.systemmgr.UserInfo;
import com.newglobe.minutes.model.systemmgr.UserInfoCriteria;
import com.newglobe.minutes.service.systemmgr.IUserInfoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 14-2-17.
 */
public class UserInfoServiceImpl implements IUserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUser(String loginName) throws Exception {
        UserInfoCriteria example = new UserInfoCriteria();
        example.createCriteria().andIsValidEqualTo("1").andUserNameEqualTo(loginName);
        List<UserInfo> userInfoList = userInfoMapper.selectByExample(example);
        UserInfo userinfo = new UserInfo();
        if( null != userInfoList && userInfoList.size() > 0){
            userinfo =  userInfoList.get(0);
        }
        return userinfo;
    }

    @Override
    public Integer login(UserInfo userInfo) throws Exception {
        return null;
    }

    @Override
    public int save(UserInfo userInfo) throws Exception {
        return 0;
    }

    @Override
    public int update(UserInfo userInfo) throws Exception {
        return 0;
    }

    @Override
    public void delete(Long sysUserId) throws Exception {

    }

    @Override
    public UserInfo getUser(Long sysUserId) throws Exception {
        return null;
    }

    @Override
    public boolean isExistUserName(UserInfo userInfo) throws Exception {
        return false;
    }
}
