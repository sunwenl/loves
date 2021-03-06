# 开闭原则(OCP:Open-Closed Principle)
定义：一个软件实体应当对扩展开放，对修改关闭。即软件实体应尽量在不修改原有代码的情况下进行扩展。

根据开闭原则，在设计一个软件系统模块（类，方法）的时候，应该可以在不修改原有的模块（修改关闭）的基础上，能扩展其功能（扩展开放）。
遵循开闭原则的系统设计，可以让软件系统可复用，并且易于维护。这也是系统设计需要遵循开闭原则的原因：  
 1.稳定性。开闭原则要求扩展功能不修改原来的代码，这可以让 软件系统在变化中保持稳定。  
 2.扩展性。开闭原则要求对扩展开放，通过扩展提供新的或改变原有的功能，让软件系统具有灵活的可扩展性。  
 
### 如何使用开闭原则
 * 抽象约束。首先通过接口或抽象类约束扩展，对扩展进行边界限定，不允许出现在接口或抽象类中不存在的public方法；
           第二，参数类型，引用对象尽量使用接口或者抽象类，而不是实现类；
           第三，抽象层尽量保持稳定，一旦确定既不允许修改。
 * 元数据(metadata)控制模块行为。尽量使用元数据(用来描述环境和数据的数据，通俗的说就是配置参数)来控制程序的行为，减少重复开发。
 * 制定项目章程。对于项目来说，约定优于配置。
 * 封装变化。第一，将相同的变化封装到一个接口或抽象类中；
           第二，将不同的变化封装到不同的接口或抽象类中，不应该有两个不同的变化出现在同一个接口或抽象类中。

 * 开-闭原则（六大原则中绝对的大姐大，另外五姐妹心甘情愿臣服）：
   最后一个原则，一句话，对修改关闭，对扩展开放。

 * 就是说我任何的改变都不需要修改原有的代码，而只需要加入一些新的实现，就可以达到我的目的，
   这是系统设计的理想境界，但是没有任何一个系统可以做到这一点，哪怕我一直最欣赏的spring框架也做不到，
   虽说它的扩展性已经强到变态。

 * 这个原则更像是前五个原则的总纲，前五个原则就是围着它转的，只要我们尽量的遵守前五个原则，
   那么设计出来的系统应该就比较符合开闭原则了，相反，如果你违背了太多，
   那么你的系统或许也不太遵循开闭原则。
 * 在《大话设计模式》一书中，提到一句话与各位共勉，我觉得很有说服力，即用抽象构建框架，用细节实现扩展。