package cn.liguohao.ds;

/**
 * 静态链表
 * 数组实现的链式结构线性表
 *
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/3/28
 */
public class StaticLinkedList<T> {

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


}
