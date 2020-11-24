package cn.liguohao.design.pattern.mvc;

import cn.liguohao.design.pattern.mvc.controller.BeatController;
import cn.liguohao.design.pattern.mvc.model.BeatModel;
import cn.liguohao.design.pattern.mvc.view.DJView;

/**
 * @Description TODO
 * @Author liguohao
 * @Date 2020/10/5 15:47
 */
public class DriverTest {
    public static void main(String[] args) {
        BeatModel beatModel = new BeatModel();
        BeatController beatController = new BeatController(beatModel);
    }
}
