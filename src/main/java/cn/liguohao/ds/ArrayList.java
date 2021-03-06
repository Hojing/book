package cn.liguohao.ds;

/**
 * 顺序线性表
 * 顺序存储方式
 *
 * @author <a href="https://liguohao.cn" target="_blank">李国豪</a>
 * @since 2021/3/17
 */
public class ArrayList<E> implements List<E> {

    /**
     * 大小
     */
    private int SIZE = 0;

    /**
     * 默认容量
     */
    private final int DEFAULT_CAPACITY = 20;

    /**
     * 当前容量
     */
    private int CURRENT_CAPACITY = -1;

    /**
     * 扩容倍数
     */
    private final int CAPACITY_EX_MULTIPLE = 2;

    /**
     * 数据
     */
    private Object[] DATA;

    /**
     * 默认构造
     */
    public ArrayList() {
        init(DEFAULT_CAPACITY);
    }

    /**
     * 指定容量
     *
     * @param capacity 容量大小
     */
    public ArrayList(int capacity) {
        assert (capacity >= 0) : "容量不可为负数";
        init(capacity);
    }

    /**
     * 初始化
     *
     * @param capacity 顺序线性表数组容量
     */
    private void init(int capacity) {
        CURRENT_CAPACITY = capacity;
        DATA = new Object[capacity];
    }

    /**
     * @see List#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return SIZE == 0;
    }

    /**
     * @see List#clear()
     */
    @Override
    public void clear() {
        DATA = null;
    }

    /**
     * @see List#size()
     */
    @Override
    public int size() {
        return SIZE;
    }

    /**
     * 顺序线性表的插入：
     * <ul>
     *     <li>如果插入的位置不合理，抛出异常</li>
     *     <li>如果线性表长度大于等于数组长度，则动态扩容，暂定两倍扩容</li>
     *     <li>从最后一个元素开始向前遍历到索引位置，分别将它们都向后移动一个位置</li>
     *     <li>将要插入的元素填入索引位置处</li>
     *     <li>大小加一</li>
     * </ul>
     *
     * @see List#set(int, Object)
     */
    @Override
    public void set(int index, E element) {

        // 判断插入的位置合理性
        assert index >= 0 && index <= SIZE : "索引位置不合理 ==> index=" + index;
        // 判断容量是否足够，不够则扩容
        if (SIZE + 1 >= CURRENT_CAPACITY) {
            Object[] NEW_DATA = new Object[CURRENT_CAPACITY * CAPACITY_EX_MULTIPLE];
            System.arraycopy(DATA, 0, NEW_DATA, 0, SIZE);
            DATA = NEW_DATA;
        }
        // 后移其它元素  从最后一个元素遍历到当前索引位置
        for (int i = SIZE - 1; i >= index; i--) {
            DATA[i + 1] = DATA[i];
        }
        // 插入新元素
        DATA[index] = element;
        // 大小加一
        SIZE++;
    }

    /**
     * @see List#add(Object)
     */
    @Override
    public void add(E element) {
        set(SIZE, element);
    }

    /**
     * @see List#get(int)
     */
    @Override
    public E get(int index) {
        return (E) DATA[index];
    }

    /**
     * 顺序线性表的删除：
     * <ul>
     *     <li>索引位置不合理，抛出异常</li>
     *     <li>取出被删除的元素</li>
     *     <li>从删除位置开始从前往后遍历，直到最后一个元素位置，将索引位置后方的元素前移一位</li>
     *     <li>大小减一</li>
     * </ul>
     *
     * @see List#remove(int)
     */
    @Override
    public E remove(int index) {
        // 判断删除的索引位置合理性
        assert index >= 0 && index <= SIZE : "索引位置不合理 ==> index=" + index;
        // 前移索引位置后方的元素 从索引位置往后遍历
        E indexElement = (E) DATA[index];
        for (int i = index; i < SIZE; i++) {
            DATA[i] = DATA[i + 1];
        }
        //大小减一
        SIZE--;
        // 返回被删除的元素
        return indexElement;
    }


    /**
     * 获取列表内元素所在索引位置
     *
     * @param element 元素
     * @return 索引位置
     */
    int getIndex(E element) {
        for (int i = 0; i < SIZE; i++) {
            if (DATA[i] == element) {
                return i;
            }
        }
        return -1;
    }
}
