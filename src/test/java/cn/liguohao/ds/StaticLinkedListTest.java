package cn.liguohao.ds;

import org.junit.Before;
import org.junit.Test;

/**
 * 测试
 * 静态链表
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/4/2
 */
public class StaticLinkedListTest {

    private StaticLinkedList<User> list;

    @Before
    public void beforeTest(){
        list = new StaticLinkedList<User>();
        list.add(new User().setUsername("张三").setPassword("333")); // index=0
        list.add(new User().setUsername("李四").setPassword("444")); // index=1
        list.add(new User().setUsername("王五").setPassword("555")); // index=2
        list.add(new User().setUsername("赵六").setPassword("666")); // index=3
    }

    @Test
    public void add(){
        System.out.println(list.size());
        System.out.println(list.getIndexNode(0));
    }

    @Test
    public void get(){
        System.out.println(list.get(3)); //User{username='赵六', password='666'}
    }

    @Test
    public void addIndex(){
        System.out.println(list.get(3)); //User{username='赵六', password='666'}
        list.set(3,new User().setUsername("黑七").setPassword("777"));
        System.out.println(list.get(3)); //User{username='黑七', password='777'}
        System.out.println(list.get(4)); //User{username='赵六', password='666'}
    }

    @Test
    public void removeIndex(){
        System.out.println(list.get(2)); //User{username='王五', password='555'}
        list.remove(2);
        System.out.println(list.get(2)); //User{username='赵六', password='666'}
    }

    @Test
    public void clear(){
        list.clear();
        System.out.println(list.get(0));
    }

}
