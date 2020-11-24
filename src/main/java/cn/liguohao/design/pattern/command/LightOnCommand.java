package cn.liguohao.design.pattern.command;

import cn.liguohao.design.pattern.command.entity.Light;

/**
 * @Description TODO
 * @Author liguohao
 * @Date 2020/9/24 23:00
 */
public class LightOnCommand  implements Command{
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
