package cn.liguohao.design.pattern.io;

import java.io.*;

/**
 * @Description TODO
 * @Author liguohao
 * @Date 2020/9/21 4:52
 */
public class InputTest {
    public static void main(String[] args) {
        try {
            LowerCaseInputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("Java\\src\\main\\resources\\test.txt")));
            int i;
            while ((i = in.read()) >0) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
