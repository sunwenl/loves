package com.loves.designModel.sixPrinciples.lsp.version01;

/**
 * @Author ：SunWenLong
 * @Date ：2018/11/22
 */
public class Client {
    public static void main(String[] args) {
        SomeoneClass someoneClass = new SomeoneClass();
        someoneClass.someoneMethod(new Parent());
        someoneClass.someoneMethod(new Child());
    }
}
//总结：
//比如我们有某一个类，其中有一个方法，调用了某一个父类的方法。
//父类代码如下:Parent
//结果我有一个子类把父类的方法给覆盖了，并且抛出了一个异常:Child
//这个异常是运行时才会产生的，也就是说，我的SomeoneClass并不知道会出现这种情况，
//结果就是我调用下面这段代码的时候，本来我们的思维是Parent都可以传给someoneMethod完成我的功能，
//我的Child继承了Parent，当然也可以了，但是最终这个调用会抛出异常。
//
//这就相当于埋下了一个个陷阱，因为本来我们的原则是，父类可以完成的地方，
//我用子类替代是绝对没有问题的，但是这下反了，我每次使用一个子类替换一个父类的时候，
//我还要担心这个子类有没有给我埋下一个上面这种炸弹。
//
//所以里氏替换原则是一个需要我们深刻理解的原则，因为往往有时候违反它我们可以得到很多，
//失去一小部分，但是有时候却会相反，所以要想做到活学活用，就要深刻理解这个原则的意义所在。