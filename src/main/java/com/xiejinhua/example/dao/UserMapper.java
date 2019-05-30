package com.xiejinhua.example.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
	
	@Select("select count(1) from histories")
	public Integer getCount() throws Exception;
	
	public int insert( String name ) throws Exception;

}