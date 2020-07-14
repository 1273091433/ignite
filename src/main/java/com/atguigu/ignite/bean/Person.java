package com.atguigu.ignite.bean;

/**
 * @Classname Person
 * @Description TODO
 * @Date 2020/7/12 20:21
 * @Created by 86153
 */
public class Person {
    private PersonKey personKey;
    private String name;
    private long cityId;

    public PersonKey getPersonKey() {
        return personKey;
    }

    public void setPersonKey(PersonKey personKey) {
        this.personKey = personKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public Person() {
    }
}
