package com.xiejinhua.example.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DoubleMapper {

	@Insert("INSERT INTO `double` VALUES (${b1},${b2},${b3},${b4},${b5},${b6},${r})")
	@Options(useGeneratedKeys = false)
	int insertDouble(@Param("b1") int b1, @Param("b2") int b2, @Param("b3") int b3, @Param("b4") int b4,
			@Param("b5") int b5, @Param("b6") int b6, @Param("r") int r);

}
