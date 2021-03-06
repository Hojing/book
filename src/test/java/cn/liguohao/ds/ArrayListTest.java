package cn.liguohao.ds;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**自定义顺序线性表测试
 * @author <a href="https://liguohao.cn" target="_blank">李国豪</a>
 * @since 2021/3/17
 */
public class ArrayListTest {

    @Test
    public void capacityRationality(){
        new ArrayList<>(-213);
    }

    @Test
    public void add(){
        ArrayList<User> list = new ArrayList<User>();
        list.add(
                User.build().setUsername("张三").setPassword("333")
        );
        list.add(
                User.build().setUsername("李四").setPassword("444")
        );
        list.add(
                User.build().setUsername("王五").setPassword("555")
        );
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        list.set(1,
                User.build().setUsername("赵六").setPassword("666"));

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));

    }

    @Test
    public void remove(){
        ArrayList<User> list = new ArrayList<User>();
        list.add(
                User.build().setUsername("张三").setPassword("333")
        );
        list.add(
                User.build().setUsername("李四").setPassword("444")
        );
        list.add(
                User.build().setUsername("王五").setPassword("555")
        );
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        list.remove(0);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
    }
}
