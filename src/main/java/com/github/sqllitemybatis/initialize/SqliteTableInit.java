package com.github.sqllitemybatis.initialize;

import com.github.sqllitemybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SqliteTableInit implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (userMapper.isTableExists() == 0) {
            userMapper.createTable();
        }
    }

}
