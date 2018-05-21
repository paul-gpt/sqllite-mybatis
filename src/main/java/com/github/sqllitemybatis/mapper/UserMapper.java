package com.github.sqllitemybatis.mapper;

import com.github.sqllitemybatis.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Insert("INSERT INTO t_user(name, age) VALUES(#{name}, #{age})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Integer insert(User user);

    @Select("SELECT * FROM t_user WHERE id = #{id}")
    User select(Integer id);

    @Select("SELECT * FROM t_user")
    List<User> findAll();

    @Update("CREATE TABLE t_user(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(64), age INTEGER)")
    void createTable();

    @Select("SELECT count(1) FROM sqlite_master WHERE type='table' and name = 't_user'")
    int isTableExists();

}
