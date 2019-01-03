package com.loves.designModel.structureModel.adapterPattern.version02;

import com.loves.designModel.structureModel.adapterPattern.version01.Computer;
import com.loves.designModel.structureModel.adapterPattern.version01.PlayMp3;

/**
 * @Author ：xiaoyijia
 * @Date ：2018/12/25
 *
 * 对象的适配器模式
 */
public class Adapter implements PlayMp3 {

    private Computer computer;

    public Adapter(Computer computer){
        this.computer = computer;
    }

    public void readComputerMp3(){
        computer.readComputerMp3();
    }

    @Override
    public void readCardMp3() {
        System.out.println("读取内存卡的mp3文件");
    }
}
