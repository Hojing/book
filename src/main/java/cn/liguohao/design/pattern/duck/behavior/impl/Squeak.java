package cn.liguohao.design.pattern.duck.behavior.impl;

import cn.liguohao.design.pattern.duck.behavior.QuackBehavior;

/**
 * @Description squeak
 * @Author liguohao
 * @Date 2020/9/17 15:51
 */
public class Squeak implements QuackBehavior {
    public void quack() {
        System.out.println("Squeak");
    }
}
