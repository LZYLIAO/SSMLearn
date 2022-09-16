package com;

import com.test.liao.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JdbcTemplateTest2 {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //更新、删除
    @Test
    public void testUpdate(){
        jdbcTemplate.update("update users set money=9999 where name=?","Tom");
    }
    @Test
    public void testDelete(){
        jdbcTemplate.update(("delete from users where name=?"),"Tom");
    }
//    查询
    @Test
    public void testSelectAll(){

        List<Account> list=jdbcTemplate.query("select * from users",new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(list);
    }
    @Test
    public void testQueryOne(){
        Account account=jdbcTemplate.queryForObject("select * from users where name=?",new BeanPropertyRowMapper<Account>(Account.class),"Tom123");
        System.out.println(account);
    }
    @Test
    public void testQueryCount(){
        Long ret=jdbcTemplate.queryForObject(("select count(*) from users"),Long.class);
        System.out.println(ret);
    }


}
