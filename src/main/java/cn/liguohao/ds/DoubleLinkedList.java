package cn.liguohao.ds;

/**
 * 单链双向线性表
 * 线性表
 * 链式存储结构
 *
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/4/5
 */
public class DoubleLinkedList<T> implements List<T> {

    /**
     * 链表的头节点
     * 数据域为null
     */
    private Node<T> head;

    /**
     * 链表的大小
     */
    private int size = 0;

    /**
     * 链表的节点
     */
    class Node<E> {
        /**
         * 数据域
         */
        private E data;

        /**
         * 节点前一个节点
         */
        private Node<E> pre;

        /**
         * 节点后一个节点
         */
        private Node<E> next;

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

        public Node<E> setNext(Node next) {
            this.next = next;
            return this;
        }

        /**
         * 判断节点是否有下一个元素
         *
         * @return true-有 false-无
         */
        public boolean hasNext() {
            return next != null;
        }

        public Node<E> getPre() {
            return pre;
        }

        public Node<E> setPre(Node<E> pre) {
            this.pre = pre;
            return this;
        }
    }

    public DoubleLinkedList() {
        init();
    }

    /**
     * 链表初始化
     */
    private void init() {
        head = new Node<T>();
    }

    /**
     * 头节点的指针为null
     * 则代表链表为空
     *
     * @return 是否为空
     * @see List#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 指针遍历清除法：
     * 用指针从头遍历到尾
     * 一个一个节点置空
     * <hr>
     * 相比 暴力断链清除法
     * 时间复杂度从 O(1) => O(n)
     * 空间复杂度从 O(n) => O(1)
     * <hr>
     * 暴力断链清除法的弊端：
     * <pre>head.next = null;</pre>
     * 断链虽然和头节点没关系了，但是其它节点还是连着的，这在Java里属于强引用，GC是不会回收的，会一直占用堆空间
     * 这点非常影响程序的健壮性，牺牲点时间相对来说非常划算
     *
     * @see List#clear()
     */
    @Override
    public void clear() {
        Node node = head;

        // 需要注意语句的执行先后顺序
        while (node.hasNext()){
            Node currentNode = node;
            node = node.next;
            currentNode.data = null;
            currentNode.next = null;
            currentNode.pre = null;

            --size;
        }
    }

    /**
     * @return 链表的元素数量
     * @see List#size()
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @see List#set(int, Object)
     */
    @Override
    public void set(int index, Object element) {
        Node beforeNode = getBeforeIndexNode(index);
        Node afterNode = beforeNode.next;

        Node newNode = new Node().setData(element);

        afterNode.pre = newNode;
        newNode.next = afterNode;

        newNode.pre = beforeNode;
        beforeNode.next = newNode;

        ++size;
    }

    /**
     * 添加
     *
     * @param element 待添加的元素
     * @see List#add(Object)
     */
    @Override
    public void add(Object element) {
        Node last = getLastNode();
        Node newNode = new Node();
        newNode.data = element;
        last.next = newNode;
        newNode.pre = last;

        ++size;
    }

    /**
     *
     * @see List#get(int)
     */
    @Override
    public T get(int index) {
        return getIndexNode(index).data;
    }


    /**
     * @see List#remove(int)
     */
    @Override
    public T remove(int index) {
        Node<T> beforeIndexNode = getBeforeIndexNode(index);

        Node<T> indexNode = beforeIndexNode.next;
        beforeIndexNode.next = indexNode.next;
        indexNode.pre = beforeIndexNode;

        --size;
        return indexNode.data;
    }

    /**
     * 获取指定索引位置节点的前一节点
     *
     * @param index 索引位置
     * @return 索引位置节点的前一节点
     */
    private Node<T> getBeforeIndexNode(int index) {
        assert index >= 0 && index <= size() : "索引越界 ==> " + index + " SIZE=" + size();
        Node pointer = head.next;
        for (int i = 0; i < index - 1; i++) {
            pointer = pointer.next;
        }
        return pointer;
    }

    /**
     * 获取指定索引位置节点
     *
     * @param index 索引位置
     * @return 索引位置
     */
    public Node<T> getIndexNode(int index) {
        assert index >= 0 && index < size : "索引越界 ==> index=" + index + " index<size SIZE=" + size();
        Node pointer = head.next;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        return pointer;
    }

    /**
     * 获取链表的最后一个节点
     *
     * @return 链表的最后一个节点
     */
    public Node<T> getLastNode() {
        Node node = head;
        while (node.hasNext()) {
            node = node.next;
        }
        return node;
    }
}
