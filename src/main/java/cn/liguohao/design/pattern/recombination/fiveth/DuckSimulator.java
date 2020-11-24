package cn.liguohao.design.pattern.recombination.fiveth;

import cn.liguohao.design.pattern.duck.Duck;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Description TODO 鸭子模拟器
 * @Author liguohao
 * @Date 2020/10/5 12:29
 */
public class DuckSimulator{
    public static void main(String[] args) {

        QuackableAbstractFactory quackableFactory = new QuackableFactory();

        Quackable quackableCollection = quackableFactory.createQuackableCollection(Flock.class);
        Quackable quackableCollection2 = quackableFactory.createQuackableCollection(Flock.class);
        if(!(quackableCollection instanceof Flock)) throw new UnsupportedOperationException("不支持集合类："+Flock.class.getName());
        Flock flock = (Flock) quackableCollection;
        flock.add(quackableFactory.createQuackable(DuckCall.class));
        flock.add(quackableFactory.createQuackable(MallardDuck.class));


        Flock childFlock = (Flock) quackableCollection2;

        childFlock.add(quackableFactory.createQuackable(RedheadDuck.class));
        childFlock.add(quackableFactory.createQuackable(RubberDuck.class));

        flock.add(childFlock);

        flock.add(quackableFactory.createQuackableAdapter(GooseAdapter.class,new Goose()));

        flock.quack();

    }


}
