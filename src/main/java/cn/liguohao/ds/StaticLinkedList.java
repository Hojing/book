package cn.liguohao.ds;

/**
 * 未实现
 * 静态链表
 * 数组实现的链式结构线性表
 *
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/3/28
 */
public class StaticLinkedList<T> implements List<T> {

    /**
     * 节点数组
     */
    private ArrayList<Node<T>> nodeArrayList = new ArrayList<Node<T>>();

    /**
     * 链表元素个数
     * 不包括头节点
     */
    private int size = 0;

    /**
     * 链表头节点
     */
    private Node<T> head = new Node<T>().setCur(1);

    /**
     * 节点
     * @param <E> 节点存放数据的类型
     */
    class Node<E> {
        /**
         * 数据
         */
        E data;
        /**
         * 指针
         */
        int cur;

        public E getData() {
            return data;
        }

        public Node<E> setData(E data) {
            this.data = data;
            return this;
        }

        public int getCur() {
            return cur;
        }

        public Node<E> setCur(int cur) {
            this.cur = cur;
            return this;
        }
    }

    /**
     * 初始化添加头节点
     */
    public StaticLinkedList() {
        nodeArrayList.add(head);
    }

    /**
     * @see List#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {

    }

    /**
     * @see List#size()
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, T element) {
        assert index >= 0  : "索引不合法 ==> index="+index;

        Node beforeNode = getBeforeIndexNode(index);
        Node afterNode = nodeArrayList.get(beforeNode.cur);

        Node<T> newNode = new Node<T>().setData(element).setCur(beforeNode.cur);
        beforeNode.setCur(index);


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

    public Node getBeforeIndexNode(int index) {
        return null;
    }

    public Node getIndexNode(int index) {
        return null;
    }

    public Node getLastNode() {
        return null;
    }


}
