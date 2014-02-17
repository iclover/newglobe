package com.newglobe.minutes.service.systemmgr;

import com.newglobe.minutes.model.systemmgr.UserInfo;

public interface IUserInfoService {

	public UserInfo getUser(String loginName) throws Exception;

	/**
	 * @param userInfo
	 * @return 1:没有该用户 2：用户密码错误 3:用户状态冻结或离职 0：登陆成功
	 * @throws Exception
	 */
	public Integer login(UserInfo userInfo, final String ipAddress) throws Exception;

	/**
	 * 新增系统用户：1成功 2：名称重复
	 */
	public int save(UserInfo userInfo) throws Exception;

	/**
	 * 更新系统用户：1 成功 2名称重复
	 */
	public int update(UserInfo userInfo) throws Exception;

	public void delete(Long sysUserId) throws Exception;

	public UserInfo getUser(Long sysUserId) throws Exception;
	
	/**
	 * 判断该用户是否已经存在
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	public boolean isExistUserName(UserInfo userInfo) throws Exception ;

}