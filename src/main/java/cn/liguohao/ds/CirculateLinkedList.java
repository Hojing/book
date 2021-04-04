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
        rear = new Node<>();
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

            --size;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, T element) {
        Node<T> beforeNode = getBeforeIndexNode(index);
        Node<T> afterNode = beforeNode.next;

        Node<T> newNode = new Node<T>().setData(element);

        beforeNode.next = newNode;
        newNode.next = afterNode;

        ++size;
    }

    @Override
    public void add(T element) {
        Node<T> last = getLastNode();
        Node<T> newNode = new Node<T>().setData(element);
        last.next = newNode;
        newNode.next = rear;

        ++size;
    }

    @Override
    public T get(int index) {
        return getIndexNode(index).data;
    }

    @Override
    public T remove(int index) {
        Node<T> beforeIndexNode = getBeforeIndexNode(index);

        Node<T> indexNode = beforeIndexNode.next;
        beforeIndexNode.next = indexNode.next;

        --size;
        return indexNode.data;
    }



    /**
     * 获取索引位置的上一个节点
     * 指针从头节点往下移动 index 次 即是索引节点的前节点
     *
     * @param index 链表索引位置
     * @return 索引位置的上一个节点
     */
    public Node<T> getBeforeIndexNode(int index) {
        assert (index >= 0 && index <= size) : "索引越界 ==> index=" + index + " size=" + size;

        // 将指针从头节点往下移动 index 次 即是索引节点的前一节点
        Node<T> beforeIndexNode = rear;
        for (int i = 0; i < index; i++) {
            beforeIndexNode = beforeIndexNode.next;
        }

        return beforeIndexNode;
    }

    /**
     * 获取索引位置节点
     *
     * @param index 链表索引位置
     * @return 链表索引位置节点
     */
    public Node<T> getIndexNode(int index) {
        return index == -1 ? rear : getBeforeIndexNode(index).next;
    }

    /**
     * 获取链表最后一个节点
     *
     * @return 链表最后一个节点
     */
    public Node<T> getLastNode() {
        // 链表最后一个节点的索引值为 size-1
        return getIndexNode(size == 0 ? -1 : (size - 1));
    }
}
