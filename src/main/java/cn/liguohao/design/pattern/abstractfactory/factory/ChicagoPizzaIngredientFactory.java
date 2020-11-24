package cn.liguohao.design.pattern.abstractfactory.factory;

import cn.liguohao.design.pattern.abstractfactory.pepperoni.Pepperoni;
import cn.liguohao.design.pattern.abstractfactory.pepperoni.SlicedPepperoni;
import cn.liguohao.design.pattern.abstractfactory.veggies.BlackOlives;
import cn.liguohao.design.pattern.abstractfactory.veggies.EggPlant;
import cn.liguohao.design.pattern.abstractfactory.veggies.Spinach;
import cn.liguohao.design.pattern.abstractfactory.veggies.Veggies;
import cn.liguohao.design.pattern.abstractfactory.cheese.Cheese;
import cn.liguohao.design.pattern.abstractfactory.cheese.Mozzarella;
import cn.liguohao.design.pattern.abstractfactory.clams.Clams;
import cn.liguohao.design.pattern.abstractfactory.clams.FrozenClams;
import cn.liguohao.design.pattern.abstractfactory.dough.Dough;
import cn.liguohao.design.pattern.abstractfactory.dough.ThickCrustDough;
import cn.liguohao.design.pattern.abstractfactory.sauce.PlumTomatoSauce;
import cn.liguohao.design.pattern.abstractfactory.sauce.Sauce;

/**
 * @Description TODO
 * @Author liguohao
 * @Date 2020/9/21 15:38
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientAbstractFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new Mozzarella();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies[] veggies ={
                new BlackOlives(),
                new EggPlant(),
                new Spinach()
        };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FrozenClams();
    }
}
