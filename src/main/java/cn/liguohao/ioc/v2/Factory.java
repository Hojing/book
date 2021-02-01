package cn.liguohao.ioc.v2;

/**工厂
 * 用于创建Bean
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/2/1
 */
public interface Factory<T> {

    T createBean();

}
