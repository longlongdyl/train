package com.sh2004.bean;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ProjectName: train
 * @Package: com.sh2004.bean
 * @Description: java类作用描述
 * @Author: 邓禹龙
 * @CreateDate: 2020/11/12 10:05
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Table(name = "t_order")
public class Order {
    @Id
    @KeySql(useGeneratedKeys = true)
    private String oid;
    private String otime;
    private String uid;
    private String otime2;
    private User user;

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", otime='" + otime + '\'' +
                ", uid='" + uid + '\'' +
                ", otime2='" + otime2 + '\'' +
                ", user=" + user +
                '}';
    }

    public String getOtime2() {
        return otime2;
    }

    public void setOtime2(String otime2) {
        this.otime2 = otime2;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOtime() {
        return otime;
    }

    public void setOtime(String otime) {
        this.otime = otime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
