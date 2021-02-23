package cn.liguohao.arthmetic;

import cn.liguohao.arithmetic.SearchArthmetic;
import org.junit.Test;

/**查询算法测试
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/2/23
 */
public class SearchArthmeticTest {

    @Test
    public void binarySearchTest(){
        int[] intArr = {1,2,4,5,7,8,9,12,21,23,34,36,131};

        /**例如：8 index=5
         * {1,2,4,5,7,8,9,12,21,34,36,23,131}
         * {1,2,4,5,7,8}
         * {5,7,8}
         * {8}
         */
        int index = SearchArthmetic.binarySearch(intArr, 36);
        System.out.println(index);

    }

}
