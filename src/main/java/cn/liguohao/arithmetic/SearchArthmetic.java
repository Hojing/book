package cn.liguohao.arithmetic;

/**查询算法
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/2/23
 */
public class SearchArthmetic {

    /**
     * 强行查找
     * @param longArr 从小到大有序的int数组
     * @param key 集合中存在的值
     * @return 元素在数组中的索引位置
     */
    public static int forceSearch(long[] longArr, long key){
        for(int i=0;i<longArr.length;i++) if(key==longArr[i]) return i;
        return -1;
    }

    /**
     * 二分查找：用当前元素与数组中中间元素进行比较，一半一半地缩小范围直到找到元素位置
     * @param longArr 从小到大有序的int数组
     * @param key 集合中存在的值
     * @return 元素在数组中的索引位置
     */
    public static int binarySearch(long[] longArr, long key){

        // 数组必须是从小到大顺序的
        if(!checkArrayIsOrderOfLowToHigh(longArr)) throw new IllegalArgumentException("array must be order of low to high ...");

        int low = 0;
        int high = longArr.length - 1;

        // 待查询的元素范围[low,high]
        while (low <= high){
            int middle = low + (high - low)/2;
            if(key < longArr[middle]){
                high = middle - 1;
            }else if(key > longArr[middle]){
                low = middle + 1;
            }else {
                return middle;
            }
        }
        return -1;
    }

    /**
     * 检查数组是否是从小到大顺序的
     * @param longArr 待检测的数组
     * @return 是否从小到大顺序
     */
    public static boolean checkArrayIsOrderOfLowToHigh(long[] longArr){
        for (int i=0;i<longArr.length;i++) if(i<longArr.length-1 && longArr[i] > longArr[i+1]) return false;
        return true;
    }

}
