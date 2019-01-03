package com.loves.thread.version002;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/3
 */
public class User {
    private int id;
    private String name;

    User(int id, String name){
        this.id = id ;
        this.name = name;
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

    public String  toString(){
        return "User[ id:"+this.id+",name:"+this.name+"]";
    }
}
