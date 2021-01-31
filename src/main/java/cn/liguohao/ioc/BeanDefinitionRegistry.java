package cn.liguohao.ioc;

/**Bean注册到IOC容器的行为定义
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/1/31
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册Bean到IOC容器
     * @param uniqueName Bean的唯一名称
     * @param beanDefinition Bean的定义信息
     * @throws IOCException 异常情况
     */
    void registerBeanDefinition(String uniqueName, BeanDefinition beanDefinition) throws IOCException;

    /**
     * 根据唯一名称获取Bean对象
     * @param uniqueName Bean的唯一名称
     * @return Bean的定义信息
     */
    BeanDefinition getBeanDefinition(String uniqueName);

    /**
     * 根据唯一名称判断是否存在对应的Bean
     * @param uniqueName Bean的唯一名称
     * @return 是否存在
     */
    boolean containsBeanDefinition(String uniqueName);

}
