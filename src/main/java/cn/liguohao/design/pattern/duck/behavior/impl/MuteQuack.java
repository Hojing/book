package cn.liguohao.design.pattern.duck.behavior.impl;

import cn.liguohao.design.pattern.duck.behavior.QuackBehavior;

/**
 * @Description mute quack
 * @Author liguohao
 * @Date 2020/9/17 15:50
 */
public class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
