package cn.liguohao.ds;

/**
 * 静态链表
 * 数组实现的链式结构线性表
 *
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/3/28
 */
public class StaticLinkedList<T> implements List<T>{

    /**
     * 数据域
     */
    private ArrayList<T> data = new ArrayList<T>();

    /**
     * 指针域
     */
    private ArrayList<T> cur = new ArrayList<T>();

    public StaticLinkedList(){
        cur.set(0,data.get(0));
    }


    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void set(int index, T element) {

    }

    @Override
    public void add(T element) {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T remove(int index) {
        return null;
    }
}
