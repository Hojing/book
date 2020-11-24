package cn.liguohao.design.pattern.duck.behavior.impl;

import cn.liguohao.design.pattern.duck.behavior.FlyBehavior;

/**
 * @Description can not fly
 * @Author liguohao
 * @Date 2020/9/17 15:48
 */
public class FlyNoWay implements FlyBehavior {

    public void fly() {
        System.out.println("I can not fly...");
    }
}
