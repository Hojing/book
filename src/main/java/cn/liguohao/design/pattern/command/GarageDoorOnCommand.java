package cn.liguohao.design.pattern.command;

import cn.liguohao.design.pattern.command.entity.Garage;

/**
 * @Description TODO
 * @Author liguohao
 * @Date 2020/9/24 23:14
 */
public class GarageDoorOnCommand implements Command{

    private Garage garage;

    public GarageDoorOnCommand(Garage garage) {
        this.garage = garage;
    }

    @Override
    public void execute() {
        garage.doorTurnOn();
    }
}
