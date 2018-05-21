package com.github.test;

import com.alibaba.fastjson.JSON;
import com.github.sqllitemybatis.Main;
import com.github.sqllitemybatis.domain.User;
import com.github.sqllitemybatis.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("钢铁侠");
        user.setAge(40);
        Integer id = userMapper.insert(user);
        System.out.println(user.getId());
        System.out.println(JSON.toJSONString(userMapper.findAll()));
    }

}
