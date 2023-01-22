package Mizut452.learn_law.Mapper;

import Mizut452.learn_law.Model.Entity.LoginUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoginUserMapper {
    @Select("SELECT * FROM userList")
    List<LoginUser> selectAll();

    @Select("SELECT * FROM userList WHERE username = #{username}")
    LoginUser findByUsername(@Param("username") String username);

    @Insert("INSERT INTO userList (email, username, password) VALUES(#{email}, #{username}, #{password})")
    void create(LoginUser loginUser);
}
