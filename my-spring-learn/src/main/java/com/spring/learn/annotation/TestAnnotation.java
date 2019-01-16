package com.spring.learn.annotation;
import java.lang.reflect.Field;

@SetTable(value = "user_cash")
class UserCash{
    @SetProperty(name="id",length = 2)
    private int id;
    @SetProperty(name="user_name",length =3)
    private String userName;

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
/**
 * @Author ：SunWenLong
 * @Date ：2019/1/11
 * 使用java自定义注解 模拟ORM框架注解版本
 */
public class TestAnnotation {
    public static void main(String[] args) throws  Exception{
        // 1.反射class
        Class clazz= Class.forName("com.spring.learn.annotation.UserCash");
        // 2.获取表名称注解
        SetTable setTable = (SetTable) clazz.getAnnotation(SetTable.class);
        //3获取所有的成员属性
        Field[] declaredFields= clazz.getDeclaredFields();
        StringBuffer sf= new StringBuffer();
        sf.append("select ");
        String formName = setTable.value();
        for (int i=0;i<declaredFields.length;i++){
            Field field = declaredFields[i];
            //4获取属性字段
            SetProperty sb = field.getAnnotation(SetProperty.class);
            sf.append(" "+sb.name() + " ");
            if(i == declaredFields.length -1){
                sf.append(" from ");
            }else {
                sf.append(" , ");
            }
        }
        sf.append(" "+ formName);
        System.out.println(sf.toString());
    }
}
