package com.itinna.smalltool.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/spring-context.xml", "classpath:/log/log4j.xml" })
public class TemplateMapperTest {

    @Autowired
    private TemplateMapper templateMapper;

    @Test
    public void test() {
        int count = this.templateMapper.countWritableByUserId(1L);
        System.out.println(count);
    }
}
