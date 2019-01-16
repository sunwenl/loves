package com.loves.designModel.structureModel.proxy.version05.proxy;

import org.apache.poi.ss.formula.ptg.Pxg;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/14
 * 静态代理需要自己生成代理类
 */
public class ProxyHose implements Hose {
    private xiaoming xm;
    public ProxyHose(xiaoming xm){
        this.xm  = xm;
    }
    @Override
    public void sale() {
        System.out.println("买房前的代理");
        xm.sale();
        System.out.println("买房后的代理");
    }
}

class MainTest{
    public static void main(String[] args) {
        xiaoming xm = new xiaoming();
        ProxyHose px = new ProxyHose(xm);
        px.sale();
    }
}
