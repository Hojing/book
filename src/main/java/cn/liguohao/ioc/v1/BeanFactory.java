package cn.liguohao.ioc.v1;

/**Bean工厂
 * 负责管理容器中的所有Bean对象
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/1/31
 */
public interface BeanFactory {

    /**
     * 获取Bean
     * @param uniqueName Bean对象在IOC容器中的唯一名称
     * @return 容器中的Bean对象
     * @throws Exception 异常情况
     */
    Object getBean(String uniqueName) throws Exception;

}
