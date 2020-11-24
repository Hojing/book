package cn.liguohao.design.pattern.proxy.cdcover;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description TODO
 * @Author liguohao
 * @Date 2020/10/4 15:00
 */
public class DriverTest {
    public static void main(String[] args) {
        ImageComponent imageComponent;
        Frame frame = new Frame("CD 封面加载");
        //https://liguohao.cn/img/5.c05bbb36.jpg
        try {
            URL url = new URL("https","liguohao.cn",80,"img/5.c05bbb36.jpg");
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
