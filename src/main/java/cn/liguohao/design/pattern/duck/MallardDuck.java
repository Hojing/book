package cn.liguohao.design.pattern.duck;

import cn.liguohao.design.pattern.duck.behavior.impl.FlyWithWings;
import cn.liguohao.design.pattern.duck.behavior.impl.Quack;

/**
 * @Description mallard duck
 * @Author liguohao
 * @Date 2020/9/17 15:53
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();        // mallard duck can quack
        flyBehavior = new FlyWithWings();   // mallard duck can fly
    }

    public void display() {
        System.out.println("I am a real Mallard duck...");
    }
}
