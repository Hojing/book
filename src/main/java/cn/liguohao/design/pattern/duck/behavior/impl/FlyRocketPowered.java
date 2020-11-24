package cn.liguohao.design.pattern.duck.behavior.impl;

import cn.liguohao.design.pattern.duck.behavior.FlyBehavior;

/**
 * @Description flying with a rocket
 * @Author liguohao
 * @Date 2020/9/17 16:02
 */
public class FlyRocketPowered implements FlyBehavior {
    public void fly() {
        System.out.println("I am flying with a rocket!");
    }
}
