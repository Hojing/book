package cn.liguohao.design.pattern.recombination.third;

/**
 * @Description TODO
 * @Author liguohao
 * @Date 2020/10/5 12:20
 */
public class MallardDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println(this.getClass().getSimpleName()+": Quack");
    }
}
