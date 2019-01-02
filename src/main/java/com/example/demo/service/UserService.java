package com.example.demo.service;

import com.example.demo.bean.PageBean;
import com.example.demo.bean.User;

public interface UserService {

	PageBean getUsersPage(PageBean pb, String nickName);
	
	User getUser();
}
