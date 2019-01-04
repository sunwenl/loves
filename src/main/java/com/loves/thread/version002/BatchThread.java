package com.loves.thread.version002;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/3
 *
 * 多线程  分发信息
 */
public class BatchThread {

    private List<User> userList;

    BatchThread() {
        userList = new ArrayList();
        for (int i = 1; i < 11; i++) {
            User user = new User(i, "姓名" + i);
            userList.add(user);
        }
    }

    public static void main(String[] args) {
        //1,初始化数据
        BatchThread batchThread = new BatchThread();

        //2.设置每个线程最多跑几个
        int count = 2;
        //3,计算线程数，并计算每个线程跑那些数据
        List<List<User>> lists = ListUtils.splitList(batchThread.userList, count);
        for (int i = 0; i < lists.size(); i++) {
            //4,让每个子线程 执行数据
            UserThread userThread = new UserThread(lists.get(i));
            userThread.setName("线程"+(i+1));
            userThread.start();
        }
    }
}


