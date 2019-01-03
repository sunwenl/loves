package com.loves.designModel.structureModel.adapterPattern;

import com.loves.designModel.structureModel.adapterPattern.version01.Adapter;
import com.loves.designModel.structureModel.adapterPattern.version01.PlayMp3;

/**
 * @Author ：xiaoyijia
 * @Date ：2018/12/25
 *
 * 适配器模式
 */
public class Test {

    public static void main(String[] args) {
        PlayMp3 playMp3= new Adapter();

        playMp3.readCardMp3();

        playMp3.readComputerMp3();
    }
}
