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
     * 数据域
     */
    private ArrayList<T> dataArray;

    /**
     * 指针域
     */
    private ArrayList<Integer> curArray;

    /**
     * 链表元素个数
     * 不包括头节点
     */
    private int size = 0;

    /**
     * 节点在数据域和指针域的数组索引指针
     */
    private int pointer = 0;

    /**
     * 链表头节点
     */
    private Node<T> head;

    /**
     * 节点
     * @param <E> 节点存放数据的类型
     */
    class Node<E> {
        /**
         * 数据
         */
        private E data;
        /**
         * 下个节点的指针
         */
        private Node<E> next;

        /**
         * 节点在数据域和指针域的数组索引位置
         */
        private int index;

        public E getData() {
            return data;
        }

        public Node<E> setData(E data) {
            this.data = data;
            return this;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> setNext(Node<E> next) {
            this.next = next;
            return this;
        }

        public int getIndex() {
            return index;
        }

        public Node<E> setIndex(int index) {
            this.index = index;
            return this;
        }
    }

    public StaticLinkedList() {
        staticLinkedListInit();
    }

    /**
     * 静态链表初始化
     */
    private void staticLinkedListInit() {
        dataArray = new ArrayList<T>();
        curArray = new ArrayList<Integer>();
        head = new Node<T>();

        head.setIndex(pointer);
        dataArray.set(pointer, head.getData());
        curArray.set(pointer,pointer);
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
