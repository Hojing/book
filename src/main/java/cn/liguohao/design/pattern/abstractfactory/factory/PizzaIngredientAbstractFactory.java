package cn.liguohao.design.pattern.abstractfactory.factory;

import cn.liguohao.design.pattern.abstractfactory.pepperoni.Pepperoni;
import cn.liguohao.design.pattern.abstractfactory.veggies.Veggies;
import cn.liguohao.design.pattern.abstractfactory.cheese.Cheese;
import cn.liguohao.design.pattern.abstractfactory.clams.Clams;
import cn.liguohao.design.pattern.abstractfactory.dough.Dough;
import cn.liguohao.design.pattern.abstractfactory.sauce.Sauce;

/**
 * @Description TODO
 * @Author liguohao
 * @Date 2020/9/21 15:20
 */
public interface PizzaIngredientAbstractFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClam();
}
