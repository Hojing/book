package cn.liguohao.ioc.v2;

/**Bean容器
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/2/1
 */
public interface BeanContainer {

    Object getBean(String name);

    boolean register(BeanDefinition beanDefinition);

}
