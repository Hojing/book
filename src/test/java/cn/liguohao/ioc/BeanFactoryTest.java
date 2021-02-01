package cn.liguohao.ioc;

import cn.liguohao.ioc.v1.DefaultBeanFactory;
import cn.liguohao.ioc.v1.FactoryBean;
import cn.liguohao.ioc.v1.GenericBeanDefinition;
import org.junit.Test;

/**
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/1/31
 */
public class BeanFactoryTest {

    @Test
    public void classCreateTest() throws Exception {
        DefaultBeanFactory defaultBeanFactory = new DefaultBeanFactory();
        String uniqueName = "user";

        GenericBeanDefinition<User> userGenericBeanDefinition = new GenericBeanDefinition<User>();
        userGenericBeanDefinition.setClazz(User.class);

        defaultBeanFactory.registerBeanDefinition(uniqueName,userGenericBeanDefinition);

        System.out.println(defaultBeanFactory.getBean(uniqueName));
        System.out.println(defaultBeanFactory.getBean(uniqueName));

    }


    @Test
    public void staticFactoryCreateTest() throws Exception {
        DefaultBeanFactory defaultBeanFactory = new DefaultBeanFactory();
        String uniqueName = "user";
        String userStaticFactoryUniqueName = "userStaticFactory";
        String factoryMethodName = "createUser";

        GenericBeanDefinition<UserStaticFactory> userStaticFactoryGenericBeanDefinition = new GenericBeanDefinition<>();
        userStaticFactoryGenericBeanDefinition.setClazz(UserStaticFactory.class);
        defaultBeanFactory.registerBeanDefinition(userStaticFactoryUniqueName,userStaticFactoryGenericBeanDefinition);


        GenericBeanDefinition<User> userGenericBeanDefinition = new GenericBeanDefinition<User>();
        userGenericBeanDefinition.setFactoryBeanUniqueName(userStaticFactoryUniqueName);
        userGenericBeanDefinition.setFactoryBeanMethodName(factoryMethodName);
        defaultBeanFactory.registerBeanDefinition(uniqueName,userGenericBeanDefinition);

        System.out.println(defaultBeanFactory.getBean(uniqueName));
        System.out.println(defaultBeanFactory.getBean(uniqueName));

    }

    @Test
    public void factoryInstanceCreateTest() throws Exception {
        DefaultBeanFactory defaultBeanFactory = new DefaultBeanFactory();
        String factoryBeanUniqueName = "factoryBean";
        String factoryMethodName = "createBean";
        String userBeanUniqueName = "userBean";

        GenericBeanDefinition<FactoryBean> factoryBeanGenericBeanDefinition = new GenericBeanDefinition<>();
        FactoryBean<User> userUserFactoryBean = new UserFactoryBean<>();
        factoryBeanGenericBeanDefinition.setClazz((Class<FactoryBean>) userUserFactoryBean.getClass());
        defaultBeanFactory.registerBeanDefinition(factoryBeanUniqueName,factoryBeanGenericBeanDefinition);

        GenericBeanDefinition<User> userGenericBeanDefinition = new GenericBeanDefinition<>();
        userGenericBeanDefinition.setFactoryBeanUniqueName(factoryBeanUniqueName);
        userGenericBeanDefinition.setFactoryBeanMethodName(factoryMethodName);
        defaultBeanFactory.registerBeanDefinition(userBeanUniqueName,userGenericBeanDefinition);

        System.out.println(defaultBeanFactory.getBean(userBeanUniqueName));
        System.out.println(defaultBeanFactory.getBean(userBeanUniqueName));

    }

}
