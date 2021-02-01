package cn.liguohao.ioc.v1;

import java.lang.reflect.Method;

/**通用的Bean定义类
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/1/31
 */
public class GenericBeanDefinition<T> implements BeanDefinition {

    private Class<T> clazz;
    private String factoryBeanUniqueName;
    private String factoryBeanMethodName;
    private Method initMethod;
    private Method destroyMethod;
    private boolean isSinglethon;
    private boolean isPrimary;

    @Override
    public Class getBeanClass() {
        return this.clazz;
    }

    @Override
    public String getFactoryBeanMethodName() {
        return this.factoryBeanMethodName;
    }

    @Override
    public String getFactoryBeanUniqueName() {
        return this.factoryBeanUniqueName;
    }

    @Override
    public String getInitMethodName() {
        return this.initMethod.getName();
    }

    @Override
    public String getDestoryMethodName() {
        return this.destroyMethod.getName();
    }

    @Override
    public boolean isSingleton() {
        return this.isSinglethon;
    }

    @Override
    public boolean isPrimary() {
        return this.isPrimary;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }


    public void setFactoryBeanUniqueName(String factoryBeanUniqueName) {
        this.factoryBeanUniqueName = factoryBeanUniqueName;
    }

    public void setFactoryBeanMethodName(String factoryBeanMethodName) {
        this.factoryBeanMethodName = factoryBeanMethodName;
    }

    public void setInitMethod(Method initMethod) {
        this.initMethod = initMethod;
    }

    public void setDestroyMethod(Method destroyMethod) {
        this.destroyMethod = destroyMethod;
    }

    public void setSinglethon(boolean singlethon) {
        isSinglethon = singlethon;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }
}
