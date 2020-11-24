package cn.liguohao.design.pattern.recombination.first;

/**
 * @Description TODO 鸭鸣器
 * @Author liguohao
 * @Date 2020/10/5 12:27
 */
public class DuckCall implements Quackable{
    @Override
    public void quack() {
        System.out.println(this.getClass().getSimpleName() + ": Kwak");
    }
}
