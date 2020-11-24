package cn.liguohao.design.pattern.command.entity;

import cn.liguohao.design.pattern.command.Command;

/**
 * @Description TODO 遥控器
 * @Author liguohao
 * @Date 2020/9/24 23:03
 */
public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void buttonPress(){
        command.execute();
    }
}
