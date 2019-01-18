package com.zz.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zz.user.object.User;

@Mapper
public interface UserMapper {

	@Select("select * from t_user where name=#{name}")
	List<User> findUserByName(@Param("name") String name);
	
	@Insert("insert into t_user(name,age,gender) values(#{user.name},#{user.age},#{user.gender})")
	void insertUser(@Param("user") User user);
	
	@Delete("delete from t_user where name=#{name}")
	int deleteUser(@Param("name") String name);
}
