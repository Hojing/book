package cn.liguohao.ioc.v1;

/**工厂Bean
 * 用于创建对应的Bean
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/1/31
 */
public interface FactoryBean<T> {

    default T createBean(){
        return (T) new Object();
    };
}
