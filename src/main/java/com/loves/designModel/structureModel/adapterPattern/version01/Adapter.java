package com.loves.designModel.structureModel.adapterPattern.version01;

/**
 * @Author ：xiaoyijia
 * @Date ：2018/12/25
 *
 * 让一个对象具备多种功能
 * 类适配器模式
 */
public class Adapter extends Computer implements PlayMp3 {

    @Override
    public void readCardMp3() {
        System.out.println("读取内存卡的mp3文件");
    }
}
