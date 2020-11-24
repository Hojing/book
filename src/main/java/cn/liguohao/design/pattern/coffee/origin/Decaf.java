package cn.liguohao.design.pattern.coffee.origin;

/**
 * @Description TODO decaf
 * @Author liguohao
 * @Date 2020/9/20 22:42
 */
public class Decaf extends Beverage {
    public Decaf() {
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
