package cn.liguohao.design.pattern.abstractfactory.test;

import cn.liguohao.design.pattern.abstractfactory.pizza.Pizza;
import cn.liguohao.design.pattern.abstractfactory.store.NYPizzaStore;

/**
 * @Description TODO
 * @Author liguohao
 * @Date 2020/9/21 16:27
 */
public class StoreTest {
    public static void main(String[] args) {
        NYPizzaStore nyPizzaStore = new NYPizzaStore();
        Pizza pizza = nyPizzaStore.orderPizza("cheese");
        System.out.println(pizza);
    }
}
