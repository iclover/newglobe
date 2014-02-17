package com.newglobe.minutes.dao.systemmgr;

import com.newglobe.minutes.model.systemmgr.UserInfo;
import com.newglobe.minutes.model.systemmgr.UserInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {
    int countByExample(UserInfoCriteria example);

    int deleteByExample(UserInfoCriteria example);

    int deleteByPrimaryKey(Long userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoCriteria example);

    UserInfo selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoCriteria example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoCriteria example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}