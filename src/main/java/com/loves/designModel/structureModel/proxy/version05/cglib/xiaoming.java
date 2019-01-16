package com.loves.designModel.structureModel.proxy.version05.cglib;

import com.loves.designModel.structureModel.proxy.version05.proxy.Hose;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/14
 */
public class xiaoming implements Hose {
    @Override
    public void sale() {
        System.out.println("我是小明   我要买房了" );
    }
}
