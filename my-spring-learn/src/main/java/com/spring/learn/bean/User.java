package com.spring.learn.bean;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/8
 */
public class User {
    private int id;
    private String name;
    public User(){
        System.out.println("user 无参构造");
    }
    public User(int id,String name){
        System.out.println("user 有参构造，name:"+name+",id:"+id);
        this.id =id;
        this.name=name;
    }

    @Override
    public String toString() {
        return "user---name:"+name+",id:"+id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
