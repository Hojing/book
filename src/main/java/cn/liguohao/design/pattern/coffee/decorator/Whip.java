package cn.liguohao.design.pattern.coffee.decorator;

import cn.liguohao.design.pattern.coffee.origin.Beverage;

/**
 * @Description TODO
 * @Author liguohao
 * @Date 2020/9/21 3:52
 */
public class Whip extends CondimentDecorator {
    protected Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        // Whip cost &0.10
        return beverage.cost() + .10;
    }
}
