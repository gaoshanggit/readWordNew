package com.gs.app.read.api.domain;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author GaoShan =.=
 * @version 1.0
 * @since 2016/9/30 13:20
 */

@Repository
public class UserDao  {

    @Resource
    private JdbcTemplate jdbcTemplate;

    // 查询匹配用户名，密码 的用户数量
    public int getMatchCount(String userName,String passWord){
        String sqlStr =" SELECT count(*) FROM user " +
                " where user_name =? and password=? ";
        return jdbcTemplate.queryForInt(sqlStr,new Object[]{userName,passWord});
    }

    // 根据用户名查询用户的 sql
    public User findUserByUserName(final String userName){

        String sqlStr = " SELECT user_id,user_name "+" FROM user WHERE user_name = ? ";
        final User user = new User();
        jdbcTemplate.query(sqlStr,new Object[]{userName},
                new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                user.setUserId(rs.getString("user_id"));
                user.setUserName(userName);
                user.setCredits(rs.getString("credits"));
            }
        });

    return user;
    }

    public void updateLoginInfo(User user){
        String sqlStr = "UPDATE user SET last_visit=?,last_ip=?,credits=? "
                +"WHERE user_id=? ";
        jdbcTemplate.update(sqlStr,new Object[]{user.getLastVisit(),
                user.getLastIp(),user.getCredits(),user.getUserId()});
    }

}
