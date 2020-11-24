package cn.liguohao.util;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 数组工具类
 */
public class ArrayUtil {


    /**
     * 复制数组
     * @param originalArray 原数组
     * @return
     */
    public static Object[] copyOf(Object[] originalArray){
        return copyOfAssignLength(originalArray, originalArray.length);
    }

    /**
     * 复制数组
     * @param originalArray 原数组
     * @param length 复制的长度
     * @return
     */
    public static Object[] copyOfAssignLength(Object[] originalArray, int length){
        return goodCopyOf(originalArray,length);
    }

    private static Object[] badCopyOf(Object[] originalArray, int length){
        // 创建一个新数组
        Object[] newArray = new Object[Math.min(originalArray.length,length)];
        // 复制数组
        System.arraycopy(originalArray,0,newArray,0,Math.min(originalArray.length,length));
        return newArray;
    }
    private static Object[] goodCopyOf(Object[] originalArray, int length){
        // 获取原数组的Class对象
        Class<? extends Object[]> originalArrayClass = originalArray.getClass();
        // 如果不是数组，返回null
        if(!originalArrayClass.isArray()) return null;
        // 获取原数组中的组件类型
        Class<?> originalArrayClassComponentType = originalArrayClass.getComponentType();
        // 获取原数组的长度
        //int originalLength = originalArray.length;
        int originalLength = Array.getLength(originalArray); //我也不清楚这里为什么不用上面那种，《Java核心技术卷一》里是这样写的
        // 创建和原数组相同类型的新数组
        Object newArray = Array.newInstance(originalArrayClassComponentType, length);
        // 复制
        System.arraycopy(originalArray,0,newArray,0,Math.min(originalLength,length));
        // 返回新数组
        return newArray.getClass().isArray()?(Object[]) newArray:null;
    }


    // 测试入口
    public static void main(String[] args) {
        // 字符数组的复制
        String[] strings = {"ofdsj","jsfdoia"};
        System.out.println(strings.getClass().getComponentType()); //class java.lang.String
        System.out.println(strings.length); //2
        System.out.println(Array.getLength(strings)); //2
        System.out.println(strings.length == Array.getLength(strings)); //true
        String[] newStrings = (String[]) ArrayUtil.copyOf(strings);
        System.out.println(Arrays.toString(newStrings)); //[ofdsj, jsfdoia]

        // 基本类型数组的复制
        Integer[] ints = {2,34,234,123};
        Integer[] newInts = (Integer[]) ArrayUtil.copyOf(ints);
        System.out.println(Arrays.toString(newInts)); //[2, 34, 234, 123]


        // 对象数组的复制
        User[] users = new User[3];
        for (int i=0;i< users.length;i++) {
            users[i] = new User("User "+i);
        }
        User[] newUsers = (User[]) ArrayUtil.copyOf(users);
        System.out.println(Arrays.toString(newUsers)); //[User{username='User 0'}, User{username='User 1'}, User{username='User 2'}]

    }


}

/**
 * 测试用用户类
 */
class User {
    private Integer UUID;
    private String username;
    private String password;
    private String email;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public Integer getUUID() {
        return UUID;
    }

    public void setUUID(Integer UUID) {
        this.UUID = UUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}
