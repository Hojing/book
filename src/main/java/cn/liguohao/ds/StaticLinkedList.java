package cn.liguohao.ds;

import java.util.Scanner;

/**
 * 静态链表
 * 数组实现的链式结构线性表
 * 实现思路：
 * <ul>
 *     <li>两个顺序线性表，一个用于存放数据的数据表[data]，一个用于存放指针的指针域[cur]</li>
 *     <li>节点的索引[index], 在数据域[data]对应的是链表节点的数据，在指针域[cur]对应的是链表节点的[next]指针</li>
 * </ul>
 *
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/3/28
 */
public class StaticLinkedList<T> implements List<T>{

    /**
     * 数据域
     * 用于存放链表节点的数据
     * 相当于Node.data
     */
    private ArrayList<T> data = new ArrayList<T>();

    /**
     * 指针域
     * 用于存放链表节点的指针
     * 相当于Node.next
     */
    private ArrayList<Integer> cur = new ArrayList<Integer>();

    /**
     * 链表的元素个数
     */
    private int SIZE = 0;

    public StaticLinkedList(){

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
        assert index>=0 : "list index is not negative";

        data.set(index,element);
        cur.set(index,++index);

        ++SIZE;

    }

    @Override
    public void add(T element) {

        data.add(element);
        //cur.add();

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
