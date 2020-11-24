package cn.liguohao.design.pattern.recombination.fiveth;

/**
 * @Description TODO
 * @Author liguohao
 * @Date 2020/10/5 12:28
 */
public class RubberDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println(this.getClass().getSimpleName() + ": Squack");
    }
}
