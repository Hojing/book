package cn.liguohao.ds;

/**
 * 循环链表
 * 线性表
 * 链式存储结构
 *
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/4/1
 */
public class CirculateLinkedList<T> implements List<T> {

    /**
     * 链表节点
     *
     * @param <T> 存储数据类型
     */
    class Node<T> {
        /**
         * 数据
         */
        private T data;
        /**
         * 下一个节点指针
         */
        private Node<T> next;

        public boolean hasNext() {
            return next != null;
        }

        public T getData() {
            return data;
        }

        public Node<T> setData(T data) {
            this.data = data;
            return this;
        }

        public Node<T> getNext() {
            return next;
        }

        public Node<T> setNext(Node<T> next) {
            this.next = next;
            return this;
        }
    }

    /**
     * 尾部节点
     * 当链表为空时，尾部节点就是头节点
     */
    private Node<T> rear;

    /**
     * 链表元素个数
     * 不包括尾(头)节点
     */
    private int size = 0;

    public CirculateLinkedList() {
        init();
    }

    /**
     * 链表初始化
     */
    private void init() {
        Node<T> rear = new Node<>();
        rear.setNext(rear);
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @see SingleLinkedList#clear()
     * @see List#clear()
     */
    @Override
    public void clear() {
        Node node = rear.next;

        // 需要注意语句的执行先后顺序
        while (node.hasNext()){
            Node currentNode = node;
            node = node.next;
            currentNode.data = null;
            currentNode.next = null;
        }
    }

    @Override
    public int size() {
        return size;
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
