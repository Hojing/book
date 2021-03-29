package cn.liguohao.ds;

/**线性表
 * 数据结构定义
 * <a href="https://github.com/li-guohao/book/img/ds/ADT-List.png">ADT-List.png</a>
 * @author <a href="https://liguohao.cn" target="_blank">liguohao</a>
 * @since 2021/3/17
 */
public interface List<T> {

    /**
     * 是否为空
     * @return true-为空 false-不为空
     */
    boolean isEmpty();

    /**
     * 清空
     */
    void clear();

    /**
     * 返回线性表中元素的个数
     * @return 元素的个数
     */
    int size();

    /**
     * 向指定的索引位置
     * @param index 索引位置
     * @param element 待添加的元素
     */
    void set(int index, T element);

    /**
     * 添加元素
     * @param element 待添加的元素
     */
    void add(T element);

    /**
     * 获取指定索引位置的元素
     * @param index 索引位置
     * @return 索引位置的元素
     */
    T get(int index);

    /**
     * 移除指定索引的元素
     * @param index 索引位置
     * @return 被移除的元素
     */
    T remove(int index);

}
