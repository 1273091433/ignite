package com.atguigu.ignite.bean;

/**
 * @Classname Address
 * @Description TODO
 * @Date 2020/7/13 17:09
 * @Created by 86153
 */
public class Address {
    private String name;
    private long val;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getVal() {
        return val;
    }

    public void setVal(long val) {
        this.val = val;
    }

    public Address() {
    }

    public Address(String name, long val) {
        this.name = name;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", val=" + val +
                '}';
    }
}
