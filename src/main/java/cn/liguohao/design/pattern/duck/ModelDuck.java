package cn.liguohao.design.pattern.duck;

import cn.liguohao.design.pattern.duck.behavior.impl.FlyNoWay;
import cn.liguohao.design.pattern.duck.behavior.impl.Quack;

/**
 * @Description TODO
 * @Author liguohao
 * @Date 2020/9/17 15:59
 */
public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay();   // at first, model duck can not fly
        quackBehavior = new Quack();    // model duck can quack
    }

    public void display() {
        System.out.println("I am a model duck");
    }
}
