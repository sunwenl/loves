package com.loves.shejimoshi.sixPrinciples.srp.version02;

import java.io.IOException;

/**
 * @Author ：SunWenLong
 * @Date ：2018/11/22
 */
public class Calculator {
    public int add(int a,int b){
        return a + b;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Reader reader = new Reader("/Users/Downloads/data.txt");
        Calculator calculator = new Calculator();
        System.out.println("result:" + calculator.add(reader.getA(),reader.getB()));
    }
}

//总结：
//我们分离出来一个类用来读取数据，来看Reader
//下面是我们单独的计算器类。
//我们将一个类拆成了两个类，这样以后我们如果有减法，乘法等等，就不用出现那么多重复代码了。
//
//以上是我临时杜撰的例子，虽然很简单，并且没有什么现实意义，但是我觉得足够表达单一职责的意思，
//并且也足够说明它的重要性。单一职责原则是我觉得六大原则当中最应该遵守的原则，
//因为我在实践过程中发现，当你在项目的开发过程中遵循它，几乎完全不会给你的系统造成任何多余的复杂性，
//反而会令你的程序看起来井然有序。
