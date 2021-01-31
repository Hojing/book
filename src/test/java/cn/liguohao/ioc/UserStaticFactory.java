package cn.liguohao.ioc;

/**
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/1/31
 */
public class UserStaticFactory {

    public static User createUser(){
        System.out.println(UserStaticFactory.class.getName()+" => createUser ...");
        return new User();
    }

}
