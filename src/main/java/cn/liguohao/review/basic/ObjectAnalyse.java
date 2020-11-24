package cn.liguohao.review.basic;

import org.junit.Test;

/**
 * Obejct对象剖析
 */
public class ObjectAnalyse {

    /**
     * x.clone() != x // true
     * x.clone().getClass() == x.getClass() //true 但不绝对
     * x.clone().equals(x) //true   但不绝对
     *
     */
    @Test
    public void cloneAnalyse() throws CloneNotSupportedException {
        User user = new User("测试用户");
        Object clone = user.clone();
        System.out.println(clone != user); //true
        System.out.println(clone.getClass() == user.getClass()); //true
        // Object.equals()方法默认是 通过 == 进行判断的。如子类重写了equals方法，结果以子类为准
        System.out.println(clone.equals(user)); //false


    }


}


