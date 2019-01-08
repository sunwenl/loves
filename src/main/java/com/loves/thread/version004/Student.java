package com.loves.thread.version004;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/5
 */
public class Student {
    private int id;
    private String name;
    private String sex;

    // 为false表示 未写入完值  。为true 写入完值out线程开始读取值，读取完，修改为false
    private boolean flag = false;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student 信息是[id:"+this.id+",name:"+this.name+",sex:"+this.sex+"]";
    }
}
