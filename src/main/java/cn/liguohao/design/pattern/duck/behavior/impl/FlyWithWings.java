package cn.liguohao.design.pattern.duck.behavior.impl;

import cn.liguohao.design.pattern.duck.behavior.FlyBehavior;

/**
 * @Description fly with wings
 * @Author liguohao
 * @Date 2020/9/17 15:46
 */
public class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("I am flying !! ");
    }
}
