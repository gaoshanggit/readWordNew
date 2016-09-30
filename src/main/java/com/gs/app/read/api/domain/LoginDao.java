package com.gs.app.read.api.domain;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author GaoShan =.=
 * @version 1.0
 * @since 2016/9/30 18:51
 */
@Repository
public class LoginDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public void insertLogin(LoginLog loginLog) {
        String sqlStr = " INSERT INTO login_log (user_id, ip,login_datetime) " +
                " VALUES (?,?,?) ";
        Object[] args = {loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()};
        jdbcTemplate.update(sqlStr, args);

    }
}
