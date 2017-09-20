package com.saltedfish.blog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.saltedfish.blog.dao.api.IInformationDao;
import com.saltedfish.blog.dao.api.IUserDao;
import com.saltedfish.blog.pojo.Information;
import com.saltedfish.blog.pojo.User;
import com.saltedfish.blog.service.api.IUserService;
import com.saltedfish.blog.vo.UserVo;

@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDao;
	@Resource
	private IInformationDao infoDao;
	
	@Override
	public UserVo login(String username, String password) {
		UserVo response = null;
		if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
			User user = userDao.getUser(username, password);
			if (user != null) {
				Information information = infoDao.getInfo(user.getUser_id());
				if (information != null && information.getUser_id() == user.getUser_id()) {
					response = getUserVo(user, information);
				}
			}
		}
		return response;
	}
	
	private UserVo getUserVo(User user, Information information) {
		UserVo result = null;
		if (information.getUser_id() == user.getUser_id()) {
			result = new UserVo();
			result.setUser_id(user.getUser_id());
			result.setNick_name(information.getNick_name());
			result.setReal_name(information.getReal_name());
			result.setBirthday(information.getBirthday());
			result.setEmail(information.getEmail());
			result.setQq(information.getQq());
			result.setMobile(information.getMobile());
		}
		return result;
	}

}
