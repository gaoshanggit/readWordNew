package com.gs.app.read.api.domain;

/**
 * /**
 * @author GaoShan =.=
 * @version 1.0
 * @since 2017/7/21 22:16
 */

public class StudentBean {

    private String no; //学号
    private String name; //姓名
    private String age; //年龄
    private float score; //成绩


    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
