package com.xiejinhua.example.server.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiejinhua.example.dao.UserMapper;
import com.xiejinhua.example.server.UserServer;

@Service
public class UserServerImpl implements UserServer {

	private Logger log = LoggerFactory.getLogger(UserServerImpl.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Integer getUserCount() {

		Integer count = null;
		try{
			count = this.userMapper.getCount();
		}catch (Exception e) {
			e.printStackTrace();
			log.info("执行数据库失败： -------------- " + e.getMessage());
			return null;
		}

		if ( count == null ) {
			log.info("执行数据库数据返回null但是并没有错误返回");
			return null;
		}
		
		return count;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int insert(String name) throws Exception {
		
		if ( name == null || name.length() <= 0 )
			return 0;
		
		int count = this.userMapper.insert(name);
		if ( count > 0 )
			throw new Exception();
		return count;
	}

}
