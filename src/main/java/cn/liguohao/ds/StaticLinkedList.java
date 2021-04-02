package cn.liguohao.ds;

/**
 * 静态链表
 * 数组实现的链式结构线性表
 *
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/3/28
 */
public class StaticLinkedList<T> implements List<T> {

    /**
     * 模拟内存的数组
     * 这里为了省去动态扩容和设定初始容量等操作 直接使用的顺序线性表ArrayList
     */
    private ArrayList<Node<T>> memoryArray;

    /**
     * 链表元素个数
     * 不包括头节点
     */
    private int size = 0;

    /**
     * 链表头节点
     */
    private Node<T> head;

    /**
     * 节点
     *
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
         * 节点在 模拟内存 的数组 中的位置索引
         */
        private int cur;

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

        public boolean hasNext() {
            return next != null;
        }

        public int getCur() {
            return cur;
        }

        public Node<E> setCur(int cur) {
            this.cur = cur;
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
        head = new Node<T>().setCur(0);
        memoryArray = new ArrayList<Node<T>>();
        memoryArray.add(head);
    }

    /**
     * @see List#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @see List#clear()
     */
    @Override
    public void clear() {
        if (size != 0) {
            Node<T> currentNode = head;
            while (currentNode.hasNext()) {
                Node<T> willClearNode = currentNode;
                currentNode = currentNode.next;
                willClearNode.setCur(-1);
                willClearNode.setData(null);
                willClearNode.setNext(null);

                --size;
            }
        }
    }

    /**
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
    public void set(int index, T element) {
        assert index >= 0 : "索引不合法 ==> index=" + index;

        // 获取新节点的前节点和后节点
        Node<T> beforeNode = getBeforeIndexNode(index);
        Node<T> afterNode = beforeNode.next;

        // 构建新节点 新节点在内存数组中的索引位置值=内存数组的大小值
        Node<T> newNode = new Node<T>().setData(element).setCur(memoryArray.size());
        // 将新节点存放到内存数组中
        memoryArray.set(memoryArray.size(), newNode);
        // 构建新节点和前节点与后节点之间的关系
        beforeNode.setNext(newNode);
        newNode.setNext(afterNode);

        // 链表元素个数加一
        ++size;
    }

    /**
     * @see List#add(Object)
     */
    @Override
    public void add(T element) {
        Node<T> lastNode = getLastNode();

        // 构建新节点 新节点在内存数组中的索引位置值=内存数组的大小值
        Node<T> newNode = new Node<T>().setData(element).setCur(memoryArray.size());
        // 将新节点存放到内存数组中
        memoryArray.set(memoryArray.size(), newNode);
        // 构建新节点与最后一个节点的关系
        if(lastNode == null) {
            head.setNext(newNode);
        }else {
            lastNode.setNext(newNode);
        }

        // 链表元素个数加一
        ++size;
    }

    /**
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
        Node<T> currentNode = beforeIndexNode.next;

        // 移除节点关系
        beforeIndexNode.next = currentNode.next;

        // 从内存数组中移除当前索引节点
        Node<T> removeNode = memoryArray.remove(currentNode.cur);

        // 元素个数减一
        --size;

        // 返回被移除元素数据
        return removeNode.data;
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
        Node<T> beforeIndexNode = head;
        for (int i = 0; i < index ; i++) {
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
        return getBeforeIndexNode(index).next;
    }

    /**
     * 获取链表最后一个节点
     *
     * @return 链表最后一个节点
     */
    public Node<T> getLastNode() {
        // 链表最后一个节点的索引值为 size-1
        return getIndexNode(size == 0 ? 0 : (size - 1));
    }


}
