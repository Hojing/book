package cn.liguohao.ds;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;

/**
 * 单元测试
 * 线性表
 * 链式存储结构
 * 单链表
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/3/20
 */
public class SingleLinkedListTest {

    private SingleLinkedList list;

    @Before
    public void before(){
        list = new SingleLinkedList();
        list.add(new User().setUsername("张三").setPassword("333"));
        list.add(new User().setUsername("李四").setPassword("444"));
        list.add(new User().setUsername("王五").setPassword("555"));
        list.add(new User().setUsername("赵六").setPassword("666"));
    }

    @Test
    public void add(){
        System.out.println(list.size());
        System.out.println(list.getIndexNode(0));
    }

    @Test
    public void get(){
        System.out.println(list.get(3));
    }

    @Test
    public void addIndex(){
        System.out.println(list.get(3));
        list.add(3,new User().setUsername("黑七").setPassword("777"));
        System.out.println(list.get(4));
    }

    @Test
    public void removeIndex(){
        System.out.println(list.get(3));
        list.remove(3);
        System.out.println(list.get(3));
    }

    @Test
    public void clear(){
        list.clear();
        System.out.println(list.get(0));
    }


}
