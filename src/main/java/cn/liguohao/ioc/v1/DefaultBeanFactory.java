package cn.liguohao.ioc.v1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**默认的BeanFactory
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/1/31
 */
public class DefaultBeanFactory implements BeanFactory,BeanDefinitionRegistry{
    /**
     * BeanDefinition Map 集合
     */
    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public void registerBeanDefinition(String uniqueName, BeanDefinition beanDefinition) throws IOCException {
        // 如果已经存在了此uniqueName 抛出异常
        if(this.containsBeanDefinition(uniqueName)) throw new IOCException("uniqueName="+uniqueName+"的BeanDefinition已经存在");
        // 注册Bean定义信息
        this.beanDefinitionMap.put(uniqueName,beanDefinition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String uniqueName) {
        return beanDefinitionMap.get(uniqueName);
    }

    @Override
    public boolean containsBeanDefinition(String uniqueName) {
        return this.beanDefinitionMap.containsKey(uniqueName);
    }

    @Override
    public Object getBean(String uniqueName) throws Exception{
        return this.doGetBean(uniqueName);
    }

    /**
     * 获取Bean对象
     * @param uniqueName Bean对象再Map种的ID
     * @return Bean对象
     * @throws IOCException
     */
    protected Object doGetBean(String uniqueName) throws Exception {
        if(uniqueName == null || "".equals(uniqueName)) throw new IOCException("uniqueName="+uniqueName+" is not empty");
        BeanDefinition beanDefinition = this.getBeanDefinition(uniqueName);

        return this.doCreateBean(beanDefinition);
    }

    /**
     * 创建Bean对象
     * @param beanDefinition Bean对象定义信息
     * @return Bean对象
     * @throws IOCException
     */
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        if(!beanDefinition.validate()) throw new IOCException("BeanDefinition="+beanDefinition+" 定义 不符合规定");
        if(beanDefinition.getFactoryBeanMethodName()==null){
            return this.doGreateBeanByClass(beanDefinition.getBeanClass());
        }else {
            if(beanDefinition.getBeanClass()==null){
                return this.doCreateBeanByFactoryInterface(beanDefinition.getFactoryBeanUniqueName(),beanDefinition.getFactoryBeanMethodName());
            }else {
                return this.doCreateBeanByStaticFactory(beanDefinition.getBeanClass(),beanDefinition.getFactoryBeanMethodName());
            }
        }
    }

    /**
     * 通过Class.newInterfance创建对象
     * @param beanClass Bean的Class对象
     * @return Bean对象
     */
    protected Object doGreateBeanByClass(Class beanClass) throws Exception {
        return beanClass.newInstance();
    }

    /**
     * 通过静态工厂创建Bean对象
     * @param beanClass 工厂Bean类
     * @param factoryBeanMethodName 指定的工厂Bean方法
     * @return Bean对象实例
     */
    private Object doCreateBeanByStaticFactory(Class beanClass, String factoryBeanMethodName) throws Exception {
        return beanClass.getMethod(factoryBeanMethodName).invoke(null);
    }
    /**
     * 通过工厂实例创建Bean对象
     * @param factoryBeanUniqueName 工厂Bean的唯一名称
     * @param factoryBeanMethodName 指定的工厂Bean方法
     * @return Bean对象实例
     */
    private Object doCreateBeanByFactoryInterface(String factoryBeanUniqueName, String factoryBeanMethodName) throws Exception {
        Object factoryBean = this.getBean(factoryBeanUniqueName);
        return factoryBean.getClass().getMethod(factoryBeanMethodName).invoke(factoryBean);
    }


}
