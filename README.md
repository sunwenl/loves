#学习系列

## io包
 * io 简单学习 
 * hashMap 简单学习
 * aop 简单学习
 * designModel 简单学习
 
## 设计模式学习系列篇：

### 六大设计原则(SOLID)
 * 单一职责原则(SRP) (/designModel/sixPrinciples/srp)
 * 开闭原则(OCP) (/designModel/sixPrinciples/ocp)
 * 里氏替换原则(LSP) (/designModel/sixPrinciples/lsp)
 * 迪米特法则(LOD) (/designModel/sixPrinciples/lod)
 * 接口隔离原则(ISP) (/designModel/sixPrinciples/isp)
 * 依赖倒置原则(DIP) (/designModel/sixPrinciples/dip)  
 
### 创建型模式
 * 单例模式、工厂模式、抽象工厂模式、生成器模式、原型模式
    * 单例模式(Singleton Pattern):保证一个类仅有一个实例，并提供一个访问它的全局访问点。例：跨窗体访问同一个实例。
    * 工厂模式(Factory Pattern):根据提供给工厂的数据，从一系列相关的类中选择一个类实例并返回。例:Oracle,SQL Server 访问类的选择
    * 抽象工厂模式(Abstract Factory Pattern):为一组类返回一个工厂。
    * 生成器模式(Builder Pattern):根据提供给他的数据及表示，组装成新的对象。 例：根据用户不同的选择显示不同控件。
    * 原型模式(Prototype Pattern):由结果到一个新的结果。例：根据由执行的SQL 查询结果得到另一个结果。与生成器类似工厂，两者都返回由许多方法的对象组成的类。差别:抽象工厂返回一系列相关的类。生成器是根据提供给它的数据一步一步地构建一个复杂的对象。

### 结构型模式
 * 适配器模式、桥接模式、组成模式、装饰模式、外观模式、享元模式、代理模式。
    * 适配器模式(Adapter Pattern):将一个类将一种接口转换成另一种接口。
    * 桥接模式(Bridge Pattern):类的接口和它的实现相分离，无需改变调用者的代码即可替代实现的过程。
    * 组成模式(Composite Pattern):组合就是对象的结合。可以构建部分-整体的关系或数据的树形关系。
    * 装饰模式(Decorator Pattern):用一个类包装给定的类改变单个对象的行为，但不需要创建一个新的派生类。
    * 外观模式(Facde Pattern):可以将一系统复杂的类包装成一个简单的封闭接口。
    * 享元模式(Flyweight Pattern):通过共享（把参数移动外部）大幅地减少单个实例的数目。
    * 代理模式(Proxy Pattern):为一个复杂的对象提供一个简单的占位对象。

### 行为型模式
 * 中介者模式、命令模式、备忘录模式、状态模式、策略模式、解释器模式、迭代器模式、观察者模式、访问者模式、模板方法模式。
    * 中介者模式(Mediator Pattern):中介者做为唯一了解其它类的一个,简化了通信.促进类之音的松散便于修改维护。
      每个和中介者通信的控件都称为同事。
      应用:可视界面的程序中，当面临多个对象之间复杂的通信时，可使用。
    * 命令模式(Command Pattern):只将请求转发给特定的对象。
      目的：将程序的界面和操作分离。
      缺点：增加了散乱的小类
    * 备忘录模式(Memento Pattern):保存对象的数据以便以后能够恢复它。
      发起人(Originator):是一个对象，我们要保存它的状态。
      备忘录(Memento):是另外一个对象，它保存了发起人的状态。
      负责人(Caretaker):管理状态保存的时机，保存备忘录，并且如果需要的话，使用备忘录恢复发起人的状态。
    * 状态模式(State Pattern):用一个对象表示程序的状态，并通过转换对象来转换程序的状态。
      以前,根据传进来的参数执行不同的计算或显示不同的内容。switch-case/if else状态模式要取代它。
    * 策略模式(Stractegy Pattern):与状态模式相似,根据需要选择一封装在Context驱动器类。
    * 观察者模式(Observer Pattern):以多种形式显示数据。在观察者模式中，把数据称为目标(Subject),把每种显示称为观察者(Observer)
    * 解释器模式(Interpreter Pattern):为某种语言定义一个文法，并用该文法解释语言中的语句。
      适用性:
      1.当读者需要一个命令解释器分析用户命令时。
      2.当程序需要分析一个代数串时。
      3.发程序要生成各种形式的输出时。
    * 迭代器模式(Iterator Pattern):允许使用一个标准的接口顺序访问一个数据列表或集合。
    * 模板方法模式（Template Method Pattern):先创建一个父类，把其中一个或多个方法留个子类实现。
      是一种非常简单又常用的模式。思想：将一个类的基本部分抽取出来放到一个基类中，不必重出现在一个派生类中。
    * 职责链(Chain of Responsibility):允许多个类处理同一个请求。
      要点：
      1.链的组织是从最特珠的到最一般的。
      2.不能保证在任何情况下都会有响应。
      职责链用于分析器与编译器。
      
## 微信企业自动转账到个人：
 * see -> com.loves.weixin
 * 参考：https://blog.csdn.net/github_38924695/article/details/78850704
    