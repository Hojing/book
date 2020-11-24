package cn.liguohao.design.pattern.abstractfactory.pizza;

import cn.liguohao.design.pattern.abstractfactory.cheese.Cheese;
import cn.liguohao.design.pattern.abstractfactory.pepperoni.Pepperoni;
import cn.liguohao.design.pattern.abstractfactory.sauce.Sauce;
import cn.liguohao.design.pattern.abstractfactory.veggies.Veggies;
import cn.liguohao.design.pattern.abstractfactory.clams.Clams;
import cn.liguohao.design.pattern.abstractfactory.dough.Dough;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author liguohao
 * @Date 2020/9/21 13:55
 */
public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Veggies[] veggies;
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clam;

    public abstract void prepare();

    public void bake(){
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut(){
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box(){
        System.out.println("Place pizza in officaial PizzaStore box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough=" + dough +
                ", sauce=" + sauce +
                ", veggies=" + Arrays.toString(veggies) +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", clam=" + clam +
                '}';
    }
}
