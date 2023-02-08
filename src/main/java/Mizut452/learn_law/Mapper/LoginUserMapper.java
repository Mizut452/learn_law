package Mizut452.learn_law.Mapper;

import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LoginUserMapper {
    @Select("SELECT * FROM userList WHERE username = #{username}")
    LoginUser findByUsername(@Param("username") String username);

    //プライマリーキーと自動採番を同期させる
    @Select("SELECT setval('userList.userId', (SELECT MAX(userId) FROM userList))")
    LoginUser primaryKeySync();

    @Select("SELECT * FROM userList WHERE userId = #{userId}")
    LoginUser findByUserId(@Param("userId") int userId);

    @Select("SELECT * FROM userList")
    List<LoginUser> selectAll();

    @Insert("INSERT INTO userList (email, username, password, roleName) VALUES(#{email}, #{username}, #{password}, 'ROLE_GENERAL')")
    void create(LoginUser loginUser);

    @Update("UPDATE userList SET email = #{email}, username = #{username}, password = #{password} WHERE userId = #{userId}")
    void update(int userId);

    @Update("UPDATE userList SET roleName = #{roleName} WHERE userId = #{userId}")
    void updateUserRole(String roleName, int userId);
}
