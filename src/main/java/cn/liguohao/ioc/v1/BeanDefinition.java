package cn.liguohao.ioc.v1;


/**Bean定义
 * 定义需要注册到IOC容器的Bean具备的条件
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/1/31
 */
public interface BeanDefinition {

    /**
     * 获取 Bean对应的Class
     * @return Bean对应的Class
     */
    Class getBeanClass();

    /**
     * 获取 工厂Bean实例此Bean对应的方法名
     * 工厂Bean: 专门实例当前Bean的工厂
     * @return 工厂Bean实例此Bean对应的方法名
     */
    String getFactoryBeanMethodName();

    /**
     * 获取 工厂Bean的唯一名称
     * 工厂Bean: 专门实例当前Bean的工厂
     * @return 工厂Bean的唯一名称
     */
    String getFactoryBeanUniqueName();

    /**
     * 获取 Bean的初始化方法名
     * @return Bean的初始化方法名
     */
    String getInitMethodName();

    /**
     * 获取 Bean的销毁方法名
     * 常用于资源释放等场景
     * @return Bean的销毁方法名
     */
    String getDestoryMethodName();

    /**
     * 判断 Bean在IOC容器是否为单例模式
     * @return Bean在IOC容器是否为单例模式
     */
    boolean isSingleton();

    /**
     * 判断 当前Bean实例是否为IOC容器中多个相同Class类型的主要实例
     * @return 当前Bean实例是否为IOC容器中多个相同Class类型的主要实例
     */
    boolean isPrimary();

    /**
     * 校验 Bean定义信息是否符合规定
     * @return Bean定义信息是否符合规定
     */
    default boolean validate(){
        /**
         * IOC容器创建对象的几种方法
         * 1.Class.newInterface: Class文件直接新建对象 此种方法需要Class
         * 2.Factory.staticCreateBeanMethod: 静态工厂方法创建 此种方法需要 factoryBeanUniqueName 和 factoryBeanMethodName
         * 3.FactoryInterface.createBeanMeathod: 工厂成员方法创建 此种方法需要Class 和 factoryBeanMethodName
         */
        if(getFactoryBeanMethodName()==null){ //使用第一种方法
            if(getBeanClass() == null){ //要求Class不能为空
                return false;
            }
        }else { //使用第二种或第三种
            if(getBeanClass() == null){//Class为空时 使用第二种方法 要求 factoryBeanUniqueName不能为空
                if(getFactoryBeanUniqueName() == null) return false;
            }else { //Class不为空时 使用第三种方法 要求 factoryBeanUniqueName必须为空
                if(getFactoryBeanUniqueName() != null) return false;
            }
        }
        return true;
    };
}
