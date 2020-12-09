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
        UserDao userDao = new UserDaoImpl();
        userDao.regist();
        userDao.login();
    }

    /**
     * 动态代理调用
     */
    @Test
    public void dynaimcProxy(){
        CommonInvocationHandler<UserDao> userDaoCommonInvocationHandler = new CommonInvocationHandler<UserDao>();

        UserDao userDao = userDaoCommonInvocationHandler.bind(new UserDaoImpl());
        userDao.regist();
        userDao.login();


    }
}
