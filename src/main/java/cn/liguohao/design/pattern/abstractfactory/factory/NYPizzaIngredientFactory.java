package cn.liguohao.design.pattern.abstractfactory.factory;

import cn.liguohao.design.pattern.abstractfactory.cheese.ReggianoCheese;
import cn.liguohao.design.pattern.abstractfactory.pepperoni.Pepperoni;
import cn.liguohao.design.pattern.abstractfactory.pepperoni.SlicedPepperoni;
import cn.liguohao.design.pattern.abstractfactory.veggies.*;
import cn.liguohao.design.pattern.abstractfactory.cheese.Cheese;
import cn.liguohao.design.pattern.abstractfactory.clams.Clams;
import cn.liguohao.design.pattern.abstractfactory.clams.FreshClams;
import cn.liguohao.design.pattern.abstractfactory.dough.Dough;
import cn.liguohao.design.pattern.abstractfactory.dough.ThinCrustDough;
import cn.liguohao.design.pattern.abstractfactory.sauce.MarinaraSauce;
import cn.liguohao.design.pattern.abstractfactory.sauce.Sauce;
import cn.liguohao.design.pattern.abstractfactory.veggies.*;

/**
 * @Description TODO
 * @Author liguohao
 * @Date 2020/9/21 15:27
 */
public class NYPizzaIngredientFactory implements PizzaIngredientAbstractFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies[] veggies = {
                new Garlic(),
                new Onion(),
                new RedPepper(),
                new Mushroom()
        };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }
}
