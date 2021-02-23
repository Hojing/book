package cn.liguohao.arthmetic;

import cn.liguohao.arithmetic.SearchArthmetic;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

/**查询算法测试
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/2/23
 */
public class SearchArthmeticTest {

    @Test
    public void binarySearchTest(){
        int length = 99999999;
        long[] testLongArr = new long[length];
        long key = 999999998;
        System.out.println("generate data long array ...");
        for(int i=0;i<length;i++){
            testLongArr[i] = i;
        }
        System.out.println("generate data long array finish");

        Arrays.sort(testLongArr);

        long time1 = System.nanoTime();

        System.out.println(SearchArthmetic.forceSearch(testLongArr,key));

        long time2 = System.nanoTime();
        System.out.println("force search use time ==> "+(time2-time1)+"ms");

        /**例如：8 index=5
         * {1,2,4,5,7,8,9,12,21,34,36,23,131}
         * {1,2,4,5,7,8}
         * {5,7,8}
         * {8}
         */
        System.out.println(SearchArthmetic.binarySearch(testLongArr, key));

        long time3 = System.nanoTime();

        System.out.println("binary search use time ==> "+(time3-time2)+"ms");

    }

}
