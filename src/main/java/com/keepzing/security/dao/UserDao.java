package com.keepzing.security.dao;

import com.keepzing.security.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    @Select("select * from users where username = #{username}")
    User selectUserByUsername(String username);
}
