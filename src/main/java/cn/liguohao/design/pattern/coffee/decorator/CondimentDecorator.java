package cn.liguohao.design.pattern.coffee.decorator;

import cn.liguohao.design.pattern.coffee.origin.Beverage;

/**
 * @Description TODO condiment, a decorator for beverage.
 * @Author liguohao
 * @Date 2020/9/20 22:31
 */
public abstract class CondimentDecorator extends Beverage {

    // this method is same as Class Beverage getDesctiption method
    public abstract String getDescription();

}
