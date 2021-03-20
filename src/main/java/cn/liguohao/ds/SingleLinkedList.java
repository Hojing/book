package cn.liguohao.ds;

/**
 * 线性表
 * 链式存储结构
 * 单链表
 *
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/3/20
 */
public class SingleLinkedList implements List {

    /**
     * 链表的头节点
     * 数据域为null
     */
    private Node head = new Node();

    /**
     * 链表的节点
     */
    class Node {
        /**
         * 数据域
         */
        private Object data;

        /**
         * 指针域
         */
        private Node next;

        public Object getData() {
            return data;
        }

        public Node setData(Object data) {
            this.data = data;
            return this;
        }

        public Node getNext() {
            return next;
        }

        public Node setNext(Node next) {
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

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public SingleLinkedList() {
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
        }
    }

    /**
     * @return 链表的元素数量
     * @see List#size()
     */
    @Override
    public int size() {
        int size = 0;
        Node node = head;
        while (node.hasNext()) {
            size++;
            node = node.next;
        }
        return size;
    }

    /**
     * 单链线性表的指定索引位置元素的下个位置插入：
     * <ul>
     *     <li>声明一个节点[pointer]指向链表的第一个节点, 初始化[j]从1开始</li>
     *     <li>当[j]<[index]时，遍历链表，让节点[pointer]的指针向后移动，不断执行下一节点,j累加1</li>
     *     <li>若链表末尾指针为空，则说明第[index]的元素不存在</li>
     *     <li>否则查找成功，新建一个待插入的空节点[newNode]</li>
     *     <li>将数据元素[element]赋值给空节点的数据域</li>
     *     <li>先将新建的节点[newNode]的指针指向下一个节点，再将上一个节点的指针执行新建的节点[newNode]</li>
     * </ul>
     *
     * @see List#add(int, Object)
     */
    @Override
    public void add(int index, Object element) {
        Node indexNode = getIndexNode(index);

        Node newNode = new Node();
        newNode.data = element;

        // 需要注意的是：下面两行的顺序不能反了
        // 一定要先将新建的节点[newNode]的指针指向下一个节点，再将上一个节点的指针执行新建的节点
        newNode.next = indexNode.next;
        indexNode.next = newNode;

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
    }

    /**
     * 单链线性表的指定索引位置元素获取：
     * <ul>
     *     <li>声明一个节点[pointer]指向链表的第一个节点, 初始化[j]从1开始</li>
     *     <li>当[j]<[index]时，遍历链表，让节点[pointer]的指针向后移动，不断执行下一节点,j累加1</li>
     *     <li>若到链表末尾[pointer]为空，则说明第[index]个元素不存在</li>
     *     <li>否则查找成功，返回节点[pointer]的数据</li>
     * </ul>
     *
     * @see List#get(int)
     */
    @Override
    public Object get(int index) {
        return getIndexNode(index).data;
    }


    /**
     * @see List#remove(int)
     */
    @Override
    public Object remove(int index) {
        Node beforeIndexNode = getBeforeIndexNode(index);

        Node indexNode = beforeIndexNode.next;
        beforeIndexNode.next = indexNode.next;

        return indexNode;
    }

    /**
     * 获取指定索引位置节点的前一节点
     *
     * @param index 索引位置
     * @return 索引位置节点的前一节点
     */
    private Node getBeforeIndexNode(int index) {
        assert index >= 0 && index <= size() : "索引越界 ==> " + index + " SIZE=" + size();
        Node pointer = head;
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
    public Node getIndexNode(int index) {
        assert index >= 0 && index <= size() : "索引越界 ==> " + index + " SIZE=" + size();
        Node pointer = head;
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
    public Node getLastNode() {
        Node node = head;
        while (node.hasNext()) {
            node = node.next;
        }
        return node;
    }
}
