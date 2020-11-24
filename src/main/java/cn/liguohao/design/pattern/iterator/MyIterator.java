package cn.liguohao.design.pattern.iterator;

/**
 * @Description TODO
 * @Author liguohao
 * @Date 2020/10/2 2:05
 */
public interface MyIterator<T> {

    T next();

    boolean hasNext();

}
