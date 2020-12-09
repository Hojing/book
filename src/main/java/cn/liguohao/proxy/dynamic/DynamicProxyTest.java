package cn.liguohao.proxy.dynamic;

import org.junit.Test;

/**动态代理测试
 * @Author liguohao
 * @Date 2020/12/9
 */
public class DynamicProxyTest {

    /**
     * 正常调用
     */
    @Test
    public void normal(){
        UserDao userDao = new cn.liguohao.java.demo.proxy.dynamic.UserDaoImpl();
        userDao.regist();
        userDao.login();
    }

    /**
     * 动态代理调用
     */
    @Test
    public void dynaimcProxy(){
        cn.liguohao.java.demo.proxy.dynamic.CommonInvocationHandler<UserDao> userDaoCommonInvocationHandler = new cn.liguohao.java.demo.proxy.dynamic.CommonInvocationHandler<UserDao>();

        UserDao userDao = userDaoCommonInvocationHandler.bind(new cn.liguohao.java.demo.proxy.dynamic.UserDaoImpl());
        userDao.regist();
        userDao.login();


    }
}
