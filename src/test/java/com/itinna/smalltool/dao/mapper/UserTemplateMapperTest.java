package com.itinna.smalltool.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itinna.smalltool.dao.model.UserTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/spring-context.xml" })
public class UserTemplateMapperTest {

    @Autowired
    private UserTemplateMapper userTemplateMapper;

    @Test
    public void testSelectById() {
        UserTemplate userTemplate = this.userTemplateMapper.selectByPrimaryKey(1L);
        if (userTemplate == null) {
            System.out.println("userTemplate is ull");
        } else {
            System.out.println(userTemplate.toString());
        }
    }

}
