package cn.liguohao.ds;

/**
 * 算法的时间复杂度，即算法的时间量度，算法分析时语句的总执行次数，是关于问题规模的函数，这个函数表示的就是算法的时间复杂度
 *
 * <hr>
 * 大O阶推导法
 * <ul>
 *     <li>用常数1取代运行时间中的所有加法常数</li>
 *     <li>在修改后的运行次数函数中，只保留最高阶项</li>
 *     <li>如果最高阶项存在且不是1，则去除与这个项相乘的常数</li>
 * </ul>
 *
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/4/5
 */
public class TimeComplexity {
    public static void main(String[] args) {
        System.out.println(constant(100));
    }

    /**
     * 常数阶
     *
     * @param n 问题的输入规模
     * @return 输出结果
     */
    public static int constant(int n) {
        int sum = 0;
        sum = (1 + n) * n / 2;
        return sum;
    }

    /**
     * 线性阶
     *
     * @param n 问题的输入规模
     * @return 输出结果
     */
    public static int linearity(int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += 1;
        }
        return result;
    }

    /**
     * 对数阶
     *
     * @param n 问题的输入规模
     * @return 输出结果
     */
    public static int logarithm(int n) {
        int count = 1;
        while (count < n) {
            count = count * 2;
        }
        return count;
    }

    /**
     * 平方阶
     *
     * @param n 问题的输入规模
     * @return 输出结果
     */
    public static int square(int n) {
        int i, j, res = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                res += 1;
            }
        }
        return res;
    }

}
