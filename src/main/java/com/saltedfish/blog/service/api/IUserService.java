package com.saltedfish.blog.service.api;

import com.saltedfish.blog.vo.UserVo;

public interface IUserService {

	UserVo login(String username, String password);

}
