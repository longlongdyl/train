package com.sh2004.bean;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ProjectName: Train
 * @Package: com.sh2004.bean
 * @Description: java类作用描述
 * @Author: 邓禹龙
 * @CreateDate: 2020/11/12 10:01
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Table(name = "t_train")
public class Train {
    @Id
    @KeySql(useGeneratedKeys = true)
    private String tid;
    @Column(name = "tnumber")
    private String tnumber;
    private String taddress;
    private String ttime;
    private String ttype;
   // private Order order;

    @Override
    public String toString() {
        return "Train{" +
                "tid='" + tid + '\'' +
                ", tnumber='" + tnumber + '\'' +
                ", taddress='" + taddress + '\'' +
                ", ttime='" + ttime + '\'' +
                ", ttype='" + ttype + '\'' +
                ", order=" + "" +
                '}';
    }

/*    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }*/

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTnumber() {
        return tnumber;
    }

    public void setTnumber(String tnumber) {
        this.tnumber = tnumber;
    }

    public String getTaddress() {
        return taddress;
    }

    public void setTaddress(String taddress) {
        this.taddress = taddress;
    }

    public String getTtime() {
        return ttime;
    }

    public void setTtime(String ttime) {
        this.ttime = ttime;
    }

    public String getTtype() {
        return ttype;
    }

    public void setTtype(String ttype) {
        this.ttype = ttype;
    }
}
